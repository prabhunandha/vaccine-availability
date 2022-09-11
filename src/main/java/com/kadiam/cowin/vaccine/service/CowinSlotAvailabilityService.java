package com.kadiam.cowin.vaccine.service;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kadiam.cowin.vaccine.domain.*;
import com.kadiam.cowin.vaccine.util.EmailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@EnableScheduling
public class CowinSlotAvailabilityService {
    public static final Logger log = LoggerFactory.getLogger(CowinSlotAvailabilityService.class);

    @Value("${area.districtId}")
    private String districtId;

    @Value("${area.pincode}")
    private String pincode;

    @Value("${cowin.url}")
    private String cowinURL;

    @Value("${http.method.type}")
    private String http_method;

    @Value("${age.limit}")
    private long ageLimt;

    @Autowired
    public EmailUtil emailUtil;

    @Scheduled(cron="*/10 * * * * *")
    public void checkAvailableSlot() throws Exception {
        log.info("Entry");
        ObjectMapper mapper = new ObjectMapper();
        StringBuffer sb = new StringBuffer();
        String inputLineDispatch_api;
        StringBuffer response_dispatch_api = new StringBuffer();
        SessionPOJO sessionPOJO;
        VaccineFeesPOJO vaccineFeesPOJO;
        int i=1;

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = sdf.format(date);
        String dynamicAPIURL = cowinURL.contains("district") ? String.format(cowinURL,districtId,strDate) : String.format(cowinURL,pincode,strDate);
//        String dynamicAPIURL = String.format(cowinURL,districtId,strDate);
        System.out.println("Dynamic String---->>>"+dynamicAPIURL);

        URL api = new URL(dynamicAPIURL);

        HttpURLConnection httpURLConnection = (HttpURLConnection) api.openConnection();

        httpURLConnection.setRequestMethod(http_method);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("User-Agent", "Chrome/90.0.4430.93");
        httpURLConnection.setDoOutput(true);
        int responseCode = httpURLConnection.getResponseCode();
        log.info(sdf.format(Calendar.getInstance().getTime())+"LOG : ---------- Cowin HTTP Response code  : "+responseCode+"\n");

        BufferedReader in_dispatch_api = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            while((inputLineDispatch_api = in_dispatch_api.readLine()) != null){
            response_dispatch_api.append(inputLineDispatch_api);
        }
        in_dispatch_api.close();
        byte[] jsonDataResponseDispatch  = response_dispatch_api.toString().getBytes();
        Centers centers = mapper.readValue(jsonDataResponseDispatch, Centers.class);
        List<Center> centerList = centers.getCenters();
//        centerList.stream().forEach(e -> System.out.println(" Available Capacity  -->"+ e.getSessions().get(0).getmAvailableCapacityDose1() +" Center Id  -->"+e.getCenterId()));

        List<AvailableSlot> availableSlotList = getAvailableSlotPOJO(centerList);

//        System.out.println("availableSlotList Size==>>"+availableSlotList.size());

        for(AvailableSlot availableSlot : availableSlotList){
            sessionPOJO = availableSlot.getmSessions();
            if(sessionPOJO.getmMinAgeLimit() == ageLimt){
                /*System.out.println(i+". ********** Available Slot Details ********** START");
                System.out.println("Hospital Name : "+availableSlot.getmName());
                System.out.println("Address : "+availableSlot.getmAddress());
                System.out.println("State : "+availableSlot.getmStateName());
                System.out.println("District : "+availableSlot.getmDistrictName());
                System.out.println("Block : "+availableSlot.getmBlockName());
                System.out.println("Pincode : "+availableSlot.getmPincode());
                System.out.println("Fees Type : "+availableSlot.getmFeeType());
                System.out.println("Available Date : "+sessionPOJO.getmDate());
                System.out.println("Available Capacity : "+sessionPOJO.getmAvailableCapacity());
                System.out.println("Age Limit : "+sessionPOJO.getmMinAgeLimit());
                System.out.println("Vaccine Name : "+sessionPOJO.getmVaccine());*/
                vaccineFeesPOJO = availableSlot.getmVaccineFees();
               /* if(null != vaccineFeesPOJO)
                    System.out.println("Vaccine Cost : "+vaccineFeesPOJO.getmFee());

                System.out.println(i+". **************************************** END\n");*/

                sb.append(i+".")
                        .append("\tHospital Name : "+availableSlot.getmName()+"\n")
                        .append("\tAddress : "+availableSlot.getmAddress()+"\n")
                        .append("\tState : "+availableSlot.getmStateName()+"\n")
                        .append("\tDistrict : "+availableSlot.getmDistrictName()+"\n")
                        .append("\tBlock : "+availableSlot.getmBlockName()+"\n")
                        .append("\tPincode : "+availableSlot.getmPincode()+"\n")
                        .append("\tFees Type : "+availableSlot.getmFeeType()+"\n")
                        .append("\tAvailable Date : "+sessionPOJO.getmDate()+"\n")
                        .append("\tAvailable Capacity : "+sessionPOJO.getmAvailableCapacity()+"\n")
                        .append("\tAge Limit : "+sessionPOJO.getmMinAgeLimit()+"\n")
                        .append("\tVaccine Name : "+sessionPOJO.getmVaccine()+"\n\n");
                i++;
            }
        }
        if(availableSlotList.size()>0 && sb.length()>0){
            emailUtil.sendEmail(new StringBuffer("********** Available Slot Details ********** \n\n").append(sb.toString()).append("\n\n").append("Best Regards\nPrabhunandha").toString(),strDate);
        }
        log.info("Exit");
    }

    private List<AvailableSlot> getAvailableSlotPOJO(List<Center> centerList) {
        List<AvailableSlot> availableSlotList = new ArrayList<>();
        AvailableSlot availableSlot;

        SessionPOJO sessionPOJO;
        VaccineFeesPOJO vaccineFeesPOJO;

        for(Center center: centerList) {
            for (Session session : center.getSessions()) {
                if(session.getmAvailableCapacity() > 0) {
                    availableSlot = new AvailableSlot();

                    availableSlot.setmCenterId(center.getCenterId());
                    availableSlot.setmName(center.getName());
                    availableSlot.setmStateName(center.getStateName());
                    availableSlot.setmAddress(center.getAddress());
                    availableSlot.setmDistrictName(center.getDistrictName());
                    availableSlot.setmBlockName(center.getBlockName());
                    availableSlot.setmPincode(center.getPincode());
                    availableSlot.setmFeeType(center.getFeeType());

                    sessionPOJO = new SessionPOJO();

                    sessionPOJO.setmSessionId(session.getmSessionId());
                    sessionPOJO.setmDate(session.getmDate());
                    sessionPOJO.setmAvailableCapacity(session.getmAvailableCapacity());
                    sessionPOJO.setmMinAgeLimit(session.getmMinAgeLimit());
                    sessionPOJO.setmVaccine(session.getmVaccine());
                    sessionPOJO.setmSlots(session.getmSlots());

                    availableSlot.setmSessions(sessionPOJO);

                    if(null != center.getmVaccineFees()){
                        vaccineFeesPOJO = new VaccineFeesPOJO();
                        vaccineFeesPOJO.setmFee(center.getmVaccineFees().get(0).getmFee());
                        availableSlot.setmVaccineFees(vaccineFeesPOJO);
                    }
                    availableSlotList.add(availableSlot);
                }
            }
        }
        return availableSlotList;
    }
}

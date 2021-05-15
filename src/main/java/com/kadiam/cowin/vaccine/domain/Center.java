package com.kadiam.cowin.vaccine.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import java.util.List;


@Generated("net.hexar.json2pojo")
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Center {

    @JsonProperty("address")
    private String mAddress;
    @JsonProperty("block_name")
    private String mBlockName;
    @JsonProperty("center_id")
    private Long mCenterId;
    @JsonProperty("district_name")
    private String mDistrictName;
    @JsonProperty("fee_type")
    private String mFeeType;
    @JsonProperty("from")
    private String mFrom;
    @JsonProperty("lat")
    private Long mLat;
    @JsonProperty("long")
    private Long mLong;
    @JsonProperty("name")
    private String mName;
    @JsonProperty("pincode")
    private Long mPincode;
    @JsonProperty("sessions")
    private List<Session> mSessions;
    @JsonProperty("state_name")
    private String mStateName;
    @JsonProperty("to")
    private String mTo;

    @JsonProperty("vaccine_fees")
    private List<VaccineFees> mVaccineFees;


    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getBlockName() {
        return mBlockName;
    }

    public void setBlockName(String blockName) {
        mBlockName = blockName;
    }

    public Long getCenterId() {
        return mCenterId;
    }

    public void setCenterId(Long centerId) {
        mCenterId = centerId;
    }

    public String getDistrictName() {
        return mDistrictName;
    }

    public void setDistrictName(String districtName) {
        mDistrictName = districtName;
    }

    public String getFeeType() {
        return mFeeType;
    }

    public void setFeeType(String feeType) {
        mFeeType = feeType;
    }

    public String getFrom() {
        return mFrom;
    }

    public void setFrom(String from) {
        mFrom = from;
    }

    public Long getLat() {
        return mLat;
    }

    public void setLat(Long lat) {
        mLat = lat;
    }

    public Long getLong() {
        return mLong;
    }

    public void setLong(Long mLong) {
        mLong = mLong;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Long getPincode() {
        return mPincode;
    }

    public void setPincode(Long pincode) {
        mPincode = pincode;
    }

    public List<Session> getSessions() {
        return mSessions;
    }

    public void setSessions(List<Session> sessions) {
        mSessions = sessions;
    }

    public String getStateName() {
        return mStateName;
    }

    public void setStateName(String stateName) {
        mStateName = stateName;
    }

    public String getTo() {
        return mTo;
    }

    public void setTo(String to) {
        mTo = to;
    }

    public List<VaccineFees> getmVaccineFees() {
        return mVaccineFees;
    }

    public void setmVaccineFees(List<VaccineFees> mVaccineFees) {
        this.mVaccineFees = mVaccineFees;
    }
}

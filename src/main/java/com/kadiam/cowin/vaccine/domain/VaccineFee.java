
package com.kadiam.cowin.vaccine.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class VaccineFee {

    @JsonProperty("fee")
    private String mFee;
    @JsonProperty("vaccine")
    private String mVaccine;

    public String getFee() {
        return mFee;
    }

    public void setFee(String fee) {
        mFee = fee;
    }

    public String getVaccine() {
        return mVaccine;
    }

    public void setVaccine(String vaccine) {
        mVaccine = vaccine;
    }

}

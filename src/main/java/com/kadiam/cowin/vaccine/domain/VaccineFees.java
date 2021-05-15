package com.kadiam.cowin.vaccine.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VaccineFees {
    @JsonProperty("vaccine")
    private String mVaccine;

    @JsonProperty("fee")
    private long mFee;

    public VaccineFees(String mVaccine, long mFee) {
        this.mVaccine = mVaccine;
        this.mFee = mFee;
    }

    public String getmVaccine() {
        return mVaccine;
    }

    public void setmVaccine(String mVaccine) {
        this.mVaccine = mVaccine;
    }

    public long getmFee() {
        return mFee;
    }

    public void setmFee(long mFee) {
        this.mFee = mFee;
    }

    public VaccineFees() {
    }
}

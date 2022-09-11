package com.kadiam.cowin.vaccine.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VaccineFees {
    @JsonProperty("vaccine")
    private String mVaccine;

    @JsonProperty("fee")
    private double mFee;

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

    public double getmFee() {
        return mFee;
    }

    public void setmFee(double mFee) {
        this.mFee = mFee;
    }

    public VaccineFees() {
    }
}

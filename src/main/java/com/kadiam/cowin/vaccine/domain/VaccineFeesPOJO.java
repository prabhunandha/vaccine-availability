package com.kadiam.cowin.vaccine.domain;

public class VaccineFeesPOJO {

    private String mVaccine;

    private double mFee;

    public VaccineFeesPOJO(String mVaccine, long mFee) {
        this.mVaccine = mVaccine;
        this.mFee = mFee;
    }

    public VaccineFeesPOJO() {
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
}

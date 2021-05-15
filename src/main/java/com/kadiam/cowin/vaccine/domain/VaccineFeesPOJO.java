package com.kadiam.cowin.vaccine.domain;

public class VaccineFeesPOJO {

    private String mVaccine;

    private long mFee;

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

    public long getmFee() {
        return mFee;
    }

    public void setmFee(long mFee) {
        this.mFee = mFee;
    }
}

package com.kadiam.cowin.vaccine.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.List;

public class SessionPOJO {

    private Long mAvailableCapacity;

    private String mDate;

    private Long mMinAgeLimit;

    private String mSessionId;

    private List<String> mSlots;

    private String mVaccine;

    public SessionPOJO(Long mAvailableCapacity, String mDate, Long mMinAgeLimit, String mSessionId, List<String> mSlots, String mVaccine) {
        this.mAvailableCapacity = mAvailableCapacity;
        this.mDate = mDate;
        this.mMinAgeLimit = mMinAgeLimit;
        this.mSessionId = mSessionId;
        this.mSlots = mSlots;
        this.mVaccine = mVaccine;
    }

    public SessionPOJO() {
    }

    public Long getmAvailableCapacity() {
        return mAvailableCapacity;
    }

    public void setmAvailableCapacity(Long mAvailableCapacity) {
        this.mAvailableCapacity = mAvailableCapacity;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public Long getmMinAgeLimit() {
        return mMinAgeLimit;
    }

    public void setmMinAgeLimit(Long mMinAgeLimit) {
        this.mMinAgeLimit = mMinAgeLimit;
    }

    public String getmSessionId() {
        return mSessionId;
    }

    public void setmSessionId(String mSessionId) {
        this.mSessionId = mSessionId;
    }

    public List<String> getmSlots() {
        return mSlots;
    }

    public void setmSlots(List<String> mSlots) {
        this.mSlots = mSlots;
    }

    public String getmVaccine() {
        return mVaccine;
    }

    public void setmVaccine(String mVaccine) {
        this.mVaccine = mVaccine;
    }
}

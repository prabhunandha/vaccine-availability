
package com.kadiam.cowin.vaccine.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Session {

    @JsonProperty("available_capacity")
    private Long mAvailableCapacity;
    @JsonProperty("date")
    private String mDate;
    @JsonProperty("min_age_limit")
    private Long mMinAgeLimit;
    @JsonProperty("session_id")
    private String mSessionId;
    @JsonProperty("slots")
    private List<String> mSlots;
    @JsonProperty("vaccine")
    private String mVaccine;
    @JsonProperty("available_capacity_dose1")
    private Long mAvailableCapacityDose1;
    @JsonProperty("available_capacity_dose2")
    private Long mAvailableCapacityDose2;

    public Session(Long mAvailableCapacity, String mDate, Long mMinAgeLimit, String mSessionId, List<String> mSlots, String mVaccine, Long mAvailableCapacityDose1, Long mAvailableCapacityDose2) {
        this.mAvailableCapacity = mAvailableCapacity;
        this.mDate = mDate;
        this.mMinAgeLimit = mMinAgeLimit;
        this.mSessionId = mSessionId;
        this.mSlots = mSlots;
        this.mVaccine = mVaccine;
        this.mAvailableCapacityDose1 = mAvailableCapacityDose1;
        this.mAvailableCapacityDose2 = mAvailableCapacityDose2;
    }

    public Session() {
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

    public Long getmAvailableCapacityDose1() {
        return mAvailableCapacityDose1;
    }

    public void setmAvailableCapacityDose1(Long mAvailableCapacityDose1) {
        this.mAvailableCapacityDose1 = mAvailableCapacityDose1;
    }

    public Long getmAvailableCapacityDose2() {
        return mAvailableCapacityDose2;
    }

    public void setmAvailableCapacityDose2(Long mAvailableCapacityDose2) {
        this.mAvailableCapacityDose2 = mAvailableCapacityDose2;
    }
}

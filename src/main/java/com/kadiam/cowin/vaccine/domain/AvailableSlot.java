
package com.kadiam.cowin.vaccine.domain;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class AvailableSlot {

    private String mAddress;

    private String mBlockName;

    private Long mCenterId;

    private String mDistrictName;

    private String mFeeType;

    private String mFrom;

    private Long mLat;

    private Long mLong;

    private String mName;

    private Long mPincode;

    private String mStateName;

    private String mTo;

    private Long mAvailableCapacity;

    private String mDate;

    private Long mMinAgeLimit;

    private String mSessionId;

    /*private List<String> mSlots;*/

    private String mVaccine;

    private long mFee;

    private SessionPOJO mSessions;

    private VaccineFeesPOJO mVaccineFees;

    public AvailableSlot(String mAddress, String mBlockName, Long mCenterId, String mDistrictName, String mFeeType, String mFrom, Long mLat, Long mLong, String mName, Long mPincode, String mStateName, String mTo, Long mAvailableCapacity, String mDate, Long mMinAgeLimit, String mSessionId, String mVaccine, long mFee, SessionPOJO mSessions, VaccineFeesPOJO mVaccineFees) {
        this.mAddress = mAddress;
        this.mBlockName = mBlockName;
        this.mCenterId = mCenterId;
        this.mDistrictName = mDistrictName;
        this.mFeeType = mFeeType;
        this.mFrom = mFrom;
        this.mLat = mLat;
        this.mLong = mLong;
        this.mName = mName;
        this.mPincode = mPincode;
        this.mStateName = mStateName;
        this.mTo = mTo;
        this.mAvailableCapacity = mAvailableCapacity;
        this.mDate = mDate;
        this.mMinAgeLimit = mMinAgeLimit;
        this.mSessionId = mSessionId;
        this.mVaccine = mVaccine;
        this.mFee = mFee;
        this.mSessions = mSessions;
        this.mVaccineFees = mVaccineFees;
    }

    public AvailableSlot() {
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmBlockName() {
        return mBlockName;
    }

    public void setmBlockName(String mBlockName) {
        this.mBlockName = mBlockName;
    }

    public Long getmCenterId() {
        return mCenterId;
    }

    public void setmCenterId(Long mCenterId) {
        this.mCenterId = mCenterId;
    }

    public String getmDistrictName() {
        return mDistrictName;
    }

    public void setmDistrictName(String mDistrictName) {
        this.mDistrictName = mDistrictName;
    }

    public String getmFeeType() {
        return mFeeType;
    }

    public void setmFeeType(String mFeeType) {
        this.mFeeType = mFeeType;
    }

    public String getmFrom() {
        return mFrom;
    }

    public void setmFrom(String mFrom) {
        this.mFrom = mFrom;
    }

    public Long getmLat() {
        return mLat;
    }

    public void setmLat(Long mLat) {
        this.mLat = mLat;
    }

    public Long getmLong() {
        return mLong;
    }

    public void setmLong(Long mLong) {
        this.mLong = mLong;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public Long getmPincode() {
        return mPincode;
    }

    public void setmPincode(Long mPincode) {
        this.mPincode = mPincode;
    }

    public String getmStateName() {
        return mStateName;
    }

    public void setmStateName(String mStateName) {
        this.mStateName = mStateName;
    }

    public String getmTo() {
        return mTo;
    }

    public void setmTo(String mTo) {
        this.mTo = mTo;
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

    public SessionPOJO getmSessions() {
        return mSessions;
    }

    public void setmSessions(SessionPOJO mSessions) {
        this.mSessions = mSessions;
    }

    public VaccineFeesPOJO getmVaccineFees() {
        return mVaccineFees;
    }

    public void setmVaccineFees(VaccineFeesPOJO mVaccineFees) {
        this.mVaccineFees = mVaccineFees;
    }
}

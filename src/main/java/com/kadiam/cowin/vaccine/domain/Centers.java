package com.kadiam.cowin.vaccine.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Centers {

    @JsonProperty("centers")
    private List<Center> mCenters;

    public List<Center> getCenters() {
        return mCenters;
    }

    public void setCenters(List<Center> centers) {
        mCenters = centers;
    }

}

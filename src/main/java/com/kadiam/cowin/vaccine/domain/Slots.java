package com.kadiam.cowin.vaccine.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Slots {

    @JsonProperty("seats")
    private Long mSeats;
    @JsonProperty("time")
    private String mTime;
}

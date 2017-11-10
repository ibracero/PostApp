package com.ibracero.postapp.data.datasources.network.model;

import com.google.gson.annotations.SerializedName;

public class ApiGeo {

    @SerializedName("lng")
    private String lng;

    @SerializedName("lat")
    private String lat;

    public String getLng() {
        return lng;
    }

    public String getLat() {
        return lat;
    }
}
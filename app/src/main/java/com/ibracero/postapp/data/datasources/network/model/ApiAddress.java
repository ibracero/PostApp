package com.ibracero.postapp.data.datasources.network.model;

import com.google.gson.annotations.SerializedName;

public class ApiAddress {

    @SerializedName("geo")
    private ApiGeo geo;

    @SerializedName("zipCode")
    private String zipcode;

    @SerializedName("street")
    private String street;

    @SerializedName("suite")
    private String suite;

    @SerializedName("city")
    private String city;

    public ApiGeo getGeo() {
        return geo;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }
}
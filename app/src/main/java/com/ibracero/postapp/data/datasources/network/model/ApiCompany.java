package com.ibracero.postapp.data.datasources.network.model;

import com.google.gson.annotations.SerializedName;

public class ApiCompany {

    @SerializedName("catchPhrase")
    private String catchPhrase;

    @SerializedName("name")
    private String name;

    @SerializedName("bs")
    private String bs;

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getName() {
        return name;
    }

    public String getBs() {
        return bs;
    }
}
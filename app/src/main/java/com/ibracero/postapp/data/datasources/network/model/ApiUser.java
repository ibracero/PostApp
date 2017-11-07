package com.ibracero.postapp.data.datasources.network.model;

import com.google.gson.annotations.SerializedName;

public class ApiUser {

    @SerializedName("id")
    private String id;

    @SerializedName("phone")
    private String phone;

    @SerializedName("username")
    private String username;

    @SerializedName("website")
    private String website;

    @SerializedName("address")
    private ApiAddress address;

    @SerializedName("email")
    private String email;

    @SerializedName("company")
    private ApiCompany company;

    @SerializedName("name")
    private String name;

    public String getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public String getWebsite() {
        return website;
    }

    public ApiAddress getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public ApiCompany getCompany() {
        return company;
    }

    public String getName() {
        return name;
    }
}

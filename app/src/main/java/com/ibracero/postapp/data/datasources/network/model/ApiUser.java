package com.ibracero.postapp.data.datasources.network.model;

import com.google.gson.annotations.SerializedName;

public class ApiUser {

    @SerializedName("id")
    private int id;

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

    private ApiUser(Builder builder) {
        id = builder.id;
        phone = builder.phone;
        username = builder.username;
        website = builder.website;
        address = builder.address;
        email = builder.email;
        company = builder.company;
        name = builder.name;
    }

    public int getId() {
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


    public static final class Builder {
        private int id;
        private String phone;
        private String username;
        private String website;
        private ApiAddress address;
        private String email;
        private ApiCompany company;
        private String name;

        public Builder() {
        }

        public Builder id(int val) {
            id = val;
            return this;
        }

        public Builder phone(String val) {
            phone = val;
            return this;
        }

        public Builder username(String val) {
            username = val;
            return this;
        }

        public Builder website(String val) {
            website = val;
            return this;
        }

        public Builder address(ApiAddress val) {
            address = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder company(ApiCompany val) {
            company = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public ApiUser build() {
            return new ApiUser(this);
        }
    }
}

package com.ibracero.postapp.data.datasources.network.model;

import com.google.gson.annotations.SerializedName;

public class ApiPost {

    @SerializedName("userId")
    private int userId;

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("body")
    private String body;

    private ApiPost(Builder builder) {
        userId = builder.userId;
        id = builder.id;
        title = builder.title;
        body = builder.body;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }


    public static final class Builder {
        private int userId;
        private int id;
        private String title;
        private String body;

        public Builder() {
        }

        public Builder userId(int val) {
            userId = val;
            return this;
        }

        public Builder id(int val) {
            id = val;
            return this;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder body(String val) {
            body = val;
            return this;
        }

        public ApiPost build() {
            return new ApiPost(this);
        }
    }
}

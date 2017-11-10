package com.ibracero.postapp.data.datasources.network.model;

import com.google.gson.annotations.SerializedName;

public class ApiComment {

    @SerializedName("postId")
    private int postId;

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("body")
    private String body;

    private ApiComment(Builder builder) {
        postId = builder.postId;
        name = builder.name;
        email = builder.email;
        body = builder.body;
    }

    public int getPostId() {
        return postId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }

    public static final class Builder {
        private int postId;
        private String name;
        private String email;
        private String body;

        public Builder() {
        }

        public Builder postId(int val) {
            postId = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder body(String val) {
            body = val;
            return this;
        }

        public ApiComment build() {
            return new ApiComment(this);
        }
    }
}

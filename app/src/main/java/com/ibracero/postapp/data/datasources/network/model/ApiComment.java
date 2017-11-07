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
}

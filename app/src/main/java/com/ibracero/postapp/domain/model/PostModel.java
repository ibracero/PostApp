package com.ibracero.postapp.domain.model;

public class PostModel {

    private int userId;

    private int id;

    private String title;

    private String body;

    private PostModel(Builder builder) {
        setUserId(builder.userId);
        setId(builder.id);
        setTitle(builder.title);
        setBody(builder.body);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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

        public PostModel build() {
            return new PostModel(this);
        }
    }
}

package com.ibracero.postapp.domain.model;

public class Comment {

    private int postId;
    private String name;
    private String email;
    private String body;

    private Comment(Builder builder) {
        setPostId(builder.postId);
        setName(builder.name);
        setEmail(builder.email);
        setBody(builder.body);
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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

        public Comment build() {
            return new Comment(this);
        }
    }
}

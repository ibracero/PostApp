package com.ibracero.postapp.domain.model;

import java.io.Serializable;

public class CommentModel implements Serializable {

    private int postId;
    private String name;
    private String email;
    private String body;

    private CommentModel(Builder builder) {
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

        public CommentModel build() {
            return new CommentModel(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentModel that = (CommentModel) o;

        if (postId != that.postId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        return body != null ? body.equals(that.body) : that.body == null;
    }

    @Override
    public int hashCode() {
        int result = postId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        return result;
    }
}

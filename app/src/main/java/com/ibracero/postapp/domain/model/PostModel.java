package com.ibracero.postapp.domain.model;

import java.io.Serializable;
import java.util.List;

public class PostModel implements Serializable {

    private int userId;

    private int id;

    private String title;

    private String body;

    private List<CommentModel> comments;

    private UserModel writer;

    private PostModel(Builder builder) {
        setUserId(builder.userId);
        setId(builder.id);
        setTitle(builder.title);
        setBody(builder.body);
        setComments(builder.comments);
        setWriter(builder.writer);
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

    public List<CommentModel> getComments() {
        return comments;
    }

    public void setComments(List<CommentModel> comments) {
        this.comments = comments;
    }

    public UserModel getWriter() {
        return writer;
    }

    public void setWriter(UserModel writer) {
        this.writer = writer;
    }

    public static final class Builder {
        private int userId;
        private int id;
        private String title;
        private String body;
        private List<CommentModel> comments;
        private UserModel writer;

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

        public Builder comments(List<CommentModel> val) {
            comments = val;
            return this;
        }

        public Builder writer(UserModel val) {
            writer = val;
            return this;
        }

        public PostModel build() {
            return new PostModel(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostModel postModel = (PostModel) o;

        return id == postModel.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}

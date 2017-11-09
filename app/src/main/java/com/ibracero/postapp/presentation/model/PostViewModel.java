package com.ibracero.postapp.presentation.model;

public class PostViewModel {

    private int id;

    private String title;

    private PostViewModel(Builder builder) {
        id = builder.id;
        title = builder.title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public static final class Builder {
        private int id;
        private String title;

        public Builder() {
        }

        public Builder id(int val) {
            id = val;
            return this;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public PostViewModel build() {
            return new PostViewModel(this);
        }
    }
}

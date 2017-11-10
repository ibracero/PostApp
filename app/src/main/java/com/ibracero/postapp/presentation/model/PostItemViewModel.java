package com.ibracero.postapp.presentation.model;

public class PostItemViewModel {

    private int id;
    private String title;
    private String writerImage;

    private PostItemViewModel(Builder builder) {
        id = builder.id;
        title = builder.title;
        writerImage = builder.writerImage;
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

    public String getWriterImage() {
        return writerImage;
    }

    public void setWriterImage(String writerImage) {
        this.writerImage = writerImage;
    }

    public static final class Builder {
        private int id;
        private String title;
        private String writerImage;

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

        public Builder writerImage(String val) {
            writerImage = val;
            return this;
        }

        public PostItemViewModel build() {
            return new PostItemViewModel(this);
        }
    }
}

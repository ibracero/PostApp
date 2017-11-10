package com.ibracero.postapp.presentation.model;

public class PostDetailViewModel {

    String postTitle;
    String postBody;
    String writerName;
    String writerImageUrl;
    String commentCounter;

    private PostDetailViewModel(Builder builder) {
        setPostTitle(builder.postTitle);
        setPostBody(builder.postBody);
        setWriterName(builder.writerName);
        setWriterImageUrl(builder.writerImageUrl);
        setCommentCounter(builder.commentCounter);
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public String getWriterImageUrl() {
        return writerImageUrl;
    }

    public void setWriterImageUrl(String writerImageUrl) {
        this.writerImageUrl = writerImageUrl;
    }

    public String getCommentCounter() {
        return commentCounter;
    }

    public void setCommentCounter(String commentCounter) {
        this.commentCounter = commentCounter;
    }


    public static final class Builder {
        private String postTitle;
        private String postBody;
        private String writerName;
        private String writerImageUrl;
        private String commentCounter;

        public Builder() {
        }

        public Builder postTitle(String val) {
            postTitle = val;
            return this;
        }

        public Builder postBody(String val) {
            postBody = val;
            return this;
        }

        public Builder writerName(String val) {
            writerName = val;
            return this;
        }

        public Builder writerImageUrl(String val) {
            writerImageUrl = val;
            return this;
        }

        public Builder commentCounter(String val) {
            commentCounter = val;
            return this;
        }

        public PostDetailViewModel build() {
            return new PostDetailViewModel(this);
        }
    }
}

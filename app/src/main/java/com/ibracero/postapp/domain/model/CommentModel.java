package com.ibracero.postapp.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

public class CommentModel implements Parcelable {

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

    protected CommentModel(Parcel in) {
        postId = in.readInt();
        name = in.readString();
        email = in.readString();
        body = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(postId);
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(body);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CommentModel> CREATOR = new Creator<CommentModel>() {
        @Override
        public CommentModel createFromParcel(Parcel in) {
            return new CommentModel(in);
        }

        @Override
        public CommentModel[] newArray(int size) {
            return new CommentModel[size];
        }
    };

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
}

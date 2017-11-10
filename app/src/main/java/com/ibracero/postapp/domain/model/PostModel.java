package com.ibracero.postapp.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class PostModel implements Parcelable {

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

    protected PostModel(Parcel in) {
        userId = in.readInt();
        id = in.readInt();
        title = in.readString();
        body = in.readString();
        comments = in.createTypedArrayList(CommentModel.CREATOR);
        writer = in.readParcelable(UserModel.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(userId);
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(body);
        dest.writeTypedList(comments);
        dest.writeParcelable(writer, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PostModel> CREATOR = new Creator<PostModel>() {
        @Override
        public PostModel createFromParcel(Parcel in) {
            return new PostModel(in);
        }

        @Override
        public PostModel[] newArray(int size) {
            return new PostModel[size];
        }
    };

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
}

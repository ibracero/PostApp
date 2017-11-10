package com.ibracero.postapp.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable{

    private int id;

    private String username;

    private String email;

    private UserModel(Builder builder) {
        id = builder.id;
        username = builder.username;
        email = builder.email;
    }

    protected UserModel(Parcel in) {
        id = in.readInt();
        username = in.readString();
        email = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(username);
        dest.writeString(email);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }


    public static final class Builder {
        private int id;
        private String username;
        private String email;

        public Builder() {
        }

        public Builder id(int val) {
            id = val;
            return this;
        }

        public Builder username(String val) {
            username = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public UserModel build() {
            return new UserModel(this);
        }
    }
}

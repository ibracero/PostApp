package com.ibracero.postapp.domain.model;

import java.io.Serializable;

public class UserModel implements Serializable {

    private int id;

    private String username;

    private String email;

    private UserModel(Builder builder) {
        id = builder.id;
        username = builder.username;
        email = builder.email;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserModel userModel = (UserModel) o;

        return id == userModel.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}

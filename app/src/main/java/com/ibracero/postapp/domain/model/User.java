package com.ibracero.postapp.domain.model;

public class User {

    private String id;

    private String phone;

    private String username;

    private String website;

    private Address address;

    private String email;

    private Company company;

    private String name;

    private User(Builder builder) {
        setId(builder.id);
        setPhone(builder.phone);
        setUsername(builder.username);
        setWebsite(builder.website);
        setAddress(builder.address);
        setEmail(builder.email);
        setCompany(builder.company);
        setName(builder.name);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static final class Builder {
        private String id;
        private String phone;
        private String username;
        private String website;
        private Address address;
        private String email;
        private Company company;
        private String name;

        public Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder phone(String val) {
            phone = val;
            return this;
        }

        public Builder username(String val) {
            username = val;
            return this;
        }

        public Builder website(String val) {
            website = val;
            return this;
        }

        public Builder address(Address val) {
            address = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder company(Company val) {
            company = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

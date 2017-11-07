package com.ibracero.postapp.domain.model;

public class Address
{
    private Geo geo;

    private String zipcode;

    private String street;

    private String suite;

    private String city;

    private Address(Builder builder) {
        setGeo(builder.geo);
        setZipcode(builder.zipcode);
        setStreet(builder.street);
        setSuite(builder.suite);
        setCity(builder.city);
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public static final class Builder {
        private Geo geo;
        private String zipcode;
        private String street;
        private String suite;
        private String city;

        public Builder() {
        }

        public Builder geo(Geo val) {
            geo = val;
            return this;
        }

        public Builder zipcode(String val) {
            zipcode = val;
            return this;
        }

        public Builder street(String val) {
            street = val;
            return this;
        }

        public Builder suite(String val) {
            suite = val;
            return this;
        }

        public Builder city(String val) {
            city = val;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}
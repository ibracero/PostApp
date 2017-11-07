package com.ibracero.postapp.domain.model;

public class Geo
{
    private String lng;

    private String lat;

    private Geo(Builder builder) {
        setLng(builder.lng);
        setLat(builder.lat);
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public static final class Builder {
        private String lng;
        private String lat;

        public Builder() {
        }

        public Builder lng(String val) {
            lng = val;
            return this;
        }

        public Builder lat(String val) {
            lat = val;
            return this;
        }

        public Geo build() {
            return new Geo(this);
        }
    }
}
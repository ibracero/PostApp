package com.ibracero.postapp.domain.model;

public class Company
{
    private String catchPhrase;

    private String name;

    private String bs;

    private Company(Builder builder) {
        setCatchPhrase(builder.catchPhrase);
        setName(builder.name);
        setBs(builder.bs);
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public static final class Builder {
        private String catchPhrase;
        private String name;
        private String bs;

        public Builder() {
        }

        public Builder catchPhrase(String val) {
            catchPhrase = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder bs(String val) {
            bs = val;
            return this;
        }

        public Company build() {
            return new Company(this);
        }
    }
}
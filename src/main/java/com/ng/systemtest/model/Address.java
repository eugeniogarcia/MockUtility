package com.ng.systemtest.model;

public class Address {

    private String street;
    private String houseNumber;
    private String postalCode;
    private String city;
    private String country;

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public static final class AddressBuilder {
        private String street;
        private String houseNumber;
        private String postalCode;
        private String city;
        private String country;

        private AddressBuilder() {
        }

        public static AddressBuilder anAddress() {
            return new AddressBuilder();
        }

        public AddressBuilder withStreet(String street) {
            this.street = street;
            return this;
        }

        public AddressBuilder withHouseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
            return this;
        }

        public AddressBuilder withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public AddressBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public AddressBuilder withCountry(String country) {
            this.country = country;
            return this;
        }

        public Address build() {
            Address address = new Address();
            address.houseNumber = this.houseNumber;
            address.city = this.city;
            address.street = this.street;
            address.postalCode = this.postalCode;
            address.country = this.country;
            return address;
        }
    }
}

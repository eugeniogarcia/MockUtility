package com.ng.systemtest.app.model;

public class ContactMedium {

    private String phoneNumberMobile;
    private String phoneNumberFixnet;
    private String email;

    public String getPhoneNumberMobile() {
        return phoneNumberMobile;
    }

    public String getPhoneNumberFixnet() {
        return phoneNumberFixnet;
    }

    public String getEmail() {
        return email;
    }

    public static final class ContactMediumBuilder {
        private String phoneNumberMobile;
        private String phoneNumberFixnet;
        private String email;

        private ContactMediumBuilder() {
        }

        public static ContactMediumBuilder aContactMedium() {
            return new ContactMediumBuilder();
        }

        public ContactMediumBuilder withPhoneNumberMobile(String phoneNumberMobile) {
            this.phoneNumberMobile = phoneNumberMobile;
            return this;
        }

        public ContactMediumBuilder withPhoneNumberFixnet(String phoneNumberFixnet) {
            this.phoneNumberFixnet = phoneNumberFixnet;
            return this;
        }

        public ContactMediumBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public ContactMedium build() {
            ContactMedium contactMedium = new ContactMedium();
            contactMedium.phoneNumberMobile = this.phoneNumberMobile;
            contactMedium.phoneNumberFixnet = this.phoneNumberFixnet;
            contactMedium.email = this.email;
            return contactMedium;
        }
    }
}

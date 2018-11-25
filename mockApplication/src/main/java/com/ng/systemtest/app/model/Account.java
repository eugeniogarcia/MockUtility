package com.ng.systemtest.app.model;

import java.util.Date;

public class Account {

    private String scn;
    private String salutation;
    private String firstName;
    private String lastName;
    private Language language;
    private Date birthDate;
    private Gender gender;
    private Address address;
    private ContactMedium contactMedium;
    private int regLevel = 0;
    private int authLevel = 0;

    private Account(final String scn, final String salutation, final String firstName, final String lastName) {
        this.scn = scn;
        this.salutation = salutation;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getScn() {
        return scn;
    }

    public String getSalutation() {
        return salutation;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Language getLanguage() {
        return language;
    }

    public Date getBirthDate() { return birthDate; }

    public Gender getGender() { return gender; }

    public Address getAddress() { return address; }

    public ContactMedium getContactMedium() { return contactMedium; }

    public int getRegLevel() {
        return regLevel;
    }

    public int getAuthLevel() {
        return authLevel;
    }

    public static final class AccountBuilder {
        private String scn;
        private String salutation;
        private String firstName;
        private String lastName;
        private Language language = Language.EN;
        private Date birthDate;
        private Gender gender;
        private Address address;
        private ContactMedium contactMedium;
        private int regLevel = 0;
        private int authLevel = 0;

        private AccountBuilder() {
        }

        public static AccountBuilder anAccount() {
            return new AccountBuilder();
        }

        public AccountBuilder withScn(String scn) {
            this.scn = scn;
            return this;
        }

        public AccountBuilder withSalutation(String salutation) {
            this.salutation = salutation;
            return this;
        }

        public AccountBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public AccountBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public AccountBuilder withLanguage(Language language) {
            this.language = language;
            return this;
        }

        public AccountBuilder withBirthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public AccountBuilder withGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public AccountBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public AccountBuilder withContactMedium(ContactMedium contactMedium) {
            this.contactMedium = contactMedium;
            return this;
        }

        public AccountBuilder withRegLevel(int regLevel) {
            this.regLevel = regLevel;
            return this;
        }

        public AccountBuilder withAuthLevel(int authLevel) {
            this.authLevel = authLevel;
            return this;
        }

        public Account build() {
            Account account = new Account(scn, salutation, firstName, lastName);
            account.address = this.address;
            account.birthDate = this.birthDate;
            account.contactMedium = this.contactMedium;
            account.language = this.language;
            account.regLevel = this.regLevel;
            account.gender = this.gender;
            account.authLevel = this.authLevel;
            return account;
        }
    }
}

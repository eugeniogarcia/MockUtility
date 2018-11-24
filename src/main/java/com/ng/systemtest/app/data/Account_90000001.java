package com.ng.systemtest.app.data;

import java.util.Date;

import com.ng.systemtest.model.Account;
import com.ng.systemtest.model.Address;
import com.ng.systemtest.model.ContactMedium;
import com.ng.systemtest.model.Gender;

public class Account_90000001 {

    public static Account build() {
        return Account.AccountBuilder.anAccount()
                .withScn("90000001")
                .withGender(Gender.FEMALE)
                .withSalutation("Ms.")
                .withFirstName("Suanne")
                .withLastName("Viox")
                .withBirthDate(new Date(-332106348))
                .withAddress(
                        Address.AddressBuilder.anAddress()
                                .withStreet("Bahnhofstrasse")
                                .withHouseNumber("47")
                                .withPostalCode("10698")
                                .withCity("Berlin")
                                .withCountry("Germany")
                                .build()
                )
                .withContactMedium(
                        ContactMedium.ContactMediumBuilder.aContactMedium()
                                .withPhoneNumberMobile("+41799066680")
                                .withEmail("marco.pagamici@swisscom.com")
                                .build()
                )
                .build();
    }
}

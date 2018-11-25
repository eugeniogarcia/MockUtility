package com.ng.systemtest.app.mocks.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ng.systemtest.Templates;
import com.ng.systemtest.app.AccountMockContext;
import com.ng.systemtest.app.model.Account;
import com.ng.systemtest.app.model.Address;
import com.ng.systemtest.app.model.ContactMedium;
import com.ng.systemtest.app.model.Gender;

@RestController
@RequestMapping(value = "/ngeso/v1")
public class mockController {
	private static final Logger LOGGER = LoggerFactory.getLogger(mockController.class);

	@RequestMapping(value = "/individuals",produces = { "application/json" }, method = RequestMethod.GET)
	public ResponseEntity<String> createLog(@RequestParam("scn") String scn) {
		LOGGER.info("Processing a requesto to /individuals?scn={}",scn);
		LOGGER.info("Preparing the mocking data");

		final Account cuenta=Account.AccountBuilder.anAccount()
        .withScn(scn)
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

		final String cuerpo=Templates.process("individuals/individuals.vm", new AccountMockContext(cuenta).getVelocityContext());
		//Reply is ready
		final ResponseEntity<String> respuesta=new ResponseEntity<String>(cuerpo,HttpStatus.OK);
		LOGGER.info("Replying to requesto to /individuals?scn={}",scn);
		return respuesta;
	}
}

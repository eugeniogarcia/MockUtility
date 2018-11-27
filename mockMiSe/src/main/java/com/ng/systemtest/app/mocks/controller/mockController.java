package com.ng.systemtest.app.mocks.controller;

import static com.ng.systemtest.Templates.fromResource;

import java.util.Date;
import java.util.Random;

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

		String pais="";
		if(scn.compareTo("A")==0) {
			pais="Italiana";
			}
		else {
			pais="god only knows";
		}
		String phone="",email="";
		if(Math.random()<0.5) {
			phone="+41799066680";
		}
		if(Math.random()<0.5) {
			email="marco.pagamici@swisscom.com";
		}        
        
		final Account cuenta=Account.AccountBuilder.anAccount()
        .withScn(scn)
        .withGender(Gender.FEMALE)
        .withSalutation("Ms.")
        .withFirstName("Suanne")
        .withLastName("Viox")
        .withBirthDate(new Date(-332106348))
        .withNationality(pais)
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
                        .withPhoneNumberMobile(phone)
                        .withEmail(email)
                        .build()
        )
        .build();

		String cuerpo;
		switch(scn) {
			case "A":
				cuerpo=Templates.process("individuals/individuals_ms.vm", new AccountMockContext(cuenta).getVelocityContext());
				break;
			case "B":
				cuerpo=fromResource("sockjs-node/sockjs-node.json");
				break;
			default:
				cuerpo=Templates.process("individuals/individuals.vm", new AccountMockContext(cuenta).getVelocityContext());
		}
		
		//Reply is ready
		final ResponseEntity<String> respuesta=new ResponseEntity<String>(cuerpo,HttpStatus.OK);
		LOGGER.info("Replying to requesto to /individuals?scn={}",scn);
		return respuesta;
	}
}

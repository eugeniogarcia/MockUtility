package com.ng.systemtest.app.mocks;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.put;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;

import com.ng.systemtest.Templates;
import com.ng.systemtest.app.AccountMockContext;

public class CallforwardingPreferences {

	private final AccountMockContext mockContext;

	public CallforwardingPreferences(AccountMockContext mockContext) {
		super();
		this.mockContext = mockContext;
	}

	public void build() {
		stubFor(get(
				urlMatching(mockContext.getBaseUrl() + "/user-preferences/callforwarding.*"))
						.willReturn(aResponse()
								.withHeader("Content-type", "application/json")
								.withBody(Templates.process("userpref/callforwarding/get-callforwarding-pref.vm", mockContext.getVelocityContext()))
                                //En este caso especificamos ademas que queremos transformar la salida. Esto nos permite
								//aplicar logica en el body, que en tiempo de ejecución se ejecutara, tomando por ejemplo
								//valores del imput, reemplazando campos por valores del input, ... (ver doc adjunto
								.withTransformers("response-template")));

		stubFor(put(urlMatching(mockContext.getBaseUrl() + "/user-preferences/callforwarding"))
						.willReturn(aResponse()
								.withHeader("Content-type", "application/json")
								.withBody(Templates.process("userpref/callforwarding/put-callforwarding-pref.vm", mockContext.getVelocityContext()))
                                .withTransformers("response-template")));
	}
}

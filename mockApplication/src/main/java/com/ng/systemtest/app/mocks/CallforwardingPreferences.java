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
				urlMatching(mockContext.getBaseUrl() + "/oce/gp/v1/user-preferences/callforwarding.*"))
						.willReturn(aResponse()
								.withHeader("Content-type", "application/json")
								.withBody(Templates.process("userpref/callforwarding/get-callforwarding-pref.vm", mockContext.getVelocityContext()))
                                .withTransformers("response-template")));

		stubFor(put(urlMatching(mockContext.getBaseUrl() + "/oce/gp/v2/user-preferences/callforwarding"))
						.willReturn(aResponse()
								.withHeader("Content-type", "application/json")
								.withBody(Templates.process("userpref/callforwarding/put-callforwarding-pref.vm", mockContext.getVelocityContext()))
                                .withTransformers("response-template")));
	}
}

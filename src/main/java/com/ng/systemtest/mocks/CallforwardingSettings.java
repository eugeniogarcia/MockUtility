package com.ng.systemtest.mocks;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.put;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;

import com.ng.systemtest.Templates;
import com.ng.systemtest.app.AccountMockContext;

public class CallforwardingSettings {

	private final AccountMockContext mockContext;

	public CallforwardingSettings(AccountMockContext mockContext) {
		super();
		this.mockContext = mockContext;
	}

	public void build() {
		stubFor(get(urlMatching(mockContext.getBaseUrl() + "/emarestserver/scmsubscribers/.*"))
				.willReturn(aResponse()
						.withHeader("Content-type", "text/xml")
						.withBody(Templates.process("ema/emarestserver/scmsubscribers/callforwarding-settings.vm",
								mockContext.getVelocityContext()))
						.withTransformers("response-template")));

		stubFor(put(urlMatching(mockContext.getBaseUrl() + "/emarestserver/scmsubscribers/.*"))
				.willReturn(aResponse().withStatus(200)));
	}
}

package com.ng.systemtest.app.mocks;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;

import com.ng.systemtest.Templates;
import com.ng.systemtest.app.AccountMockContext;

public class Individuals {

    private final AccountMockContext mockContext;

    public Individuals(AccountMockContext mockContext) {
        this.mockContext = mockContext;
    }

    public void build() {
        stubFor(get(urlMatching(mockContext.getBaseUrl() + "/individuals.*")).withQueryParam("scn", equalTo(mockContext.getAccount().getScn()))
                .willReturn(aResponse()
                        .withHeader("Content-type", "application/json")
                        .withBody(Templates.process("oce/fda/v1/individuals/individuals.vm", mockContext.getVelocityContext()))));
    }

}

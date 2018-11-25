package com.ng.systemtest.app.mocks;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;

import com.ng.systemtest.Templates;
import com.ng.systemtest.app.AccountMockContext;

public class UserProfile {

    private static final String MOCKED_SCN_HEADER_KEY = "mocked-scn";
    private final AccountMockContext mockContext;

    public UserProfile(AccountMockContext mockContext) {
        this.mockContext = mockContext;
    }

    public void build() {
        stubFor(get(urlMatching(mockContext.getBaseUrl() + "/oce/gp/v1/user/profile")).withHeader(MOCKED_SCN_HEADER_KEY, containing(mockContext.getAccount().getScn()))
                .willReturn(aResponse()
                        .withHeader("Content-type", "application/json")
                        .withBody(Templates.process("oce/gp/v1/user/profile/profile.vm", mockContext.getVelocityContext()))));
    }

}

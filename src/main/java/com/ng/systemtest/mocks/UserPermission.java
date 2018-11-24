package com.ng.systemtest.mocks;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;

import com.ng.systemtest.Templates;
import com.ng.systemtest.app.AccountMockContext;

public class UserPermission {

    private final AccountMockContext mockContext;

    public UserPermission(AccountMockContext mockContext) {
        this.mockContext = mockContext;
    }

    public void build() {
        stubFor(get(urlMatching(mockContext.getBaseUrl() + "/oce/gp/v1/user/permissions"))
                .willReturn(aResponse()
                        .withHeader("Content-type", "application/json")
                        .withBody(Templates.process("oce/gp/v1/user/permissions/permissions.vm", mockContext.getVelocityContext()))));
    }

}

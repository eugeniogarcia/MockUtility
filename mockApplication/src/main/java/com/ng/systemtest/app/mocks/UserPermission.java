package com.ng.systemtest.app.mocks;

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
        stubFor(get(urlMatching(mockContext.getBaseUrl() + "/user/permissions"))
                .willReturn(aResponse()
                        .withHeader("Content-type", "application/json")
                        .withBody(Templates.process("permissions/permissions.vm", mockContext.getVelocityContext()))));
    }

}

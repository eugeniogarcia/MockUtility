package com.ng.systemtest.mocks;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.ng.systemtest.Templates.fromResource;

import com.ng.systemtest.MockContext;

public class SockJS {

    private MockContext mockContext;

    public SockJS(MockContext mockContext) {
        this.mockContext = mockContext;
    }

    public void build() {
        stubFor(get(urlMatching( mockContext.getBaseUrl() + "/sockjs-node/.*"))
                .willReturn(aResponse()
                        .withHeader("Content-type", "application/json")
                        .withBody(fromResource("sockjs-node/sockjs-node.json"))));
    }

}

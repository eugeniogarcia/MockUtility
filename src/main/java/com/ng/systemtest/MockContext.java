package com.ng.systemtest;

import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;

public abstract class MockContext {

    protected final String baseUrl;
    protected final VelocityContext velocityContext;

    public MockContext(String baseUrl) {
        this.baseUrl = baseUrl;
        velocityContext = new VelocityContext();
        velocityContext.put("StringUtils", StringUtils.class);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public VelocityContext getVelocityContext() {
        return velocityContext;
    }
}

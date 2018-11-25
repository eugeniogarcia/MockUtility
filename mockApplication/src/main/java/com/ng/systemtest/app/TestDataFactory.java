package com.ng.systemtest.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ng.systemtest.MockServer;
import com.ng.systemtest.iDataFactory;
import com.ng.systemtest.app.data.Account_90000001;
import com.ng.systemtest.app.mocks.AssetsBundle;
import com.ng.systemtest.app.mocks.CallforwardingPreferences;
import com.ng.systemtest.app.mocks.CallforwardingSettings;
import com.ng.systemtest.app.mocks.Individuals;
import com.ng.systemtest.app.mocks.Permission;
import com.ng.systemtest.app.mocks.SockJS;
import com.ng.systemtest.app.mocks.UserPermission;
import com.ng.systemtest.app.mocks.UserProfile;

public class TestDataFactory implements iDataFactory{

	private static final Logger LOGGER = LoggerFactory.getLogger(TestDataFactory.class);

    public void createTestData(final String baseUrl, final MockServer server) {
        LOGGER.info("Creating collection [{}] of mocks", baseUrl);
        trainMocks(new AccountMockContext(baseUrl, Account_90000001.build()));
        LOGGER.info("Finished creating mocks");
    }

    public void trainMocks(AccountMockContext mockContext) {
        new SockJS(mockContext).build();
        new Permission(mockContext).build();
        new UserProfile(mockContext).build();
        new UserPermission(mockContext).build();
        new Individuals(mockContext).build();
        new AssetsBundle(mockContext).build();
        new CallforwardingSettings(mockContext).build();
        new CallforwardingPreferences(mockContext).build();
    }



}

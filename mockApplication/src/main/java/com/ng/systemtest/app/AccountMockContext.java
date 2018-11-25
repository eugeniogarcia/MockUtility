package com.ng.systemtest.app;

import com.ng.systemtest.MockContext;
import com.ng.systemtest.app.model.Account;

public class AccountMockContext extends MockContext{

    private final Account account;

    public AccountMockContext(String baseUrl, Account account) {
    	super(baseUrl);
        this.account = account;
        velocityContext.put("account", account);
    }

    public Account getAccount() {
        return account;
    }

}

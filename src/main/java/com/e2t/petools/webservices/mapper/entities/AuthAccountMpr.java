package com.e2t.petools.webservices.mapper.entities;

import com.e2t.petools.dao.entities.Account;

public class AuthAccountMpr {

    private String login;
    private String password;

    public AuthAccountMpr() {
    }

    public AuthAccountMpr(Account account) {
        this.login = (account.getLogin() != null) ? account.getLogin() : null;
        this.password = (account.getPassword() != null) ? account.getPassword() : null;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

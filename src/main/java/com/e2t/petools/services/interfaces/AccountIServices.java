package com.e2t.petools.services.interfaces;

import com.e2t.petools.dao.entities.Account;

public interface AccountIServices {

    Account authentication(Account account);

    Account createAccount(Account account);

}

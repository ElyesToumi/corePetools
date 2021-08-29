package com.e2t.petools.services.implementation;

import com.e2t.petools.dao.entities.Account;
import com.e2t.petools.dao.repository.AccountIRepository;
import com.e2t.petools.services.interfaces.AccountIServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServices implements AccountIServices {

    @Autowired
    private AccountIRepository accountRepository;

    @Override
    public Account authentication(Account account) {
        if (account != null && account.getLogin() != null && account.getPassword() != null) {
            return accountRepository.findByLoginAndPassword(account.getLogin(), account.getPassword());
        }
        return null;
    }

    @Override
    public Account createAccount(Account account) {
        if (account != null &&
                account.getEmail() != null &&
                accountRepository.findByEmail(account.getEmail()) == null) {
            return accountRepository.save(account);
        }
        return null;
    }
}

package com.e2t.petools.dao.repository;

import com.e2t.petools.dao.entities.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountIRepository extends CrudRepository<Account, Long> {

    Account findByEmail(String email);

    Account findByLoginAndPassword(String login, String password);

}

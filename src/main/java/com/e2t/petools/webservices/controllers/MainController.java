package com.e2t.petools.webservices.controllers;

import com.e2t.petools.dao.entities.Account;
import com.e2t.petools.services.interfaces.AccountIServices;
import com.e2t.petools.webservices.mapper.common.PetMapper;
import com.e2t.petools.webservices.mapper.entities.AccountMpr;
import com.e2t.petools.webservices.mapper.entities.AuthAccountMpr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("cpet")
public class MainController {

    @Autowired
    private AccountIServices accountServices;

    @PostMapping(value = "/createAccount")
    public AccountMpr createUser(@RequestBody AccountMpr accountMpr) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Account account = accountServices.createAccount((Account) PetMapper.parseObjectToType(accountMpr, Account.class));
        return (AccountMpr) PetMapper.parseObjectToType(account,AccountMpr.class);
    }

    @PostMapping(value = "/authenticateAccount")
    public AccountMpr getUserByLoginAndPassword(@RequestBody AuthAccountMpr authAccountMpr) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Account account = accountServices.authentication((Account) PetMapper.parseObjectToType(authAccountMpr, Account.class));
        return (AccountMpr) PetMapper.parseObjectToType(account,AccountMpr.class);
    }

}
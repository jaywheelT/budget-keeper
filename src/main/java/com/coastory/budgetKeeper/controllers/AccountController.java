package com.coastory.budgetKeeper.controllers;

import com.coastory.budgetKeeper.dao.models.Account;
import com.coastory.budgetKeeper.dao.repositories.AccountRepository;
import com.coastory.budgetKeeper.utils.models.ActionType;
import com.coastory.budgetKeeper.utils.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/budgetKeeper")
public class AccountController {

  @Autowired
  AccountRepository accountRepository;

  @RequestMapping(path = "/account", method = RequestMethod.POST)
  public @ResponseBody
  Message addAccount(@RequestBody Account account) {
    accountRepository.save(account);
    return new Message(true, Account.class.getName(), ActionType.ADD);
  }

  @RequestMapping(path = "/account", method = RequestMethod.GET, produces = "application/json")
  public Iterable<Account> getAccounts() {
    return accountRepository.findAll();
  }

  @RequestMapping(path = "/account/{id}", method = RequestMethod.GET, produces = "application/json")
  public Account getAccountById(@PathVariable Long id) {
    return accountRepository.findOne(id);
  }

}

package com.coastory.budgetKeeper.controllers;

import com.alibaba.fastjson.JSON;
import com.coastory.budgetKeeper.dao.models.Entry;
import com.coastory.budgetKeeper.dao.repositories.EntryRepository;
import com.coastory.budgetKeeper.utils.models.ActionType;
import com.coastory.budgetKeeper.utils.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
@RequestMapping(path = "/budgetKeeper")
public class EntryController {
  @Autowired
  EntryRepository entryRepository;

  @Autowired
  EntityManager entityManager;

  @RequestMapping(path = "/entry", method = RequestMethod.POST)
  public Message addExpense(@RequestBody Entry expenseEntry) {
    entryRepository.save(expenseEntry);
    return new Message(true, Entry.class.getName(), ActionType.ADD);

  }

  @RequestMapping(path = "/entry", method = RequestMethod.GET, produces = "application/json")
  public Iterable<Entry> getEntries() {
    return entryRepository.findAll();
  }
}

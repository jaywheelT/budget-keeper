package com.coastory.budgetKeeper.controllers;

import com.coastory.budgetKeeper.models.Entry;
import com.coastory.budgetKeeper.repositories.EntryRepository;
import com.coastory.budgetKeeper.utils.ActionType;
import com.coastory.budgetKeeper.utils.Message;
import com.coastory.budgetKeeper.utils.MessageBody;
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
  public String addExpense(@RequestBody Entry expenseEntry) {
    entryRepository.save(expenseEntry);
    return Message.jsonMessage(new MessageBody(true, Entry.class.getName(), ActionType.ADD));

  }

  @RequestMapping(path = "/entry", method = RequestMethod.GET, produces = "application/json")
  public Iterable<Entry> getEntries() {
    return entryRepository.findAll();
  }
}

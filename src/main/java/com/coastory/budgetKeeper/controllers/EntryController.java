package com.coastory.budgetKeeper.controllers;

import com.coastory.budgetKeeper.dao.models.Entry;
import com.coastory.budgetKeeper.dao.repositories.EntryRepository;
import com.coastory.budgetKeeper.utils.models.ActionType;
import com.coastory.budgetKeeper.utils.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/budgetKeeper")
public class EntryController {
  @Autowired
  EntryRepository entryRepository;

  @RequestMapping(path = "/entry", method = RequestMethod.POST)
  public Message addEntries(@RequestBody Entry expenseEntry) {
    entryRepository.save(expenseEntry);
    return new Message(true, Entry.class.getName(), ActionType.ADD);

  }

  @RequestMapping(path = "/entry", method = RequestMethod.PATCH)
  public Message updateEntry(@RequestBody Entry expenseEntry) {
    entryRepository.save(expenseEntry);
    return new Message(true, Entry.class.getName(), ActionType.UPDATE);

  }

  @RequestMapping(path = "/entry", method = RequestMethod.GET, produces = "application/json")
  public Iterable<Entry> getEntries() {
    return entryRepository.findAll();
  }

  @RequestMapping(path = "/entry/comments", method = RequestMethod.GET, produces = "application/json")
  public List<String> findSimilarComment() {
    return entryRepository.findDistinctComments();
  }

  @RequestMapping(path = "/entry/comments/{categoryId}", method = RequestMethod.GET, produces = "application/json")
  public List<String> findSimilarCommentByCategoryId(@PathVariable int categoryId) {
    return entryRepository.findDistinctCommentsByCategoryId(categoryId);
  }

  @RequestMapping(path = "/entry/comments/{categoryId}/{amount}",
      method = RequestMethod.GET, produces = "application/json")
  public String findSimilarCommentByCategoryId(@PathVariable int categoryId, @PathVariable double amount) {
    return entryRepository.findDistinctCommentsByCategoryIdAndAmount(categoryId, amount)
        .stream()
        .findFirst()
        .orElse(null);
  }
}

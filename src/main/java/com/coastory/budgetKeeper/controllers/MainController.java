package com.coastory.budgetKeeper.controllers;

import com.google.common.collect.Lists;
import com.coastory.budgetKeeper.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class MainController {

  @Autowired
  EntryRepository entryRepository;

  @RequestMapping("/welcome")
  public String welcome(Map<String, Object> model) {
    double allExpense = Lists.newArrayList(entryRepository.findAll()).stream()
        .filter(entry -> entry.getType().equals(0))
        .mapToDouble(entry -> entry.getAmount())
        .sum();

    model.put("allExpense", String.valueOf(allExpense));
    return "index";
  }

  @RequestMapping("/list")
  public String list(Map<String, Object> model) {
    model.put("allEntries", entryRepository.findAll());
    return "list";
  }

}

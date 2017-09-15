package com.coastory.budgetKeeper.controllers;

import com.coastory.budgetKeeper.dao.models.Entry;
import com.coastory.budgetKeeper.dao.repositories.EntryRepository;
import com.coastory.budgetKeeper.services.BalanceService;
import com.coastory.budgetKeeper.utils.models.EntryFliter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

  @Autowired
  private EntryRepository entryRepository;

  @Autowired
  private BalanceService balanceService;

  @RequestMapping("/welcome")
  public String welcome(Map<String, Object> model) {
    List<Entry> entries = balanceService.filterEntries(new EntryFliter.Builder().type(0).build());

    double allExpense = entries.stream()
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

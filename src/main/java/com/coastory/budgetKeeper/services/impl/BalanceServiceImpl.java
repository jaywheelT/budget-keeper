package com.coastory.budgetKeeper.services.impl;

import static java.util.stream.Collectors.toList;

import com.google.common.collect.Lists;
import com.coastory.budgetKeeper.dao.models.Category;
import com.coastory.budgetKeeper.dao.models.Entry;
import com.coastory.budgetKeeper.dao.repositories.EntryRepository;
import com.coastory.budgetKeeper.services.BalanceService;
import com.coastory.budgetKeeper.utils.models.DateFilter;
import com.coastory.budgetKeeper.utils.models.EntryFliter;
import com.coastory.budgetKeeper.utils.DateRangeAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BalanceServiceImpl implements BalanceService {

  @Autowired
  private EntryRepository entryRepository;

  @Override
  public List<Entry> filterEntries(EntryFliter entryFliter) {
    List<Integer> types = entryFliter.getTypes();
    List<Category> categories = entryFliter.getCategories();
    DateFilter dateFilter = entryFliter.getDateFilter();
    if (dateFilter == null) {
      dateFilter = DateRangeAdapter.defaultDateFilter();
    }
    LocalDate start = dateFilter.getStart();
    LocalDate end = dateFilter.getEnd();
    List<Entry> entries;
    entries = getAllEntries().stream()
        .filter(e -> types == null || types.contains(e.getType()))
        .filter(e -> categories == null || categories.contains(e.getCategory()))
        .filter(e -> start.isBefore(e.getDate()) || start.isEqual(e.getDate()))
        .filter(e -> end.isAfter(e.getDate()) || end.isEqual(e.getDate()))
        .collect(toList());

    return entries;
  }

  private List<Entry> getAllEntries() {
    return Lists.newArrayList(entryRepository.findAll());
  }

}

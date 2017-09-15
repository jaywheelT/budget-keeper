package com.coastory.budgetKeeper.services;

import com.coastory.budgetKeeper.dao.models.Entry;
import com.coastory.budgetKeeper.utils.models.EntryFliter;

import java.util.List;

public interface BalanceService {
  public List<Entry> filterEntries(EntryFliter entryFliter);
}

package com.coastory.budgetKeeper.services;

import com.coastory.budgetKeeper.models.Entry;
import com.coastory.budgetKeeper.services.internal.EntryFliter;

import java.util.List;

public interface BalanceService {
  public List<Entry> filterEntries(EntryFliter entryFliter);
}

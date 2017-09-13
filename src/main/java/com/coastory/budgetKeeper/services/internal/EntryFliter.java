package com.coastory.budgetKeeper.services.internal;

import com.coastory.budgetKeeper.models.Category;
import com.coastory.budgetKeeper.utils.DateRange;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Locale;

public class EntryFliter {

  private List<Category> categories;

  private DateFilter dateFilter;

  public List<Category> getCategories() {
    return categories;
  }

  public void setCategories(List<Category> categories) {
    this.categories = categories;
  }

  public DateFilter getDateFilter() {
    return dateFilter;
  }

  public void setDateFilter(DateFilter dateFilter) {
    this.dateFilter = dateFilter;
  }

  public EntryFliter(List<Category> categories, DateFilter dateFilter) {
    this.categories = categories;
    this.dateFilter = dateFilter;
  }
}

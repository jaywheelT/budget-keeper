package com.coastory.budgetKeeper.services.internal;

import com.coastory.budgetKeeper.models.Category;

import java.util.Arrays;
import java.util.List;

public class EntryFliter {

  private List<Category> categories;

  private DateFilter dateFilter;

  private List<Integer> types;

  private EntryFliter(Builder builder) {
    this.categories = builder.categories;
    this.dateFilter = builder.dateFilter;
    this.types = builder.types;
  }

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

  public List<Integer> getTypes() {
    return types;
  }

  public void setTypes(List<Integer> types) {
    this.types = types;
  }

  public static class Builder {

    private List<Category> categories;

    private DateFilter dateFilter;

    private List<Integer> types;

    public Builder() {
    }

    public Builder categories(List<Category> categories) {
      this.categories = categories;
      return this;
    }

    public Builder category(Category category) {
      this.categories = Arrays.asList(category);
      return this;
    }

    public Builder types(List<Integer> types) {
      this.types = types;
      return this;
    }

    public Builder type(Integer type) {
      this.types = Arrays.asList(type);
      return this;
    }

    public Builder date(DateFilter dateFilter) {
      this.dateFilter = dateFilter;
      return this;
    }

    public EntryFliter build() {
      return new EntryFliter(this);
    }
  }
}

package com.coastory.budgetKeeper.utils.models;

import com.coastory.budgetKeeper.dao.models.Category;

import java.util.Arrays;
import java.util.List;

public class EntryFliter {

  private List<Category> categories;

  private DateFilter dateFilter;

  private List<Integer> types;

  private String comment;

  private EntryFliter(Builder builder) {
    this.categories = builder.categories;
    this.dateFilter = builder.dateFilter;
    this.types = builder.types;
    this.comment = builder.comment;
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

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public static class Builder {

    private List<Category> categories;

    private DateFilter dateFilter;

    private List<Integer> types;

    private String comment;

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

    public Builder comment(String comment) {
      this.comment = comment;
      return this;
    }

    public EntryFliter build() {
      return new EntryFliter(this);
    }
  }
}

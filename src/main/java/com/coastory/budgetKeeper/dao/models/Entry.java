package com.coastory.budgetKeeper.dao.models;

import com.alibaba.fastjson.annotation.JSONField;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Entry {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private double amount;

  private String comment;

  @JSONField(format = "MM/dd/yyyy")
  private LocalDate date;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  public Entry() {
  }

  public Entry(double amount, String comment, LocalDate date, Category category) {
    this.amount = amount;
    this.comment = comment;
    this.date = date;
    this.category = category;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }
}

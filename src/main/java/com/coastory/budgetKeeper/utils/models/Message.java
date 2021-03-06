package com.coastory.budgetKeeper.utils.models;

public class Message {

  private boolean isSuccess;

  private String entityName;

  private ActionType action;

  public Message(boolean isSuccess, String entityName, ActionType action) {
    this.isSuccess = isSuccess;
    this.entityName = entityName;
    this.action = action;
  }

  public boolean isSuccess() {
    return isSuccess;
  }

  public void setSuccess(boolean success) {
    isSuccess = success;
  }

  public String getEntityName() {
    return entityName;
  }

  public void setEntityName(String entityName) {
    this.entityName = entityName;
  }

  public ActionType getAction() {
    return action;
  }

  public void setAction(ActionType action) {
    this.action = action;
  }
}

package com.coastory.budgetKeeper.utils;

import com.alibaba.fastjson.JSON;

public class Message {

  public static String jsonMessage(MessageBody messageBody) {
    return JSON.toJSONString(messageBody);
  }
}

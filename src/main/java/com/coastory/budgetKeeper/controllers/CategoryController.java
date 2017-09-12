package com.coastory.budgetKeeper.controllers;

import com.coastory.budgetKeeper.models.Category;
import com.coastory.budgetKeeper.repositories.CategoryRepository;
import com.coastory.budgetKeeper.utils.ActionType;
import com.coastory.budgetKeeper.utils.Message;
import com.coastory.budgetKeeper.utils.MessageBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/bk")
public class CategoryController {

  @Autowired
  CategoryRepository categoryRepository;

  @RequestMapping(path = "/cat", method = RequestMethod.POST)
  public @ResponseBody MessageBody addCategory(@RequestBody Category category) {
    categoryRepository.save(category);
    return new MessageBody(true, Category.class.getName(), ActionType.ADD);
  }

  @RequestMapping(path = "/cat", method = RequestMethod.GET, produces = "application/json")
  public Iterable<Category> getCategories() {
    return categoryRepository.findAll();
  }

  @RequestMapping(path = "/{className}/{instance}", method = RequestMethod.POST)
  public String test(@PathVariable String className, @PathVariable String instance, @RequestBody Category category) {
    return className + "  " + instance + category.getName();
  }

}

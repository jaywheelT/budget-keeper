package com.coastory.budgetKeeper.controllers;

import com.coastory.budgetKeeper.dao.models.Category;
import com.coastory.budgetKeeper.dao.repositories.CategoryRepository;
import com.coastory.budgetKeeper.utils.models.ActionType;
import com.coastory.budgetKeeper.utils.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/budgetKeeper")
public class CategoryController {

  @Autowired
  CategoryRepository categoryRepository;

  @RequestMapping(path = "/category", method = RequestMethod.POST)
  public @ResponseBody Message addCategory(@RequestBody Category category) {
    categoryRepository.save(category);
    return new Message(true, Category.class.getName(), ActionType.ADD);
  }

  @RequestMapping(path = "/category", method = RequestMethod.GET, produces = "application/json")
  public Iterable<Category> getCategories() {
    return categoryRepository.findAllByOrderByTypeDesc();
  }

  @RequestMapping(path = "/{className}/{instance}", method = RequestMethod.POST)
  public String test(@PathVariable String className, @PathVariable String instance, @RequestBody Category category) {
    return className + "  " + instance + category.getName();
  }

}

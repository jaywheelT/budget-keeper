package com.coastory.budgetKeeper.dao.repositories;

import com.coastory.budgetKeeper.dao.models.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
  List<Category> findAllByOrderByTypeDesc();
}

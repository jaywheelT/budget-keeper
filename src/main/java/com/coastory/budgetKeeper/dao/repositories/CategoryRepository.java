package com.coastory.budgetKeeper.dao.repositories;

import com.coastory.budgetKeeper.dao.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}

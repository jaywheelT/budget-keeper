package com.coastory.budgetKeeper.repositories;

import com.coastory.budgetKeeper.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}

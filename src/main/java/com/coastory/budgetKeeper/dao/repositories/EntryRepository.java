package com.coastory.budgetKeeper.dao.repositories;

import com.coastory.budgetKeeper.dao.models.Entry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EntryRepository extends CrudRepository<Entry, Long> {

  @Query("SELECT DISTINCT comment FROM Entry WHERE category_id = ?1 AND amount = ?2")
  List<String> findDistinctCommentsByCategoryIdAndAmount(int categoryId, double amount);

  @Query("SELECT DISTINCT comment FROM Entry")
  List<String> findDistinctComments();
}

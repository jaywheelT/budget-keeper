package com.coastory.budgetKeeper.dao.repositories;

import com.coastory.budgetKeeper.dao.models.Entry;
import org.springframework.data.repository.CrudRepository;

public interface EntryRepository extends CrudRepository<Entry, Long> {

}

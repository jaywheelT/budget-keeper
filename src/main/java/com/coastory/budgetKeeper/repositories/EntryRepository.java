package com.coastory.budgetKeeper.repositories;

import com.coastory.budgetKeeper.models.Entry;
import org.springframework.data.repository.CrudRepository;

public interface EntryRepository extends CrudRepository<Entry, Long> {

}

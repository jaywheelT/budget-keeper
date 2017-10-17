package com.coastory.budgetKeeper.dao.repositories;

import com.coastory.budgetKeeper.dao.models.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}

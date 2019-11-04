package com.example.demo.model;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

    Account findOneByUserId(Long userId);
}

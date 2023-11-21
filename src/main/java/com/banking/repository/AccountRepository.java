package com.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.banking.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	
	
	@Query(value = "select * from account where type=?1", nativeQuery = true)
	List<Account> findAll(String type);

}

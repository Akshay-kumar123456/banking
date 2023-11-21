package com.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.model.AccountDetails;

public interface AccountDetailsRepository  extends JpaRepository<AccountDetails, Integer>{

}

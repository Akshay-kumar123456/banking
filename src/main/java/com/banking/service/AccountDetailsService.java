package com.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.model.AccountDetails;
import com.banking.repository.AccountDetailsRepository;

@Service
public class AccountDetailsService {
	@Autowired
	private AccountDetailsRepository accounTDetailsRepository;

	public AccountDetails insert(AccountDetails accountDetails) {
		
		return accounTDetailsRepository.save(accountDetails);
	}

}

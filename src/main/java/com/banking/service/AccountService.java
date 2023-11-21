package com.banking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.enums.AccountType;
import com.banking.exception.InvalidIdException;
import com.banking.model.Account;
import com.banking.model.AccountHolder;
import com.banking.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;

	public Account insert(Account account) throws InvalidIdException {
		
	if (account.getType().equals( AccountType.BUSINESS)) {
		 return accountRepository.save(account);
	}	
	else  if (account.getType().equals( AccountType.DMAT)) {
    	 return accountRepository.save(account);
     }	
	else  if(	account.getType().equals( AccountType.SAVINGS)) {
    	return accountRepository.save(account);
    }
	else	
	     throw new InvalidIdException("account type not found")	;
    }

	public Account getby(int aid) throws InvalidIdException {
		Optional<Account> optional = accountRepository.findById(aid);
		if(!optional.isPresent())
			throw new InvalidIdException("account  id invalid");
		return optional.get();
	}

	

}

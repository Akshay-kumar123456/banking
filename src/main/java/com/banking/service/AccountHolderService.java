package com.banking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.exception.InvalidIdException;
import com.banking.model.AccountHolder;
import com.banking.repository.AccountHolderRepository;

import antlr.collections.List;

@Service
public class AccountHolderService {
	
	@Autowired
	private AccountHolderRepository accountHolderRepository;

	public AccountHolder insert(AccountHolder accountHolder) {
		
		return accountHolderRepository.save(accountHolder) ;
	}

	public AccountHolder getby(int ahid) throws InvalidIdException {
		Optional<AccountHolder> optional = accountHolderRepository.findById(ahid);
		if(!optional.isPresent())
			throw new InvalidIdException("account holder id invalid");
		return optional.get();
	}

	
}

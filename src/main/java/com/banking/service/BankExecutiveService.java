package com.banking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.exception.InvalidIdException;
import com.banking.model.AccountHolder;
import com.banking.model.BankExecutive;
import com.banking.repository.BankExecutiveRepository;

@Service
public class BankExecutiveService {
	@Autowired
	private BankExecutiveRepository bankExecutiveRepository;

	public BankExecutive insert(BankExecutive bankExecutive) {
		
		return bankExecutiveRepository.save(bankExecutive) ;
	}

	public BankExecutive getby(int eid) throws InvalidIdException {
		Optional<BankExecutive> optional = bankExecutiveRepository.findById(eid);
		if(!optional.isPresent())
			throw new InvalidIdException("executive id invalid");
		return optional.get();
	}

}

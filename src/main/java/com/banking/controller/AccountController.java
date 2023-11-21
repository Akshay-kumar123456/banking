package com.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.exception.InvalidIdException;
import com.banking.model.Account;
import com.banking.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
     @Autowired
	private AccountService accountService;

	@PostMapping("/add")
	public ResponseEntity<?> addAcount(@RequestBody Account account) {

		try {
			account = accountService.insert(account);
			return ResponseEntity.ok().body(account);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	
	
	
	@PutMapping("/updateBalance/{aId}")
	public ResponseEntity<?> updateBalance(@PathVariable("aid") int aid, @RequestBody Account account1) {
		try {
			Account account = accountService.getby(aid);
			if (account1.getType() != null)
				account.setType(account1.getType());

			if (account1.getRateOfInterest() != 0)
				account.setRateOfInterest(account1.getRateOfInterest());

			if (account1.getBalance() != null)
				account.setBalance(account1.getBalance());
			
			account = accountService.insert(account);
			return ResponseEntity.ok().body(account);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
	
	@GetMapping("/getallAccounts/{type}")
	public List<Account> findallAccounts(@PathVariable String type){
		List<Account> list=accountService.findall(type);
		return list;
	}
}

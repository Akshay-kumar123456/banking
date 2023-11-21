package com.banking.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banking.dto.AccountDetailsDto;
import com.banking.exception.InvalidIdException;
import com.banking.model.Account;
import com.banking.model.AccountDetails;
import com.banking.model.AccountHolder;
import com.banking.model.BankExecutive;
import com.banking.service.AccountDetailsService;
import com.banking.service.AccountHolderService;
import com.banking.service.AccountService;
import com.banking.service.BankExecutiveService;

@RestController
@RequestMapping("/accountdetails")
public class AccountDetailsController {
	@Autowired
	private AccountHolderService accountHolderService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private BankExecutiveService bankExecutiveService;
	@Autowired
	private AccountDetailsService accountDetailsService;

	@PostMapping("/add")
	public ResponseEntity<?> addaccountdetails(@RequestBody AccountDetailsDto details) {
		
		int ahid =details.getAccountHolderId();
		int aid = details.getAccountId();
		int eid = details.getBankExecutiveId();
		try {
			AccountDetails accountDetails = new AccountDetails();
			AccountHolder accountHolder= accountHolderService.getby(ahid);
			accountDetails.setAccountHolder(accountHolder);
			Account account = accountService.getby(aid);
			accountDetails.setAccount(account);
			BankExecutive executive = bankExecutiveService.getby(eid);
			accountDetails.setBankexecutive(executive);
			accountDetails.setDateOfCreation(LocalDate.now());
			
			accountDetails=accountDetailsService.insert(accountDetails);
			return ResponseEntity.ok().body(accountDetails);
			
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		
		
		
		
		
		
		
		
	}
	
	
	
		
		
		
	
	
	
}

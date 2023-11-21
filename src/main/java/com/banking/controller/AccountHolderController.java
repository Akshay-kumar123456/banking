package com.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.banking.model.AccountHolder;
import com.banking.service.AccountHolderService;



@RestController
@RequestMapping("/accountholder")
public class AccountHolderController {
	
	@Autowired
    private AccountHolderService accountHolderService;
	
	@PostMapping("/add")
	public AccountHolder addAccountHolder(@RequestBody AccountHolder accountHolder) {
		
		return  accountHolderService.insert(accountHolder);
	}
	
	
	
}

package com.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.banking.enums.Role;
import com.banking.model.BankExecutive;
import com.banking.model.User;
import com.banking.service.BankExecutiveService;
import com.banking.service.UserService;

@RestController
@RequestMapping("/executive")
public class BankExecutiveController {
	@Autowired
	private UserService userService;
	@Autowired
	private BankExecutiveService bankExecutiveService;
	
	
	@PostMapping("/add")
	public BankExecutive addBankExecutive(@RequestBody BankExecutive bankExecutive) {
		User user=bankExecutive.getUser();
		
		user.setRole(Role.EXECUTIVE);
		user = userService.insert(user);
		bankExecutive.setUser(user);
		return bankExecutiveService.insert(bankExecutive);
		
	}


	

}

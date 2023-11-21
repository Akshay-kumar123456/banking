package com.banking.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class AccountDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private LocalDate dateOfCreation;
	@ManyToOne
	private AccountHolder accountHolder;
	@ManyToOne
	private Account account;
	@ManyToOne
	private BankExecutive bankexecutive;
	
	
	public BankExecutive getBankexecutive() {
		return bankexecutive;
	}
	public void setBankexecutive(BankExecutive bankexecutive) {
		this.bankexecutive = bankexecutive;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(LocalDate dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	public AccountHolder getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "AccountDetails [id=" + id + ", dateOfCreation=" + dateOfCreation + ", accountHolder=" + accountHolder
				+ ", account=" + account + ", bankexecutive=" + bankexecutive + "]";
	}
	
	
	

}

package com.bankapp.model.service;

import java.util.List;
import java.util.Optional;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AppUser;

public interface AccountService {
	void blockAccount(Long accountNumber);

	void createAccount(Account account);

	void deposit(Long accountNumber, double amount);

	void withdraw(Long accountNumber, double amount);

	void transfer(Long fromAccNumber, Long toAccNumber, double amount);

	public List<Account> getallAccounts();

	public void deleteAccount(Long id);

	public Account addAccount(Account account);

	public Account updateAccount(Long id, Account account);
	
	public Optional<Account> findAccountById(Long id);
	
	

}

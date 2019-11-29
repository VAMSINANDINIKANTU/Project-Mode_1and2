package com.bankapp.model.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountTranscation;
import com.bankapp.model.entities.AppUser;
import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.repository.AccountRepository;
import com.bankapp.model.repository.AccountTranscationRepository;
import com.bankapp.model.repository.CustomerRepository;
import com.bankapp.model.repository.TransactionLogRepository;
import com.bankapp.model.service.exceptions.AccountNotFoundException;
import com.bankapp.model.service.exceptions.NotSufficientFundException;
import com.bankapp.model.service.exceptions.UserNotFoundException;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AccountTranscationRepository accountTransactionRepository;
	@Autowired
	private TransactionLogRepository transactionLogRepository;

	@Override
	public void blockAccount(Long accountNumber) {

	}

	@Override
	public void createAccount(Account account) {
		/*
		 * accountRepository.save(account);
		 * customerRepository.save(account.getCustomer());
		 */

	}

	@Override
	public void deposit(Long accountNumber, double amount) {
		Account account = accountRepository.findById(accountNumber)
				.orElseThrow(AccountNotFoundException::new);
		account.setBalance(account.getBalance() + amount);

		AccountTranscation accountTransaction = new AccountTranscation(
				"deposit", amount);
		account.addAccountTransaction(accountTransaction);
		accountRepository.save(account);
		TransactionLog log = new TransactionLog(accountNumber, null, "depoist",
				amount, "MeenaKumari", "done");
		transactionLogRepository.save(log);

	}

	@Override
	public void withdraw(Long accountNumber, double amount) {
		Account account = accountRepository.findById(accountNumber)
				.orElseThrow(AccountNotFoundException::new);
		if (account.getBalance() - amount < 100)
			throw new NotSufficientFundException();
		account.setBalance(account.getBalance() - amount);
		AccountTranscation accountTransaction = new AccountTranscation(
				"withdraw", amount);
		account.addAccountTransaction(accountTransaction);
		accountRepository.save(account);
		TransactionLog log = new TransactionLog(accountNumber, null,
				"withdraw", amount, "VenkateshBabu", "done");
		transactionLogRepository.save(log);

	}

	@Override
	public void transfer(Long fromAccNumber, Long toAccNumber, double amount) {

		this.withdraw(fromAccNumber, amount);
		this.deposit(toAccNumber, amount);
		AccountTranscation accountTransaction = new AccountTranscation(
				"transfer", amount);
		TransactionLog log = new TransactionLog(fromAccNumber, toAccNumber,
				"transfer", amount, "VenkateshBabu", "done");
		transactionLogRepository.save(log);

	}

	@Override
	public Account updateAccount(Long id, Account account) {

		Account accounttoBeUpdated = accountRepository.findById(id)
				.orElseThrow(AccountNotFoundException::new);
		accounttoBeUpdated.setBalance(account.getBalance());
		accounttoBeUpdated.setAccountType(account.getAccountType());

		return accountRepository.save(accounttoBeUpdated);
	}

	@Override
	public List<Account> getallAccounts() {

		return accountRepository.findAll();
	}

	@Override
	public void deleteAccount(Long id) {
		accountRepository.deleteById(id);
	}

	@Override
	public Account addAccount(Account account) {

		return accountRepository.save(account);
	}

	@Override
	public Optional<Account> findAccountById(Long id) {
		// TODO Auto-generated method stub
		return accountRepository.findById(id);
	}

}

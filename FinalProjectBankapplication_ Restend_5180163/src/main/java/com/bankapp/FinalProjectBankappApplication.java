package com.bankapp;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountType;
import com.bankapp.model.entities.AppUser;
import com.bankapp.model.entities.Customer;

import com.bankapp.model.repository.AccountRepository;
import com.bankapp.model.repository.AccountTranscationRepository;
import com.bankapp.model.repository.CustomerRepository;
import com.bankapp.model.repository.TransactionLogRepository;
import com.bankapp.model.repository.UserRepository;
import com.bankapp.model.service.AccountService;

@EnableTransactionManagement
@SpringBootApplication
public class FinalProjectBankappApplication implements CommandLineRunner {
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountTranscationRepository accountTransactionRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TransactionLogRepository transactionLogRepository;

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectBankappApplication.class, args);

	}
	@Autowired
	private AccountService accountService;

	@Override
	public void run(String... args) throws Exception {
		

		
		
		  /*Customer customer = new Customer("MeenaKumari", "meena@gmail.com",
		  "4568912345", "Throvagunga", "Ongole", "India", "52264"); Customer
		  customer2 = new Customer("Srinivasarao", "srinu@gmail.com",
		  "987765426", "delhi", "delhi", "India", "52289"); Customer customer3
		  = new Customer("VenkateshBabu", "venky@gmail.com", "9877665535",
		  "noida", "Up", "India", "52264");
		  
		  Account account = new Account(3000.0, customer, false,
		  "savings");
		  Account account2 = new Account(5000.0,
		 customer2, false, "savings");
		  Account account3 = new Account(8000.0, customer3, false, "savings");
		  
		  customer.setAccount(account); customer2.setAccount(account2);
		  customer3.setAccount(account3);
		  
		  accountRepository.save(account); accountRepository.save(account2);
		  accountRepository.save(account3);
		  
		  customerRepository.save(customer);
		  customerRepository.save(customer2);
		  customerRepository.save(customer3);
		 

		AppUser user1 = new AppUser("raj", "raj@gmail.com", "raj", "bangolre", new String[] { "ROLE_ADMIN" }, true);

		AppUser user2 = new AppUser("nandu", "nandu@gmail.com", "nandu", "bangolre", new String[] { "ROLE_MGR" }, true);

		AppUser user3 = new AppUser("nani", "nani@gmail.com", "nani", "chennai", new String[] { "ROLE_CLERK" }, true);

		AppUser user4 = new AppUser("kiran", "kiran@gmail.com", "kiran", "chennai", new String[] { "ROLE_CLERK" },
				true);

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);*/
		
		//accountService.deposit(1L, 1000);
		//accountService.withdraw(3L, 100);
		//accountService.transfer(1L, 3L, 10);
		//accountService.deposit(1l, 12.0);
	}

}

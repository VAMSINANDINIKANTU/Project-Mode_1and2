package com.bankapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.exceptions.UserNotFoundException;
import com.bankapp.web.controller.requests.AccountRequest;

@RestController
@RequestMapping("/api")
public class AccountController {
	@Autowired
	private AccountService accountService;

	@GetMapping(path = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Account> getallAccounts() {

		return accountService.getallAccounts();

	}

	@GetMapping(path = "account/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> getByid(@PathVariable(name = "id") Long id) {
		Account account = accountService.findAccountById(id).orElseThrow(
				UserNotFoundException::new);

		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}

	/*
	 * public ResponseEntity<Account> addAccount(@RequestBody Account
	 * account,@RequestBody AccountRequest request) { Customer customer=new
	 * Customer(request.getName(), request.getEmail(), request.getPhone(),
	 * request.getAddress(), request.getCity(), request.getCountryName(),
	 * request.getPincode()); Account accountnew=new
	 * Account(request.getBalance(), request.isBlocked(),
	 * request.getAccountType()); account.setCustomer(customer);
	 * accountService.addAccount(accountnew); return new
	 * ResponseEntity<Account>(accountService.addAccount(account),
	 * HttpStatus.OK); }
	 */

	@PostMapping(path = "account", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> addAccount(@RequestBody Account account) {

		accountService.addAccount(account);
		return new ResponseEntity<Account>(accountService.addAccount(account),
				HttpStatus.OK);
	}

	@PutMapping(path = "account/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> updateAccount(
			@PathVariable(name = "id") Long id, @RequestBody Account account) {

		return new ResponseEntity<Account>(accountService.updateAccount(id,
				account), HttpStatus.OK);

	}

	@DeleteMapping(path = "deleteaccount/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> deleteAccount(
			@PathVariable(name = "id") Long id) {

		accountService.deleteAccount(id);
		return new ResponseEntity<Account>(HttpStatus.NO_CONTENT);
	}

}

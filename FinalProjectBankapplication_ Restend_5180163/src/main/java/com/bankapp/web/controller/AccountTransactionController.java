package com.bankapp.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.Account;
import com.bankapp.model.service.AccountService;
import com.bankapp.web.controller.requests.DepositRequest;
import com.bankapp.web.controller.requests.TransferRequest;
import com.bankapp.web.controller.requests.WithdrawRequest;

@RestController
@RequestMapping(path = "api")
public class AccountTransactionController {
	@Autowired
	private AccountService accountService;

	@PostMapping(path = "/operation/deposit")
	private ResponseEntity<Void> deposit(@RequestBody DepositRequest req) {
		accountService.deposit(req.getAccountNumber(), req.getAmount());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping(path = "/operation/withdraw")
	public ResponseEntity<Account> withdrawFromAccount(
			@RequestBody WithdrawRequest request, Principal principal) {
		accountService.withdraw(request.getAccountNumber(), request.getAmount());
		return new ResponseEntity<Account>(HttpStatus.OK);

	}

	@PostMapping(path = "/operation/transfer")
	public ResponseEntity<Account> transferFromAccount(
			@RequestBody TransferRequest request, Principal principal) {
		accountService.transfer(request.getFromaccount(),
				request.getToaccount(), request.getAmount());
		return new ResponseEntity<Account>(HttpStatus.OK);

	}

}

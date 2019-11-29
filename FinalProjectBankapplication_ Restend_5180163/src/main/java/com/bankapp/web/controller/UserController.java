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

import com.bankapp.model.entities.AppUser;
import com.bankapp.model.service.UserService;
import com.bankapp.model.service.exceptions.UserNotFoundException;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userservice;

	@GetMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AppUser> getAllUsers() {

		return userservice.findAll();

	}

	@PostMapping(path = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AppUser> addUser(@RequestBody AppUser user) {
		return new ResponseEntity<AppUser>(userservice.addUser(user),
				HttpStatus.OK);
	}

	@PutMapping(path = "/user/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AppUser> updateUser(
			@PathVariable(name = "id") Long id, @RequestBody AppUser user) {

		return new ResponseEntity<AppUser>(userservice.updateUser(id, user),
				HttpStatus.OK);
	}

	@DeleteMapping(path = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AppUser> deleteAppUser(
			@PathVariable(name = "id") Long id) {

		userservice.deleteUser(id);
		return new ResponseEntity<AppUser>(HttpStatus.NO_CONTENT);
	}

	@GetMapping(path = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AppUser> getByid(@PathVariable(name = "id") Long id) {
		AppUser user = userservice.findUserById(id).orElseThrow(
				UserNotFoundException::new);

		return new ResponseEntity<AppUser>(user, HttpStatus.OK);
	}

	@GetMapping(path = "/home")
	public String hello() {
		return "welcome to home";

	}

	@GetMapping(path = "/admin")
	public String admin() {
		return "welcome to admin";

	}

	@GetMapping(path = "/mgr")
	public String mgr() {
		return "welcome to mgr";

	}

	@GetMapping(path = "/clerk")
	public String clerck() {
		return "welcome to clerck";

	}

}

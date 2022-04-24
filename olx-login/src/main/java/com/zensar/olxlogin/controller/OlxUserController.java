package com.zensar.olxlogin.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxlogin.entity.User;
import com.zensar.olxlogin.service.LoginService;

@RestController
@RequestMapping("/user")
public class OlxUserController {

	@Autowired
	private LoginService loginService;

	// Registers a user
	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	
	public User registerUser(@RequestBody User user) {
		return loginService.registerUser(user);
	}

	// Logs in a user // user authentication
	@PostMapping(value = "/authenticate", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })

	public ResponseEntity<User> userAuthentication(@RequestBody User user, @RequestHeader("auth-token") String token) {

		if (loginService.userAuthentication(user,token) == null) {
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

	}

	// Get All Users
	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })

	public List<User> getAllUsers() {
		return loginService.getAllUsers();
	}

	// Logs out a user
	@DeleteMapping("/logout")
	public boolean deleteUser(@RequestHeader("auth-token") String token) {
		return loginService.deleteUser(token);

	}

}

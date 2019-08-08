package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.repository.UserRepository;


@RestController
@CrossOrigin
public class AppController {
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("home")
	public ResponseEntity<String> welcome() {		
		return new ResponseEntity<String>("Welcome!", HttpStatus.OK);
	}
	
	//@Secured("ADMIN")
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("app/admins-only")
	public ResponseEntity<String> adminsMethod() {		
		return new ResponseEntity<String>("This content is for admins only", HttpStatus.OK);
	}
	
	//@Secured("USER")
	@PreAuthorize("hasAuthority('USER')")
	@GetMapping("app/user-only")
	public ResponseEntity<String> userMethod() {		
		return new ResponseEntity<String>("This content is for users only", HttpStatus.OK);
	}
	
	@GetMapping("app/unspec-role")
	public ResponseEntity<String> unspecMethod() {		
		return new ResponseEntity<String>("This content is for anyone", HttpStatus.OK);
	}
	
	

}

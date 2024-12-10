package com.twitter.twitter.UserControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.twitter.Repository.UserRepo;
import com.twitter.twitter.Response.UserResponse;
import com.twitter.twitter.UserEntities.Entity.UserDetails;

@RestController
public class UserController {
	
	
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping(value = "/user/{id}")
	private ResponseEntity<UserDetails> getUserData(@PathVariable("id") Integer id){
		
		UserDetails userDetails  = userRepo.findById(id).orElse(new UserDetails());
		
		return new ResponseEntity<>(userDetails,HttpStatus.OK );
	}
	
	@PostMapping(value ="/user")
	private String addUser(@RequestBody UserDetails user) {
		System.out.println(user);
		
		userRepo.save(user);
		
		return "success";
	}

}

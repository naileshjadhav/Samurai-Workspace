package com.zensar.samurai.registration.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.samurai.registration.model.SamuraiUserDto;
import com.zensar.samurai.registration.service.SamuraiRegistrationService;

@RestController
public class SamuraiRegistrationController {

	private static final Logger log = LoggerFactory.getLogger(SamuraiRegistrationController.class);
	@Autowired
	private SamuraiRegistrationService pathService;

	@PostMapping(value = "/user", consumes = "application/json", produces = "application/json")
	public ResponseEntity<SamuraiUserDto> saveUserDetails(@Valid @RequestBody SamuraiUserDto userDetails) {

		log.info("user name:: {}", userDetails.getUserName());
		log.info("user email:: {}", userDetails.getUserEmail());
		log.info("user organisation:: {}", userDetails.getUserOrganisation());
		userDetails = pathService.saveSamuraiUserDetails(userDetails);
		return new ResponseEntity<SamuraiUserDto>(userDetails, HttpStatus.CREATED);
	}

	/*
	 * @GetMapping("/user/{userId}") public ResponseEntity<SamuraiUserDto>
	 * getUserById(@PathVariable Long userId) { log.info("Requested userId:: {}",
	 * userId); SamuraiUserDto userDetails = new SamuraiUserDto(); if (userId !=
	 * null && userId > 0) { userDetails =
	 * pathService.getSamuraiUserDetailsById(userId); return new
	 * ResponseEntity<SamuraiUserDto>(userDetails, HttpStatus.FOUND); } return new
	 * ResponseEntity<SamuraiUserDto>(userDetails, HttpStatus.NOT_FOUND); }
	 */

	@GetMapping("/user/{userName}")
	public ResponseEntity<SamuraiUserDto> getUserByName(@PathVariable String userName) {
		log.info("Requested userId:: {}", userName);
		SamuraiUserDto userDetails = new SamuraiUserDto();
		if (userName != null && userName != "") {
			userDetails = pathService.getSamuraiUserDetailsByName(userName);
			return new ResponseEntity<SamuraiUserDto>(userDetails, HttpStatus.FOUND);
		}
		return new ResponseEntity<SamuraiUserDto>(userDetails, HttpStatus.NOT_FOUND);
	}

}

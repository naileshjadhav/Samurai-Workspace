package com.zensar.samurai.controller;

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

import com.zensar.samurai.model.SamuraiPathDto;
import com.zensar.samurai.service.SamuraiPathService;

@RestController
public class SamuraiController {

	private static final Logger log = LoggerFactory.getLogger(SamuraiController.class);
	@Autowired
	private SamuraiPathService pathService;

	@PostMapping(value = "/path", consumes = "application/json", produces = "application/json")
	public ResponseEntity<SamuraiPathDto> saveDeploymentPath(@Valid @RequestBody SamuraiPathDto pathDto) {

		log.info("Deployment path:: {}", pathDto.getDeploymentPath());
		log.info("Integration path:: {}", pathDto.getIntegrationPath());
		log.info("Path name:: {}", pathDto.getPathName());
		pathDto = pathService.saveSamuraiPath(pathDto);
		return new ResponseEntity<SamuraiPathDto>(pathDto, HttpStatus.CREATED);
	}

	@GetMapping("/path/{name}")
	public ResponseEntity<SamuraiPathDto> getPathByName(@PathVariable String name) {
		log.info("Requested path:: {}", name);
		SamuraiPathDto pathDto = new SamuraiPathDto();
		if (name != null && name != "") {
			pathDto = pathService.getSamuraiPath(name);
			return new ResponseEntity<SamuraiPathDto>(pathDto, HttpStatus.FOUND);
		}
		return new ResponseEntity<SamuraiPathDto>(pathDto, HttpStatus.NOT_FOUND);
	}

}

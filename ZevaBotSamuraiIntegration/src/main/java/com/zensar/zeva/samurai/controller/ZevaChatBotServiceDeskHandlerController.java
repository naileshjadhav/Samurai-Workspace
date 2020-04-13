package com.zensar.zeva.samurai.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.zeva.samurai.model.ServiceDeskDto;

@RestController
@RequestMapping("/v1/zeva/servicedesk")
public class ZevaChatBotServiceDeskHandlerController {

	private static final Logger log = LoggerFactory.getLogger(ZevaChatBotServiceDeskHandlerController.class);

	// RestTemplate restTemplate = new RestTemplate();

	@PostMapping(value = "/rasa", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ServiceDeskDto> chatWithZeva(@Valid @RequestBody ServiceDeskDto deskDto) {

		log.info("Start");
		//extract dto
		//call to service desk
		//get response from service desk
		//pass response to ZEVA
		return ResponseEntity.ok(deskDto);
	}

}

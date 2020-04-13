package com.zensar.samurai.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zensar.samurai.model.RasaChatBot;
import com.zensar.samurai.model.ZenAnalyticaDTO;


@RestController
@RequestMapping(value = "/samurai")
public class SamuraiRecommendationEngineIntegrationController {
	
	private static final Logger log = LoggerFactory.getLogger(SamuraiRecommendationEngineIntegrationController.class);

	RestTemplate restTemplate = new RestTemplate();
	
	@PostMapping(value = "/rasa", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ResponseEntity<String>> chatWithZeva(@Valid @RequestBody RasaChatBot rasaChatBot) {

		log.info("Rest call......" + restTemplate.toString());
		ResponseEntity<String> resp;
		HttpEntity<RasaChatBot> requestEntity = new HttpEntity<RasaChatBot>(rasaChatBot);
		Class<String> responseType = String.class;
		HttpMethod method = HttpMethod.POST;
		URI url = null;
		try {
			url = new URI("http://52.172.146.59:8000/rasa_bot/chat");
		} catch (URISyntaxException e) {
			log.error("URI error::" + e);
		}
		log.info("Url..." + url + " req entiry.." + requestEntity.getBody());
		resp = restTemplate.exchange(url, method, requestEntity, responseType);
		log.info("rasaChatBot response code....." + resp);
		return ResponseEntity.ok(resp);
	}

	
	@PostMapping(value = "/analytica", consumes = "application/json", produces = "application/json")
	public String chatWithZenAnalytica(@Valid @RequestBody ZenAnalyticaDTO zenAnalyticaDTO) {

		log.info("Rest call......" + restTemplate.toString());
		ResponseEntity<String> response;
		HttpEntity<ZenAnalyticaDTO> requestEntity = new HttpEntity<ZenAnalyticaDTO>(zenAnalyticaDTO);
		Class<String> responseType = String.class;
		HttpMethod method = HttpMethod.POST;
		URI url = null;
		try {
			url = new URI("http://52.172.146.59:5004/suggestions");
		} catch (URISyntaxException e) {
			log.error("URI error::" + e);
		}
		log.info("Url..." + url + " req entiry.." + requestEntity.getBody());
		response = restTemplate.exchange(url, method, requestEntity, responseType);
		log.info("ZenAnalytica response....." + response);

		return response.getBody();
	}
	
}

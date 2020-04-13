package com.zensar.SamuraiZenAnalyticaIntegration.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zensar.SamuraiZenAnalyticaIntegration.model.ZenAnalyticaDTO;

@RestController
public class SamuraiZenanalyticaIntegrationController {

	private static final Logger log = LoggerFactory.getLogger(SamuraiZenanalyticaIntegrationController.class);

	@Autowired
	RestTemplate restTemplate;

	@Value("${urlPath}")
	String urlPath;

	@PostMapping(value = "/analytica", consumes = "application/json", produces = "application/json")
	public String chatWithZenAnalytica(@Valid @RequestBody ZenAnalyticaDTO zenAnalyticaDTO) throws URISyntaxException {

		HttpEntity<ZenAnalyticaDTO> requestEntity = new HttpEntity<ZenAnalyticaDTO>(zenAnalyticaDTO);
		Class<String> responseType = String.class;
		HttpMethod method = HttpMethod.POST;
		URI url = new URI(urlPath);
		log.info("analytica url..." + url + " and request entiry.." + requestEntity.getBody());
		ResponseEntity<String> response = restTemplate.exchange(url, method, requestEntity, responseType);
		log.info("ZenAnalytica response....." + response);
		return response.getBody();
	}

}

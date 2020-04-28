package com.zensar.SamuraiZenAnalyticaIntegration.controller;

import java.net.URI;
import java.time.LocalDateTime;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zensar.SamuraiZenAnalyticaIntegration.model.SamuraiRpaDto;
import com.zensar.SamuraiZenAnalyticaIntegration.service.SamuraiRpaService;

@RestController
public class SamuraiZenanalyticaIntegrationController {

	private static final Logger log = LoggerFactory.getLogger(SamuraiZenanalyticaIntegrationController.class);

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	SamuraiRpaService service;

	@Value("${analyticaUri}")
	String analyticaUri;

	@PostMapping(value = "/analytica", consumes = "application/json", produces = "application/json")
	public String samuraiAnalyticaRpaIntegration(@Valid @RequestBody SamuraiRpaDto rpaDto) throws Exception {

		log.info("Started rpa call...........");
		rpaDto.setRequestDateTime(LocalDateTime.now());
		rpaDto.setEformStatusByPlatform("Open");
		SamuraiRpaDto rpaDto2 = service.saveRpaRequest(rpaDto);
		log.info("Saved samuraiRpaId:: " + rpaDto2.getSamuraiRpaId());

		HttpEntity<SamuraiRpaDto> requestEntity = new HttpEntity<SamuraiRpaDto>(rpaDto);
		Class<SamuraiRpaDto> responseType = SamuraiRpaDto.class;
		HttpMethod method = HttpMethod.POST;
		URI url = new URI(analyticaUri);
		ResponseEntity<SamuraiRpaDto> response = restTemplate.exchange(url, method, requestEntity, responseType);
		log.info("Analytica response status::" + response.getStatusCodeValue());
		SamuraiRpaDto rpaDto3 = response.getBody();
		rpaDto3.setSamuraiRpaId(rpaDto2.getSamuraiRpaId());
		log.info("zenanalyticaUserResponse::" + rpaDto3.getResolutionResponse());
		if (response.getStatusCode() == HttpStatus.OK) {
			rpaDto3 = service.mergeRpaRequest(rpaDto3);
			log.info("After saving response zenanalyticaUserResponse:: " + rpaDto3.getResolutionResponse());
			return rpaDto3.getResolutionResponse();
		} else {
			return rpaDto.getResolutionResponse();
		}
	}

}

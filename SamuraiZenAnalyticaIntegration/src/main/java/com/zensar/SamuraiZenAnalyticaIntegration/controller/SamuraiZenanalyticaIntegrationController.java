package com.zensar.SamuraiZenAnalyticaIntegration.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zensar.SamuraiZenAnalyticaIntegration.model.SamuraiAnalyticaDto;
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

	private static final String EFORM_STATUS_BY_PLATFORM = "Open";
	private static final String PLATFORM_REMARK = "Pending";

	@PostMapping(value = "/analytica", consumes = "application/json", produces = "application/json")
	public java.util.List<SamuraiAnalyticaDto> samuraiAnalyticaRpaIntegration(@Valid @RequestBody SamuraiRpaDto rpaDto)
			throws Exception {

		log.info("Started rpa call...........");
		List<SamuraiAnalyticaDto> rpaDto3 = new ArrayList<SamuraiAnalyticaDto>();
		rpaDto.setRequestDateTime(LocalDateTime.now());
		if (rpaDto.getEformId() != null && rpaDto.getEformId() != 0)
			rpaDto.setEformStatusByPlatform(EFORM_STATUS_BY_PLATFORM);
		rpaDto.setPlatformRemarks(PLATFORM_REMARK);
		SamuraiRpaDto rpaDto2 = service.saveRpaRequest(rpaDto);

		HttpEntity<SamuraiRpaDto> requestEntity = new HttpEntity<SamuraiRpaDto>(rpaDto);
		HttpMethod method = HttpMethod.POST;
		URI url = new URI(analyticaUri);
		ResponseEntity<List<SamuraiAnalyticaDto>> response = restTemplate.exchange(url, method, requestEntity,
				new ParameterizedTypeReference<List<SamuraiAnalyticaDto>>() {
				});
		log.info("Analytica response status::" + response.getStatusCodeValue());

		if (response.getStatusCodeValue() == 200) {
			rpaDto3 = response.getBody();
			rpaDto2.setAnalyticaDtos(rpaDto3);
			rpaDto2 = service.saveRpaRequest(rpaDto2);
		}
		log.info("Finished rpa call...........");
		return rpaDto3;
	}

}

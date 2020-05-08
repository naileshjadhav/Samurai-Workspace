package com.zensar.SamuraiZenAnalyticaIntegration.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.SamuraiZenAnalyticaIntegration.entity.SamuraiAnalytica;
import com.zensar.SamuraiZenAnalyticaIntegration.entity.SamuraiRpa;
import com.zensar.SamuraiZenAnalyticaIntegration.exception.ResourceNotFound;
import com.zensar.SamuraiZenAnalyticaIntegration.model.SamuraiAnalyticaDto;
import com.zensar.SamuraiZenAnalyticaIntegration.model.SamuraiRpaDto;
import com.zensar.SamuraiZenAnalyticaIntegration.repository.SamuraiRpaRepository;

@Service
public class SamuraiRpaServiceImpl implements SamuraiRpaService {

	private static final Logger log = LoggerFactory.getLogger(SamuraiRpaServiceImpl.class);

	@Autowired
	SamuraiRpaRepository repository;

	@Override
	public SamuraiRpaDto saveRpaRequest(SamuraiRpaDto dto) {

		SamuraiRpa entity = new SamuraiRpa();
		BeanUtils.copyProperties(dto, entity);
		List<SamuraiAnalyticaDto> analyticaDtos = dto.getAnalyticaDtos();
		for (SamuraiAnalyticaDto samuraiAnalyticaDto : analyticaDtos) {
			SamuraiAnalytica analytica = new SamuraiAnalytica();
			BeanUtils.copyProperties(samuraiAnalyticaDto, analytica);
			entity.addAnalytica(analytica);
		}
		entity = repository.save(entity);
		BeanUtils.copyProperties(entity, dto);
		log.info("Analytica response size::::" + dto.getAnalyticaDtos().size());
		return dto;
	}

	@Override
	public List<SamuraiRpaDto> saveAllAnalyticaResponse(List<SamuraiRpaDto> rpaDto3) {

		List<SamuraiRpa> entities = new ArrayList<SamuraiRpa>();
		for (SamuraiRpaDto samuraiRpaDto : rpaDto3) {
			SamuraiRpa entity = new SamuraiRpa();
			BeanUtils.copyProperties(samuraiRpaDto, entity);
			entities.add(entity);
		}

		entities = (List<SamuraiRpa>) repository.saveAll(entities);

		List<SamuraiRpaDto> dtos = new ArrayList<SamuraiRpaDto>();
		for (SamuraiRpa samuraiRpa : entities) {
			SamuraiRpaDto dto = new SamuraiRpaDto();
			BeanUtils.copyProperties(samuraiRpa, dto);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public SamuraiRpaDto mergeRpaRequest(SamuraiRpaDto dto) throws ResourceNotFound {

		log.info("merging rpa request.....");
		SamuraiRpa entity = new SamuraiRpa();
		entity = repository.findById(dto.getSamuraiRpaId())
				.orElseThrow(() -> new ResourceNotFound("Resource not found for id:: " + dto.getSamuraiRpaId()));
//		entity.setDbConnectionUrl(dto.getDbConnectionUrl());
//		entity.setResolutionPlatform(dto.getResolutionPlatform());
//		entity.setResolutionResponse(dto.getResolutionResponse());
		entity = repository.save(entity);
		BeanUtils.copyProperties(entity, dto);
		log.info("merge rpa request finished.....");
		return dto;
	}

}

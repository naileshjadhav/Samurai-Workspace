package com.zensar.SamuraiZenAnalyticaIntegration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.SamuraiZenAnalyticaIntegration.entity.SamuraiRpa;
import com.zensar.SamuraiZenAnalyticaIntegration.exception.ResourceNotFound;
import com.zensar.SamuraiZenAnalyticaIntegration.model.SamuraiRpaDto;
import com.zensar.SamuraiZenAnalyticaIntegration.repository.SamuraiRpaRepository;

@Service
public class SamuraiRpaServiceImpl implements SamuraiRpaService {

	private static final Logger log = LoggerFactory.getLogger(SamuraiRpaServiceImpl.class);

	@Autowired
	SamuraiRpaRepository repository;

	@Override
	public SamuraiRpaDto saveRpaRequest(SamuraiRpaDto dto) {

		log.info("saving rpa request.....");
		SamuraiRpa entity = new SamuraiRpa();
		BeanUtils.copyProperties(dto, entity);
		entity = repository.save(entity);
		BeanUtils.copyProperties(entity, dto);
		log.info("saving rpa request finished.....");
		return dto;
	}

	@Override
	public SamuraiRpaDto mergeRpaRequest(SamuraiRpaDto dto) throws ResourceNotFound {

		log.info("merging rpa request.....");
		SamuraiRpa entity = new SamuraiRpa();
		entity = repository.findById(dto.getSamuraiRpaId())
				.orElseThrow(() -> new ResourceNotFound("Resource not found for id:: " + dto.getSamuraiRpaId()));
		entity.setDbConnectionUrl(dto.getDbConnectionUrl());
		entity.setResolutionPlatform(dto.getResolutionPlatform());
		entity.setResolutionResponse(dto.getResolutionResponse());
		entity = repository.save(entity);
		BeanUtils.copyProperties(entity, dto);
		log.info("merge rpa request finished.....");
		return dto;
	}

	/*
	 * @Override public SamuraiRpaDto saveZenAnalyticaResponse(SamuraiRpaDto dto) {
	 * 
	 * SamuraiRpa entity = new SamuraiRpa();
	 * entity.setRequestDateTime(LocalDateTime.now()); BeanUtils.copyProperties(dto,
	 * entity); entity = repository.save(entity); BeanUtils.copyProperties(entity,
	 * dto); return dto; }
	 */

}

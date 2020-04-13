package com.zensar.samurai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.samurai.entity.SamuraiPath;
import com.zensar.samurai.exception.ResourceNotFound;
import com.zensar.samurai.model.SamuraiPathDto;
import com.zensar.samurai.repository.SamuraiPathServiceRepository;

@Service
public class SamuraiPathServiceImpl implements SamuraiPathService {

	@Autowired
	private SamuraiPathServiceRepository repository;

	@Override
	public SamuraiPathDto saveSamuraiPath(SamuraiPathDto dto) {

		SamuraiPath entity = new SamuraiPath();
		entity.setDeploymentPath(dto.getDeploymentPath());
		entity.setIntegrationPath(dto.getIntegrationPath());
		entity.setPathName(dto.getPathName());
		entity = repository.save(entity);
		return dto;
	}

	@Override
	public SamuraiPathDto getSamuraiPath(String pathName) throws ResourceNotFound {

		SamuraiPathDto dto = new SamuraiPathDto();
		SamuraiPath entity = repository.getSamuraiPathByPathName(pathName)
				.orElseThrow(() -> new ResourceNotFound("Path not found for: " + pathName));
		dto.setDeploymentPath(entity.getDeploymentPath());
		dto.setIntegrationPath(entity.getIntegrationPath());
		dto.setDatabasePath(entity.getPathName());
		return dto;
	}

}

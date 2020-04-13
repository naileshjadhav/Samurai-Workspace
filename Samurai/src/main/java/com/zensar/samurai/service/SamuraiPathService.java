package com.zensar.samurai.service;

import com.zensar.samurai.model.SamuraiPathDto;

public interface SamuraiPathService {

	SamuraiPathDto saveSamuraiPath(SamuraiPathDto dto);

	SamuraiPathDto getSamuraiPath(String pathName);

}
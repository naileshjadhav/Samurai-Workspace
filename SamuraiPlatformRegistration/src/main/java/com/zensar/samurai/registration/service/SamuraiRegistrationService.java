package com.zensar.samurai.registration.service;

import com.zensar.samurai.registration.model.SamuraiUserDto;

public interface SamuraiRegistrationService {

	SamuraiUserDto saveSamuraiUserDetails(SamuraiUserDto userDetails);

	SamuraiUserDto getSamuraiUserDetailsById(Long userId);

	SamuraiUserDto getSamuraiUserDetailsByName(String userName);

}
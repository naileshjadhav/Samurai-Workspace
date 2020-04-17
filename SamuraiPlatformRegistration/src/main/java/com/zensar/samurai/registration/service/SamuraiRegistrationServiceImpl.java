package com.zensar.samurai.registration.service;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.samurai.registration.entiry.SamuraiUser;
import com.zensar.samurai.registration.exception.ResourceNotFound;
import com.zensar.samurai.registration.model.SamuraiUserDto;
import com.zensar.samurai.registration.repository.RegistrationServiceRepository;

@Service
public class SamuraiRegistrationServiceImpl implements SamuraiRegistrationService {

	private static final Logger log = LoggerFactory.getLogger(SamuraiRegistrationServiceImpl.class);

	@Autowired
	private RegistrationServiceRepository repository;

	@Override
	public SamuraiUserDto saveSamuraiUserDetails(SamuraiUserDto userDetails) {

		log.info("saving user details.....");
		SamuraiUser user = new SamuraiUser();
		user.setUserEmail(userDetails.getUserEmail());
		user.setUserMobileNo(userDetails.getUserMobileNo());
		user.setUserName(userDetails.getUserName());
		user.setUserOrganisation(userDetails.getUserOrganisation());
		user.setRegistrationDate(LocalDateTime.now());
		user = repository.save(user);
		log.info("user details....." + user.getUserId());
		return userDetails;
	}

	@Override
	public SamuraiUserDto getSamuraiUserDetailsById(Long userId) {

		log.info("getting user details....." + userId);
		SamuraiUserDto dto = new SamuraiUserDto();
		SamuraiUser user = repository.findById(userId)
				.orElseThrow(() -> new ResourceNotFound("User not found for: " + userId));
		dto.setRegistrationDate(user.getRegistrationDate());
		dto.setUserEmail(user.getUserEmail());
		dto.setUserMobileNo(user.getUserMobileNo());
		dto.setUserName(user.getUserName());
		dto.setUserOrganisation(user.getUserOrganisation());
		log.info("user details name....." + user.getUserName());
		return dto;
	}

	@Override
	public SamuraiUserDto getSamuraiUserDetailsByName(String userName) {
		log.info("getting user details....." + userName);
		SamuraiUserDto dto = new SamuraiUserDto();
		SamuraiUser user = repository.getUserByUserName(userName)
				.orElseThrow(() -> new ResourceNotFound("User not found for: " + userName));
		dto.setRegistrationDate(user.getRegistrationDate());
		dto.setUserEmail(user.getUserEmail());
		dto.setUserMobileNo(user.getUserMobileNo());
		dto.setUserName(user.getUserName());
		dto.setUserOrganisation(user.getUserOrganisation());
		log.info("user details id....." + user.getUserId());
		return dto;
	}

}

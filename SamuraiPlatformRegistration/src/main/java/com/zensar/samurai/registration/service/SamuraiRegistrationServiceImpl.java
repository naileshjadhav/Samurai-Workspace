package com.zensar.samurai.registration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.zensar.samurai.registration.entity.SamuraiUser;
import com.zensar.samurai.registration.exception.ResourceNotFound;
import com.zensar.samurai.registration.model.SamuraiUserDto;
import com.zensar.samurai.registration.repository.RegistrationServiceRepository;

@Service
public class SamuraiRegistrationServiceImpl implements SamuraiRegistrationService {

	private static final Logger log = LoggerFactory.getLogger(SamuraiRegistrationServiceImpl.class);

	@Autowired
	private RegistrationServiceRepository repository;

	private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Override
	public SamuraiUserDto saveSamuraiUserDetails(SamuraiUserDto userDetails) {

		log.info("saving user details.....");
		SamuraiUser user = new SamuraiUser();
		BeanUtils.copyProperties(userDetails, user);
		user.setUserPassword(bCryptPasswordEncoder.encode(userDetails.getUserPassword()));
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
		BeanUtils.copyProperties(user, dto);
		log.info("user details name....." + dto.getUserName());
		return dto;
	}

	@Override
	public SamuraiUserDto getSamuraiUserDetailsByName(String userName) {
		log.info("getting user details....." + userName);
		SamuraiUserDto dto = new SamuraiUserDto();
		SamuraiUser user = repository.getUserByUserName(userName)
				.orElseThrow(() -> new ResourceNotFound("User not found for: " + userName));
		BeanUtils.copyProperties(user, dto);
		log.info("user details id....." + dto.getUserId());
		return dto;
	}

}

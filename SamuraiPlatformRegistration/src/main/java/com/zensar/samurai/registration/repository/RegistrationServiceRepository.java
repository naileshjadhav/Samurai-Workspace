/**
 * 
 */
package com.zensar.samurai.registration.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.zensar.samurai.registration.entity.SamuraiUser;

/**
 * @author Nailesh
 *
 */
public interface RegistrationServiceRepository extends CrudRepository<SamuraiUser, Long>{

	public Optional<SamuraiUser> getUserByUserName(String userName);
}

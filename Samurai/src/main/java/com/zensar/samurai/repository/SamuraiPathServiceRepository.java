package com.zensar.samurai.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zensar.samurai.entity.SamuraiPath;

@Repository
public interface SamuraiPathServiceRepository extends CrudRepository<SamuraiPath, Long> {

	public Optional<SamuraiPath> getSamuraiPathByPathName(String pathName);

}

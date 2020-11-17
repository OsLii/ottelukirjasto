package com.example.ottelukirjasto.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface BoutRepository extends CrudRepository<Bout, Long> {

	Optional<Bout> findById(Long id);

}
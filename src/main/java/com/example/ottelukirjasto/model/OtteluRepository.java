package com.example.ottelukirjasto.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OtteluRepository extends CrudRepository<Ottelu, Long> {

	List<Ottelu> findByOtteluId(Long id);
    
}
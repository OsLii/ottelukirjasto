package com.example.ottelukirjasto.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface OrganizationRepository extends CrudRepository<Organization, Long> {

	List<Organization> findByName(String name);

}
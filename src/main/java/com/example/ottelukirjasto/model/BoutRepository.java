package com.example.ottelukirjasto.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface BoutRepository extends CrudRepository<Bout, Long> {

	List<Bout> findByCompetitor1(String competitor1);

}
package com.falcon.avisep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.falcon.avisep.model.Cours;

/**
 * Spring Data JPA repository for the Cours entity.
 */
@SuppressWarnings("unused")
public interface CoursRepository extends JpaRepository<Cours,Long> {

}

package com.falcon.avisep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.falcon.avisep.model.Form;

/**
 * Spring Data JPA repository for the Form entity.
 */
@SuppressWarnings("unused")
public interface FormRepository extends JpaRepository<Form,Long> {

    @Query("select distinct form from Form form left join fetch form.templates")
    List<Form> findAllWithEagerRelationships();

    @Query("select form from Form form left join fetch form.templates where form.id =:id")
    Form findOneWithEagerRelationships(@Param("id") Long id);

}

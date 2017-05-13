package com.falcon.avisep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.falcon.avisep.model.Template;

/**
 * Spring Data JPA repository for the Template entity.
 */
@SuppressWarnings("unused")
public interface TemplateRepository extends JpaRepository<Template,Long> {

//    @Query("select distinct template from Template template left join fetch template.questions")
//    List<Template> findAllWithEagerRelationships();
//
//    @Query("select template from Template template left join fetch template.questions where template.id =:id")
//    Template findOneWithEagerRelationships(@Param("id") Long id);

}

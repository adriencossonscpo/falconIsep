package com.falcon.avisep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.falcon.avisep.model.UserAvis;

/**
 * Spring Data JPA repository for the UserAvis entity.
 */
@SuppressWarnings("unused")
public interface UserAvisRepository extends JpaRepository<UserAvis,Long> {

    @Query("select distinct userAvis from UserAvis userAvis left join fetch userAvis.classes")
    List<UserAvis> findAllWithEagerRelationships();

    @Query("select userAvis from UserAvis userAvis left join fetch userAvis.classes where userAvis.userId =:id")
    UserAvis findOneWithEagerRelationships(@Param("id") Long id);

}

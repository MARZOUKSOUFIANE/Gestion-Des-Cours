package org.glsid.dao;

import org.glsid.entities.Cours;
import org.glsid.entities.Ensignant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource
public interface EnsignantRepository extends JpaRepository<Ensignant, Long>{

	@Query("select c.cours from Ensignant c where c.code=:x")
	public Page<Cours> listCours(@Param("x")Long code,Pageable pageable);
	
	@Modifying
    @Transactional
	@Query("delete from Ensignant c where c.departement.code=:x")
	public void deleteEnsDept(@Param("x")long code);
}

package org.glsid.dao;


import org.glsid.entities.Cours;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CourRepository extends JpaRepository<Cours, Long>{

	@Query("select c from Cours c where c.ensignant.nom=:x")
	public Page<Cours> listCours(@Param("x")String nom,Pageable pageable);
	
	@Modifying
    @Transactional
	@Query("delete from Cours c where c.ensignant.code=:x")
	public void deleteCoursEns(@Param("x")long code);
}

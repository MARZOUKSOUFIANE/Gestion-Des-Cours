package org.glsid.dao;

import java.util.Collection;

import org.glsid.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface DepartementRepository extends JpaRepository<Departement, Long>{

	@RestResource(path = "/ListDepartements")
	@Query("select c from Departement c where c.nom=:x")
	public Collection<Departement> getDepartment(@Param("x")String nom);
}

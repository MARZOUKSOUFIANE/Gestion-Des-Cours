package org.glsid.metier;

import java.util.Collection;

import org.glsid.entities.Cours;
import org.glsid.entities.Departement;
import org.glsid.entities.Ensignant;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

public interface IMetier {

	public void ajouter_cour(Cours cours);
	public Ensignant consulter_ensignant(long code);
	public Page<Cours> listCours (long code,int page,int size);
	public Page<Cours> listCours (int page,int size);
	public Page<Cours> listCours (String nom,int page,int size);
	public Page<Ensignant> listEnsignants (int page,int size);
	public void deleteCoursEns(long code);
	public Collection<Departement> getDepartment(String nom);
	public Page<Departement> listDepartements(int page,int size);
	public void deleteEnsDept(long code);

}

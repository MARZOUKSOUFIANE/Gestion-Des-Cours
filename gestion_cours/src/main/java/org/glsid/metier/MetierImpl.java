package org.glsid.metier;

import java.util.Collection;

import org.glsid.dao.CourRepository;
import org.glsid.dao.DepartementRepository;
import org.glsid.dao.EnsignantRepository;
import org.glsid.entities.Cours;
import org.glsid.entities.Departement;
import org.glsid.entities.Ensignant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MetierImpl implements IMetier {

	@Autowired
	private CourRepository courRepository;
	@Autowired
	private EnsignantRepository ensignantRepository;
	@Autowired
	private DepartementRepository departementRepository;

	@Override
	public void ajouter_cour(Cours cours) {
		// TODO Auto-generated method stub
		courRepository.save(cours);
	}

	@Override
	public Ensignant consulter_ensignant(long code) {
		// TODO Auto-generated method stub
		return ensignantRepository.getOne(code);
	}

	@Override
	public Page<Cours> listCours(long code, int page, int size) {
		// TODO Auto-generated method stub
		return ensignantRepository.listCours(code, new PageRequest(page, size));
	}

	@Override
	public Page<Cours> listCours(int page, int size) {
		// TODO Auto-generated method stub
		return courRepository.findAll(new PageRequest(page, size));
	}

	@Override
	public Page<Cours> listCours(String nom, int page, int size) {
		// TODO Auto-generated method stub
		return courRepository.listCours(nom,new PageRequest(page, size));
	}
	
	@Override
	public Page<Ensignant> listEnsignants(int page, int size) {
		// TODO Auto-generated method stub
		return ensignantRepository.findAll(new PageRequest(page, size));
	}

	@Override
	public void deleteCoursEns(long code) {
		// TODO Auto-generated method stub
		courRepository.deleteCoursEns(code);
	}

	@Override
	public Collection<Departement> getDepartment(String nom) {
		// TODO Auto-generated method stub
		return departementRepository.getDepartment(nom);
	}

	@Override
	public Page<Departement> listDepartements(int page, int size) {
		// TODO Auto-generated method stub
		return departementRepository.findAll(new PageRequest(page, size));
	}

	@Override
	public void deleteEnsDept(long code) {
		// TODO Auto-generated method stub
	ensignantRepository.deleteEnsDept(code);
	}

}

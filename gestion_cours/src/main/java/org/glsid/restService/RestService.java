package org.glsid.restService;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.glsid.dao.CourRepository;
import org.glsid.dao.DepartementRepository;
import org.glsid.dao.EnsignantRepository;
import org.glsid.entities.Cours;
import org.glsid.entities.Departement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestService {

	@Autowired
	private CourRepository CourRepository;
	@Autowired
	private DepartementRepository departementRepository;
	@Autowired
	private EnsignantRepository EnsignantRepository;
	
	@GetMapping(value = "/listCours")
	public List<Cours> listCours(){
		return CourRepository.findAll();
	}
	
	@GetMapping(value = "/listCours/{id}")
	public Cours listCours(@PathVariable(name = "id") long id){
		return CourRepository.findById(id).get();
	}
	
	@PutMapping(value = "/listCours/{id}")
	public void update(@PathVariable(name = "id") long id,@RequestBody Cours P){
		P.setCode(id);
		CourRepository.save(P);
	}
	
	@PostMapping(value = "/listCours")
	public void ajouter(@RequestBody Cours P){
		CourRepository.save(P);
	}
	
	@PostMapping(value = "/listDepts")
	public void ajouter(@RequestBody Departement d){
		departementRepository.save(d);
	}
	
	@DeleteMapping(value = "/listCours/{id}")
	public void delete(@PathVariable(name = "id") long id){
		CourRepository.deleteById(id);
	}
}

package org.glsid.web;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.validation.Valid;

import org.glsid.dao.DepartementRepository;
import org.glsid.dao.EnsignantRepository;
import org.glsid.entities.Departement;
import org.glsid.entities.Ensignant;
import org.glsid.entities.Permanant;
import org.glsid.entities.Vacataire;
import org.glsid.metier.IMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EnsignantController {

	@Autowired
	private IMetier metier;
	@Autowired
	private EnsignantRepository ensignantRepository;
	@Autowired
	private DepartementRepository departementRepository;
	
	
	@RequestMapping("/ensignants")
	public String ensignants(Model model,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="4")int size){
		
		Ensignant ensignant=new Vacataire();
		ensignant.setDepartement(new Departement());
		model.addAttribute("ensignant",ensignant);
		
		try {
			
			Page<Ensignant> pageEnsignant= metier.listEnsignants(page, size);
			
			model.addAttribute("listEnsignants",pageEnsignant.getContent());
			model.addAttribute("departements", departementRepository.findAll());
			
			
			int [] pages=new int[pageEnsignant.getTotalPages()];
			model.addAttribute("pages",pages);
			model.addAttribute("pageCourante", page);
			
		} catch (RuntimeException e) {
			model.addAttribute("e",e);
			model.addAttribute("errorMessage","Enseignant introuvalble");
			System.err.println(e.getMessage());;
			model.addAttribute("ensignant",null);

		}
		
		return "ensignant";		
		
	}

	
	  @RequestMapping(value = "/deleteEnsignant", method = RequestMethod.GET) 
	  public String delete(Model model,@RequestParam(name="code") Long code) {
	  metier.deleteCoursEns(code);	  
	  ensignantRepository.deleteById(code);
	  return "redirect:/ensignants"; 
	  }
	  
	  
	  @RequestMapping(value = "/editEnsignant", method = RequestMethod.GET) public
	  String editClient(Model model,Long
	  code,@RequestParam(name="page",defaultValue="0")int
	  page,@RequestParam(name="size",defaultValue="4")int size) { 
	  
      SimpleDateFormat f=new SimpleDateFormat("MM/dd/yyyy");

      Ensignant ensignant=ensignantRepository.findById(code).get();	  
	  if(ensignant!=null){
		  model.addAttribute("ensignant", ensignant);
		  String date=f.format(ensignant.getDateNaissance());
	      try {
			model.addAttribute("date", date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  Page<Ensignant> pageEnsignant=metier.listEnsignants(page, size);
	  
	  model.addAttribute("listEnsignants",pageEnsignant.getContent());
	  int [] pages=new int[pageEnsignant.getTotalPages()];
		model.addAttribute("pages",pages);
		model.addAttribute("pageCourante", page);
		}
	  
	  else{ return "redirect:/ensignants"; }
	  
	  return "redirect:/ensignants"; }
	  
	  
	  
	  @RequestMapping(value = "/saveEnsignant", method = RequestMethod.POST) 
	  public String saveEnsignant(Model model, Long code,String nom,String dateNaissance,long departement,String TYPE_ENS) {
	 
		  Departement dept=departementRepository.findById(departement).get();

		if (TYPE_ENS.equals("vac")) {
			SimpleDateFormat f=new SimpleDateFormat("yyyy-mm-dd");
			Date date=null;
			try {
				date = f.parse(dateNaissance);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Ensignant ensignant=new Vacataire(nom,date,dept, 45);
			  ensignantRepository.save(ensignant); 
		}
		else {
			SimpleDateFormat f=new SimpleDateFormat("yyyy-mm-dd");
			Date date=null;
			try {
				date = f.parse(dateNaissance);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Ensignant ensignant=new Permanant(nom, date,dept, 25);
			  ensignantRepository.save(ensignant); 
		}
		return "redirect:/ensignants";
	  
}
}
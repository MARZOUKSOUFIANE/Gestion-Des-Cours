package org.glsid.web;

import java.util.Collection;

import javax.validation.Valid;

import org.glsid.dao.CourRepository;
import org.glsid.dao.EnsignantRepository;
import org.glsid.entities.Cours;
import org.glsid.entities.Departement;
import org.glsid.metier.IMetier;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlleur {
    @Autowired
	private IMetier metier;
    @Autowired
    private CourRepository CourRepository;
    @Autowired
    private EnsignantRepository ensignantRepository;
	
    @RequestMapping("/")
    public String defaut() {
    	return "redirect:/school";
    }
    
    @RequestMapping("/school")
    public String index(Model model,
    		@RequestParam(name="page",defaultValue="0") int page,
    		@RequestParam(name="size",defaultValue="5") int size) {
    	
     	try {
    		int pageCourante=page;
    		Page<Cours> listCours=metier.listCours(page, size);
        	int[]  pages=new int[listCours.getTotalPages()];
        	model.addAttribute("pages", pages);
        	model.addAttribute("listCours", listCours.getContent());
        	model.addAttribute("ensignants", ensignantRepository.findAll());
        	model.addAttribute("pageCourante", pageCourante);
		} catch (Exception e) {
			model.addAttribute("exception", e.getMessage());
		}
    	return "cours";
    }
    
    @RequestMapping("/ens_cours")
    public String index(Model model,String nom,
    		@RequestParam(name="page",defaultValue="0") int page,
    		@RequestParam(name="size",defaultValue="5") int size) {
    	
     	try {
    		int pageCourante=page;
    		Page<Cours> listCours=metier.listCours(nom,page, size);
        	int[]  pages=new int[listCours.getTotalPages()];
        	model.addAttribute("pages", pages);
        	model.addAttribute("listCours", listCours.getContent());
        	model.addAttribute("pageCourante", pageCourante);
		} catch (Exception e) {
			model.addAttribute("exception", e.getMessage());
		}
    	return "cours";
    }
    

	  @RequestMapping(value = "/saveCours", method = RequestMethod.POST) 
	  public String saveEnsignant(Model model, @Valid Cours cours,BindingResult bindingResult) {
		  if (bindingResult.hasErrors()) {
				return "cours";
			}
     CourRepository.save(cours);
		return "redirect:/school";
	  
}
    
}

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
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DepartementController {

	@Autowired
	private IMetier metier;
	@Autowired
	private EnsignantRepository ensignantRepository;
	@Autowired
	private DepartementRepository departementRepository;

	@RequestMapping("/departements")
	public String departements(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "4") int size) {

		try {

			Page<Departement> pageDepartements = metier.listDepartements(page, size);

			model.addAttribute("listDepartements", pageDepartements.getContent());

			int[] pages = new int[pageDepartements.getTotalPages()];
			model.addAttribute("pages", pages);
			model.addAttribute("pageCourante", page);

		} catch (RuntimeException e) {
			model.addAttribute("e", e);
			model.addAttribute("errorMessage", "Departement introuvalble");
			System.err.println(e.getMessage());
			;
		}

		return "departement";

	}

	@RequestMapping(value = "/deleteDepartement", method = RequestMethod.GET)
	public String delete(Model model, @RequestParam(name = "code") Long code) {
		// metier.deleteEnsDept(code);
		for (Departement p : departementRepository.findAll()) {
			if (p.getCode() == departementRepository.getOne(code).getCode()) {
				for (Ensignant e : p.getEnsignants()) {
					metier.deleteCoursEns(e.getCode());
					ensignantRepository.deleteById(p.getCode());
				}
			}
		}
		departementRepository.deleteById(code);
		return "redirect:/departements";
	}

	@RequestMapping(value = "/saveDepartement", method = RequestMethod.POST)
	public String saveEnsignant(Model model, @Valid Departement departement, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "departement";
		}
		departementRepository.save(departement);
		return "redirect:/departements";

	}
}
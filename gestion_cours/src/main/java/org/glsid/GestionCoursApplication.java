package org.glsid;

import java.util.Date;

import org.glsid.dao.CourRepository;
import org.glsid.dao.DepartementRepository;
import org.glsid.dao.EnsignantRepository;
import org.glsid.dao.UserRepository;
import org.glsid.entities.Cours;
import org.glsid.entities.Departement;
import org.glsid.entities.Ensignant;
import org.glsid.entities.Permanant;
import org.glsid.entities.User;
import org.glsid.entities.Vacataire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class GestionCoursApplication implements CommandLineRunner{
	@Autowired
   CourRepository courRepository;
	@Autowired
   EnsignantRepository ensignantRepository;
	@Autowired
   DepartementRepository departementRepository;
	@Autowired
   UserRepository UserRepository;
	@Autowired
   PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(GestionCoursApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		
		/*
		 * Departement dep1=departementRepository.save(new Departement("informatique"));
		 * Departement dep2=departementRepository.save(new Departement("mathematique"));
		 * 
		 * Ensignant ens1=ensignantRepository.save(new Vacataire("soufiane", new Date(),
		 * dep1, 45)); Ensignant ens2=ensignantRepository.save(new Permanant("ahmed",
		 * new Date(), dep2, 25));
		 * 
		 * Cours c1=courRepository.save(new Cours("jee", 45, 4,ens1)); Cours
		 * c2=courRepository.save(new Cours("java", 25, 4,ens2));
		 * 
		 * User user1=UserRepository.save(new
		 * User("soufiane",passwordEncoder.encode("soufiane123"), "ADMIN",
		 * "all_Resources")); User user2=UserRepository.save(new
		 * User("marzouk",passwordEncoder.encode("marzouk123"), "USER",
		 * "access_cours"));
		 */
		 
		
		
		
	}

}

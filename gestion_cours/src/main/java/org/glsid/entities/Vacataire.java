package org.glsid.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("vac")
public class Vacataire extends Ensignant{

	private double tauxHorVac;

	public Vacataire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vacataire(String nom, Date dateNaissance,Departement dept,double tauxHorVac) {
		super(nom, dateNaissance,dept);
		this.tauxHorVac =tauxHorVac;
		// TODO Auto-generated constructor stub
	}

	

	
	
	
}

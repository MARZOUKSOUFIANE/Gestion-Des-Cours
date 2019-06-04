package org.glsid.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("per")
public class Permanant extends Ensignant{

	private double SOM;

	public Permanant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Permanant(String nom, Date dateNaissance,Departement dept,double tauxHorVac) {
		super(nom, dateNaissance,dept);
		this.SOM =tauxHorVac;
		// TODO Auto-generated constructor stub
	}

	
	
	
}

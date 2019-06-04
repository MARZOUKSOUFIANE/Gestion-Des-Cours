package org.glsid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@XmlRootElement
public class Cours implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	private String titre;
	private double horaire;
	private int coefficient;
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "code_ens")
	private Ensignant ensignant;

	public Cours() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cours(String titre, double horaire, int coefficient, Ensignant ensignant) {
		super();
		this.titre = titre;
		this.horaire = horaire;
		this.coefficient = coefficient;
		this.ensignant = ensignant;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public double getHoraire() {
		return horaire;
	}

	public void setHoraire(double horaire) {
		this.horaire = horaire;
	}

	public int getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}

	@XmlTransient
	public Ensignant getEnsignant() {
		return ensignant;
	}

	public void setEnsignant(Ensignant ensignant) {
		this.ensignant = ensignant;
	}

}

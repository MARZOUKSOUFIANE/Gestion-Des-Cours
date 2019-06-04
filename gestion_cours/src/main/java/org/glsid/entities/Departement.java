package org.glsid.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Departement implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;
	private String nom;
	@OneToMany(mappedBy = "departement", fetch = FetchType.LAZY)
	@JsonBackReference
	private Collection<Ensignant> ensignants;

	public Collection<Ensignant> getEnsignants() {
		return ensignants;
	}

	public void setEnsignants(Collection<Ensignant> ensignants) {
		this.ensignants = ensignants;
	}

	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Departement(String nom) {
		super();
		this.nom = nom;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}

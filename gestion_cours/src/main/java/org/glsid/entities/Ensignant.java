package org.glsid.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_ENS", discriminatorType = DiscriminatorType.STRING, length = 3)

public abstract class Ensignant implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;
	private String nom;
	private Date dateNaissance;
	@OneToMany(mappedBy="ensignant",fetch=FetchType.LAZY)
	@JsonBackReference
	private Collection<Cours> cours;
	@ManyToOne
	@JoinColumn(name="dept")
	@JsonManagedReference
	private Departement departement;
    
	public Collection<Cours> getCours() {
		return cours;
	}

	public void setCours(Collection<Cours> cours) {
		this.cours = cours;
	}

	

	public Ensignant(String nom, Date dateNaissance, Departement departement) {
		super();
		this.nom = nom;
		this.dateNaissance = dateNaissance;
		this.departement = departement;
	}

	public Ensignant() {
		super();
		// TODO Auto-generated constructor stub
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

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

}

package com.master.foreignClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ProduitPrix entity provides the base persistence definition of the
 * ProduitPrix entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table
public  class ProduitPrix implements java.io.Serializable {

	// Fields

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer codePdt;
	@Column
	private String nomPdt ;
	@Column
	private String descPdt ;
	@Column
	private Float prixPdt;

	// Constructors

	/** default constructor */
	public ProduitPrix() {
	}

	/** minimal constructor */
	public ProduitPrix(Integer codePdt) {
		this.codePdt = codePdt;
	}

	/** full constructor */
	public ProduitPrix(Integer codePdt, String nomPdt , String descPdt , Float prixPdt) {
		this.codePdt = codePdt;
		this.nomPdt  = nomPdt ;
		this.descPdt  = descPdt ;
		this.prixPdt = prixPdt;
	}

	// Property accessors

	public Integer getCodePdt() {
		return this.codePdt;
	}

	public void setCodePdt(Integer codePdt) {
		this.codePdt = codePdt;
	}

	public String getNomPdt () {
		return this.nomPdt ;
	}

	public void setNomPdt (String nomPdt ) {
		this.nomPdt  = nomPdt ;
	}

	public String getDescPdt () {
		return this.descPdt ;
	}

	public void setDescPdt (String descPdt ) {
		this.descPdt  = descPdt ;
	}

	public Float getPrixPdt() {
		return this.prixPdt;
	}

	public void setPrixPdt(Float prixPdt) {
		this.prixPdt = prixPdt;
	}

}
package com.master.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ProduitStock")
public class ProduitStock {
	
	private int codeProduitStock ;
	private String nomPdt ;
	private int codePdt ;
	private int prixPdt ;
	private int qtePdt ;
	private String descPdt ;
	private Date dateProduitStock ;
	
	
	public String getNomPdt() {
		return nomPdt;
	}
	public void setNomPdt(String nomPdt) {
		this.nomPdt = nomPdt;
	}
	//getters and setters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	public int getCodeProduitStock() {
		return codeProduitStock;
	}
	public void setCodeProduitStock(int codeProduitStock) {
		this.codeProduitStock = codeProduitStock;
	}
	@Column
	public int getCodePdt() {
		return codePdt;
	}
	public void setCodePdt(int codePdt) {
		this.codePdt = codePdt;
	}
	@Column
	public int getPrixPdt() {
		return prixPdt;
	}
	public void setPrixPdt(int prixPdt) {
		this.prixPdt = prixPdt;
	}
	@Column
	public int getQtePdt() {
		return qtePdt;
	}
	public void setQtePdt(int qtePdt) {
		this.qtePdt = qtePdt;
	}
	@Column
	public String getDescPdt() {
		return descPdt;
	}
	public void setDescPdt(String descPdt) {
		this.descPdt = descPdt;
	}
	@Column(nullable = false)
	public Date getDateProduitStock() {
		return dateProduitStock;
	}
	public void setDateProduitStock(Date dateProduitStock) {
		this.dateProduitStock = dateProduitStock;
	}
	@Override
	public String toString() {
		return "ProduitStock [codeProduitStock=" + codeProduitStock + ", nomPdt=" + nomPdt + ", prixPdt=" + prixPdt + ", codePdt=" + codePdt + ", qtePdt="
				+ qtePdt + ", descPdt=" + descPdt + ", dateProduitStock=" + dateProduitStock + "]";
	}
	
	
	
	

}

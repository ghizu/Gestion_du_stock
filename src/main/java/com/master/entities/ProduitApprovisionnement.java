package com.master.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "produitsApprovisionnement")
public class ProduitApprovisionnement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codeProduitAppr", unique = true, nullable = false)
	private int codeProduitAppr;

	@Column(name = "codePdt")
	private int codePdt;

	@Column(name = "qteCommande")
	private int qteCommande;
	
	private int prixPdt;

	@Column(name = "datePrevueLivraison")
	private Date datePrevueLivraison;
	

	public ProduitApprovisionnement(int codeProduitAppr, int codePdt, int qteCommande, int prixPdt, Date datePrevueLivraison ) {
		super();
		this.codeProduitAppr = codeProduitAppr;
		this.codePdt = codePdt;
		this.qteCommande = qteCommande;
		this.prixPdt = prixPdt;
		this.datePrevueLivraison = datePrevueLivraison;
		
	}

	public ProduitApprovisionnement() {
		super();
	}

	@Override
	public String toString() {
		return "ProduitApprovisionnement [codeProduitAppr=" + codeProduitAppr + ", codePdt=" + codePdt 
				+ ", qteCommande=" + qteCommande + ", prixPdt=" + prixPdt + ", datePrevueLivraison=" + datePrevueLivraison + "]";
	}

	public int getCodeProduitAppr() {
		return codeProduitAppr;
	}

	public void setCodeProduitAppr(int codeProduitAppr) {
		this.codeProduitAppr = codeProduitAppr;
	}
	

	public int getCodePdt() {
		return codePdt;
	}

	public void setCodePdt(int codePdt) {
		this.codePdt = codePdt;
	}

	public int getQteCommande() {
		return qteCommande;
	}

	public void setQteCommande(int qteCommande) {
		this.qteCommande = qteCommande;
	}
	
	public int getPrixPdt() {
		return prixPdt;
	}

	public void setPrixPdt(int prixPdt) {
		this.prixPdt = prixPdt;
	}

	public Date getDatePrevueLivraison() {
		return datePrevueLivraison;
	}

	public void setDatePrevueLivraison(Date datePrevueLivraison) {
		this.datePrevueLivraison = datePrevueLivraison;
	}

}

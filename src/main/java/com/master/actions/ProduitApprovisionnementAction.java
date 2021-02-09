package com.master.actions;


import java.util.List;

import com.master.DAO.ProduitApprovisionnementDAO;
import com.master.DAO.ProduitPrixDAO;
import com.master.entities.ProduitApprovisionnement;
import com.master.foreignClasses.ProduitPrix;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ProduitApprovisionnementAction extends ActionSupport {

	private ProduitApprovisionnement produitApprovisionnement = new ProduitApprovisionnement();
	private ProduitPrix Produit;
	private List<ProduitApprovisionnement> produitsApprovisionnement;
	private ProduitApprovisionnementDAO dao;
	private ProduitPrixDAO dao2;
	private List<ProduitPrix> Produit_List;
	private int id;

	public ProduitApprovisionnementAction() {
		dao = new ProduitApprovisionnementDAO();
		dao2 = new ProduitPrixDAO();
	}

	@Override
	public String execute() throws Exception {
		Produit_List = dao2.list();
		produitsApprovisionnement = dao.list();
		return SUCCESS;
	}

	public String addProduitApprovisionnement() {
		dao.add(produitApprovisionnement);
		return SUCCESS;
	}

	public String editProduitApprovisionnement () {
		dao.add(produitApprovisionnement);
		return SUCCESS ;
	}
	public String deleteProduitApprovisionnement() {
		System.out.println("delete called");
		try {
			dao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problème lors de l'ajout d'un objet");
		}

		return SUCCESS;
	}

	public String updateProduitApprovisionnement() {
		Produit_List = dao2.list();
		produitApprovisionnement=dao.getById(id);
		return SUCCESS;
	}

	public ProduitApprovisionnement getProduitApprovisionnement() {
		return produitApprovisionnement;
	}

	public void setProduitApprovisionnement(ProduitApprovisionnement produitApprovisionnement) {
		this.produitApprovisionnement = produitApprovisionnement;
	}

	public ProduitPrix getProduit() {
		return Produit;
	}

	public void setProduit(ProduitPrix Produit) {
		this.Produit = Produit;
	}

	public List<ProduitApprovisionnement> getProduitsApprovisionnement() {
		return produitsApprovisionnement;
	}

	public void setProduitsApprovisionnement(List<ProduitApprovisionnement> produitsApprovisionnement) {
		this.produitsApprovisionnement = produitsApprovisionnement;
	}

	public ProduitApprovisionnementDAO getDao() {
		return dao;
	}

	public void setDao(ProduitApprovisionnementDAO dao) {
		this.dao = dao;
	}

	public ProduitPrixDAO getDao2() {
		return dao2;
	}

	public void setDao2(ProduitPrixDAO dao2) {
		this.dao2 = dao2;
	}

	public List<ProduitPrix> getProduit_List() {
		return Produit_List;
	}

	public void setProduit_List(List<ProduitPrix> Produit_List) {
		this.Produit_List = Produit_List;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

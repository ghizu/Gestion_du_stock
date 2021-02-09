package com.master.actions;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.master.DAO.ProduitApprovisionnementDAO;
import com.master.DAO.ProduitPrixDAO;
import com.opensymphony.xwork2.ActionSupport;

public class AcceuilAction extends ActionSupport {

	private int total_produitApprovisionnement ;
	private int total_produitApprovisionnement_ce_mois ;
	private double Budget_produitApprovisionnement_total ;
	private double Budget_produitApprovisionnement_ce_mois ;
	
	private ProduitApprovisionnementDAO dao ;
	private ProduitPrixDAO dao2  ;
	public AcceuilAction () {
		dao = new ProduitApprovisionnementDAO() ;
		dao2 = new ProduitPrixDAO() ;
	}
	@Override
	public String execute() throws Exception {

//		HttpSession session  = ServletActionContext.getRequest().getSession(false);
//		if (session ==null || session.getAttribute("login") == null)
//			return "login" ;
		total_produitApprovisionnement  =  dao.get_total_produitApprovisionnement();
		total_produitApprovisionnement_ce_mois = dao.total_produitApprovisionnement_ce_mois() ;
		
		return SUCCESS;
	}
	public String logout() {
		return SUCCESS ;
	}
	public int getTotal_produitApprovisionnement() {
		return total_produitApprovisionnement;
	}
	public void setTotal_produitApprovisionnement(int total_produitApprovisionnement) {
		this.total_produitApprovisionnement = total_produitApprovisionnement;
	}
	public int getTotal_produitApprovisionnement_ce_mois() {
		return total_produitApprovisionnement_ce_mois;
	}
	public void setTotal_produitApprovisionnement_ce_mois(int total_produitApprovisionnement_ce_mois) {
		this.total_produitApprovisionnement_ce_mois = total_produitApprovisionnement_ce_mois;
	}
	
	public double getBudget_produitApprovisionnement_total() {
		return Budget_produitApprovisionnement_total;
	}
	public void setBudget_produitApprovisionnement_total(double budget_produitApprovisionnement_total) {
		Budget_produitApprovisionnement_total = budget_produitApprovisionnement_total;
	}
	public double getBudget_produitApprovisionnement_ce_mois() {
		return Budget_produitApprovisionnement_ce_mois;
	}
	public void setBudget_produitApprovisionnement_ce_mois(double budget_produitApprovisionnement_ce_mois) {
		Budget_produitApprovisionnement_ce_mois = budget_produitApprovisionnement_ce_mois;
	}
	public void setBudget_produitApprovisionnement_ce_mois(int budget_produitApprovisionnement_ce_mois) {
		Budget_produitApprovisionnement_ce_mois = budget_produitApprovisionnement_ce_mois;
	}
	
}

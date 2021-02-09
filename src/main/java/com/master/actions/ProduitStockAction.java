package com.master.actions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.master.DAO.CommandDAO;
import com.master.DAO.ProduitApprovisionnementDAO;
import com.master.DAO.ProduitPrixDAO;
import com.master.DAO.ProduitStockDAO;
import com.master.entities.ProduitApprovisionnement;
import com.master.entities.ProduitStock;
import com.master.foreignClasses.ProduitPrix;
import com.master.foreignClasses.Commandes;
import com.opensymphony.xwork2.ActionSupport;

public class ProduitStockAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private ProduitStock produitStock = new ProduitStock();

	private Date startDate;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	
	// lists
	
	private List<ProduitStock> produitStockGenerale;
	private List<ProduitPrix> ProduitList;
	private List<String> dates_string_list;
	private List<ProduitPrix> Produit_List;

	// pointer
	
	public List<ProduitPrix> getProduit_List() {
		return Produit_List;
	}

	public void setProduit_List(List<ProduitPrix> Produit_List) {
		this.Produit_List = Produit_List;
	}

	private int id;
	private String date;
	private Date current_produitStock_date;
	private String current_produitStock_date_string;

	// dao
	
	private List<ProduitStock> produitStock_shown;
	private ProduitStockDAO dao;
	private ProduitPrixDAO dao2;
	private CommandDAO dao3 ;
	private ProduitApprovisionnementDAO dao4 ;
	
	private List<Date> produitsStock_dates_liste;

	// constructor
	public ProduitStockAction() {
		dao = new ProduitStockDAO();
		dao2 = new ProduitPrixDAO();
		dao3 = new CommandDAO(); 
		dao4 = new ProduitApprovisionnementDAO();
		this.startDate =this.get_start_date() ;
	}

	public Date get_start_date() {

		return dao.get_distinct_dates().get(0);
	}

	@Override
	public String execute() throws Exception {

		System.out.println("exécuter a été appelé");

		produitsStock_dates_liste = dao.get_distinct_dates();
		dates_string_list = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		for (int i = 0; i < produitsStock_dates_liste.size(); i++) {
			dates_string_list.add(sdf.format(produitsStock_dates_liste.get(i)));
		}
		this.produitStock_shown = dao.list();
		this.ProduitList = dao2.list();
		this.produitStockGenerale = new ArrayList<ProduitStock>();

		for (int i = 0; i < ProduitList.size(); i++) {
			produitStockGenerale.add(new ProduitStock());
		}
		this.load_codePdt_in_produitStockGenerale(ProduitList);
		for (ProduitStock prodStock : produitStockGenerale) {
			System.out.println(prodStock.getCodePdt());
		}
		return SUCCESS;
	}

	
	

	public String produitStock_a_une_date() {

		List<Date> dates = dao.get_distinct_dates();
		
		if (current_produitStock_date !=  null)
		{
			if (dates.contains((Date) current_produitStock_date)) {
				produitStockGenerale = dao.get_produitsStock_of_date(current_produitStock_date);
				produitStock_shown = dao.get_produitStock_with_name(produitStockGenerale);
				for (int i = 0; i < produitStock_shown.size(); i++) {
					System.out.println("shownshownshownshownshown  " + produitStock_shown.get(i));
				}
			} else {
				Date produitStock_old_date = current_produitStock_date ;
				for (int i = 0; i < dates.size() - 1; i++) {
					if ((produitStock_old_date.compareTo(dates.get(i)) > 0)
							&& (produitStock_old_date.compareTo(dates.get(i + 1)) <= 0)) {
						produitStock_old_date = dates.get(i);
						break;
					}
				}
				produitStockGenerale = dao.get_produitsStock_of_date(produitStock_old_date);
				produitStock_shown = dao.get_produitStock_with_name(produitStockGenerale);
				//
				List<Commandes> commands = dao3.get_commands_by_date(produitStock_old_date, current_produitStock_date);
				List<ProduitApprovisionnement> produitsApprovisionnement = dao4.get_produitsApprovisionnement_by_date(produitStock_old_date, current_produitStock_date);
				for (int i = 0; i < commands.size(); i++) {
					for (int j = 0; j < produitStock_shown.size(); j++) {
						if (commands.get(i).getCodePdt() == produitStock_shown.get(j).getCodePdt()) {
							produitStock_shown.get(j).setQtePdt(produitStock_shown.get(j).getQtePdt() - commands.get(i).getQteCmd());
						}
					}
				}
				for (int i = 0; i < produitsApprovisionnement.size(); i++) {
					for (int j = 0; j < produitStock_shown.size(); j++) {
						if (produitsApprovisionnement.get(i).getCodePdt() == produitStock_shown.get(j).getCodePdt()) {
							produitStock_shown.get(j).setQtePdt(produitStock_shown.get(j).getQtePdt() + produitsApprovisionnement.get(i).getQteCommande() );
						}
					}
				}
				
			}

		}
		
		return SUCCESS;
	}

	public String add() {

		try {
			System.out.println();
			dao.add(getProduitStock());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problème lors de l'ajout d'un objet");
		}
		this.produitStockGenerale = dao.list();
		return SUCCESS;
	}

	public String edit() {
		Produit_List = dao2.list();
		produitStock = dao.getById(id);
		return SUCCESS;
	}

	public String update() {
		System.out.println(produitStock.getDateProduitStock());
		dao.add(produitStock);
		return SUCCESS;
	}

	public String delete() {
		System.out.println("delete called");
		try {
			dao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problème lors de l'ajout d'un objet");
		}
		this.produitStockGenerale = dao.list();
		return SUCCESS;
	}

	public String save_produitStock() {

		System.out.println(current_produitStock_date);
		this.ProduitList = dao2.list();
		for (int i = 0; i < produitStockGenerale.size(); i++) {
			produitStockGenerale.get(i).setDateProduitStock(this.current_produitStock_date);
		}
		for (int i = 0; i < produitStockGenerale.size(); i++) {
			this.produitStockGenerale.get(i).setCodePdt(this.ProduitList.get(i).getCodePdt());
		}
		for (int i = 0; i < produitStockGenerale.size(); i++) {
			dao.add(produitStockGenerale.get(i));
		}
		return SUCCESS;
	}

	private void load_codePdt_in_produitStockGenerale(List<ProduitPrix> ProduitList) {
		for (int i = 0; i < ProduitList.size(); i++) {
			this.produitStockGenerale.get(i).setCodePdt(ProduitList.get(i).getCodePdt());
			this.produitStockGenerale.get(i).setNomPdt(ProduitList.get(i).getNomPdt());
		}
	}

	public String produitStock_information() throws java.text.ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date dt = formatter.parse(current_produitStock_date_string);
		this.produitStock_shown = dao.get_produitsStock_of_date(dt);
		System.out.println();
		return SUCCESS;
	}

	public String delete_produitsStock() throws java.text.ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date dt = formatter.parse(current_produitStock_date_string);
		dao.delete_by_date(dt);
		return SUCCESS;
	}

	////////////////////////////////////////////////////////////////////////////////////////////

	public String getCurrent_produitStock_date_string() {
		return current_produitStock_date_string;
	}

	public void setCurrent_produitStock_date_string(String current_produitStock_date_string) {
		this.current_produitStock_date_string = current_produitStock_date_string;
	}

	public ProduitStock getProduitStock() {
		return produitStock;
	}

	public void setProduitStock(ProduitStock produitStock) {
		this.produitStock = produitStock;
	}

	public List<ProduitStock> getProduitStockGenerale() {
		return produitStockGenerale;
	}

	public void setProduitStockGenerale(List<ProduitStock> produitStockGenerale) {
		this.produitStockGenerale = produitStockGenerale;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ProduitStock> getProduitStock_shown() {
		return produitStock_shown;
	}

	public void setProduitStock_shown(List<ProduitStock> produitStock_shown) {
		this.produitStock_shown = produitStock_shown;
	}

	public List<ProduitPrix> getProduitList() {
		return ProduitList;
	}

	public void setProduitList(List<ProduitPrix> ProduitList) {
		this.ProduitList = ProduitList;
	}

	public Date getCurrent_produitStock_date() {
		return current_produitStock_date;
	}

	public void setCurrent_produitStock_date(Date current_produitStock_date) {
		this.current_produitStock_date = current_produitStock_date;
	}

	public List<Date> getProduitsStock_dates_liste() {
		return produitsStock_dates_liste;
	}

	public void setProduitsStock_dates_liste(List<Date> produitsStock_dates_liste) {
		this.produitsStock_dates_liste = produitsStock_dates_liste;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<String> getDates_string_list() {
		return dates_string_list;
	}

	public void setDates_string_list(List<String> dates_string_list) {
		this.dates_string_list = dates_string_list;
	}

}

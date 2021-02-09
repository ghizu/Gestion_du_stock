import com.master.DAO.ProduitPrixDAO;
import com.master.foreignClasses.ProduitPrix;

public class MainApp {

	public static void main(String[] args) throws Exception {		
		
		ProduitPrixDAO dao2 = new ProduitPrixDAO();
//		ProduitPrix Produit=new ProduitPrix(1, "asusTec 1", "Asus 1", 4000f);
//		ProduitPrix Produit1=new ProduitPrix(2, "asusTec 2", "asus 2", 5000f);
		//0, "asusTec 3", "asus", 3000f
		ProduitPrix Produit2=new ProduitPrix();
		Produit2.setDescPdt("PcAsus");
		Produit2.setNomPdt("asusTec ");
		Produit2.setPrixPdt(6000f);
//		dao2.add(Produit);
//		dao2.add(Produit1);
		dao2.add(Produit2);
		
		
	}
}

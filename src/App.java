import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import DAO.DAOCategorie;
import DAO.DAOCompteRendu;
import DAO.DAOCreneaux;
import DAO.DAOGeneric;
import DAO.DAOMedecin;
import DAO.DAOProduit;
import DAO.DAOVisiteur;
import model.Visiteur;
import util.HibernateUtil;
import util.TestConnection;
import views.NewRDV;
import views.ViewRDV;
import views.allRDV;
import views.allRDVMedcin;
import views.compteRenduVisite;
import views.connexion;
import views.newCRV;

public class App {


	public static void username(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Visiteur user = (Visiteur) session.get(Visiteur.class, id);
		System.out.println("Visiteur name : " + user.getVisiteurNom());
	}
	public static void main(String[] args) throws HibernateException, SQLException {
		/*System.out.println("Running");
		*///TestConnection t = new TestConnection();
		//t.init();
		
		
		new Controller(new connexion(), new DAOVisiteur(HibernateUtil.getSessionFactory().openSession()), new DAOMedecin(HibernateUtil.getSessionFactory().openSession())).Init();
		
		//new ControllerCRV(new compteRenduVisite(), new DAOCompteRendu(HibernateUtil.getSessionFactory().openSession())).Init();
		
	    //new ControllerNewCRV(new newCRV(), new DAOProduit(HibernateUtil.getSessionFactory().openSession()), new DAOCategorie(HibernateUtil.getSessionFactory().openSession()),new DAOMedecin(HibernateUtil.getSessionFactory().openSession()),new DAOVisiteur(HibernateUtil.getSessionFactory().openSession()),new DAOCompteRendu(HibernateUtil.getSessionFactory().openSession())).Init();

		//new ControllerNewRDV(new NewRDV(), new DAOCreneaux(HibernateUtil.getSessionFactory().openSession()), new DAOMedecin(HibernateUtil.getSessionFactory().openSession())).Init();
		
		//new ControllerRDV(new ViewRDV(), new DAOCreneaux(HibernateUtil.getSessionFactory().openSession()), new DAOMedecin(HibernateUtil.getSessionFactory().openSession()), new DAOVisiteur(HibernateUtil.getSessionFactory().openSession())).Init();
		
		//new ControllerAllRDV2(new allRDV(), new DAOCreneaux(HibernateUtil.getSessionFactory().openSession()), new DAOVisiteur(HibernateUtil.getSessionFactory().openSession())).Init();
		
		//new ControllerRDVMed(new allRDVMedcin(), new DAOCreneaux(HibernateUtil.getSessionFactory().openSession()), new DAOMedecin(HibernateUtil.getSessionFactory().openSession())).Init();
	}

}

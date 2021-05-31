


import java.awt.event.ActionListener;
import java.awt.image.ConvolveOp;
import java.sql.SQLException;
import java.util.List;

import javax.security.auth.Refreshable;
import javax.swing.JButton;
import javax.xml.bind.ParseConversionEvent;

import org.hibernate.HibernateException;

import DAO.DAOCompteRendu;
import DAO.DAOVisiteur;
import views.connexion;
import views.acceuil;
import views.compteRenduVisite;
import model.CompteRenduVisite;
import model.Visiteur;
import util.HibernateUtil;

import java.awt.Color;
import java.awt.event.ActionEvent;

public class Controller implements ActionListener{
	
	private connexion fenetre;
	private compteRenduVisite compteRenduVisite;
	DAOVisiteur daoVisiteur;
	List<DAOVisiteur> cities;
	int IndexCity = 0;
	
	
	public Controller(connexion fenetre, DAOVisiteur daoVisiteur) {
		
		this.fenetre = fenetre;
		this.daoVisiteur = daoVisiteur;
		fenetre.getBtnConnexion().addActionListener(this);
					
	}

	public void Init() {	
			
		fenetre.setVisible(true);	
		
		
	}
	
	private void ConnexionAction() throws HibernateException, SQLException {
		String mail = fenetre.getTextField_user().getText();
		String mdp = fenetre.getTextField_mdp().getText();
		
		if(mail.equals("")) {
			System.out.println("Veuillez entrer un email");
		}
		else {
			Visiteur bdd_visiteur = daoVisiteur.verifEmail(mail);	
			if(bdd_visiteur != null) {
				String bdd_mdp = bdd_visiteur.getVisiteurPassword();
				
				if(bdd_mdp.equals(mdp)) {
					new ControllerCRV(new compteRenduVisite(), new DAOCompteRendu(HibernateUtil.getSessionFactory().openSession())).Init();
					
				}else {
					System.out.println("Mot de passe incorrecte");
				}
			}
			else {
				System.out.println("Email incorrecte");
			}
			
		}
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buton = (JButton) e.getSource();
		String name = buton.getName();
		switch (name) {
		case "Connexion":
			try {
				ConnexionAction();
			} catch (HibernateException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		default:
			break;
		}
		
		
	}
}


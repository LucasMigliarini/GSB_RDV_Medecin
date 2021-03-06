


import java.awt.event.ActionListener;
import java.awt.im.InputContext;
import java.awt.image.ConvolveOp;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.security.auth.Refreshable;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.xml.bind.ParseConversionEvent;

import org.hibernate.HibernateException;

import DAO.DAOCategorie;
import DAO.DAOCompteRendu;
import DAO.DAOCreneaux;
import DAO.DAOMedecin;
import DAO.DAOProduit;
import DAO.DAOVisiteur;
import views.NewRDV;
import views.allRDVMedcin;
import views.compteRenduVisite;
import views.newCRV;
import model.Categorie;
import model.CompteRenduVisite;
import model.Creneaux;
import model.Medecin;
import model.Produit;
import model.Visiteur;
import util.HibernateUtil;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class ControllerNewRDV implements ActionListener{
	
	private NewRDV fenetre;
	
	DAOCreneaux daoCre;
	DAOMedecin daoMed;
	List<Medecin> listProd;
	
	
	
	public ControllerNewRDV(NewRDV fenetre, DAOCreneaux daoCre,DAOMedecin daoMed) {
		
		this.fenetre = fenetre;
		this.daoCre = daoCre;
		this.daoMed = daoMed;
		fenetre.getBtnRetour().addActionListener(this);
		fenetre.getBtnValider().addActionListener(this);
					
	}

	public void Init() throws SQLException {
		List<Medecin> med = daoMed.findAll();
		for (Medecin medecin: med) {
			fenetre.getComboBox_med().addItem(medecin.getMedecinNom());
		}
		
			
		fenetre.setVisible(true);

	}
	
	private void valider() throws HibernateException, SQLException {
		String medecin = fenetre.getComboBox_med().getSelectedItem().toString();
		Medecin mede = daoMed.findByName(medecin);
		
		String date = fenetre.getTxt_date().getText().toString();
		String heure = fenetre.getTxt_heure().getText().toString();
		
		Creneaux cre = new Creneaux();
		cre.setCreDate(date);
		cre.setCreHeure(heure);
		cre.setMedecin(mede);
		daoCre.SaveOrUpdate(cre);
		
		new ControllerRDVMed(new allRDVMedcin(), new DAOCreneaux(HibernateUtil.getSessionFactory().openSession()), new DAOMedecin(HibernateUtil.getSessionFactory().openSession())).Init();
	}
	
	private void retour() throws HibernateException, SQLException {
		fenetre.setVisible(false);
		new ControllerRDVMed(new allRDVMedcin(), new DAOCreneaux(HibernateUtil.getSessionFactory().openSession()), new DAOMedecin(HibernateUtil.getSessionFactory().openSession())).Init();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buton = (JButton) e.getSource();
		String name = buton.getName();
		switch (name) {
		case "valider":
			try {
				valider();
			} catch (HibernateException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		case "retour":
			try {
				retour();
			} catch (HibernateException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		default:
			break;
		}
		
		
	}
}


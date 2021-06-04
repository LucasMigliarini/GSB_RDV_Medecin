


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
import views.ViewRDV;
import views.allRDV;
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

public class ControllerRDVMed implements ActionListener{
	
	private allRDVMedcin fenetre;
	
	DAOCreneaux daoCre;
	DAOMedecin daoMed;
	List<Creneaux> listCre;
	MyDefaultModelCreneauxMed model;
	
	
	
	public ControllerRDVMed(allRDVMedcin fenetre, DAOCreneaux daoCre, DAOMedecin daoMed) {
		
		this.fenetre = fenetre;
		this.daoCre = daoCre;
		this.daoMed = daoMed;
		fenetre.getBtnNewRDV().addActionListener(this);
		fenetre.getBtnVoir().addActionListener(this);
					
	}

	public void Init() throws SQLException {
		List<Medecin> med = daoMed.findAll();
		for (Medecin medecin : med) {
			fenetre.getComboBox_med().addItem(medecin.getMedecinNom());
		}
			
		fenetre.setVisible(true);

	}
	
	private void voir() {

		Medecin medecin = daoMed.findByName(fenetre.getComboBox_med().getSelectedItem().toString());
		List<Creneaux> cre = daoCre.FindReserverByMed(medecin);
		model = new MyDefaultModelCreneauxMed(cre);
		fenetre.getTable().setModel(model);
	}
	
	
	private void newRDV() throws HibernateException, SQLException {
		fenetre.setVisible(false);
		new ControllerNewRDV(new NewRDV(), new DAOCreneaux(HibernateUtil.getSessionFactory().openSession()), new DAOMedecin(HibernateUtil.getSessionFactory().openSession())).Init();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buton = (JButton) e.getSource();
		String name = buton.getName();
		switch (name) {
		case "newRDV":
			try {
				newRDV();
			} catch (HibernateException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "voir":
			voir();
			break;
		default:
			break;
		}
		
		
	}
}


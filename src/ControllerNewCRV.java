


import java.awt.event.ActionListener;
import java.awt.image.ConvolveOp;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.security.auth.Refreshable;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.ParseConversionEvent;

import org.hibernate.HibernateException;

import DAO.DAOCategorie;
import DAO.DAOCompteRendu;
import DAO.DAOMedecin;
import DAO.DAOProduit;
import DAO.DAOVisiteur;

import views.compteRenduVisite;
import views.newCRV;
import model.Categorie;
import model.CompteRenduVisite;
import model.Medecin;
import model.Produit;
import model.Visiteur;
import util.HibernateUtil;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class ControllerNewCRV implements ActionListener{
	
	private newCRV fenetre;
	
	DAOCategorie daoCat;
	DAOProduit daoProd;
	DAOMedecin daoMed;
	DAOVisiteur daoVisi;
	DAOCompteRendu daoCRV;
	List<Produit> listProd;
	
	String[] columns = {
            "Produits"
        };
	DefaultTableModel modele = new DefaultTableModel(columns, 0);
	
	//Categorie firstcat = daoCat.find(1);

	
	
	
	public ControllerNewCRV(newCRV fenetre, DAOProduit DaoProd, DAOCategorie DaoCat,DAOMedecin daoMed,DAOVisiteur daoVisi, DAOCompteRendu daoCRV) {
		
		this.fenetre = fenetre;
		this.daoCat = DaoCat;
		this.daoProd = DaoProd;
		this.daoMed = daoMed;
		this.daoVisi = daoVisi;
		this.daoCRV = daoCRV;
		fenetre.getBtnRetour().addActionListener(this);
		fenetre.getBtnValider().addActionListener(this);
		fenetre.getBtnAjouter().addActionListener(this);
		fenetre.getComboBox_cat().addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent event) {
	            //
	            // Get the source of the component, which is our combo
	            // box.
	            //
	            JComboBox comboBox = (JComboBox) event.getSource();
	            String comboBoxname = comboBox.getName();
	    		
	    		switch (comboBoxname) {
	    		case "selectionner":
	    			viewProduit();
	    			break;	

	    		default:
	    			break;
	    		}		
	           

	        }
	    });
	}

	public void Init() throws SQLException {
		List<Categorie> med = daoCat.findAll();
		
		for (Categorie categorie : med) {
			fenetre.getComboBox_cat().addItem(categorie.getCategorieNom());
		}
		
		List<Medecin> medecins = daoMed.findAll();
		for (Medecin Medecin : medecins) {
			fenetre.getComboBox_med().addItem(Medecin.getMedecinNom());
		}
		
		List<Visiteur> visiteurs = daoVisi.findAll();
		for (Visiteur visiteur : visiteurs) {
			fenetre.getComboBox_visi().addItem(visiteur.getVisiteurNom());
		}
		
		
		listProd= daoProd.findAll();
		System.out.println("ok");
	    
		fenetre.setVisible(true);

	}
	
	public void ajouerProduit() {
		String prod = fenetre.getComboBox_prod().getSelectedItem().toString();
		 modele.addRow(
	                new String[]{
	                	prod                 
	                }
	           );
		 fenetre.getTable().setModel(modele);
	}
	
	public void viewProduit() {
		String categorie = fenetre.getComboBox_cat().getSelectedItem().toString();
		if (categorie == null) {
			fenetre.getComboBox_cat().setSelectedItem("medicament");
		}
			Categorie cate = daoCat.findByName(fenetre.getComboBox_cat().getSelectedItem().toString());
			listProd = (List<Produit>) daoProd.findByCat(cate.getCategorieId());
			fenetre.getComboBox_prod().removeAllItems();
			for (Produit produit : listProd) {
				fenetre.getComboBox_prod().addItem(produit.getProduitNom());
			}
		
		
	}
	
	public void valider() throws HibernateException, SQLException {
		CompteRenduVisite cdr = new CompteRenduVisite();
		cdr.setCRVDate(fenetre.getTxt_date().getText());
		cdr.setCRVHeure(fenetre.getTxt_heure().getText());
		cdr.setCRVDescription(fenetre.getTxt_desc().getText());
		
		Medecin med = daoMed.findByName(fenetre.getComboBox_med().getSelectedItem().toString());
		Visiteur visi = daoVisi.findByName(fenetre.getComboBox_visi().getSelectedItem().toString());
		
		cdr.setMedecin(med);
		cdr.setVisiteur(visi);
		cdr.setProduits(listProd);
		
		daoCRV.SaveOrUpdate(cdr);
		
		fenetre.setVisible(false);
		new ControllerCRV(new compteRenduVisite(), new DAOCompteRendu(HibernateUtil.getSessionFactory().openSession())).Init();
			
	}
	
	public void retour() throws HibernateException, SQLException {
		fenetre.setVisible(false);
		new ControllerCRV(new compteRenduVisite(), new DAOCompteRendu(HibernateUtil.getSessionFactory().openSession())).Init();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buton = (JButton) e.getSource();
		String name = buton.getName();
		
		switch (name) {
		case "ajouter":
			ajouerProduit();
			break;
		case "valider":
			try {
				valider();
			} catch (HibernateException | SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			break;
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


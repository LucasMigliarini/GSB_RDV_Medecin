


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

import DAO.DAOCategorie;
import DAO.DAOCompteRendu;
import DAO.DAOProduit;
import DAO.DAOVisiteur;

import views.compteRenduVisite;
import views.newCRV;
import model.Categorie;
import model.CompteRenduVisite;
import model.Produit;
import model.Visiteur;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class ControllerNewCRV implements ActionListener{
	
	private newCRV fenetre;
	
	DAOCategorie daoCat;
	DAOProduit daoProd;
	List<Produit> listProd;
	
	String[] columns = {
            "Produits"
        };
	DefaultTableModel modele = new DefaultTableModel(columns, 0);
	
	//Categorie firstcat = daoCat.find(1);

	
	
	
	public ControllerNewCRV(newCRV fenetre, DAOProduit DaoProd, DAOCategorie DaoCat) {
		
		this.fenetre = fenetre;
		this.daoCat = DaoCat;
		this.daoProd = DaoProd;
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
		
		
		listProd= daoProd.findAll();
		System.out.println("ok");
		//model = new MyDefaultModelProduit(listProd);		
		//fenetre.getTable().setModel(model);
	    
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
			List<Produit> produits = (List<Produit>) daoProd.findByCat(cate.getCategorieId());
			fenetre.getComboBox_prod().removeAllItems();
			for (Produit produit : produits) {
				fenetre.getComboBox_prod().addItem(produit.getProduitNom());
			}
		
		
	}
	
	public void valider() {
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buton = (JButton) e.getSource();
		String name = buton.getName();
		
		switch (name) {
		case "ajouter":
			ajouerProduit();
			break;
		default:
			break;
		}		
	}
	
	
	
}


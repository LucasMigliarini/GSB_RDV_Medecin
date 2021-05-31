


import java.awt.event.ActionListener;
import java.awt.image.ConvolveOp;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.security.auth.Refreshable;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
	MyDefaultModelProduit model;
	
	
	public ControllerNewCRV(newCRV fenetre, DAOProduit DaoProd, DAOCategorie DaoCat) {
		
		this.fenetre = fenetre;
		this.daoCat = DaoCat;
		this.daoProd = DaoProd;
		fenetre.getBtnRetour().addActionListener(this);
		fenetre.getBtnValider().addActionListener(this);
					
	}

	public void Init() throws SQLException {
		List<Categorie> med = daoCat.findAll();
		for (Categorie categorie : med) {
			fenetre.getComboBox_cat().addItem(categorie.getCategorieNom());
		}
		listProd= daoProd.findAll();
		System.out.println("ok");
		model = new MyDefaultModelProduit(listProd);
		
		fenetre.getTable().setModel(model);
		
			
		fenetre.setVisible(true);

	}
	
	/*private void update() throws SQLException {
		HashSet<CompteRenduVisite> m = model.getModifiedCRV();
		Iterator<CompteRenduVisite> it = m.iterator();
		while (it.hasNext()) {
			CompteRenduVisite c = it.next();
			System.out.println(c);
			daoCRV.SaveOrUpdate(c);
			
		}
	}
	
	/*private void search() {
		try {
			listCRV = daoCRV.findCitiesWithCountry(fenetre.getTextFieldSearch().getText());
			model = new MyDefaultModelCompteRendu(listCRV);
			fenetre.getTable().setModel(model);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
	
	/*private void delete() throws SQLException {
		int id = fenetre.getTable().getSelectedRow();
		if(id != (-1)) {	
			CompteRenduVisite c = listCRV.get(id);
			listCRV.remove(id);
			daoCRV.delete(c);
			model.fireTableDataChanged();
		}
	}*/
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buton = (JButton) e.getSource();
		String name = buton.getName();
		switch (name) {
		

		default:
			break;
		}
		
		
	}
}


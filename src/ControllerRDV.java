


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

import DAO.DAOCategorie;
import DAO.DAOCompteRendu;
import DAO.DAOCreneaux;
import DAO.DAOMedecin;
import DAO.DAOProduit;
import DAO.DAOVisiteur;
import views.NewRDV;
import views.ViewRDV;
import views.compteRenduVisite;
import views.newCRV;
import model.Categorie;
import model.CompteRenduVisite;
import model.Creneaux;
import model.Medecin;
import model.Produit;
import model.Visiteur;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class ControllerRDV implements ActionListener{
	
	private ViewRDV fenetre;
	
	DAOCreneaux daoCre;
	DAOMedecin daoMed;
	List<Creneaux> listCre;
	MyDefaultModelCreneaux model;
	
	
	
	public ControllerRDV(ViewRDV fenetre, DAOCreneaux daoCre, DAOMedecin daoMed) {
		
		this.fenetre = fenetre;
		this.daoCre = daoCre;
		this.daoMed = daoMed;
		fenetre.getBtnRetour().addActionListener(this);
		fenetre.getBtnValider().addActionListener(this);
					
	}

	public void Init() throws SQLException {
		List<Creneaux> cre = daoCre.FindAllReserver();
		model = new MyDefaultModelCreneaux(cre);
		fenetre.getTable().setModel(model);
			
		fenetre.setVisible(true);

	}
	
	
	
	private void valider () {
        
		int id_row = fenetre.getTable().getSelectedRow();
		
		String info1 = (String) fenetre.getTable().getValueAt(id_row,0);
		String info2 = (String) fenetre.getTable().getValueAt(id_row,1);
		String info3 = (String) fenetre.getTable().getValueAt(id_row,2);
		
		Medecin medNom = daoMed.findByName(info3);
		System.out.println(medNom.getMedecinAdresse());
		Creneaux cre = daoCre.FindByAll(info1, info2, medNom);
		cre.setCreReserver(1);
		daoCre.SaveOrUpdate(cre);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buton = (JButton) e.getSource();
		String name = buton.getName();
		switch (name) {
		case "valider":
			valider();
			break;
		default:
			break;
		}
		
		
	}
}


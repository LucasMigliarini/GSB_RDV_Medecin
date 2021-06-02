


import java.awt.event.ActionListener;
import java.awt.image.ConvolveOp;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.security.auth.Refreshable;
import javax.swing.JButton;
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
import views.compteRenduVisite;
import model.CompteRenduVisite;
import util.HibernateUtil;

import java.awt.Color;
import java.awt.event.ActionEvent;

public class ControllerCRV implements ActionListener{
	
	private compteRenduVisite fenetre;
	private NewRDV newrdv;
	
	DAOCompteRendu daoCRV;
	List<CompteRenduVisite> listCRV;
	MyDefaultModelCompteRendu model;
	
	
	public ControllerCRV(compteRenduVisite fenetre, DAOCompteRendu daocrv) {
		
		this.fenetre = fenetre;
		this.daoCRV = daocrv;
		fenetre.getBtn_delete().addActionListener(this);
		fenetre.getBtn_update().addActionListener(this);
		fenetre.getBtn_creerCRD_2().addActionListener(this);
		fenetre.getBtn_creerCRD_1().addActionListener(this);
		fenetre.getbtn_creerVoirRDV().addActionListener(this);
					
	}

	public void Init() throws SQLException {
		listCRV = daoCRV.findAll();
		System.out.println(listCRV);
		model = new MyDefaultModelCompteRendu(listCRV);
		fenetre.getTable().setModel(model);
		fenetre.setVisible(true);

	}
	
	private void update() throws SQLException {
		HashSet<CompteRenduVisite> m = model.getModifiedCRV();
		Iterator<CompteRenduVisite> it = m.iterator();
		while (it.hasNext()) {
			CompteRenduVisite c = it.next();
			System.out.println(c);
			daoCRV.SaveOrUpdate(c);
			
		}
	}
	
	
	private void delete() throws SQLException {
		int id = fenetre.getTable().getSelectedRow();
		if(id != (-1)) {	
			CompteRenduVisite c = listCRV.get(id);
			listCRV.remove(id);
			daoCRV.delete(c);
			model.fireTableDataChanged();
		}
	}
	
	private void takerdv() throws HibernateException, SQLException {
		fenetre.setVisible(false);
		new ControllerRDV(new ViewRDV(), new DAOCreneaux(HibernateUtil.getSessionFactory().openSession()), new DAOMedecin(HibernateUtil.getSessionFactory().openSession()),new DAOVisiteur(HibernateUtil.getSessionFactory().openSession())).Init();
	}
	
	private void newCRV() throws HibernateException, SQLException {
		fenetre.setVisible(false);
		new ControllerNewCRV(new views.newCRV(), new DAOProduit(HibernateUtil.getSessionFactory().openSession()), new DAOCategorie(HibernateUtil.getSessionFactory().openSession())).Init();
	}
	
	private void voirRDv() throws HibernateException, SQLException {
		fenetre.setVisible(false);
		new ControllerAllRDV2(new allRDV(), new DAOCreneaux(HibernateUtil.getSessionFactory().openSession()), new DAOVisiteur(HibernateUtil.getSessionFactory().openSession())).Init();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buton = (JButton) e.getSource();
		String name = buton.getName();
		switch (name) {
		case "update":
			try {
				update();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "delete":
			try {
				delete();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case"takerdv":
			try {
				takerdv();
			} catch (HibernateException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "newCRV":
			try {
				newCRV();
			} catch (HibernateException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case"voirRDV":
			try {
				voirRDv();
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


package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.HibernateUtil;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


import org.hibernate.Criteria;
import org.hibernate.Query;

import model.CompteRenduVisite;
import model.Creneaux;
import model.Medecin;
import model.Visiteur;

public class DAOCreneaux extends DAOGeneric<Creneaux>{

	public DAOCreneaux(Session session) {
		super(session, Creneaux.class);
		// TODO Auto-generated constructor stub
	}
	
	public List<Creneaux> FindAllReserver() {
	
		String SQL= "SELECT * FROM CRENEAUX WHERE CreReserver=0";
		SQLQuery query2 = session.createSQLQuery(SQL);
		query2.addEntity(entityClass);
		List<Creneaux> cre = query2.list();
		return cre;
	}
	
public Creneaux FindByAll(String date, String heure, Medecin medecin) {
	
		int idMed = medecin.getMedecinId();
			
		String SQL= "SELECT * FROM CRENEAUX WHERE CreDate=:date AND CreHeure=:heure AND CreMedecin=:idMed";
		SQLQuery query2 = session.createSQLQuery(SQL);
		query2.setString("date",date);
		query2.setString("heure",heure);
		query2.setInteger("idMed",idMed);
		query2.addEntity(entityClass);
		Creneaux cre = (Creneaux) query2.uniqueResult();
		return cre;
	}
	

	
	
	
}

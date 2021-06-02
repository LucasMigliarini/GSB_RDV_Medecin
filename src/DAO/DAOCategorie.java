package DAO;

import java.util.List;

import util.HibernateUtil;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.Query;

import model.Categorie;
import model.Medecin;
import model.Visiteur;

public class DAOCategorie extends DAOGeneric<Categorie>{

	public DAOCategorie(Session session) {
		super(session, Categorie.class);
		// TODO Auto-generated constructor stub
	}
	public Categorie findByName (String name) {	
		String SQL = "SELECT * FROM CATEGORIE WHERE CategorieNom=:name";
		SQLQuery query = session.createSQLQuery(SQL);
		query.setString("name",name);
		query.addEntity(entityClass);
		Categorie cat = (Categorie) query.uniqueResult();
		return cat;
	}
	
	
}

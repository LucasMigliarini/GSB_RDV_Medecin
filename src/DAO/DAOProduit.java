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

import model.Produit;
import model.Visiteur;

public class DAOProduit extends DAOGeneric<Produit>{

	public DAOProduit(Session session) {
		super(session, Produit.class);
		// TODO Auto-generated constructor stub
	}

	public List<Produit> findByCat (int i) {	
		String SQL = "SELECT * FROM PRODUIT WHERE ProduitCategorie =:cat";
		SQLQuery query = session.createSQLQuery(SQL);
		query.setInteger("cat",i);
		query.addEntity(entityClass);
		List<Produit> produit = (List<Produit>) query.list();
		return produit;
	}
	

	
	
}

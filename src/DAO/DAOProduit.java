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


	
	
}

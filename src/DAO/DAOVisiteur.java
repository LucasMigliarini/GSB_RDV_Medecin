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

import model.Visiteur;

public class DAOVisiteur extends DAOGeneric<Visiteur>{

	public DAOVisiteur(Session session) {
		super(session, Visiteur.class);
		// TODO Auto-generated constructor stub
	}

	
	public Visiteur verifEmail(String mail) {
		String SQL = "SELECT * FROM VISITEUR WHERE VisiteurMail=:mail";
		SQLQuery query = session.createSQLQuery(SQL);
		query.setString("mail",mail);
		query.addEntity(entityClass);
		Visiteur email = (Visiteur) query.uniqueResult();
		return email;
	}
	
	
}

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

import model.Medecin;
import model.Visiteur;

public class DAOMedecin extends DAOGeneric<Medecin>{

	public DAOMedecin(Session session) {
		super(session, Medecin.class);
		// TODO Auto-generated constructor stub
	}
	
	public Medecin findByName (String name) {	
		String SQL = "SELECT * FROM MEDECIN WHERE MedecinNom=:name";
		SQLQuery query = session.createSQLQuery(SQL);
		query.setString("name",name);
		query.addEntity(entityClass);
		Medecin med = (Medecin) query.uniqueResult();
		return med;
	}

	
	
}

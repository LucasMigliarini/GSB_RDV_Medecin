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
import model.Visiteur;

public class DAORendezVous extends DAOGeneric<CompteRenduVisite>{

	public DAORendezVous(Session session) {
		super(session, CompteRenduVisite.class);
		// TODO Auto-generated constructor stub
	}
	
	

	
	
	
}

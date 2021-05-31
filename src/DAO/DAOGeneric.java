package DAO;

import java.util.List;

import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.mapping.PersistentClass;

import util.HibernateUtil;

public abstract class DAOGeneric<T> {

	protected Session session;
	protected Class<T> entityClass;
	
	public DAOGeneric(Session session, Class<T> entityClass) {
		this.session = session;
		this.entityClass = entityClass;
	}
		
	public T find(int id) {
		
		T Value = (T) session.get(this.entityClass, id);
		return Value;
	}
	
	public void SaveOrUpdate(T entity) {
		
		session.getTransaction().begin();
		session.saveOrUpdate(entity);
		session.getTransaction().commit();
	} 
	
	public void delete(T entity) {
		
		session.getTransaction().begin();
		session.delete(entity);
		session.getTransaction().commit();
	} 
	
	public List<T> findAll() {
		
		List<T> list =  session.createQuery("FROM " + entityClass.getName()).list();
		return list;

	}
	
	public Long count() {
		
		return (Long) session.createCriteria(entityClass).setProjection(Projections.rowCount()).uniqueResult();
	}
	
}

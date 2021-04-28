package com.educomser.dao;

import com.educomser.entity.Persona;
import com.educomser.util.HibernateUtil;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonaDao {

	private Session session; // Mantiene la referencia de la sesión a la BD
	private Transaction tx; // Mantiene la referencia a la transacción

	// Inicia una sesión y una transacción a la base de datos
	private void openSession() {
		this.session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	public void save(Persona persona) {
		try {
			openSession();
			session.save(persona);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
	}

	public void update(Persona persona) {
		try {
			openSession();
			session.update(persona);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
	}

	public void delete(Persona persona) {
		try {
			openSession();
			session.delete(persona);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
	}

	public Persona findById(int id) {
		Persona persona = null;
		try {
			openSession();
			persona = (Persona) session.get(Persona.class, id);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
		return persona;

	}

	public List<Persona> findAll() {
		List<Persona> list = null;
		try {
			openSession();
			list = session.createQuery("from Persona", Persona.class).list();
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
		return list;
	}
}

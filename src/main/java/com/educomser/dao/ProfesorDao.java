package com.educomser.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.educomser.entity.Profesor;
import com.educomser.util.HibernateUtil;

public class ProfesorDao {

	private Session session; // Mantiene la referencia de la sesión a la BD
	private Transaction tx; // Mantiene la referencia a la transacción

	// Inicia una sesión y una transacción a la base de datos
	private void startOperation() {
		this.session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	public void save(Profesor Profesor) {
		try {
			startOperation();
			session.save(Profesor);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(ProfesorDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
	}

	public void update(Profesor Profesor) {
		try {
			startOperation();
			session.update(Profesor);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(ProfesorDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
	}

	public void delete(Profesor Profesor) {
		try {
			startOperation();
			session.delete(Profesor);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(ProfesorDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
	}

	public Profesor findById(int id) {
		Profesor Profesor = null;
		try {
			startOperation();
			Profesor = (Profesor) session.get(Profesor.class, id);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(ProfesorDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
		return Profesor;

	}

	public List<Profesor> findAll() {
		List<Profesor> list = null;
		try {
			startOperation();
			list = session.createQuery("from Profesor", Profesor.class).list();
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(ProfesorDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
		return list;
	}
}

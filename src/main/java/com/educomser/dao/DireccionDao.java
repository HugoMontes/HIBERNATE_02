package com.educomser.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.educomser.entity.Direccion;
import com.educomser.util.HibernateUtil;

public class DireccionDao {


	private Session session; // Mantiene la referencia de la sesión a la BD
	private Transaction tx; // Mantiene la referencia a la transacción

	// Inicia una sesión y una transacción a la base de datos
	private void startOperation() {
		this.session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	public void save(Direccion Direccion) {
		try {
			startOperation();
			session.save(Direccion);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(DireccionDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
	}

	public void update(Direccion direccion) {
		try {
			startOperation();
			session.update(direccion);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(DireccionDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
	}

	public void delete(Direccion direccion) {
		try {
			startOperation();
			session.delete(direccion);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(DireccionDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
	}

	public Direccion findById(int id) {
		Direccion direccion = null;
		try {
			startOperation();
			direccion = (Direccion) session.get(Direccion.class, id);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(DireccionDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
		return direccion;

	}

	public List<Direccion> findAll() {
		List<Direccion> list = null;
		try {
			startOperation();
			list = session.createQuery("from Direccion", Direccion.class).list();
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(DireccionDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
		return list;
	}
	
}

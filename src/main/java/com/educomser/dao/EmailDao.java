package com.educomser.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.educomser.entity.Email;
import com.educomser.util.HibernateUtil;

public class EmailDao {

	private Session session; // Mantiene la referencia de la sesión a la BD
	private Transaction tx; // Mantiene la referencia a la transacción

	// Inicia una sesión y una transacción a la base de datos
	private void startOperation() {
		this.session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	public void save(Email email) {
		try {
			startOperation();
			session.save(email);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(EmailDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
	}

	public void update(Email email) {
		try {
			startOperation();
			session.update(email);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(EmailDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
	}

	public void delete(Email email) {
		try {
			startOperation();
			session.delete(email);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(EmailDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
	}

	public Email findById(int id) {
		Email email = null;
		try {
			startOperation();
			email = (Email) session.get(Email.class, id);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(EmailDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
		return email;

	}

	public List<Email> findAll() {
		List<Email> list = null;
		try {
			startOperation();
			list = session.createQuery("from Email", Email.class).list();
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(EmailDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
		return list;
	}
}

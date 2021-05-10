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

	private Session session;
	private Transaction tx;

	private void startOperation() {
		this.session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	public void save(Profesor profesor) {
		try {
			startOperation();
			session.save(profesor);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(ProfesorDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
	}

	public void update(Profesor profesor) {
		try {
			startOperation();
			session.update(profesor);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(ProfesorDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
	}

	public void delete(Profesor profesor) {
		try {
			startOperation();
			session.delete(profesor);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(ProfesorDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
	}

	public Profesor findById(int id) {
		Profesor profesor = null;
		try {
			startOperation();
			profesor = (Profesor) session.get(Profesor.class, id);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(ProfesorDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
		return profesor;

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

	public Profesor getProfesorAndCursosById(int id) {
		Profesor profesor = null;
		try {
			startOperation();
			;
			String query = "SELECT p FROM Profesor AS p LEFT JOIN FETCH p.cursos WHERE p.id=:param1";
			profesor = (Profesor) session.createQuery(query).setParameter("param1", id).uniqueResult();
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(ProfesorDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
		return profesor;
	}

	public List<Profesor> getAllProfesoresAndCursos() {
		List<Profesor> list = null;
		try {
			startOperation();
			String query = "SELECT DISTINCT p FROM Profesor p LEFT JOIN FETCH p.cursos c ORDER BY p.id";
			list = session.createQuery(query, Profesor.class).getResultList();
		} catch (HibernateException ex) {
			Logger.getLogger(ProfesorDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
		return list;
	}
}

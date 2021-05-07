package com.educomser.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.educomser.entity.Curso;
import com.educomser.util.HibernateUtil;

public class CursoDao {

	private Session session;
	private Transaction tx;

	private void startOperation() {
		this.session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	public void save(Curso curso) {
		try {
			startOperation();
			session.save(curso);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(CursoDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
	}

	public void update(Curso curso) {
		try {
			startOperation();
			session.update(curso);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(CursoDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
	}

	public void delete(Curso curso) {
		try {
			startOperation();
			session.delete(curso);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(CursoDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
	}

	public Curso findById(int id) {
		Curso curso = null;
		try {
			startOperation();
			curso = (Curso) session.get(Curso.class, id);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(CursoDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
		return curso;

	}

	public List<Curso> findAll() {
		List<Curso> list = null;
		try {
			startOperation();
			list = session.createQuery("from Curso", Curso.class).list();
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			Logger.getLogger(CursoDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			session.close();
		}
		return list;
	}
}

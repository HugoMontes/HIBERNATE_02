package com.educomser.demo;

import com.educomser.dao.CursoDao;
import com.educomser.entity.Curso;
import com.educomser.entity.Profesor;
import com.educomser.util.HibernateUtil;

public class MuchosMuchos02 {

	public static void main(String[] args) {
		// Instanciar tres profesores
		Profesor prof1 = new Profesor("Alex");
		Profesor prof2 = new Profesor("Dilan");
		Profesor prof3 = new Profesor("Sarah");
		// Instanciar tres cursos
		Curso cur1 = new Curso("POSTGRESQL");
		Curso cur2 = new Curso("ORACLE");
		Curso cur3 = new Curso("MYSQL");
		// Asignar cursos a profesores
		prof1.getCursos().add(cur3);
		prof2.getCursos().add(cur2);
		prof3.getCursos().add(cur1);
		// Asignar profesores a cursos
		cur1.getProfesores().add(prof3);
		cur2.getProfesores().add(prof2);
		cur3.getProfesores().add(prof1);
		// Guardar cursos y profesores
		CursoDao curDao = new CursoDao();
		curDao.save(cur1);
		curDao.save(cur2);
		curDao.save(cur3);
		// Cerrar session factory
		HibernateUtil.closeSessionFactory();
	}
}

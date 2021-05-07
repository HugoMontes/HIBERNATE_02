package com.educomser.demo;

import com.educomser.dao.ProfesorDao;
import com.educomser.entity.Curso;
import com.educomser.entity.Profesor;
import com.educomser.util.HibernateUtil;

public class MuchosMuchos01 {

	public static void main(String[] args) {
		// Instanciar tres profesores
		Profesor prof1 = new Profesor("Juan");
		Profesor prof2 = new Profesor("Ana");
		Profesor prof3 = new Profesor("Lucas");
		// Instanciar tres cursos
		Curso cur1 = new Curso("JAVA");
		Curso cur2 = new Curso("PHP");
		Curso cur3 = new Curso("PYTHON");
		// Asignar cursos a profesores
		prof1.getCursos().add(cur1);
		prof1.getCursos().add(cur2);
		prof2.getCursos().add(cur3);
		// Guardar profesor y cursos
		ProfesorDao profDao = new ProfesorDao();
		profDao.save(prof1);
		profDao.save(prof2);
		profDao.save(prof3);
		// Cerrar session factory
		HibernateUtil.closeSessionFactory();
	}
}

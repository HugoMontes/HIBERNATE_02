package com.educomser.demo;

import java.util.List;

import com.educomser.dao.CursoDao;
import com.educomser.entity.Curso;
import com.educomser.entity.Profesor;
import com.educomser.util.HibernateUtil;

public class MuchosMuchos08 {

	public static void main(String[] args) {
		CursoDao curDao = new CursoDao();
		List<Curso> curList = curDao.getAllCursosAndProfesores();
		System.out.println("LISTA DE CURSOS");
		for (Curso cur : curList) {
			System.out.println("ID: " + cur.getId());
			System.out.println("Curso: " + cur.getNombreCurso());
			System.out.println("Profesores: ");
			for (Profesor prof : cur.getProfesores()) {
				System.out.println("- " + prof.getNombreProfesor());
			}
			System.out.println("-------------------------------------");
		}
		HibernateUtil.closeSessionFactory();
	}
}

package com.educomser.demo;

import java.util.Scanner;

import com.educomser.dao.CursoDao;
import com.educomser.entity.Curso;
import com.educomser.entity.Profesor;
import com.educomser.util.HibernateUtil;

public class MuchosMuchos06 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		CursoDao curDao = new CursoDao();
		System.out.println("-- BUSCAR CURSO");
		System.out.print("Ingrese el id de un curso:");
		// Curso cur = curDao.findById(in.nextInt());
		Curso cur = curDao.getCursoAndProfesoresById(in.nextInt());
		System.out.println("-- DATOS CURSO");
		System.out.println("ID: " + cur.getId());
		System.out.println("Curso: " + cur.getNombreCurso());
		System.out.println("Profesores: ");
		for (Profesor prof : cur.getProfesores()) {
			System.out.println("- " + prof.getNombreProfesor());
		}
		HibernateUtil.closeSessionFactory();
	}
}

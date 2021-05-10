package com.educomser.demo;

import java.util.Scanner;

import com.educomser.dao.ProfesorDao;
import com.educomser.entity.Curso;
import com.educomser.entity.Profesor;
import com.educomser.util.HibernateUtil;

public class MuchosMuchos05 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ProfesorDao profDao = new ProfesorDao();
		System.out.println("-- BUSCAR PROFESOR");
		System.out.print("Ingrese el id de un profesor:");
		// Profesor prof = profDao.findById(in.nextInt());
		Profesor prof = profDao.getProfesorAndCursosById(in.nextInt());
		System.out.println("-- DATOS PROFESOR");
		System.out.println("ID: " + prof.getId());
		System.out.println("Nombre: " + prof.getNombreProfesor());
		System.out.println("Cursos: ");
		for (Curso cur : prof.getCursos()) {
			System.out.println("- " + cur.getNombreCurso());
		}
		HibernateUtil.closeSessionFactory();
	}
}

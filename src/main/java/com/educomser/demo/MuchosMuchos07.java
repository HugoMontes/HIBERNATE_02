package com.educomser.demo;

import java.util.List;

import com.educomser.dao.ProfesorDao;
import com.educomser.entity.Curso;
import com.educomser.entity.Profesor;

public class MuchosMuchos07 {

	public static void main(String[] args) {
		ProfesorDao profDao = new ProfesorDao();
		List<Profesor> profList = profDao.getAllProfesoresAndCursos();
		System.out.println("LISTA DE PROFESORES");
		for (Profesor prof : profList) {
			System.out.println("ID: " + prof.getId());
			System.out.println("NOMBRE: " + prof.getNombreProfesor());
			System.out.println("CURSOS: ");
			for (Curso cur : prof.getCursos()) {
				System.out.println("- " + cur.getNombreCurso());
			}
			System.out.println("-------------------------------------");
		}
	}
}

package com.educomser.demo;

import java.util.Scanner;

import com.educomser.dao.CursoDao;
import com.educomser.dao.ProfesorDao;
import com.educomser.entity.Curso;
import com.educomser.entity.Profesor;
import com.educomser.util.HibernateUtil;

public class MuchosMuchos10 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ProfesorDao profDao = new ProfesorDao();
		CursoDao curDao = new CursoDao();
		System.out.println("-- ASIGNAR PROFESOR A CURSO"); 
		System.out.print("Ingrese el id de un curso:"); 
		Curso cur = curDao.getCursoAndProfesoresById(in.nextInt()); 
		System.out.print("Ingrese el id de un profesor asignado a " + cur.getNombreCurso() + " :");
		Profesor prof = profDao.getProfesorAndCursosById(in.nextInt());
		cur.getProfesores().add(prof);
		prof.getCursos().add(cur);
		curDao.update(cur);
		System.out.println("Los cambios se ejecutaron");
		HibernateUtil.closeSessionFactory();
	}
}

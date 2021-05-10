package com.educomser.demo;

import java.util.Scanner;

import com.educomser.dao.CursoDao;
import com.educomser.dao.ProfesorDao;
import com.educomser.entity.Curso;
import com.educomser.entity.Profesor;
import com.educomser.util.HibernateUtil;

public class MuchosMuchos09 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ProfesorDao profDao = new ProfesorDao();
		CursoDao curDao = new CursoDao();
		System.out.println("-- ASIGNAR CURSO A PROFESOR"); 
		System.out.print("Ingrese el id de un profesor:"); 
		// Profesor prof = profDao.findById(in.nextInt()); 
		Profesor prof = profDao.getProfesorAndCursosById(in.nextInt()); 
		System.out.print("Ingrese el id de un curso que dictara " + prof.getNombreProfesor() + " :");
		Curso cur = curDao.findById(in.nextInt());
		// Settear curso a profesor 
		prof.getCursos().add(cur);
		// Guardar cambios
		profDao.update(prof);
		System.out.println("Los cambios se ejecutaron");
		HibernateUtil.closeSessionFactory();
	}
}

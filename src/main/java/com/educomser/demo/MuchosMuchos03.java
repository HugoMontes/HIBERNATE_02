package com.educomser.demo;

import java.util.Scanner;

import com.educomser.dao.ProfesorDao;
import com.educomser.entity.Profesor;
import com.educomser.util.HibernateUtil;

public class MuchosMuchos03 {

	public static void main(String[] args) {
		ProfesorDao profDao = new ProfesorDao();
		Scanner in = new Scanner(System.in);
		Profesor prof = new Profesor();
		System.out.println("-- NUEVO PROFESOR");
		System.out.println("Ingrese nombre: ");
		prof.setNombreProfesor(in.next());
		System.out.println("Guardando...");
		profDao.save(prof);
		System.out.println("Los datos se han guardado correctamente.");
		HibernateUtil.closeSessionFactory();
	}
}

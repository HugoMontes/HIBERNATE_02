package com.educomser.demo;

import java.util.Scanner;

import com.educomser.dao.ProfesorDao;
import com.educomser.entity.Email;
import com.educomser.entity.Profesor;
import com.educomser.util.HibernateUtil;

public class UnoMuchos05Demo {

	public static void main(String[] args) {
		// BUSCAR UN PROFESOR Y SUS CORREOS
		ProfesorDao profDao = new ProfesorDao();
		System.out.println("Ingrese el id del profesor:");
		Scanner in = new Scanner(System.in);
		int id = in.nextInt();
		// Profesor prof = profDao.findById(id);
		Profesor prof = profDao.getProfesorAndCorreosById(id);
		System.out.println("-- DATOS PROFESOR ");
		System.out.println("Id: " + prof.getId());
		System.out.println("Nombre: " + prof.getNombre());
		System.out.println("Correos: ");
		for(Email email : prof.getEmails()) {
			System.out.println("- "+email.getCorreo());
		}
		// CERRAR SESSION FACTORY
		HibernateUtil.closeSessionFactory();
	}
}

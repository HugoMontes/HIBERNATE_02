package com.educomser.demo;

import java.util.Scanner;

import com.educomser.dao.EmailDao;
import com.educomser.entity.Email;
import com.educomser.util.HibernateUtil;

public class UnoMuchos04Demo {
	public static void main(String[] args) {
		// BUSCAR UN CORREO ELECTRONICO
		EmailDao emailDao = new EmailDao();
		System.out.println("Ingrese el id del correo:");
		Scanner in = new Scanner(System.in);
		int id = in.nextInt();
		Email email = emailDao.findById(id);
		System.out.println("-- DATOS CORREO ");
		System.out.println("Id: "+email.getId());
		System.out.println("Correo: "+email.getCorreo());
		System.out.println("Profesor: "+email.getProfesor());
		// CERRAR SESSION FACTORY
		HibernateUtil.closeSessionFactory();
	}
}

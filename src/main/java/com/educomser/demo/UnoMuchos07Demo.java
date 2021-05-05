package com.educomser.demo;

import java.util.List;

import com.educomser.dao.ProfesorDao;
import com.educomser.entity.Email;
import com.educomser.entity.Profesor;
import com.educomser.util.HibernateUtil;

public class UnoMuchos07Demo {

	public static void main(String[] args) {
		ProfesorDao profDao = new ProfesorDao();
		// List<Profesor> profList = profDao.findAll();
		List<Profesor> profList = profDao.getAllProfesoresAndCorreos();
		System.out.println("LISTA DE PROFESORES Y CORREOS");
		for (Profesor prof : profList) {
			System.out.println("ID: " + prof.getId());
			System.out.println("NOMBRE: " + prof.getNombre());
			System.out.println("CORREOS:");
			for (Email email : prof.getEmails()) {
				System.out.println("-" + email.getCorreo());
			}
			System.out.println("----------------------");
		}
		HibernateUtil.closeSessionFactory();
	}
}

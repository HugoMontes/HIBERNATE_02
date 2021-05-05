package com.educomser.demo;

import com.educomser.dao.EmailDao;
import com.educomser.entity.Email;
import com.educomser.util.HibernateUtil;

public class UnoMuchos06Demo {

	public static void main(String[] args) {
		EmailDao emailDao = new EmailDao();
		System.out.println("LISTA DE CORREOS Y PROFESORES");
		System.out.println("ID\tDESCRIPCION\tPROFESOR");
		for (Email email : emailDao.findAll()) {
			System.out.println(email.getId() + "\t" 
							+ email.getCorreo() + "\t" 
							+ email.getProfesor().getNombre());
		}
		HibernateUtil.closeSessionFactory();
	}
}

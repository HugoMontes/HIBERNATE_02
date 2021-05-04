package com.educomser.demo;

import com.educomser.dao.ProfesorDao;
import com.educomser.entity.Email;
import com.educomser.entity.Profesor;
import com.educomser.util.HibernateUtil;

public class UnoMuchos01Demo {

	public static void main(String[] args) {
		// GUARDAR PROFESOR 1 CON SUS CORREOS
		Profesor prof1 = new Profesor("Juan", 5600);
		Email e1 = new Email("juan@gmail.com", prof1);
		Email e2 = new Email("juan@hotmail.com", prof1);
		Email e3 = new Email("juan@yahoo.com", prof1);
		prof1.getEmails().add(e1);
		prof1.getEmails().add(e2);
		prof1.getEmails().add(e3);
		ProfesorDao profDao = new ProfesorDao();
		profDao.save(prof1);
		// GUARDAR PROFESOR 2 CON SUS CORREOS
		Profesor prof2 = new Profesor("Ana", 4200);
		Email e4 = new Email("ana@gmail.com", prof2);
		Email e5 = new Email("ana@hotmail.com", prof2);
		Email e6 = new Email("ana@yahoo.com", prof2);
		prof2.getEmails().add(e4);
		prof2.getEmails().add(e5);
		prof2.getEmails().add(e6);
		profDao.save(prof2);
		// CERRAR SESSION FACTORY
		HibernateUtil.closeSessionFactory();
	}
}

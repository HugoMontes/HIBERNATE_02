package com.educomser.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.educomser.dao.PersonaDao;
import com.educomser.entity.Persona;
import com.educomser.util.HibernateUtil;

public class PersonaGuardarDemo {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		
		// INSTANCIAR OBJETOS PERSONAS
		Persona per1 = new Persona(); 
		per1.setNombre("Ramiro");
		per1.setSalario(5000);
		per1.setSeguro(true);
		per1.setFechaNacimiento(format.parse("31/03/1995"));
		
		Persona per2 = new Persona();
		per2.setNombre("Maria");
		per2.setSalario(2000);
		per2.setSeguro(false);
		per2.setFechaNacimiento(format.parse("20/07/1990"));
		
		// INSTANCIAR OBJETO DAO
		PersonaDao eDao = new PersonaDao();
		eDao.save(per1);
		eDao.save(per2);

		// CERRAR SESION 
		HibernateUtil.closeSessionFactory();
	}
}

package com.educomser.demo;

import com.educomser.dao.PersonaDao;
import com.educomser.entity.Persona;
import com.educomser.util.HibernateUtil;

public class PersonaListarDemo {

	public static void main(String[] args) {
		// INSTANCIAR OBJETO DAO
		PersonaDao perDao = new PersonaDao();
		// RECUPERAR REGISTROS
		System.out.println("LISTA DE PersonaS");
		for (Persona e : perDao.findAll()) {
			System.out.println(e.getIdPersona() + "-" + e.getNombre());
		}
		// CERRAR SESION
		HibernateUtil.closeSessionFactory();
	}

}

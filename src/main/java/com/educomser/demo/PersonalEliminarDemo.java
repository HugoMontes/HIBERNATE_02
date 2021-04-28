package com.educomser.demo;

import java.util.Scanner;

import com.educomser.dao.PersonaDao;
import com.educomser.entity.Persona;
import com.educomser.util.HibernateUtil;

public class PersonalEliminarDemo {

	public static void main(String[] args) {
		// INSTANCIAR OBJETO DAO
		PersonaDao perDao = new PersonaDao();
		// ELIMINAR UN REGISTRO
		Scanner in = new Scanner(System.in);
		System.out.print("Ingrese id de Persona a eliminar:");
		int id = in.nextInt();
		Persona per = perDao.findById(id);
		if (per != null) {
			perDao.delete(per);
			System.out.println("El Persona fue eliminado...");
		} else {
			System.out.println("El Persona no existe...");
		}
		// CERRAR LA SESION DE LA FACTORIA
		HibernateUtil.closeSessionFactory();
	}
}

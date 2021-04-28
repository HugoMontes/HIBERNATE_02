package com.educomser.demo;

import java.util.Scanner;

import com.educomser.dao.PersonaDao;
import com.educomser.entity.Persona;
import com.educomser.util.HibernateUtil;

public class PersonaEditarDemo {

	public static void main(String[] args) {
		// INSTANCIAR OBJETO DAO
		PersonaDao eDao = new PersonaDao();
		// BUSCAR UN REGISTRO
		System.out.println("DETALLE Persona");
		System.out.print("Buscar por id: ");
		Scanner in = new Scanner(System.in);
		int id = in.nextInt();
		Persona emp = eDao.findById(id);
		if (emp != null) {
			// MOSTRAR DATOS DE LA BUSQUEDA
			System.out.println("ID: " + emp.getIdPersona());
			System.out.println("Nombre: " + emp.getNombre());
			// EDITAR UN REGISTRO
			if (emp != null) {
				System.out.print("Ingrese un nuevo Nombre: ");
				emp.setNombre(in.next());
				eDao.update(emp);
				System.out.println("El registro fue modificado...");
			}
		} else {
			System.out.println("La persona no existe...");
		}
		// CERRAR LA SESION DE LA FACTORIA
		HibernateUtil.closeSessionFactory();
	}
}

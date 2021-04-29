package com.educomser.demo;

import com.educomser.dao.ProfesorDao;
import com.educomser.entity.Direccion;
import com.educomser.entity.Profesor;
import com.educomser.util.HibernateUtil;

public class UnoUnoUniGuardarDemo {

	public static void main(String[] args) {
		// INSTANCIAR OBJETOS PROFESOR Y SUS DIRECCIONES
		Direccion dir1 = new Direccion(1, "Calle 1", "Zona A", 111);
		Profesor prof1 = new Profesor(1, "Juan", 6000, dir1);
		
		Direccion dir2 = new Direccion(2, "Calle 2", "Zona B", 222);
		Profesor prof2 = new Profesor(2, "Ana", 4000, dir2);
		
		// PERSISTIR LOS OBJETOS PROFESOR
		ProfesorDao profDao = new ProfesorDao();
		profDao.save(prof1);
		profDao.save(prof2);
		
		// CERRAR SESSION FACTORY
		HibernateUtil.closeSessionFactory();
	}
}

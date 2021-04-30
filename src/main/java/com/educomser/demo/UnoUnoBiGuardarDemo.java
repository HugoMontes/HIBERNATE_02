package com.educomser.demo;

import com.educomser.dao.DireccionDao;
import com.educomser.dao.ProfesorDao;
import com.educomser.entity.Direccion;
import com.educomser.entity.Profesor;
import com.educomser.util.HibernateUtil;

public class UnoUnoBiGuardarDemo {

	public static void main(String[] args) {
		// INSTANCIAR OBJETOS PROFESOR Y SUS DIRECCIONES
		Direccion dir1 = new Direccion(1, "Calle 1", "Zona A", 111);
		Profesor prof1 = new Profesor(1, "Juan", 6000);

		Direccion dir2 = new Direccion(2, "Calle 2", "Zona B", 222);
		Profesor prof2 = new Profesor(2, "Ana", 4000);

		// PERSISTIR LOS OBJETOS CON PROFESORDAO
		prof1.setDireccion(dir1);
		ProfesorDao profDao = new ProfesorDao();
		profDao.save(prof1);
		
		// PERSISTIR LOS OBJETOS CON DIRECCIONDAO
		dir2.setProfesor(prof2);
		DireccionDao dirDao = new DireccionDao();
		dirDao.save(dir2);

		// CERRAR SESSION FACTORY
		HibernateUtil.closeSessionFactory();
	}
}

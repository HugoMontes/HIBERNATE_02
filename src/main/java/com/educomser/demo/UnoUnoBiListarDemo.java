package com.educomser.demo;

import com.educomser.dao.DireccionDao;
import com.educomser.dao.ProfesorDao;
import com.educomser.entity.Direccion;
import com.educomser.entity.Profesor;

public class UnoUnoBiListarDemo {

	public static void main(String[] args) {
		// RECUPERAR EL LISTADO DE PROFESORES
		System.out.println("LISTA DE PROFESORES");
		ProfesorDao profDao = new ProfesorDao();
		System.out.println("ID\tNOMBRE\tCALLE");
		for (Profesor p : profDao.findAll()) {
			System.out.println(p.getId() + "\t" + p.getNombre() + "\t" + p.getDireccion().getCalle());
		}
		// RECUPERAR EL LISTADO DE DIRECCIONES
		System.out.println("LISTA DE DIRECCIONES");
		DireccionDao dirDao = new DireccionDao();
		System.out.println("ID\tZONA\tPROFESOR");
		for (Direccion d : dirDao.findAll()) {
			System.out.println(d.getId() + "\t" + d.getZona() + "\t" + d.getProfesor().getNombre());
		}
	}
}

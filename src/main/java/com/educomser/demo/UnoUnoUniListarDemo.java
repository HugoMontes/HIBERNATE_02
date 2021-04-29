package com.educomser.demo;

import com.educomser.dao.ProfesorDao;
import com.educomser.entity.Profesor;

public class UnoUnoUniListarDemo {

	public static void main(String[] args) {
		ProfesorDao profDao = new ProfesorDao();
		System.out.println("LISTA DE PROFESORES");
		System.out.println("ID\tNOMBRE\tCALLE");
		for (Profesor p : profDao.findAll()) {
			System.out.println(p.getId() + "\t" + p.getNombre() + "\t" + p.getDireccion().getCalle());
		}
	}
}

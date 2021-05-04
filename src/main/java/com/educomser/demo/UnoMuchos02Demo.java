package com.educomser.demo;

import java.util.Scanner;

import com.educomser.dao.ProfesorDao;
import com.educomser.entity.Profesor;
import com.educomser.util.HibernateUtil;

public class UnoMuchos02Demo {
	public static void main(String[] args) {
		// ADICIONAR UN PROFESOR 
		ProfesorDao profDao=new ProfesorDao(); 
		Scanner in = new Scanner(System.in); 
		Profesor p = new Profesor(); 
		System.out.println("-- NUEVO PROFESOR --");
		System.out.println("Ingrese nombre: ");
		p.setNombre(in.next());
		System.out.println("Ingrese sueldo: ");
		p.setSueldo(in.nextFloat());
		profDao.save(p);
		System.out.println("El profesor se ha guardado."); 
		// CERRAR SESSION FACTORY
		HibernateUtil.closeSessionFactory();
	}
}

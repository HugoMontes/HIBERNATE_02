package com.educomser.demo;

import java.util.Scanner;

import com.educomser.dao.ProfesorDao;
import com.educomser.entity.Profesor;
import com.educomser.util.HibernateUtil;

public class UnoUnoUniEliminarDemo {

	public static void main(String[] args) {
		ProfesorDao profDao = new ProfesorDao();
		System.out.print("Ingrese ID de profesor a eliminar:");
		Scanner t = new Scanner(System.in);
		Profesor p = profDao.findById(t.nextInt());
		profDao.delete(p);
		System.out.println("El profesor fue eliminado...");
		HibernateUtil.closeSessionFactory();
	}	
}

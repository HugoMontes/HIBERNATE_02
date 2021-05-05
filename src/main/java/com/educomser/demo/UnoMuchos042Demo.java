package com.educomser.demo;

import java.util.Scanner;

import com.educomser.dao.ProfesorDao;
import com.educomser.entity.Profesor;
import com.educomser.util.HibernateUtil;

public class UnoMuchos042Demo {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ProfesorDao profDao = new ProfesorDao();
		System.out.print("Seleccione el id de un profesor a eliminar: ");
		int id = in.nextInt();
		Profesor prof = profDao.findById(id);
		if(prof != null) {
			profDao.delete(prof);
			System.out.println("El profesor fue eliminado correctamente");
		}else {
			System.out.println("No existe el profesor id="+id);
		}		
		HibernateUtil.closeSessionFactory();
	}
}

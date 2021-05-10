package com.educomser.demo;

import java.util.Scanner;

import com.educomser.dao.CursoDao;
import com.educomser.entity.Curso;
import com.educomser.util.HibernateUtil;

public class MuchosMuchos04 {

	public static void main(String[] args) {
		CursoDao curDao = new CursoDao();
		Scanner in = new Scanner(System.in);
		Curso cur = new Curso();
		System.out.println("-- NUEVO CURSO");
		System.out.println("Ingrese nombre curso: ");
		cur.setNombreCurso(in.next());
		System.out.println("Guardando...");
		curDao.save(cur);
		System.out.println("Los datos se han guardado correctamente.");
		HibernateUtil.closeSessionFactory();
	}
}

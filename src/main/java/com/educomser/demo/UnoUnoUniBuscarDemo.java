package com.educomser.demo;

import java.util.Scanner;

import com.educomser.dao.ProfesorDao;
import com.educomser.entity.Profesor;

public class UnoUnoUniBuscarDemo {

	public static void main(String[] args) {
		ProfesorDao profDao = new ProfesorDao();
		System.out.println("DETALLE PROFESOR");
		System.out.print("Ingrese un id: ");
		Scanner t = new Scanner(System.in);
		Profesor p = profDao.findById(t.nextInt());
		if (p != null) {
			System.out.println("ID: " + p.getId());
			System.out.println("Nombre: " + p.getNombre());
			System.out.println("Sueldo: " + p.getSueldo());
			System.out.println("Direccion: " + p.getDireccion().getCalle() + ", " + p.getDireccion().getZona() + " Nro "
					+ p.getDireccion().getNumero());
		} else {
			System.out.println("El profesor no existe...");
		}
	}
}

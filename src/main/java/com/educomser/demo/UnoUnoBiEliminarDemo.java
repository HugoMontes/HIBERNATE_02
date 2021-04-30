package com.educomser.demo;

import java.util.Scanner;

import com.educomser.dao.DireccionDao;
import com.educomser.dao.ProfesorDao;
import com.educomser.entity.Direccion;
import com.educomser.entity.Profesor;

public class UnoUnoBiEliminarDemo {

	public static void main(String[] args) {
		// AL ELIMINAR UN PROFESOR TAMBIEN SE ELIMINA UNA DIRECCION
		ProfesorDao profDao = new ProfesorDao();
		Profesor prof = profDao.findById(1);
		System.out.println("REGISTRO A ELIMINAR");
		System.out.println("ID: "+prof.getId());
		System.out.println("Nombre: "+prof.getNombre());
		System.out.println("Sueldo: "+prof.getSueldo());
		System.out.println("Direccion: "+prof.getDireccion());
		System.out.println("Esta seguro de eliminar el registro s/n: ");
		Scanner in = new Scanner(System.in);
		String resp = in.next();
		if(resp.equals("s")) {
			profDao.delete(prof);
		}
		// AL ELIMINAR UNA DIRECCION TAMBIEN SE ELIMINA EL PROFESOR
		DireccionDao dirDao = new DireccionDao();
		Direccion dir = dirDao.findById(2);
		System.out.println("REGISTRO A ELIMINAR");
		System.out.println("ID: "+dir.getId());
		System.out.println("Zona: "+dir.getZona());
		System.out.println("Calle: "+dir.getCalle());
		System.out.println("Numero: "+dir.getNumero());
		System.out.println("Profesor: "+dir.getProfesor().getNombre());
		System.out.println("Esta seguro de eliminar el registro s/n: ");
		resp = in.next();
		if(resp.equals("s")) {
			dirDao.delete(dir);
		}		
	}
}

package com.educomser.demo;

import java.util.Scanner;

import com.educomser.dao.EmailDao;
import com.educomser.entity.Email;
import com.educomser.entity.Profesor;
import com.educomser.util.HibernateUtil;

public class UnoMuchos03Demo {
	public static void main(String[] args) {
		// ADICIONAR UN CORREO
		Scanner in=new Scanner(System.in);
		System.out.print("Ingrese el id de un profesor existente: ");
		Profesor prof = new Profesor();
		prof.setId(in.nextInt());
		System.out.print("Ingrese un nuevo correo: ");
		Email email = new Email(in.next(), prof);
		EmailDao edao = new EmailDao();
		edao.save(email);
		System.out.println("El correo se ha guardado."); 
		// CERRAR SESSION FACTORY
		HibernateUtil.closeSessionFactory();
	}
}

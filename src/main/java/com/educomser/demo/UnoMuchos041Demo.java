package com.educomser.demo;

import java.util.Scanner;

import com.educomser.dao.EmailDao;
import com.educomser.entity.Email;
import com.educomser.util.HibernateUtil;

public class UnoMuchos041Demo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		EmailDao emailDao = new EmailDao();
		System.out.print("Seleccione el id de un correo a eliminar: ");
		int id = in.nextInt();
		Email email = emailDao.findById(id);
		if(email != null) {
			emailDao.delete(email);
			System.out.println("El correo fue eliminado correctamente");
		}else {
			System.out.println("No existe el correo id="+id);
		}		
		HibernateUtil.closeSessionFactory();
	}
}

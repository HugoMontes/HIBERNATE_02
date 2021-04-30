package com.educomser.entity;

import javax.persistence.*;
@Entity
@Table(name = "tbl_emails")
public class Email {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_email")
	private int id;
	private String correo;
	@ManyToOne
	@JoinColumn(name = "idprofesor")
	private Profesor profesor;

	public Email() {
	}

	public Email(String correo, Profesor profesor) {
		this.correo = correo;
		this.profesor = profesor;
	}

	// GENERAR METODOS GETTER Y SETTER
	// GENERAR METODO TOSTRING() OMITIR PROFESOR
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	@Override
	public String toString() {
		return "Email [id=" + id + ", correo=" + correo + "]";
	}	
}

package com.educomser.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "tbl_profesores")
public class Profesor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_profesor")
	private int id;
	private String nombre;
	private float sueldo;
	@OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
	private List<Email> emails = new ArrayList<Email>();
	
	public Profesor() {
	}
	
	public Profesor(String nombre, float sueldo) {
		this.nombre = nombre;
		this.sueldo = sueldo;
	}

	// GENERAR METODOS GETTER Y SETTER
	// GENERAR METODO TOSTRING() OMITIR EMAILS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", sueldo=" + sueldo + "]";
	}	
}

package com.educomser.entity;

import javax.persistence.*;

@Entity
@Table(name = "profesor")
public class Profesor {
	@Id
	@Column(name = "id_profesor")
	private int id;
	private String nombre;
	private float sueldo;
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Direccion direccion;
	
	public Profesor() {
	}
	
	public Profesor(int id, String nombre, float sueldo) {
		this.id = id;
		this.nombre = nombre;
		this.sueldo = sueldo;
	}

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

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", sueldo=" + sueldo + "]";
	}
}

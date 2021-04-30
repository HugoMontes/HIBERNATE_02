package com.educomser.entity;

import javax.persistence.*;

@Entity
@Table(name = "direccion")
public class Direccion {
	@Id
	@Column(name = "id_direccion")
	private int id;
	private String calle;
	private String zona;
	private int numero;	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Profesor profesor;
	
	public Direccion() {
	}
	
	public Direccion(int id, String calle, String zona, int numero) {
		this.id = id;
		this.calle = calle;
		this.zona = zona;
		this.numero = numero;
	}

	// GENERAR METODOS GETTER Y SETTER
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", calle=" + calle + ", zona=" + zona + ", numero=" + numero + "]";
	}	
	
}

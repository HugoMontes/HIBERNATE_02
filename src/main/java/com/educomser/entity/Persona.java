package com.educomser.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "personas")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona")
	private int idPersona;
	@Column(name = "nombre", length=50, nullable=false)
	private String nombre;
	@Column(name = "salario", columnDefinition="float default 0")
	private float salario;
	@Column(name = "seguro")
	private boolean seguro;
	@Column(name = "fecha_nacimiento", columnDefinition="date")
	private Date fechaNacimiento;

	public Persona() {
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public boolean isSeguro() {
		return seguro;
	}

	public void setSeguro(boolean seguro) {
		this.seguro = seguro;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", salario=" + salario + ", seguro=" + seguro
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}
}

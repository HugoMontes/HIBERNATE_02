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
	
	@Column(name = "nombre_profesor", nullable = false, unique = true)	
	private String nombreProfesor;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "profesor_curso", 
	         joinColumns = { @JoinColumn(name = "profesor_id") }, 
	         inverseJoinColumns = { @JoinColumn(name = "curso_id") })
	private List<Curso> cursos = new ArrayList<Curso>();
	
	public Profesor() {
	}
	
	public Profesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreProfesor() {
		return nombreProfesor;
	}

	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombreProfesor=" + nombreProfesor + "]";
	}
}

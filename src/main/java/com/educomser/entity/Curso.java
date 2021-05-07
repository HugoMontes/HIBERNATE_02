package com.educomser.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "cursos")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_curso")
	private int id;
	@Column(name = "nombre_curso", nullable = false, unique = true)
	private String nombreCurso;
	@ManyToMany(mappedBy = "cursos", cascade = CascadeType.ALL)
	private List<Profesor> profesores = new ArrayList<Profesor>();

	public Curso() {
	}

	public Curso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public List<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombreCurso=" + nombreCurso + "]";
	}
}

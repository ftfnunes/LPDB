package com.trabalholp.negocio;


import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Avaliacao {
	@Id Long id;
	@Index String matriculaProfessor;
	String disciplina;
	String nome;
	String gabarito;
	boolean temFator;

	
	/*Getters e Setters*/
	
	
	public String getGabarito() {
		return gabarito;
	}
	public void setGabarito(String gabarito) {
		this.gabarito = gabarito;
	}
	float valor;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMatriculaProfessor() {
		return matriculaProfessor;
	}
	public void setMatriculaProfessor(String matriculaProfessor) {
		this.matriculaProfessor = matriculaProfessor;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public boolean isTemFator() {
		return temFator;
	}
	public void setTemFator(boolean temFator) {
		this.temFator = temFator;
	}
	
	
}

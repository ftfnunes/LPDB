package com.negocio.out;

import java.util.ArrayList;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.trabalholp.negocio.Avaliacao;

@Entity
public class Turma {
	@Id Long id;
	Professor professor;
	@Index Disciplina disciplina;
	ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	ArrayList<Avaliacao> notas = new ArrayList<Avaliacao>();
	@Index String nome;
	
	/*Getters e Setters*/
	
	public ArrayList<Avaliacao> getNotas() {
		return notas;
	}
	public void setNotas(ArrayList<Avaliacao> notas) {
		this.notas = notas;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina curso) {
		this.disciplina = curso;
	}
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	
}

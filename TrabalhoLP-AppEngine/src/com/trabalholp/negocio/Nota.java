package com.trabalholp.negocio;


import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Nota {
	@Id Long id;
	@Index String matriculaAluno;
	float pontuacao;
	@Index Avaliacao avaliacao;
	String respostas;	
	
	
	/*Getters e Setters*/
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMatriculaAluno() {
		return matriculaAluno;
	}
	public void setMatriculaAluno(String matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}
	public float getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(float pontuacao) {
		this.pontuacao = pontuacao;
	}
	public Avaliacao getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	public String getRespostas() {
		return respostas;
	}
	public void setRespostas(String respostas) {
		this.respostas = respostas;
	}
	
}

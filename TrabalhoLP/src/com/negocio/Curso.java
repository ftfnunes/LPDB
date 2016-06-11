package com.negocio;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Curso {
	@Id
	Long id;
	@Index
	String nome;
	
	public Curso(){}
	
	public Curso(String nome){
		this.nome = nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
	
}

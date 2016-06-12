package com.negocio.out;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Disciplina {
	@Id
	Long id;
	@Index
	String nome;
	
	/*Getters e Setters*/
	
	public Disciplina(){}
	
	public Disciplina(String nome){
		this.nome = nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
	
}

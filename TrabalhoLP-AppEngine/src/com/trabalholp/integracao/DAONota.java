package com.trabalholp.integracao;


import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.trabalholp.negocio.Avaliacao;
import com.trabalholp.negocio.Nota;
import static com.googlecode.objectify.ObjectifyService.ofy;


import java.util.List;

public class DAONota {
	
	public List<Nota> recuperaPorAluno(String matriculaAluno){
		
		List<Nota> notas = ofy().load().type(Nota.class).filter("matriculaAluno", matriculaAluno).list();
		
		return notas;
	}
	
	public void salvaNota(Nota nota){
		ofy().save().entity(nota).now();
	}
	
	public List<Nota> recuperaPorProfessor(String matriculaProfessor){
		List<Nota> notas = ofy().load().type(Nota.class).filter("avaliacao.matriculaProfessor", matriculaProfessor).list();
		
		return notas;
	}
}

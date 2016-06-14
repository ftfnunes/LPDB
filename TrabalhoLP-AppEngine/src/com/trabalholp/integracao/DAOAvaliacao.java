package com.trabalholp.integracao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import com.googlecode.objectify.ObjectifyService;
import com.trabalholp.negocio.Avaliacao;

public class DAOAvaliacao {
	
	public List<Avaliacao> recuperaPorProfessor(String matriculaProfessor){
		List<Avaliacao> avaliacao = ofy().load().type(Avaliacao.class).filter("matriculaProfessor", matriculaProfessor).list();
		return avaliacao;
	}
	
	public void salvaAvaliacao(Avaliacao avaliacao){
		ofy().save().entity(avaliacao).now();
	}
}

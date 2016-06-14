package com.trabalholp.servico;

import java.util.List;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.googlecode.objectify.ObjectifyService;
import com.trabalholp.integracao.DAOAvaliacao;
import com.trabalholp.integracao.DAONota;
import com.trabalholp.negocio.Avaliacao;
import com.trabalholp.negocio.Nota;

@Api(name="gradeapi",version="v1", description="API para gerenciar as notas e avaliacoes criadas")
public class TrabalhoaLPAPI {
	DAONota daoNota = new DAONota();
	DAOAvaliacao daoAvaliacao = new DAOAvaliacao();
	
	static{
		ObjectifyService.begin();
		ObjectifyService.register(Nota.class);
		ObjectifyService.register(Avaliacao.class);
	}
	
	@ApiMethod(name="addNota")
	public Nota salvaNotas(Nota nota){
			daoNota.salvaNota(nota);
			return nota;
	}
	
	@ApiMethod(name="addAvaliacao")
	public Avaliacao salvaAvaliacao(Avaliacao avaliacao){
		daoAvaliacao.salvaAvaliacao(avaliacao);
		return avaliacao;
	}
	
	@ApiMethod(name="listAvaliacoes")
	public List<Avaliacao> recuperaAvaliacoes(@Named("matriculaProf") String matriculaProfessor){
		return daoAvaliacao.recuperaPorProfessor(matriculaProfessor);
	}
	
	@ApiMethod(name="listNotas")
	public List<Nota> recuperaNotas(@Named("matriculaAluno") String matriculaAluno){
		return daoNota.recuperaPorAluno(matriculaAluno);
	}
	
	@ApiMethod(name="listNotasPorProf")
	public List<Nota> recuperaNotasPorProf(@Named("matriculaProf") String matriculaProfessor){
		return daoNota.recuperaPorProfessor(matriculaProfessor);
	}
	
}

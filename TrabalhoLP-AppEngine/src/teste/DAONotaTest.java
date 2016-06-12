package teste;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.googlecode.objectify.ObjectifyService;
import com.trabalholp.integracao.DAOAvaliacao;
import com.trabalholp.integracao.DAONota;
import com.trabalholp.negocio.Avaliacao;
import com.trabalholp.negocio.Nota;

public class DAONotaTest {

	 private final LocalServiceTestHelper helper =
		      new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

	 @Before
	  public void setUp() {
	    helper.setUp();
	  }

	  @After
	  public void tearDown() {
	    helper.tearDown();
	  } 
	
	@Test
	public void Savetest() {
		DAOAvaliacao daoAvaliacao = new DAOAvaliacao();
		Avaliacao avaliacao = new Avaliacao();
		
		ObjectifyService.begin();
		ObjectifyService.register(Avaliacao.class);
		ObjectifyService.register(Nota.class);
		
		avaliacao.setMatriculaProfessor("14/000");
		avaliacao.setGabarito("VVFFVV");
		avaliacao.setDisciplina("LP");
		avaliacao.setNome("P1");
		
		daoAvaliacao.salvaAvaliacao(avaliacao);
		
		DAONota daoNota = new DAONota();
		Nota nota = new Nota();
		
		nota.setAvaliacao(avaliacao);
		nota.setMatriculaAluno("14/00");
		nota.setPontuacao(10);
		nota.setRespostas("VVFFVV");
		
		daoNota.salvaNota(nota);
		assertTrue(true);
		
		List<Nota> notas = daoNota.recuperaPorAluno("14/00");
		assertTrue(notas.size() == 1);
		assertTrue(daoNota.recuperaPorAluno("0000").isEmpty());
		
		assertTrue(notas.get(0).getPontuacao() == 10);
		
		List<Nota> notasDoProf = daoNota.recuperaPorProfessor("14/000");
		assertTrue(true);
		assertTrue(notasDoProf.size() == 1);
		
		assertTrue(notasDoProf.get(0).getAvaliacao().getDisciplina() == "LP");
	}

}

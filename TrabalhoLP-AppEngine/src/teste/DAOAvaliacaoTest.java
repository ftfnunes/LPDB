package teste;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.api.datastore.dev.LocalDatastoreService;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.googlecode.objectify.ObjectifyService;
import com.trabalholp.integracao.DAOAvaliacao;
import com.trabalholp.negocio.Avaliacao;
import com.trabalholp.negocio.Nota;

public class DAOAvaliacaoTest {
	
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
	public void Test() {
		DAOAvaliacao daoAvaliacao = new DAOAvaliacao();
		Avaliacao avaliacao = new Avaliacao();
		
		ObjectifyService.begin();
		ObjectifyService.register(Avaliacao.class);
		
		avaliacao.setMatriculaProfessor("14/000");
		avaliacao.setGabarito("VVFFVV");
		avaliacao.setDisciplina("LP");
		avaliacao.setNome("P1");
		
		daoAvaliacao.salvaAvaliacao(avaliacao);
		assertTrue(true);
		
		ObjectifyService.begin();
		ObjectifyService.register(Avaliacao.class);
		assertTrue(daoAvaliacao.recuperaPorProfessor("000").isEmpty());
		List<Avaliacao> teste = daoAvaliacao.recuperaPorProfessor("14/000");
		assertTrue(teste.size() == 1);
		assertTrue(teste.get(0).getNome() == "P1");
		
	}

}

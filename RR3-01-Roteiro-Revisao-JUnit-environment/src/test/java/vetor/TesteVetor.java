
package vetor;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TesteVetor {
	private Vetor<Aluno> vetor;
	private Vetor<Aluno> vetorVazio;

	@Before
	public void setUp() throws Exception {
		vetor = new Vetor<Aluno>(5);
		vetorVazio = new Vetor<Aluno>(1);
		ComparatorAluno compMax = new ComparatorAluno();
		vetor.setComparadorMaximo(compMax);
		vetor.setComparadorMaximo(compMax);
		ComparatorAluno compMin = new ComparatorAluno();
		vetor.setComparadorMinimo(compMin);
		vetorVazio.setComparadorMinimo(compMin);
	}

	@Test
	public void testInserir() {
		assertTrue(vetor.isVazio());
		vetor.inserir(new Aluno("Aninha", 5.0));
		assertFalse(vetor.isVazio());

	}

	@Test
	public void testRemover() {
		Aluno novoAluno = new Aluno("Miss Fortune", 5.0);
		vetor.inserir(novoAluno);
		assertFalse(vetor.isVazio());
		vetor.remover(novoAluno);
		assertTrue(vetor.isVazio());
	}

	@Test
	public void testProcurar() {
		Aluno novoAluno = new Aluno("Seraphine", 5.0);
		vetor.inserir(novoAluno);

		Aluno procurado = vetor.procurar(novoAluno);
		assertEquals(novoAluno, procurado);
		procurado = vetor.procurar(new Aluno("Ana", 6.0));
		assertNull(procurado);
	}

	@Test
	public void testIsVazio() {
		assertTrue(vetorVazio.isVazio());
	}

	@Test
	public void testIsCheio() {
		for (int i = 0; i < 5; i++) {
			Aluno novoAluno = new Aluno("Bla", 7.0);
			vetor.inserir(novoAluno);
		}
		assertTrue(vetor.isCheio());
	}

	@Test
	public void testMaximo() {
		Aluno novoAluno1 = new Aluno("Bla", 7.0);
		Aluno novoAluno2 = new Aluno("Ble", 4.0);
		vetor.inserir(novoAluno1); 
		vetor.inserir(novoAluno2);
		Aluno maximo = vetor.max();
		assertEquals(novoAluno1, maximo);
	}

	@Test
	public void testMinimo() {
		Aluno novoAluno1 = new Aluno("Blo", 3.0);
		Aluno novoAluno2 = new Aluno("Blu", 8.0);
		vetor.inserir(novoAluno1);
		vetor.inserir(novoAluno2);
		Aluno minimo = vetor.min();
		assertEquals(novoAluno1, minimo);
	}

}

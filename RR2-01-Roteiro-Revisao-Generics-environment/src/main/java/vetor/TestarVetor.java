package vetor;

public class TestarVetor {

	public static void main(String[] args) {
		Vetor<Aluno> vetor = new Vetor<Aluno>(20);
		ComparadorMax compMax = new ComparadorMax();
		vetor.setComparadorMax(compMax);
		ComparadorMin compMin = new ComparadorMin();
		vetor.setComparadorMin(compMin);

		//inserindo elementos
        vetor.inserir(new Aluno("Viviane", 7.5));
        vetor.inserir(new Aluno("Ana Paula", 9.2));
        vetor.inserir(new Aluno("Matheus", 6.8));
        vetor.inserir(new Aluno("Ariany", 8.0));

		//testando
		Aluno max = vetor.getMaxVetor();
		System.out.println("O(A) MELHOR ALUNO(A) É: " + max.getNome());
		//testando 2
		Aluno min = vetor.getMinVetor();
		System.out.println("O(A) PIOR ALUNO(A) É: " + min.getNome());


	}


}

package recursao;

public class TestarMetodosRecursivos {
	public static void main(String[] args) {
		
		MetodosRecursivos m = new MetodosRecursivos();

		System.out.println(m.calcularFibonacci(6));
		System.out.println(m.calcularFatorial(5));
		System.out.println(m.countNotNull(new Object[] {3, null, 4, null, 5}, 0));
		System.out.println(m.potenciaDe2(4));
		System.out.println(m.progressaoAritmetica(2, 2, 5));
		System.out.println(m.progressaoGeometrica(2, 2, 5));
	}
}

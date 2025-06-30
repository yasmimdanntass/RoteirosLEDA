package recursao;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array){
		int result = 0;
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR A SOMA
		// DOS EMENTOS DE UM ARRAY
		return result;
	}
	public long calcularFatorial(int n) {
		long result = 1;
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR E IMPRIMIR
		// O FATORIAL DO PARAMETRO
		// DE ACORDO COM O QUE FOI MOSTRADO NO EXERCCICIO. OBSERVE QUE SENDO O
		// METODO
		// RECURSIVO, O FATORIAL DOS NUMEROS ANTERIORES TAMBEM VAO SER IMPRESSOS
        if (n == 0){
            result = 1;
        } else {
            result = n * calcularFatorial(n-1);
        }

        return result;
        
    }
	

	public int calcularFibonacci(int n) {
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR E IMPRIMIR
		// O N-ESIMO TERMO
		// DA SEQUENCIA DE FIBONACCI, QUE TEM A SEGUINTE LEI DE FORMACAO: O
		// PRIMEIRO E SEGUNDO NUMEROS
		// DA SEQUENCIA SÃO 1. A PARTIR DO TERCEIRO TERMO, CADA TERMO DA
		// SEQUENCIA É DADO
		// PELA SOMA DOS OUTROS DOIS ANTERIORES. OBSERVE QUE SENDO O METODO
		// RECURSIVO, O FIBONACCI DOS NUMEROS ANTERIORES TAMBEM VAO SER
		// IMPRESSOS
		int result = -1;

		if (n == 1 || n == 2){
			result = 1;
		} else if (n > 2){
			result = calcularFibonacci(n-1) + calcularFibonacci(n-2);
		}

		return result;
		
	}

	public int countNotNull(Object[] array, int index) {
		int result = 0;
		
		if (array[index] != null) {
			result = 1;
		}
		
		if (index != array.length - 1) {
			result = result + countNotNull(array, index+1);
		}
		return result;
}


	public int potenciaDe2(int expoente) {
		int result = 1;
		// TODO IMPLEMENTE (USANDO RECURSAO) O CODIGO PARA PRODUZIR A N-ESIMA
		// POTENCIA
		// DE 2
		if (expoente == 0){
			result = 1;

		} else {
			result = 2 * potenciaDe2( expoente -1);
		}
		
		return result;
		
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = 0;
		
		if (n == 1){
			result = termoInicial;
		} else {
			result = razao + progressaoAritmetica(termoInicial, razao, n -1);
		}
		
		return result;
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = 1;
		
		if (n == 1){
			result = termoInicial;
		} else {
			result = razao * progressaoGeometrica(termoInicial, razao, n -1);
		}
		
		return result;
	}
	
	
}

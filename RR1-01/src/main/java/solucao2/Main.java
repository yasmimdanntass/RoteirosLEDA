package solucao2;

public class Main{
    public static void main(String[] args) {
        
        Forma quadrado = new Quadrado(2);
        Forma triangulo = new Triangulo(4, 5);
        Forma retangulo = new Retangulo(4, 5);
        Forma circulo = new Circulo(2);

        System.out.println(quadrado.getArea());
        System.out.println(triangulo.getArea());
        System.out.println(retangulo.getArea());
        System.out.println(circulo.getArea());
    }
    
}


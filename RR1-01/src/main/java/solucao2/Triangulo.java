package solucao2;

public class Triangulo implements Forma{
    double base;
    double altura;

    public Triangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double getArea() {
        return (this.base * this.altura)/2;
    }

}

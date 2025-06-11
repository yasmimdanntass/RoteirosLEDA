package solucao2;

public class Retangulo implements Forma{
    double base;
    double altura;

    public Retangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double getArea() {
        return this.base * this.altura;
    }

}

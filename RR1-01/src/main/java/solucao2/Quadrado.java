package solucao2;

public class Quadrado implements Forma{
    double lado;

    public Quadrado(double lado){
        this.lado = lado;
    }

    @Override
    public double getArea() {
        return this.lado * this.lado; 
    }

    
}

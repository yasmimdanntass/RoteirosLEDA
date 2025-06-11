package solucao2;

public class Circulo implements Forma{
    double raio;

    public Circulo(double raio){
        this.raio = raio;
    }

    @Override
    public double getArea() {
        return Math.PI * this.raio * this.raio;
    }

}

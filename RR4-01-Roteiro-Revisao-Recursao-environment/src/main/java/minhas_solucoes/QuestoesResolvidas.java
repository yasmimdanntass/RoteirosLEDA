package minhas_solucoes;

public class QuestoesResolvidas {


    private static void geraNaturais(int n){

        if (n < 0) {
            System.out.println("Opa! O método só aceita números naturais.");
        } else if (n == 0) {
            System.out.print( n + " ");
        } else {
            geraNaturais(n - 1);
            System.out.print(n + " ");
        }
    }

    private static int somaNaturais(int n){
        int retorno = 0;

        if (n < 0) {
            retorno = -1;
        } else if (n == 0) {
            retorno = 0;
        } else {
            retorno += n + somaNaturais(n-1);
        }

        return retorno;

    }

    public static void main(String[] args) {
        geraNaturais(4);
        System.out.println( "\n" + somaNaturais(3));
    }
}

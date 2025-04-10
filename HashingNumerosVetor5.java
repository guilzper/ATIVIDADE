import java.util.LinkedList;
import java.util.Scanner;

public class HashingNumerosVetor5 {
    private static final int TAMANHO = 5;
    private LinkedList<Integer>[] tabela;

    public HashingNumerosVetor5() {
        tabela = new LinkedList[TAMANHO];
        for (int i = 0; i < TAMANHO; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    private int contarDigitos(int numero) {
        return String.valueOf(Math.abs(numero)).length();
    }

    private int funcaoHash(int numero) {
        return contarDigitos(numero) % TAMANHO;
    }

    public void inserir(int numero) {
        int indice = funcaoHash(numero);
        tabela[indice].add(numero);
    }

    public void exibir() {
        for (int i = 0; i < TAMANHO; i++) {
            System.out.print("Posição " + i + ": ");
            for (int num : tabela[i]) {
                System.out.print(num + " -> ");
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashingNumerosVetor5 hash = new HashingNumerosVetor5();

        System.out.println("Digite números (digite -1 para parar):");
        while (true) {
            int numero = scanner.nextInt();
            if (numero == -1) break;
            hash.inserir(numero);
        }

        hash.exibir();
    }
}

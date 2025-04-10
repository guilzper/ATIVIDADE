import java.util.ArrayList;
import java.util.Scanner;

public class HashingFechado {
    private static final int TAMANHO = 10;
    private static final int LIMITE_COLISOES = 5;
    private ArrayList<Integer>[] tabela;

    public HashingFechado() {
        tabela = new ArrayList[TAMANHO];
        for (int i = 0; i < TAMANHO; i++) {
            tabela[i] = new ArrayList<>();
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
        if (tabela[indice].size() >= LIMITE_COLISOES) {
            System.out.println("⚠️ Estouro na posição " + indice + " ao tentar inserir " + numero);
        } else {
            tabela[indice].add(numero);
        }
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
        HashingFechado hash = new HashingFechado();

        System.out.println("Digite números (digite -1 para parar):");
        while (true) {
            int numero = scanner.nextInt();
            if (numero == -1) break;
            hash.inserir(numero);
        }

        hash.exibir();
    }
}

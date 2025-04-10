import java.util.LinkedList;
import java.util.Scanner;

public class HashingNomes {
    private static final int TAMANHO = 10;
    private LinkedList<String>[] tabela;

    public HashingNomes() {
        tabela = new LinkedList[TAMANHO];
        for (int i = 0; i < TAMANHO; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    private int funcaoHash(String nome) {
        return nome.length() % TAMANHO;
    }

    public void inserir(String nome) {
        int indice = funcaoHash(nome);
        tabela[indice].add(nome);
    }

    public void exibir() {
        for (int i = 0; i < TAMANHO; i++) {
            System.out.print("Posição " + i + ": ");
            for (String nome : tabela[i]) {
                System.out.print(nome + " -> ");
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashingNomes hash = new HashingNomes();

        System.out.println("Digite nomes (digite 'fim' para parar):");
        while (true) {
            String nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("fim")) break;
            hash.inserir(nome);
        }

        hash.exibir();
    }
}

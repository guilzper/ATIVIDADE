import java.util.*;

public class HashingMultilista {
    private Map<Integer, LinkedList<Integer>> tabela;

    public HashingMultilista() {
        tabela = new HashMap<>();
    }

    private int contarDigitos(int numero) {
        return String.valueOf(Math.abs(numero)).length();
    }

    public void inserir(int numero) {
        int chave = contarDigitos(numero);
        tabela.putIfAbsent(chave, new LinkedList<>());
        tabela.get(chave).add(numero);
    }

    public void exibir() {
        for (int chave : tabela.keySet()) {
            System.out.print("Chave " + chave + ": ");
            for (int num : tabela.get(chave)) {
                System.out.print(num + " -> ");
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashingMultilista hash = new HashingMultilista();

        System.out.println("Digite números (digite -1 para parar):");
        while (true) {
            int numero = scanner.nextInt();
            if (numero == -1) break;
            hash.inserir(numero);
        }

        hash.exibir();
    }
}

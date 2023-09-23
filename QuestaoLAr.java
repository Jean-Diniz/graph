import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestaoLAr {

    public static List<Pair<Integer, Pair<Integer, Integer>>> LA_para_LAr(List<List<Pair<Integer, Integer>>> LA, int n) {
        List<Pair<Integer, Pair<Integer, Integer>>> LAr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (Pair<Integer, Integer> pair : LA.get(i)) {
                LAr.add(new Pair<>(i, new Pair<>(pair.getFirst(), pair.getSecond())));
            }
        }

        return LAr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner("4 3\n0 2 10\n1 2 5\n2 3 5\n4 4\n0 1 2\n0 2 1\n1 3 3\n2 3 8\n");

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            // considerando que os índices dos vértices começam de 0 e vão até n-1
            List<List<Pair<Integer, Integer>>> LA = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                LA.add(new ArrayList<>());
            }

            // leitura do grafo
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                int w = scanner.nextInt();

                // grafo não direcionado
                // u - v
                LA.get(u).add(new Pair(v, w));
                LA.get(v).add(new Pair(u, w));
            }

            // lista de arestas
            List<Pair<Integer, Pair<Integer, Integer>>> LAr = LA_para_LAr(LA, n);

            // imprimindo a lista
            for (Pair<Integer, Pair<Integer, Integer>> pair : LAr) {
                System.out.print("(" + pair.getSecond().getFirst() + "," + pair.getSecond().getSecond() + ")" + "[" + pair.getFirst() + "]");
            }
            System.out.println();
        }
    }
}
import java.util.*;

public class AdjacencyList {
    public static void main(String[] args) {
        String input = "5 6\n 0 1\n 0 3\n 1 4\n 2 0\n 3 1\n 4 3\n 4 5\n 1 0\n 1 2\n 1 3\n 2 0\n 2 3\n";

        Scanner scanner = new Scanner(input);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            List<List<Integer>> adjacencyList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adjacencyList.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                adjacencyList.get(u).add(v);
            }

            Random random = new Random();
            int vertex = random.nextInt(n);
            Pair<Integer, Integer> grau = returnDegree(adjacencyList, n, vertex);
            System.out.println("Vertex: " + vertex + ". In degree: " + grau.getFirst() + ". Out degree: " + grau.getSecond());
        }

    }

    static class Pair<T1, T2> {
        private T1 first;
        private T2 second;

        public Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }

        public T1 getFirst() {
            return first;
        }

        public T2 getSecond() {
            return second;
        }
    }

    static Pair<Integer, Integer> returnDegree(List<List<Integer>> adjacencyList, int n, int vertex) {
        int inDegree = 0;
        int outDegree = adjacencyList.get(vertex).size();

        for (int i = 0; i < n; i++) {
            for(int v : adjacencyList.get(i)) {
                if (v == vertex) {
                    inDegree++;
                }
            }
        }

        return new Pair<>(inDegree, outDegree);
    }
}

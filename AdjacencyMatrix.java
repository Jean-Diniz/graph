import java.util.ArrayList;
import java.util.Scanner;

public class AdjacencyMatrix {
    public static ArrayList<Integer>[] transposed(int[][] adjacencyMatrix) {
        int n = adjacencyMatrix.length;
        ArrayList<Integer>[] adjacencyList = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjacencyMatrix[i][j] == 1){
                    adjacencyList[j].add(i);
                }
            }
        }

        return adjacencyList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner("5 6\n0 1\n0 3\n1 4\n2 0\n3 1\n4 3\n");

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int[][] adjacencyMatrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adjacencyMatrix[i][j] = 0;
                }
            }

            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();

                // Grafo direcionado
                adjacencyMatrix[u][v] = 1; // u -> v
            }

            ArrayList<Integer>[] adjacencyList = transposed(adjacencyMatrix);

            for (int u = 0; u < n; u++) {
                System.out.print(u + ": ");
                for (int j = 0; j < adjacencyList[u].size(); j++) {
                    int v = adjacencyList[u].get(j);
                    System.out.print(v + " ");
                }
                System.out.println();
            }

            System.out.println();
        }

        scanner.close();
    }
}

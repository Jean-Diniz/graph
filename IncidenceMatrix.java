import java.util.Scanner;

public class IncidenceMatrix {
    public static int[][] adjacencyToIncidence(int[][] adjacencyMatrix, int n, int m) {
        int[][] incidenceMatrix = new int[m][n];

        int edge = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    incidenceMatrix[edge][i] = incidenceMatrix[edge][j] = 1;
                    edge++;
                }
            }
        }

        return incidenceMatrix;
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

                // Grafo não-direcionado
                adjacencyMatrix[u][v] = adjacencyMatrix[v][u] = 1; // u - v
            }

            int[][] incidenceMatrix = adjacencyToIncidence(adjacencyMatrix, n, m);

            for (int e = 0; e < m; e++) {
                for (int u = 0; u < n; u++) {
                    System.out.print(incidenceMatrix[e][u] + " ");
                }
                System.out.println();
            }
        }

        scanner.close();
    }
}

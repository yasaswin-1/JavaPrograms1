import java.util.Scanner;

class KMST {
    static int v;
    static int[] par;
    static final int INF = Integer.MAX_VALUE;

    static void kruskalmst(int[][] cost) {
        int mincost = 0;
        for (int i = 0; i < v; i++) {
            par[i] = i;
        }
        int edgecount = 0;
        while (edgecount < v - 1) {
            int min = INF, a = -1, b = -1;
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (find(i) != find(j) && cost[i][j] < min) {
                        min = cost[i][j];
                        a = i;
                        b = j;
                    }
                }
            }
            if (find(a) != find(b)) {
                union(a, b);
                System.out.printf("Edge %d: (%d, %d) cost: %d\n", edgecount++, a, b, min);
                mincost += min;
            }
        }
        System.out.printf("\nMinimum cost: %d\n", mincost);
    }

    static int find(int i) {
        if (par[i] != i) {
            par[i] = find(par[i]);
        }
        return par[i];
    }

    static void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        par[rootI] = rootJ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        v = sc.nextInt();
        par = new int[v];
        int[][] cost = new int[v][v];
        System.out.println("Enter cost matrix:");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                cost[i][j] = sc.nextInt();
                if (cost[i][j] == 0) {
                    cost[i][j] = INF;
                }
            }
        }
        kruskalmst(cost);
        sc.close();
    }
}

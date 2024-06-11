import java.util.Scanner;

class Knaps {
    int wt, pr;

    public Knaps(int wt, int pr) {
        this.wt = wt;
        this.pr = pr;
    }
}

public class KS01 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of items:");
        int n = sc.nextInt();
        System.out.println("Enter capacity:");
        int m = sc.nextInt();
        Knaps k[] = new Knaps[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter weight and profit for item " + (i + 1) + ":");
            int wt = sc.nextInt();
            int pr = sc.nextInt();
            k[i] = new Knaps(wt, pr);
        }
        sc.close();

        int c[][] = new int[n + 1][m + 1];

        // Build table c[][] in bottom up manner
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    c[i][j] = 0;
                } else if (k[i - 1].wt <= j) {
                    c[i][j] = Math.max(k[i - 1].pr + c[i - 1][j - k[i - 1].wt], c[i - 1][j]);
                } else {
                    c[i][j] = c[i - 1][j];
                }
            }
        }

        // Print the maximum profit
        System.out.println("Maximum profit is: " + c[n][m]);
    }
}

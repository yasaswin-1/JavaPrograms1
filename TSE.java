
import java.util.*;
public class TSE {
 static int[][] d;
 static int n;
 static boolean[] v;
 static int TC = Integer.MAX_VALUE;
 static String TP;
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 System.out.print("Enter the number of cities: ");
 n = sc.nextInt();
 d = new int[n + 1][n + 1];
 v = new boolean[n + 1];
 // Load distances
 System.out.println("Enter distances between cities (0-indexed):");
 for (int i = 1; i <= n; i++) {
 for (int j = 1; j <= n; j++) {
 d[i][j] = sc.nextInt();
 }
 }
 v[1] = true;
 BAB(1, 0, 1, "1");
System.out.println("Minimum tour cost : " + TC);
 System.out.println("Minimum tour path : " + TP);
 }
 private static void BAB(int Ccity, int currentCost, int depth, String p) {
 if (depth == n) {
 if (d[Ccity][1] != 0) {
 int totalCost = currentCost + d[Ccity][1];
 if (totalCost < TC) {
 TC = totalCost;
 TP = p + "-->1";
 }
 }
 return;
 }
 for (int Ncity = 1; Ncity <= n; Ncity++) {
 if (!v[Ncity] && d[Ccity][Ncity] != 0 && currentCost + d[Ccity][Ncity] < TC) {
 v[Ncity] = true;
 BAB(Ncity, currentCost + d[Ccity][Ncity], depth + 1, p + "-->" + Ncity);
 v[Ncity] = false;
 }
 }
 }
}
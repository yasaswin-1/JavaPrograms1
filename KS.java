
import java.util.Scanner;
public class KS{
static class Item{
int weight,profit;
double cost;
public Item(int weight,int profit){
this.weight=weight;
this.profit=profit;
this.cost=(double)profit/weight;
}
}
//sort in descending order
static void sortiemsbycost(Item items[]){
for(int i=0;i<items.length-1;i++){
for(int j=0;j<items.length-i-1;j++){
if(items[j].cost<items[j+1].cost){
Item t=items[j];
items[j]=items[j+1];
items[j+1]=t;
}
}
}
}
static double getmaxp(int capacity,Item items[]){
sortiemsbycost(items);
double totalvalue=0d;
for(Item i:items){
int curwt=i.weight;
int curpt=i.profit;
if(capacity-curwt>=0){
capacity=capacity-curwt;
totalvalue=totalvalue+curpt;
}else{
double rempt=(double)capacity/curwt;
totalvalue=totalvalue+(curpt*rempt);
break;
}
}
return totalvalue;
}
public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number items : ");
        int n = scanner.nextInt();
        Item items[] = new Item[n];
        System.out.println("Enter the weights and profits");
        for (int i = 0; i < n; i++) {
            int weight = scanner.nextInt();
            int profit = scanner.nextInt();
            items[i]=new Item(weight,profit);
        }
        System.out.print("Enter the capacity of kanpsack : ");
        int capacity=scanner.nextInt();
        double maxprofit=getmaxp(capacity,items);
        System.out.println("Max profit : "+maxprofit);
        scanner.close();
        }
 }

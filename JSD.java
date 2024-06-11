import java.util.Scanner;
public class JSD {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int j=0;
        System.out.println("enter no of jobs");
        int n=sc.nextInt();
        int p[]=new int[n];
        int d[]=new int[n];
        int jo[]=new int[n];
        System.out.println("enter profits");
        for(int i=0;i<n;i++){
            p[i]=sc.nextInt();
            jo[i]=i+1;
        }
        System.out.println("enter deadlines");
        for(int i=0;i<n;i++)
            d[i]=sc.nextInt();
        sc.close();
        for(int i=0;i<n;i++){
            for(j=0;j<n-i-1;j++){
                if(p[j]<p[j+1]){
                    int t=p[j];p[j]=p[j+1];p[j+1]=t;
                    t=d[j];d[j]=d[j+1];d[j+1]=t;
                    t=jo[j];jo[j]=jo[j+1];jo[j+1]=t;
                }
            }
        }
        int maxd=0;
        for(int i=0;i<n;i++){
            if(d[i]>maxd){
                maxd=d[i];
            }
        }
        int pro=0;
        System.out.println("the sequence is");
        for(int i=0;i<n&&i<=maxd;i++){
            if(d[i]>=i){
                pro+=p[i];
                System.out.print(jo[i]+" ");
            }
        }
            System.out.println();
            System.out.println("profit is "+pro);
    }
}

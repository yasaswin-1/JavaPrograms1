
import java.util.*;
public class BS
{
public static void main(String[] args)
{
int a[],n,key,flag=0,i,low=0,mid=0,high;
Scanner sc=new Scanner(System.in);
System.out.println("enter no of elements you want to enter");
n=sc.nextInt();
a=new int[n];
high=(n-1);
for(i=0;i<n;i++){
System.out.println("enter "+(i+1)+"st element");
a[i]=sc.nextInt();
}
System.out.println("enter the searching element");
key=sc.nextInt();
while(low<=high)
{
mid=((low+high)/2);
if(a[mid]==key){
++flag;
break;
}
else if(key>a[mid]){
low=mid+1;
}
else{
high=mid-1;
}
}
if(flag==1){
System.out.println("element found at index : "+mid);
}
else
System.out.println("element not found");
}
}


import java.util.*;

class ms {
  void merge(int arr[], int low, int mid, int high) {
    int n1 = mid - low + 1;
    int n2 = high - mid;
    int a[] = new int[n1];
    int b[] = new int[n2];
    for (int i = 0; i < n1; i++)
      a[i] = arr[low + i];
    for (int j = 0; j < n2; j++)
      b[j] = arr[mid + 1 + j];
    int i, j, k;
    i = 0;
    j = 0;
    k = low;
    while (i < n1 && j < n2) {
      if (a[i] <= b[j]) {
        arr[k++] = a[i++];
      } else {
        arr[k++] = b[j++];
      }
    }
    while (i < n1) {
      arr[k++] = a[i++];
    }
    while (j < n2) {
      arr[k++] = b[j++];
    }
  }
  void mergeSort(int arr[], int low, int high) {
    if (low < high) {
      int mid = (low + high) / 2;
      mergeSort(arr, low, mid);
      mergeSort(arr, mid + 1, high);
      merge(arr, low, mid, high);
    }
  }
  static void printArray(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; ++i)
      System.out.print(arr[i] + " ");
    System.out.println();
  }
  public static void main(String args[]) {
    int arr[],n,i;
    Scanner sc=new Scanner(System.in);
    System.out.println("enter size of array : ");
    n=sc.nextInt();
    arr=new int[n];
    System.out.println("enter elements of array : ");
    for(i=0;i<n;i++)
    arr[i]=sc.nextInt();
    ms ob = new ms();
    ob.mergeSort(arr, 0, n - 1);
    System.out.println("Sorted array is :");
    printArray(arr);
  }
}

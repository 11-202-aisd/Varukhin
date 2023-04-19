import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = i;
    }

    int pairs = in.nextInt();

    for (int i = 0; i < pairs; i++) {
      int v1 = arr[in.nextInt()];
      int v2 = arr[in.nextInt()];
      for (int j = 0; j < arr.length; j++) {
        if (arr[j] == v1) {
          arr[j] = v2;
        }
      }
    }

    int v1 = in.nextInt();
    int v2 = in.nextInt();
    System.out.println(arr[v1] == arr[v2]);
  }
}
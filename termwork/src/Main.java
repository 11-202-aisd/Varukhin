import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
    public static long iter = 0;

    public static void main(String[] args) throws Exception {
        for (int i = 100; i <= 6000; i+=100) {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("data/size" + i + ".txt"));
            BufferedReader r = new BufferedReader(new InputStreamReader(bis, StandardCharsets.UTF_8));
            int n = Integer.parseInt(r.readLine());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(r.readLine());
            }
            iter = 0;

            long start = System.nanoTime();

            stoogesort(arr, 0, n - 1);

            long end = System.nanoTime();

            System.out.println(end - start);
        }
    }


    public static void stoogesort(int[] arr, int l, int h) {
        if (l >= h) return;
        iter++;
        if (arr[l] > arr[h]) {
            int t = arr[l];
            arr[l] = arr[h];
            arr[h] = t;
        }
        if (h - l + 1 > 2) {
            int t = (h - l + 1) / 3;
            stoogesort(arr, l, h - t);
            stoogesort(arr, l + t, h);
            stoogesort(arr, l, h - t);
        }
    }
}
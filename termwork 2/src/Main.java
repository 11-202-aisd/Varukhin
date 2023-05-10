import java.io.*;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    FileWriter times = new FileWriter("outputTime.txt");
    int[] testArr = new int[10000];
    for (int i = 0; i < 10000; i++) {
      testArr[i] = (int) (Math.random() * Integer.MAX_VALUE / 2);
    }
    SplayTree st = new SplayTree();
    Arrays.stream(testArr).forEach((el) -> {
      long start = System.nanoTime();
      st.insert(el);
      long end = System.nanoTime() - start;
      try {
        times.write(end + "\n");
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    });

    times.write("\n");

    for (int i = 0; i < 100; i++) {
      int elem = testArr[(int) (Math.random() * 10000)];
      long start = System.nanoTime();
      st.search(elem);
      long end = System.nanoTime() - start;
      times.write(end + "\n");
    }

    times.write("\n");

    for (int i = 0; i < 1000; i++) {
      int elem = testArr[(int) (Math.random() * 10000)];
      long start = System.nanoTime();
      st.remove(elem);
      long end = System.nanoTime() - start;
      times.write(end + "\n");
    }

    times.flush();
  }
}
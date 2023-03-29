import java.io.*;

public class DataGenerator {
    public static final String DATA = "data/";
    public static final int FILE_COUNT = 60 - 1;

    public static final int MIN_NUM = 0;
    public static final int MAX_NUM = Integer.MAX_VALUE;


    public static final int MIN_SIZE = 100;
    public static final int MAX_SIZE = 6000;

    public static void main(String[] args) {
        generateData();
    }

    public static void generateData() {
        int size = MIN_SIZE;
        int delta = (MAX_SIZE - MIN_SIZE) / (FILE_COUNT);
        for (int i = 0; i < FILE_COUNT + 1; i++) {
            generateFile(size);
            size += delta;
            System.out.println(i + " / " + FILE_COUNT);
        }
    }

    public static void generateFile(int n) {
        File file = new File(DATA + "size" + n + ".txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream out = new FileOutputStream(file);
            BufferedOutputStream bout = new BufferedOutputStream(out);
            out.write((n + "\n").getBytes());
            for (int i = 0; i < n; i++) {
                int x = (int) (Math.random() * MAX_NUM);
                bout.write((x + "\n").getBytes());
            }
            bout.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

import java.util.EmptyStackException;

public class Stack {
    private int[] arr;
    private int size;

    public Stack(int capacity) {
        this.arr = new int[capacity];
        this.size = -1;
    }

    public boolean isEmpty() {
        return size < 0;
    }

    public void push(int n) {
        if (size == arr.length - 1) {
            throw new RuntimeException();
        }
        arr[++size] = n;
    }

    public int peek() {
        if (size == -1) {
            throw new EmptyStackException();
        }
        return arr[size];
    }

    public int pop() {
        if (size == -1) {
            throw new EmptyStackException();
        }
        return arr[size--];
    }
}

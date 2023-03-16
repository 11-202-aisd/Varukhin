import java.util.NoSuchElementException;

public class Queue {
    private Stack in;
    private Stack out;

    public Queue(int capacity) {
        in = new Stack(capacity);
        out = new Stack(capacity);
    }

    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }

    public void add(int x) {
        in.push(x);
    }

    private void shift() {
        if (out.isEmpty()) {
            if (in.isEmpty()) throw new NoSuchElementException();
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }

    public int pop() {
        shift();

        return out.pop();
    }

    public int peek() {
        shift();

        return out.peek();
    }

    public static void main(String[] args) {
        Queue a = new Queue(1000);
        a.add(1);
        a.add(2);
        a.add(3);

        while (!a.isEmpty()) {
            System.out.println(a.pop());
        }
    }
}

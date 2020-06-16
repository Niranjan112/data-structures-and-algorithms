package stack;

public class StackByArrayMain {
    public static void main(String[] args) {
        StackByArray s = new StackByArray(5);
        for (int i = 1; i <= 5; i++) {
            s.push(i * 10);
        }
        s.push(20);
        s.printStack();
        s.pop();
        s.printStack();
        s.peek();
    }
}
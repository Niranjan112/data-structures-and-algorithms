package code;
public class IntStack {
    private int[] stack;
    private int top;
    private int size;
    
    public IntStack() {
        top = -1;
        size = 50;
        stack  = new int[size];
    }

    public IntStack(int _size) {
        top = -1;
        this.size = _size;
        stack  = new int[this.size];
    }

    public boolean push(int _item) {
        if(!isFull()) {
            top++;
            stack[top] = _item;
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        return (stack.length - 1 == size);
    }

    public int pop() {
        return stack[top--];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public static void main(String[] args) {
        IntStack s = new IntStack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        // for (int i: s.stack) {
        //     System.out.println(i);
        // }
    }
}
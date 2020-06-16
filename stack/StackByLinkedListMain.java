package stack;

public class StackByLinkedListMain {
    public static void main(String[] args) {
        StackByLinkedList s = new StackByLinkedList();
        s.push(10);
        s.printStack();
        s.push(20);
        s.printStack();
        s.pop();
        s.printStack();
        s.push(12);
        s.push(58);
        s.push(99);
        s.push(110);
        s.printStack();
        System.out.println("Peeking: "+s.peek());
        s.pop();
        System.out.println("Peeking: "+s.peek());
        s.pop();
        s.pop();
        s.printStack();
    }
}
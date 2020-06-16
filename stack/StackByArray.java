package stack;

public class StackByArray {

    private int[] stackArray;
    private int topOfStack;

    public StackByArray(int size) {
        stackArray = new int[size];
        topOfStack = -1;
        System.out.println("Stack array created with size: " + size);
    }

    public void push(int value) {
        if(isStackFull()) {
            System.out.println("Stack overflow");
        } else {
            topOfStack++;
            stackArray[topOfStack] = value;
            System.out.println("Successfully added value " + stackArray[topOfStack] + " to stack at " + topOfStack);
        }
    }

    public void pop() {
        if(isStackEmpty()) {
            System.out.println("Stack underflow");
        } else {
            System.out.println("Poped value: " + stackArray[topOfStack]);
            topOfStack--;
        }
    }

    public void peek() {
        if(isStackEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Top of Stack: " + stackArray[topOfStack]);
        }
    }

    public void printStack() {
        if(isStackEmpty()) {
            System.out.println("Stack is empty");
        } else {
            for (int i = topOfStack; i >= 0; i--) {
                System.out.println(stackArray[i]);
            }
        }
    }

    public void deleteStack() {
        stackArray = null;
        System.out.println("Stack array deleted successfully");
    }

    public boolean isStackEmpty() {
        if(topOfStack == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isStackFull() {
        if(topOfStack == stackArray.length - 1) {
            return true;
        } else {
            return false;
        }
    }
}
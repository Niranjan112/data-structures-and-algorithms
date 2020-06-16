package queue;

public class CircularQueueByArray {
    int[] arr;
    int start;
    int topOfQueue;

    public CircularQueueByArray(int size) {
        arr = new int[size];
        start = -1;
        topOfQueue = -1;
        System.out.println("Queue created successfully");
    }

    public void enqueue(int value) {
        if(isQueueFull()) {
            System.out.println("Queue overflow");
        } else {
            start = start == - 1 ? 0 : start;
            topOfQueue = topOfQueue == arr.length - 1 ? 0 : ++topOfQueue;
            arr[topOfQueue] = value;
            System.out.println("\nSuccessfully inserted " + value + " in the queue");
            printQueue();
        }
    }

    public void dequeue() {
        if(isQueueEmpty()) {
            System.out.println("Queue underflow");
        } else {
            System.out.println("Dequeued value: " + arr[start]);
            arr[start] = 0;
            if(start == topOfQueue) {
                start = topOfQueue = -1;
            } else if(start == arr.length - 1) {
                start = 0;
            } else {
                start++;
            }
            printQueue();
        }
    }

    public void peek() {
        if(isQueueEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Peeking: " + arr[start] );
        }
    }

    public void printQueue() {
        if(isQueueEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Printing Queue: ");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println("\n");
            System.out.println("Start: " + arr[start]);
            System.out.println("Top of Queue: " + arr[topOfQueue]);
        }
    }

    public boolean isQueueFull() {
        if(start == topOfQueue + 1) {
            return true;
        } else if(start == 0 && topOfQueue == arr.length - 1){
            return true;
        } else {
            return false;
        }
    }

    public boolean isQueueEmpty() {
        if(topOfQueue == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void deleteQueue() {
        arr = null;
        System.out.println("Queue deleted successfully");
    }
}
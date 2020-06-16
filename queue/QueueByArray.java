package queue;

public class QueueByArray {
    int[] arr;
    int topOfQueue;
    int beginningOfQueue;

    public QueueByArray(int size) {
        arr = new int[size];
        topOfQueue = -1;
        beginningOfQueue = -1;
    }

    public void enqueue(int value) {
        if(isQueueFull()) {
            System.out.println("Queue overflow");;
        } else if(isQueueEmpty()) {
            beginningOfQueue++;
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("Successfully inserted "+value+" in the queue");
        } else {
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("Successfully inserted "+value+" in the queue");
        }
        printQueue();
    }

    public void dequeue() {
        if(isQueueEmpty()) {
            System.out.println("Queue underflow");
        } else {
            System.out.println("Dequeued value: " + arr[beginningOfQueue]);
            beginningOfQueue++;
            if(beginningOfQueue > topOfQueue) {
                beginningOfQueue = topOfQueue = -1;
            }
        }
        if(!isQueueEmpty())
            printQueue();
    }

    public void peek() {
        if(isQueueEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Peeking: " + arr[beginningOfQueue]);
        }
    }

    public void printQueue() {
        if(isQueueEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Printing Queue.......");
            for (int i = topOfQueue; i >= beginningOfQueue; i--) {
                System.out.println(arr[i]);
            }
        }
    }

    public boolean isQueueFull() {
        if(topOfQueue == arr.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isQueueEmpty() {
        if(beginningOfQueue == -1 || topOfQueue == arr.length) {
            return true;
        } else {
            return false;
        }
    }
}
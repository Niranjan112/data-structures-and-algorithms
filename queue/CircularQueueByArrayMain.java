package queue;

public class CircularQueueByArrayMain {
    public static void main(String[] args) {
        CircularQueueByArray queue = new CircularQueueByArray(5);

        for (int i = 1; i <= 6; i++) {
            queue.enqueue(i * 10);
        }
        queue.peek();
        queue.dequeue();
        queue.enqueue(11);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(44);
        queue.enqueue(99);
        queue.enqueue(100);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }
}
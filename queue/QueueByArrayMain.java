package queue;

public class QueueByArrayMain {
    public static void main(String[] args) {
        QueueByArray queue = new QueueByArray(5);

        for (int i = 1; i <= 6; i++) {
            queue.enqueue(i * 10);
        }

        queue.peek();

        System.out.println(queue.beginningOfQueue);
        System.out.println(queue.topOfQueue);

        for (int i = 0; i <= 5; i++) {
            queue.dequeue();
        }

        System.out.println(queue.beginningOfQueue);
        System.out.println(queue.topOfQueue);
        queue.peek();
        queue.enqueue(99);
        queue.enqueue(112);
        queue.peek();
    }
}
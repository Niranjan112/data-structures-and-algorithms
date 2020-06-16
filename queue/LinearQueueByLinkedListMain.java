package queue;

public class LinearQueueByLinkedListMain {
    public static void main(String[] args) {
        LinearQueueByLinkedList queueList = new LinearQueueByLinkedList();

        queueList.enqueue(10);
        System.out.println("Head: " + queueList.head.data + " Tail: " + queueList.tail.data);
        queueList.enqueue(20);
        System.out.println("Head: " + queueList.head.data + " Tail: " + queueList.tail.data);
        System.out.println("Peeking: " + queueList.peek());
        queueList.enqueue(30);
        System.out.println("Head: " + queueList.head.data + " Tail: " + queueList.tail.data);
        queueList.enqueue(40);
        System.out.println("Head: " + queueList.head.data + " Tail: " + queueList.tail.data);
        queueList.enqueue(50);
        System.out.println("Head: " + queueList.head.data + " Tail: " + queueList.tail.data);
        System.out.println("Peeking: " + queueList.peek());

        for (int i = 0; i <= 1; i++) {
            queueList.dequeue();
        }

        System.out.println("Peeking: " + queueList.peek());
    }
}
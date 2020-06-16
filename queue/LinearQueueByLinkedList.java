package queue;

public class LinearQueueByLinkedList {
    Node head;
    Node tail;
    int length = -1;

    public LinearQueueByLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if(length < 0) {
            System.out.println("Link list doesn't exist");
        } else {
            if(isQueueEmpty()) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            length++;
            System.out.println("Successfully added " + tail.data + " to queue");
            printQueue();
        }
    }

    public void dequeue() {
        if(isQueueEmpty()) {
            System.out.println("Queue underflow");
        } else {
            System.out.println("Dequeue value " + head.data + " from queue");
            head = head.next;
            if(length == 1) {
                tail = null;
            }
            length--;
            printQueue();
        }
    }

    public int peek() {
        if(isQueueEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            return head.data;
        }
    }

    public void printQueue() {
        if(isQueueEmpty()) {
            System.out.println("Queue is empty");
        } else {
            Node tempNode = head;
            while(tempNode != null) {
                System.out.println(tempNode);
                tempNode = tempNode.next;
            }
            System.out.println("\n");
        }
    }

    public boolean isQueueEmpty() {
        if(head == null && tail == null) {
            return true;
        } else {
            return false;
        }
    }

    public void deleteQueue() {
        head = tail = null;
    }

    class Node {
        int data;
        Node next;

        public Node(int value) {
            data = value;
            next = null;
        }

        public String toString() {
            return data + "";
        }
    }
}
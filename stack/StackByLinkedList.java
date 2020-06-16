package stack;

public class StackByLinkedList {

    SingleLinkedList list;

    public StackByLinkedList() {
        list = new SingleLinkedList();
    }

    public void push(int value) {
        list.insertNode(value);
        System.out.println("Value: " + value + " pushed to stack");
    }

    public int pop() {
        int value = -1;
        if(isStackEmpty()) {
            System.out.println("Stack underflow");
            return -1;
        } else {
            value = list.head.data;
            System.out.println("Pop value: " + value);
            list.deleteNode();
        }
        return value;
    }

    public int peek() {
        if(isStackEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return list.head.data;
        }
    }

    public void printStack() {
        if(isStackEmpty()) {
            System.out.println("Stack is empty");
        } else {
            Node tempNode = list.head;
            while(tempNode != null) {
                System.out.println(tempNode);
                tempNode = tempNode.next;
            }
            System.out.println("\n");
        }
    }

    public boolean isStackEmpty() {
        if(list.head == null) {
            return true;
        } else {
            return false;
        }
    }

    public void deleteStack() {
        list.head = null;
    }



    class SingleLinkedList {
        private Node head;
        private int length = -1;

        public SingleLinkedList() {
            head = null;
            length = 0;
        }

        public void insertNode(int nodeValue) {
            Node newNode = new Node(nodeValue);
            if(length < 0) {
                System.out.println("Linked list doesn't exist");
            } else {
                newNode.next = head;
                head = newNode;
                length++;
            }
        }

        public void deleteNode() {
            if(!existLinkedList()) {
                System.out.println("Linked list doesn't exist or empty");
            } else {
                head = head.next;
                length--;
            }
        }

        public boolean existLinkedList() {
            return head != null;
        }
    }

    class Node {
        private int data;
        private Node next;

        public Node(int value) {
            data = value;
            next = null;
        }

        public Node getNext() {
            return next;
        }

        public String toString() {
            return data + " ";
        }
    }
}
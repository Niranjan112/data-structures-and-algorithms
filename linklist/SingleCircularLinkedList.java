package linklist;

public class SingleCircularLinkedList {

    private Node head;
    private Node tail;
    private int length = -1;

    SingleCircularLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    public void insertNode(int nodeValue, int index) {

        Node newNode = new Node(nodeValue);

        if(length < 0) {
            System.out.println("Linklist does'nt exist");
        } else if(index == 0) {
            if(length == 0) {
                head = newNode;
                tail = newNode;
                head.next = newNode;
                length++;
                return;
            }
            newNode.next = head;
            head = newNode;
            tail.next = newNode;
        } else if(index >= length) {
            tail.next = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            Node tempNode = head;
            for (int i = 0; i < index - 1; i++) {
                tempNode = tempNode.next;
            }
            newNode.next = tempNode.next;
            tempNode.next = newNode;
        }
        length++;
    }

    public boolean searchNode(int nodeValue) {
        if(existLinklist()) {
            Node tempNode = head;
            for (int i = 0; i < length; i++) {
                if(tempNode.data == nodeValue) {
                    System.out.println("Value: " + tempNode.data + " found at index: " + i);
                    return true;
                }
                tempNode = tempNode.next;
            }
            System.out.println("Value: " + nodeValue + " not found");
        } else {
            System.out.println("Linklist doesn't exist or empty: from searchNode");
        }
        return false;
    }

    public void deleteNode(int index) {
        if(!existLinklist()) {
            System.out.println("Linklist doesn't exists or empty: from deleteNode");
        } else if(index == 0) {
            if(length == 1) {
                head.next = null;
                head = null;
                tail = null;
                length--;
                return;
            }
            head = head.next;
            tail.next = head;
            length--;
        } else if(index >= length - 1) {
            Node tempNode = head;
            for (int i = 0; i < length - 2; i++) {
                tempNode = tempNode.next;
            }
            if(tempNode == head) {
                head = tail = tempNode.next = null;
                length--;
                return;
            }
            tempNode.next = head;
            tail = tempNode;
            length--;
        } else {
            Node tempNode = head;
            for (int i = 0; i < index - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            length--;
        }
    }

    public void traverseLinklist() {
        if(existLinklist()) {
            Node tempNode = head;
            for (int i = 0; i < length; i++) {
                System.out.print(tempNode);
                if(i != length - 1) {
                    System.out.print("-> ");
                }
                tempNode = tempNode.next;
            }
            System.out.println("\n");
        } else {
            System.out.println("Linklist doesn't exist or empty: from traverseLinklist");
        }
    }

    public void printHeadAndTail() {
        System.out.println("Head: " + head.data);
        System.out.println("Tail: " + tail.data);
        System.out.println("Tail refering head: " + tail.next.data);
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public boolean existLinklist() {
        return head != null && tail != null;
    }

    class Node {
        public int data;
        public Node next;

        Node(int value) {
            data = value;
            next = null;
        }

        public String toString() {
            return data + " ";
        }
    }
}
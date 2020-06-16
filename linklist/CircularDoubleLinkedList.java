package linklist;

public class CircularDoubleLinkedList {

    private Node head;
    private Node tail;
    private int length = -1;

    CircularDoubleLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    public void insertNode(int nodeValue, int index) {
        Node newNode = new Node(nodeValue);
        if(length < 0) {
            System.out.println("Linked List is empty or doesn't exists: from insertNode");
        } else if(index == 0) {
            if(length == 0) {
                newNode.next = newNode.prev = newNode;
                head = newNode;
                tail = newNode;
                length++;
                return; 
            }
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        } else if(index >= length) {
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
            tail.next = newNode;
            tail = newNode;
        } else {
            Node tempNode = head;
            for (int i = 0; i < index - 1; i++) {
                tempNode = tempNode.next;
            }
            newNode.next = tempNode.next;
            newNode.prev = tempNode;
            tempNode.next = newNode;
            newNode.next.prev = newNode;
        }
        length++;
    }

    public boolean searchNode(int nodeValue) {
        if(existLinkesList()) {
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
            System.out.println("Linked List is empty or doesn't exists: from searchNode");
        }
        return false;
    }

    public void deleteNode(int index) {
        if(!existLinkesList()) {
            System.out.println("Linked List is empty or doesn't exists: from deleteNode");
        } else if(index == 0) {
            if(length == 1) {
                head.next = head.prev = head = tail = null;
                length--;
                return;
            }
            head = head.next;
            head.prev = tail;
            tail.next = head;
            length--;
        } else if(index >= length - 1) {
            if(length == 1) {
                head.next = head.prev = head = tail = null;
                length--;
                return;
            }
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
            length--; 
        } else {
            Node tempNode = head;
            for (int i = 0; i < index - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            tempNode.next.prev = tempNode;
            length--;
        }
    }

    public void traverseLinkedList() {
        if(existLinkesList()) {
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
            System.out.println("Linked List is empty or doesn't exists: from traverseLinkedList");
        }
    }

    public void reverseTraverseLinkedList() {
        if(existLinkesList()) {
            Node tempNode = tail;
            for (int i = 0; i < length; i++) {
                System.out.print(tempNode);
                if(i != length - 1) {
                    System.out.print("<- ");
                }
                tempNode = tempNode.prev;
            }
            System.out.println("\n");
        } else {
            System.out.println("Linked List is empty or doesn't exists: from reverseTraverseLinkedList");
        }
    }

    public void printHeadAndTail() {
        System.out.println("Head: " + head);
        System.out.println("Tail: " + tail);
        System.out.println("Head using Tail: " + tail.next);
        System.out.println("Tail using Head: " + head.prev);
    }

    public void deleteEntireLinkedList() {
        if(!existLinkesList()) {
            System.out.println("Already deleted");
        } else {
            Node tempNode = head;
            tail.next = null;
            while(tempNode != null) {
                tempNode.prev = null;
                tempNode = tempNode.next;
            }
            head = tail = null;
            System.out.println("Linked List deleted successfully");
        }
    }

    public boolean existLinkesList() {
        return head != null && tail != null;
    }
    
    class Node {
        private Node prev;
        private int data;
        private Node next;

        Node(int nodeValue) {
            prev = null;
            data = nodeValue;
            next = null;
        }

        public Node getPrev() {
            return prev;
        }

        public Node getNext() {
            return next;
        }

        public String toString() {
            return data + " ";
        }
    }
}
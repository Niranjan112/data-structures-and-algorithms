package linklist;

public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int length;

    DoubleLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    public void insertNode(int nodeValue, int index) {
        Node newNode = new Node(nodeValue);
        if(length < 0) {
            System.out.println("Linked list doesn't exist or empty: from insertNode");
            return;
        } else if(index == 0) {
            if(length == 0) {
                head = newNode;
                tail = newNode;
                length++;
                return;
            }
            head.prev = newNode;
            newNode.next = head;
            newNode.prev = null;
            head = newNode;
        } else if(index >= length) {
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = null;
            tail = newNode;
        } else {
            Node tempNode = head;
            for (int i = 0; i < index - 1; i++) {
                tempNode = tempNode.next;
            }
            newNode.next = tempNode.next;
            newNode.prev = tempNode;
            newNode.next.prev = newNode;
            tempNode.next = newNode;
        }
        length++;
    }

    public void traverseLinkedList() {
        if(existLinkedList()) {
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
            System.out.println("Linked list doesn't exist or empty: from traverseLinkedList");
        }
    }

    public void reverseTraverseLinkedList() {
        if(existLinkedList()) {
            Node tempNode = tail;
            for (int i = 0; i < length; i++) {
                System.out.print(tempNode);
                if(i != length - 1) {
                    System.out.print("-> ");
                }
                tempNode = tempNode.prev;
            }
            System.out.println("\n");
        } else {
            System.out.println("Linked list doesn't exist or empty: from reverseTraverseLinkedList");
        }
    }

    public boolean searchNode(int nodeValue) {
        if(existLinkedList()) {
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
            System.out.println("Linked list doesn't exist or empty: from reverseTraverseLinkedList");
        }
        return false;
    }

    public void deleteNode(int index) {
        if(!existLinkedList()) {
            System.out.println("Linked list doesn't exist or empty: from deleteNode");
        } else if(index == 0) {
            if(length == 1) {
                head = tail = null;
                length--;
                return;
            }
            head = head.next;
            head.prev = null;
            length--;
        } else if(index >= length - 1) {
            if(length == 1) {
                head = tail = null;
                length--;
                return;
            }
            tail = tail.prev;
            tail.next = null;
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

    public void deleteEntireLinkedList() {
        if(!existLinkedList()) {
            System.out.println("Already deleted");
        } else {
            Node tempNode = head;
            while(tempNode != null) {
                tempNode.prev = null;
                tempNode = tempNode.next;
            }
            head = tail = null;
            System.out.println("Linked list deleted successfully");
        }
    }


    public boolean existLinkedList() {
        return head != null && tail != null;
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
    
    class Node {
        private Node prev;
        private int data;
        private Node next;

        Node(int value) {
            prev = null;
            data = value;
            next = null;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrev() {
            return prev;
        }

        public String toString() {
            return data + " ";
        }
    }
}
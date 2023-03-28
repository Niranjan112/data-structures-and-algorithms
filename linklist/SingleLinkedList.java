package linklist;

public class SingleLinkedList {
    private Node head;
    private Node tail;
    private int length = -1;

    public SingleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addNode(int nodeValue, int index) {
        length = length == -1 ? 0 : length;
        Node newNode = new Node(nodeValue);

        if(length < 0) {
            System.out.print("Linked List doesn't exist");
            return;
        } else if(index == 0) { //inserting at first position
            newNode.next = head;
            head = newNode;
            if(length < 1) {
                tail = newNode;
            }
        } else if(index >= length) { //inserting at last
            tail.next = newNode;
            tail = newNode;
        } else { //inserting in between
            Node tempNode = head;
            for (int i = 0; i < index - 1; i++) {
                tempNode = tempNode.next;
            }
            Node nextNode = tempNode.next;
            tempNode.next = newNode;
            newNode.next = nextNode;
        }
        length++;
    }

    public void traverseLinkList() {
        if(isLinkListExist()) {
            Node tempNode = head;
            while(tempNode != null) {
                System.out.print(tempNode);
                tempNode = tempNode.next;
            }
            System.out.println("\n");
        } else {
            System.out.println("Linklist is empty");
        }
    }

    public boolean searhNode(int nodeValue) {
        if(isLinkListExist()) {
            Node tempNode = head;
            for(int i = 0; i < length; i++) {
                if(tempNode.data == nodeValue){
                    System.out.println("Value: " + tempNode.data + " at index: " + i);
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Value: " + nodeValue + " not found");
        return false;
    }

    public void deleteNodeByIndex(int index) {
        if(!isLinkListExist()) {
            System.out.println("Linklist doesn't exist");
        } else if(index == 0) { // deleting the first node
            head = head.next;
            length--;
            if(length == 0) {
                tail = null;
            }
        } else if(index >= length - 1) { // deleting the last node
            Node tempNode = head;
            for (int i = 0; i < length - 2; i++) {
                tempNode = tempNode.next;
            }
            if(tempNode == head) {
                tail = head = null;
                length--;
                return;
            }
            tempNode.next = null;
            tail = tempNode;
            length--;
        } else { // deleting the node in between
            Node tempNode = head;
            for(int i = 0; i < index - 1 ; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            length--;
        }
    }

    public void deleteNodeByValue(int nodeValue) {
        if(isLinkListExist()) {
            Node tempNode = head;
            for(int i = 0; i < length; i++) {
                if(tempNode.data == nodeValue){
                    deleteNodeByIndex(i);
                    return;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Value: " + nodeValue + " not found");
    }

    public void deleteWholeLinklist() {
        head = null;
        tail = null;
        System.out.println("Whole node deleted seccessfully");
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

    public boolean isLinkListExist() {
        return head != null && tail != null;
    }
    class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        public String toString() {
            return data + " ";
        }
    }
}

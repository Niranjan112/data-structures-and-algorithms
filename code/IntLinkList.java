package code;
public class IntLinkList {
    private Node head;

    public IntLinkList() {
        head = null;
    }

    public void addNode(int _data) {
        Node new_node = new Node(_data);
        if(head == null) {
            head = new_node;
        } else {
            Node temp = head;
            while(temp.link != null) {
                temp = temp.link;
            }
            temp.link = new_node;
            new_node.link = null;
        }
    }

    public void deleteNode(int _data) {
        if(head.data == _data) {
            head = head.link;
        } else {
            Node x = head;
            Node y = head.link;
            while(true) {
                if(y == null || y.data == _data) {
                    break;
                } else {
                    x = y;
                    y = y.link;
                }
            }
            if(y != null) {
                x.link = y.link;
            }
        }
    }

    public void printAll() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.link;
        }
    }
    class Node {
        private int data;
        private Node link;

        public Node(int _data) {
            this.data = _data;
        }
    }

    public static void main(String[] args) {
        IntLinkList list = new IntLinkList();
        list.addNode(10);
        list.addNode(20);
        list.addNode(30);
        list.addNode(40);
        list.addNode(50);
        list.printAll();
    }
}
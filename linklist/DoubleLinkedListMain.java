package linklist;

public class DoubleLinkedListMain {
    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.insertNode(10, 0);
        dll.traverseLinkedList();
        
        dll.insertNode(20, 1);
        dll.traverseLinkedList();
        
        dll.insertNode(30, 0);
        dll.traverseLinkedList();
        
        dll.insertNode(40, 3);
        dll.traverseLinkedList();
        
        dll.insertNode(50, 7);
        dll.traverseLinkedList();
        
        dll.insertNode(60, 4);
        dll.traverseLinkedList();
        
        dll.insertNode(70, 3);
        dll.traverseLinkedList();

        dll.searchNode(50);
        dll.searchNode(14);

        System.out.println("\nDeleting some node..........");
        dll.deleteNode(0);
        dll.traverseLinkedList();

        dll.deleteNode(10);
        dll.traverseLinkedList();

        dll.deleteNode(3);
        dll.traverseLinkedList();

        dll.deleteNode(2);
        dll.traverseLinkedList();

        dll.deleteNode(0);
        dll.traverseLinkedList();
        
        System.out.println("Length: " + dll.getLength());
        System.out.println("Head: " + dll.getHead());
        System.out.println("Tail: " + dll.getTail());

        dll.deleteEntireLinkedList();
        dll.deleteEntireLinkedList();

    }
}
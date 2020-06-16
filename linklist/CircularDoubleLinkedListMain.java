package linklist;

public class CircularDoubleLinkedListMain {
    public static void main(String[] args) {
        CircularDoubleLinkedList cdll = new CircularDoubleLinkedList();
        cdll.insertNode(10, 0);
        cdll.traverseLinkedList();
        cdll.printHeadAndTail();
        cdll.insertNode(20, 0);
        cdll.traverseLinkedList();
        cdll.printHeadAndTail();
        cdll.insertNode(30, 2);
        cdll.traverseLinkedList();
        cdll.printHeadAndTail();
        cdll.insertNode(40, 3);
        cdll.traverseLinkedList();
        cdll.printHeadAndTail();
        cdll.insertNode(50, 4);
        cdll.traverseLinkedList();
        cdll.printHeadAndTail();
        cdll.insertNode(60, 2);
        cdll.traverseLinkedList();
        cdll.printHeadAndTail();
        cdll.insertNode(70, 5);
        cdll.traverseLinkedList();
        cdll.printHeadAndTail();

        cdll.searchNode(40);
        cdll.searchNode(80);

        System.out.println("\nDeleting Node.........");
        cdll.deleteNode(8);
        cdll.traverseLinkedList();
        cdll.reverseTraverseLinkedList();
        cdll.printHeadAndTail();

        cdll.deleteNode(5);
        cdll.traverseLinkedList();
        cdll.reverseTraverseLinkedList();
        cdll.printHeadAndTail();

        cdll.deleteNode(2);
        cdll.traverseLinkedList();
        cdll.reverseTraverseLinkedList();
        cdll.printHeadAndTail();

        cdll.deleteNode(0);
        cdll.traverseLinkedList();
        cdll.reverseTraverseLinkedList();
        cdll.printHeadAndTail();

        cdll.deleteEntireLinkedList();
    }
}
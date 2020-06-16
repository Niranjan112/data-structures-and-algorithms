package linklist;

public class SingleCircularLinkedListMain {
    public static void main(String[] args) {
        SingleCircularLinkedList cll1 = new SingleCircularLinkedList();
        SingleCircularLinkedList cll2 = new SingleCircularLinkedList();

        cll1.insertNode(10, 0);
        cll1.traverseLinklist();
        cll1.deleteNode(10);
        cll1.traverseLinklist();
        cll1.insertNode(20, 0);
        cll1.traverseLinklist();
        cll1.insertNode(30, 0);
        cll1.traverseLinklist();
        cll1.insertNode(40, 1);
        cll1.traverseLinklist();
        cll1.insertNode(50, 3);
        cll1.traverseLinklist();
        cll1.insertNode(60, 4);
        cll1.traverseLinklist();
        cll1.printHeadAndTail();
        cll1.searchNode(60);
        cll1.searchNode(20);

        cll1.deleteNode(21);
        cll1.traverseLinklist();
        cll1.deleteNode(11);
        cll1.traverseLinklist();
        cll1.printHeadAndTail();
        // cll1.deleteNode(0);
        // cll1.traverseLinklist();
        // cll1.deleteNode(0);
        // cll1.traverseLinklist();
        // cll1.deleteNode(0);
        // cll1.traverseLinklist();
        // cll1.deleteNode(0);
        // cll1.traverseLinklist();
        // cll1.deleteNode(0);
        cll2.searchNode(10);
        cll2.traverseLinklist();
        cll2.deleteNode(10);
    }
}
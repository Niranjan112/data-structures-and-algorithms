package linklist;

public class SingleLinkedListMain {
    public static void main(String[] args) {
        SingleLinkedList ll = new SingleLinkedList();
        ll.addNode(10, 0);
        ll.traverseLinkList();
        ll.addNode(20, 1);
        ll.traverseLinkList();
        ll.addNode(30, 2);
        ll.traverseLinkList();
        ll.addNode(40, 2);
        ll.traverseLinkList();
        ll.addNode(50, 3);
        ll.traverseLinkList();
        ll.addNode(11, 0);
        ll.traverseLinkList();

        ll.searhNode(11);
        ll.searhNode(40);

        ll.deleteNodeByIndex(4);
        ll.traverseLinkList();
        ll.deleteNodeByIndex(2);
        ll.traverseLinkList();
        ll.deleteNodeByValue(99);
        ll.traverseLinkList();

        ll.deleteWholeLinklist();
        ll.traverseLinkList();
    }
}
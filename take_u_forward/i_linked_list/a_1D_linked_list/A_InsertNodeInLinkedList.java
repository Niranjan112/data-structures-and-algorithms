package take_u_forward.i_linked_list.a_1D_linked_list;

public class A_InsertNodeInLinkedList {

  public static void main(String[] args) {
    SingleLinkedList singleLinkedList = new SingleLinkedList();

    singleLinkedList.headNode = singleLinkedList.insertAtFront(singleLinkedList.headNode, 20);
    singleLinkedList.headNode = singleLinkedList.insertAtEnd(singleLinkedList.headNode, 30);
    singleLinkedList.headNode = singleLinkedList.insertAtEnd(singleLinkedList.headNode, 40);
    singleLinkedList.headNode = singleLinkedList.insertAtFront(singleLinkedList.headNode, 10);
    singleLinkedList.headNode = singleLinkedList.insertAtSpecificPos(singleLinkedList.headNode, 2, 50);

    singleLinkedList.printLinkedList();
  }

}

class SingleLinkedList {
  Node headNode;

  public Node insertAtFront(Node headNode, int valueOfNode) {

    Node newNode = new Node(valueOfNode);

    if (headNode != null) { // If the head node is not null means linked list is not empty so then only insert node at front.
      newNode.nextNode = headNode;
    }
    headNode = newNode; // Always makes the new Node as head node even if the list is empty it will make new Node as head and first element of list will be added.

    return headNode;
  }

  public Node insertAtEnd(Node headNode, int valueOfNode) {

    if(headNode == null) { // Check if head is null if yes then list is empty and make new Node as head node and return.
      headNode = new Node(valueOfNode);
      return headNode;
    }

    Node tempNode = headNode;
    while(tempNode.nextNode != null) { // Iterate until we get Node's next node as null.
      tempNode = tempNode.nextNode;
    }

    tempNode.nextNode = new Node(valueOfNode); // Assign new Node to last Node's next Node.

    return headNode;
  }

  public Node insertAtSpecificPos(Node headNode, int position, int valueOfNode) {

    Node newNode = new Node(valueOfNode);

    if(headNode == null) { // If head node is null then just make new node as head and return.
      headNode = newNode;
      return headNode;
    }

    if(position == 1) { // If position is 1 then add new node before head node and make new node as head and return.
      newNode.nextNode = headNode;
      headNode = newNode;
      return headNode;
    }

    // Iterate till 1 node before the give position Node.
    // Doing i = 1 till i < position - 1
    // Because first traverse is done by making tempNode = headNode, and we have to go till 1 Node before the actual position.
    Node tempNode = headNode;
    for (int i = 1; i < position - 1; i++) {
      tempNode = tempNode.nextNode;
    }

    newNode.nextNode = tempNode.nextNode; // Assign temp Node next to new Node next.
    tempNode.nextNode = newNode; // Then make tempNode next to new Node.

    return headNode;
  }

  public void printLinkedList() {

    Node currentNode = headNode;

    while (currentNode != null) {

      System.out.print("Node(" + currentNode.data + ")");
      currentNode = currentNode.nextNode;

      if (currentNode != null) {
        System.out.print(" -> ");
      }
    }
    System.out.println(" -> null");
  }
}

class Node {
  int data;
  Node nextNode;

  Node(int _data) {
    this.data = _data;
    nextNode = null;
  }
}

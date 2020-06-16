
package binarySearchTree;

public class BinarySearchTreeByLinkedListMain {
    public static void main(String[] args) {

        BinarySearchTreeByLinkedList binaryTree = new BinarySearchTreeByLinkedList();

        binaryTree.insert(100);
        binaryTree.levelOrderTraversal();
        binaryTree.insert(90);
        binaryTree.levelOrderTraversal();
        binaryTree.insert(80);
        binaryTree.levelOrderTraversal();
        binaryTree.insert(95);
        binaryTree.levelOrderTraversal();
        binaryTree.insert(195);
        binaryTree.levelOrderTraversal();
        binaryTree.insert(120);
        binaryTree.levelOrderTraversal();

        binaryTree.searchNode(195);

        binaryTree.deleteNode(90);
        binaryTree.levelOrderTraversal();

        binaryTree.deleteNode(20);
    }
}
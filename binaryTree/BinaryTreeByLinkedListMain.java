package binaryTree;

public class BinaryTreeByLinkedListMain {
    public static void main(String[] args) {
        BinaryTreeByLinkedList bt = new BinaryTreeByLinkedList();
        for (int i = 1; i <= 8; i++) {
            bt.insertNode(i * 10);
            bt.levelOrder();
        }

        bt.searchNode(11);
        bt.searchNode(70);
        bt.searchNode(40);

        bt.deleteNode(80);
        bt.levelOrder();

        bt.deleteNode(10);
        bt.levelOrder();

        bt.deleteNode(30);
        bt.levelOrder();

        System.out.println("Post order:");
        bt.postOrderTraversal(bt.root);
        System.out.println("\n\nPre order:");
        bt.preOrderTraversal(bt.root);
        System.out.println("\n\nIn order:");
        bt.inOrderTraversal(bt.root);
    }
}
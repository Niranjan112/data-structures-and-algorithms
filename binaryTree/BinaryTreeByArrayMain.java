package binaryTree;

public class BinaryTreeByArrayMain {
    public static void main(String[] args) {
        BinaryTreeByArray tree = new BinaryTreeByArray(10);

        for(int i = 1; i <= 6; i++) {
            tree.insert(i * 10);
            tree.levelOrderTraversal();
        }

        tree.search(40);

        tree.delete(30);
        tree.levelOrderTraversal();

        System.out.println("In Order Traversal");
        tree.inOrderTraversal(1);
        System.out.println("\nPost Order Traversal");
        tree.postOrderTraversal(1);
        System.out.println("\nPre Order Traversal");
        tree.preOrderTraversal(1);
    }
}
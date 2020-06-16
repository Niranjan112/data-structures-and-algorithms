package avlTree;

public class AVLTreeMain {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(10);
        tree.insert(5);
        tree.insert(3);
        tree.insert(4);
        tree.insert(50);
        tree.insert(60);
        tree.insert(70);
        tree.insert(65);

        tree.levelOrderTraversal();

        tree.deleteNode(50);
        tree.levelOrderTraversal();
        tree.deleteNode(20);
        tree.levelOrderTraversal();
        tree.deleteNode(40);
        tree.levelOrderTraversal();
        tree.deleteNode(30);
        tree.levelOrderTraversal();
    }

}
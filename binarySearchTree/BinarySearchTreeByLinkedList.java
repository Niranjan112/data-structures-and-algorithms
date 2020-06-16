package binarySearchTree;

import java.util.*;
public class BinarySearchTreeByLinkedList {
    public Node root;

    public BinarySearchTreeByLinkedList() {
        root = null;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    Node insert(Node currenttNode, int value) {
        if(currenttNode == null) {
            System.out.println("Successfully inserted node: " + value);
            return createNewNode(value);
        } else if(value <= currenttNode.data) {
            currenttNode.left = insert(currenttNode.left, value);
            return currenttNode;
        } else {
            currenttNode.right = insert(currenttNode.right, value);
            return currenttNode;
        }
    }

    public Node createNewNode(int value) {
        Node newNode = new Node(value);
        return newNode;
    }

    public void searchNode(int value) {
        searchNode(root, value);
    }

    public Node searchNode(Node currentNode, int value) {
        if(currentNode == null) {
            System.out.println("Value " + value + " not found");
            return null;
        } else if(currentNode.data == value) {
            System.out.println("Value " + value + " found in tree");
            return currentNode;
        } else if(value < currentNode.data) {
            return searchNode(currentNode.left, value);
        } else {
            return searchNode(currentNode.right, value);
        }
    }

    public void deleteNode(int value) {
        deleteNode(root, value);
    }

    public Node deleteNode(Node root, int value) {
        if(root == null) {
            System.out.println("Value: " + value + " node not found");
            return null;
        } else if(value < root.data) {
            root.left = deleteNode(root.left, value);
        } else if(value > root.data) {
            root.right = deleteNode(root.right, value);
        } else {
            if(root.left != null && root.right != null) {
                Node temp = root;
                Node minimumNodeOfRight = minimumElement(temp.right);
                root.data = minimumNodeOfRight.data;
                root.right = deleteNode(root.right, minimumNodeOfRight.data);
            } else if(root.left != null) {
                root = root.left;
            } else if(root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }
        return root;
    }

    public Node minimumElement(Node root) {
        if(root.left == null) {
            return root;
        } else {
            return minimumElement(root.left);
        }
    }

    public void levelOrderTraversal() {
        if(root == null) {
            System.out.println("Tree doesn't exists");
        } else {
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            while(!queue.isEmpty()) {
                Node presentNode = queue.remove();
                System.out.print(presentNode + " ");
                if(presentNode.left != null) {
                    queue.add(presentNode.left);
                }
                if(presentNode.right != null) {
                    queue.add(presentNode.right);
                }
            }
            System.out.println("\n");
        }
    }

    public void deleteTree() {
        root = null;
        System.out.println("Tree deleted successfully");
    }

    class Node{
        private int data;
        private Node left;
        private Node right;

        Node(int nodeValue) {
            data = nodeValue;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public String toString() {
            return data + " ";
        }
    }
}
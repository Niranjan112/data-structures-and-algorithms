package binaryTree;

import java.util.*;

public class BinaryTreeByLinkedList {

    public Node root;

    public BinaryTreeByLinkedList() {
        root = null;
    }

    public  void insertNode(int nodeValue) {
        Node newNode = new Node(nodeValue);
        if(root == null) {
            root = newNode;
            System.out.println("Successfully inserted new node " + root.data + " at Root !");
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node presentNode = queue.remove();
            if(presentNode.left == null) {
                presentNode.left = newNode;
                System.out.println("Successfully inserted new node " + presentNode.left.data + " at left !");
                break;
            } else if(presentNode.right == null) {
                presentNode.right = newNode;
                System.out.println("Successfully inserted new node " + presentNode.right.data + " at right !");
                break;
            } else {
                queue.add(presentNode.left);
                queue.add(presentNode.right);
            }
        }
        System.out.println("Queue: " + queue);
    }

    public void searchNode(int value) {
        if(root == null) {
            System.out.println("Binary tree doesn't exist: from searchNode");
        } else {
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            while(!queue.isEmpty()) {
                Node presentNode = queue.remove();
                if(presentNode.data == value) {
                    System.out.println("Node: "+ presentNode.data + " found");
                    return;
                } else {
                    if(presentNode.left != null)
                        queue.add(presentNode.left);
                    if(presentNode.right != null)
                        queue.add(presentNode.right);
                }
            }
            System.out.println("Node: " + value + " not found");
        }
    }

    public void deleteNode(int value) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node presentNode = queue.remove();
            if(presentNode.data == value) {
                presentNode.data = getDeepestNode().data;
                deleteDeepestNode();
                System.out.println("Deleted node: " + value+ " from tree");
                return;
            } else {
                if(presentNode.left != null) {
                    queue.add(presentNode.left);
                }
                if(presentNode.right != null) {
                    queue.add(presentNode.right);
                }
            }
        }
        System.out.println("Value: " + value+ " is not present in tree");
    }

    public void deleteDeepestNode() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        Node previousNode, presentNode = null;
        while(!queue.isEmpty()) {
            previousNode = presentNode;
            presentNode = queue.remove();
            if(presentNode.left == null) {
                previousNode.right = null;
                return;
            } else if(presentNode.right == null) {
                presentNode.left = null;
                return;
            }
            queue.add(presentNode.left);
            queue.add(presentNode.right);
        }
    }

    public Node getDeepestNode() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        Node presentNode = null;
        while(!queue.isEmpty()) {
            presentNode = queue.remove();
            if(presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if(presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
        return presentNode;
    }

    public void levelOrder() {
        if(root == null) {
            System.out.println("Binary tree doesn't exist: from levelOrder");
        } else {
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            while(!queue.isEmpty()) {
                Node presentNode = queue.remove();
                System.out.print(presentNode);
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

    public void preOrderTraversal(Node node) {
        if(node == null)
            return;
        System.out.print(node);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void postOrderTraversal(Node node) {
        if(node == null)
            return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node);
    }

    public void inOrderTraversal(Node node) {
        if(node == null)
            return;
        inOrderTraversal(node.left);
        System.out.print(node);
        inOrderTraversal(node.right);
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
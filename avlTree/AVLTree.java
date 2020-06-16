package avlTree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {

    Node root;

    public AVLTree() {
        root = null;
    }

    public void insert(int value) {
        root  = insert(root, value);
    }

    public Node insert(Node currentNode, int value) {
        if(currentNode == null) {
            System.out.println("Successfully inserted " + value + " in AVL Tree");
            return createNewNode(value);
        } else if(value <= currentNode.getData()) {
            currentNode.setLeft(insert(currentNode.getLeft(), value));
        } else {
            currentNode.setRight(insert(currentNode.getRight(), value));
        }

        int balance = checkBalance(currentNode.getLeft(), currentNode.getRight());

        if(balance > 1) {
            if(checkBalance(currentNode.getLeft().getLeft(), currentNode.getLeft().getRight()) > 0) {
                currentNode = rightRotate(currentNode); // LL condition
            } else {
                currentNode.setLeft(leftRotate(currentNode.getLeft())); // LR condition
                currentNode = rightRotate(currentNode);
            }
        }
        if(balance < -1) {
            if(checkBalance(currentNode.getRight().getRight(), currentNode.getRight().getLeft()) > 0) {
                currentNode = leftRotate(currentNode); // RR condition
            } else {
                currentNode.setRight(rightRotate(currentNode.getRight()));
                currentNode = leftRotate(currentNode);
            }
        }

        if(currentNode.getLeft() != null) {
            currentNode.getLeft().setHeight(calculateHeight(currentNode.getLeft()));
        }
        if(currentNode.getRight() != null) {
            currentNode.getRight().setHeight(calculateHeight(currentNode.getRight()));
        }
        currentNode.setHeight(calculateHeight(currentNode));
        return currentNode;
    }

    public void deleteNode(int value) {
        System.out.println("\nDeleting " + value + " from AVL Tree ...");
        root = deleteNode(root, value);
    }

    public Node deleteNode(Node currentNode, int value) {
        if(currentNode == null) {
            return null;
        } else if( value < currentNode.getData() ) {
            currentNode.setLeft(deleteNode(currentNode.getLeft(), value));
        } else if( value > currentNode.getData() ) {
            currentNode.setRight(deleteNode(currentNode.getRight(), value));
        } else {
            if( currentNode.getLeft() != null && currentNode.getRight() != null) {
                Node temp = currentNode;
                Node minimumNodeValue = minimumElement(temp.getRight());
                currentNode.setData(minimumNodeValue.getData());
                deleteNode(currentNode.getRight(), minimumNodeValue.getData());
            } else if(currentNode.getLeft() != null) {
                currentNode = currentNode.getLeft();
            } else if(currentNode.getRight() != null) {
                currentNode = currentNode.getRight();
            } else {
                currentNode = null;
            }
            return currentNode;
        }

        int balance = checkBalance(currentNode.getLeft(), currentNode.getRight());

        if(balance > 1) {
            if(checkBalance(currentNode.getLeft().getLeft(), currentNode.getLeft().getRight()) > 0) {
                currentNode = rightRotate(currentNode);
            } else {
                currentNode.setLeft(leftRotate(currentNode.getLeft()));
                currentNode = rightRotate(currentNode);
            }
        }

        if(balance < -1) {
            if(checkBalance(currentNode.getRight().getRight(), currentNode.getRight().getLeft()) > 0) {
                currentNode = leftRotate(currentNode);
            } else {
                currentNode.setRight(rightRotate(currentNode.getRight()));
                currentNode = leftRotate(currentNode);
            }
        }

        if(currentNode.getLeft() != null) {
            currentNode.getLeft().setHeight(calculateHeight(currentNode.getLeft()));
        }
        if(currentNode.getRight() != null) {
            currentNode.getRight().setHeight(calculateHeight(currentNode.getRight()));
        }

        currentNode.setHeight(calculateHeight(currentNode));
        return currentNode;
    }

    public Node minimumElement(Node root) {
        if(root.getLeft() == null) {
            return root;
        } else {
            return minimumElement(root.getLeft());
        }
    }

    public int checkBalance(Node rootLeft, Node rootRight) {
        if(rootLeft == null && rootRight == null) {
            return 0;
        } else if(rootLeft == null) {
            return -1 * (rootRight.getHeight() + 1);
        } else if(rootRight == null) {
            return rootLeft.getHeight() + 1;
        } else {
            return rootLeft.getHeight() - rootRight.getHeight();
        }
    }

    public Node rightRotate(Node currentNode) {
        Node newRoot = currentNode.getLeft();
        currentNode.setLeft(currentNode.getLeft().getRight());
        newRoot.setRight(currentNode);
        currentNode.setHeight(calculateHeight(currentNode));
        newRoot.setHeight(calculateHeight(newRoot));
        return newRoot;
    }

    public Node leftRotate(Node currentNode) {
        Node newRoot = currentNode.getRight();
        currentNode.setRight(currentNode.getRight().getLeft());
        newRoot.setLeft(currentNode);
        currentNode.setHeight(calculateHeight(currentNode));
        newRoot.setHeight(calculateHeight(newRoot));
        return newRoot;
    }

    public int calculateHeight(Node currentNode) {
        if(currentNode == null) {
            return 0;
        } else {
            return 1 + Math.max((currentNode.getLeft() != null ? currentNode.getLeft().getHeight() : -1),
                        (currentNode.getRight() != null ? currentNode.getRight().getHeight() : -1));
        }
    }

    public Node createNewNode(int value) {
        Node newNode = new Node();
        newNode.setData(value);
        newNode.setHeight(0);
        return newNode;
    }

    public void levelOrderTraversal() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        System.out.println("Printing Level order traversal of AVL Tree...");
        if(root == null) {
            System.out.println("Tree does not exists !");
            return;
        }
        while(!queue.isEmpty()) {
            Node presentNode = queue.remove();
            System.out.print(presentNode.getData() + " ");
            if(presentNode.getLeft() != null) {
                queue.add(presentNode.getLeft());
            }
            if(presentNode.getRight() != null) {
                queue.add(presentNode.getRight());
            }
        }
    }

    class Node {
        int height;
        Node left;
        Node right;
        int data;

        public int getHeight() {
            return height;
        }

        public int getData() {
            return data;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
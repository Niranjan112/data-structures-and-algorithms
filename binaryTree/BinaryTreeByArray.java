package binaryTree;

public class BinaryTreeByArray {
    int[] arr;
    int lastIndex;

    public BinaryTreeByArray(int size) {
        arr = new int[size + 1];
        lastIndex = 0;
        System.out.println("Successfully created array of size: " + size);
    }

    public void insert(int value) {
        if(isTreeFull()) {
            System.out.println("Could not insert value in the Tree as it is full");
        } else {
            arr[lastIndex + 1] = value;
            lastIndex++;
            System.out.println("Successfully inserted value: " + value + " at index: " + lastIndex);
        }
    }

    public int search(int value) {
        for (int i = 0; i < lastIndex; i++) {
            if(value == arr[i]) {
                System.out.println("Value: " + arr[i] + " found at index: " + i);
                return i;
            } 
        }
        System.out.println("Value: " + value + " doesn't exists");
        return -1;
    }

    public void delete(int value) {
        int location = search(value);
        if(location == -1) {
            System.out.println("Value: " + value + " is not in the Tree");
            return;
        } else {
            arr[location] = arr[lastIndex];
            lastIndex--;
            System.out.println("Value: " + value + " deleted successfully");
        }
    }

    public void levelOrderTraversal() {
        for (int i = 1; i <= lastIndex; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }

    public void preOrderTraversal(int index) {
        if(index > lastIndex)
            return;
        System.out.print(arr[index] + " ");
        preOrderTraversal(index * 2);
        preOrderTraversal(index * 2 + 1);
    }

    public void postOrderTraversal(int index) {
        if(index > lastIndex)
            return;
        postOrderTraversal(index * 2);
        postOrderTraversal(index * 2 + 1);
        System.out.print(arr[index] + " ");
    }

    public void inOrderTraversal(int index) {
        if(index > lastIndex)
            return;
        inOrderTraversal(index * 2);
        System.out.print(arr[index] + " ");
        inOrderTraversal(index * 2 + 1);
    }

    public boolean isTreeFull() {
        if(arr.length - 1 == lastIndex) {
            return true;
        } else {
            return false;
        }
    }

    public void deleteTree() {
        arr = null;
        System.out.println("Array deleted successfully");
    }
}
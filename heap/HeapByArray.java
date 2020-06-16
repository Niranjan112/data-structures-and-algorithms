package heap;

public class HeapByArray {
    int arr[];
    int sizeOfTree;

    public HeapByArray(int size) {
        arr = new int[size + 1];
        sizeOfTree = 0;
        System.out.println("Empty heap has been created");
    }

    public int sizeOfArray() {
        return arr.length;
    }

    public boolean isHeapEmpty() {
        if(sizeOfTree <= 0) {
            System.out.println("Tree is empty !");
            return true;
        } else {
            System.out.println("Tree is not empty !");
            return false;
        }
    }

    public void deleteHeap() {
        arr = null;
        System.out.println("Heap has been deleted !");
    }

    public void insert(int value) {
        System.out.println("Inserting " + value + " in Heap...");
        arr[sizeOfTree + 1] = value;
        sizeOfTree++;
        heapifyBottomToTop(sizeOfTree);
        System.out.println("Inserted " + value + " successfully in Heap !");
		levelOrder();
    }

    public void heapifyBottomToTop(int index) {
        int parent = index / 2;
        if(index <= 1) {
            return;
        }
        if(arr[index] < arr[parent]) {
            int temp = arr[index];
            arr[index] = arr[parent];
            arr[parent] = temp;
        }
        heapifyBottomToTop(parent);
    }

    public int extractTopOfHeap() {
        if(isHeapEmpty()) {
            System.out.println("Heap is empty !");
			return -1;
        } else {
            System.out.println("Head of the Heap is: " + arr[1]);
            System.out.println("Extracting it now...");
            int extractedValue = arr[1];
            arr[1] = arr[sizeOfTree];
            sizeOfTree--;
            heapifyTopToBottom(1);
            System.out.println("Successfully extracted value from Heap.");
			levelOrder();
            return extractedValue;
        }
    }

    public void heapifyTopToBottom(int index) {
        int left = index * 2;
        int right = index * 2 + 1;
        int smallestChild = 0;

        if(sizeOfTree < left) {
            return;
        } else if(sizeOfTree == left) {
            if(arr[index] > arr[left]) {
                int temp = arr[index];
                arr[index]  = arr[left];
                arr[left] = temp;
            }
            return;
        } else {
            if(arr[left] < arr[right]) {
                smallestChild = left;
            } else {
                smallestChild = right;
            }

            if(arr[index] > arr[smallestChild]) {
                int temp = arr[index];
                arr[index] = arr[smallestChild];
                arr[smallestChild] = temp;
            }
        }
        heapifyTopToBottom(smallestChild);
    }

    public void levelOrder() {
        System.out.println("Printing all the elements of this Heap...");
        for (int i = 1; i <= sizeOfTree; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }
}
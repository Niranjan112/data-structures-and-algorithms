package heap;

public class HeapByArrayMain {
    public static void main(String[] args) {
        HeapByArray heap = new HeapByArray(10);

        heap.insert(100);
		heap.insert(90);
		heap.insert(80);
		heap.insert(70);
		heap.insert(60);
		heap.insert(50);
		heap.insert(40);
		heap.insert(30);
		heap.insert(20);
		
		heap.extractTopOfHeap();
		
		heap.insert(110);
		heap.extractTopOfHeap();
    }
}
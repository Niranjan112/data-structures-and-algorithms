package code;
public class IntQueue {
    private int[] queue;
    private int size;
    private int total;
    private int rear;
    private int front;

    public IntQueue(int _size) {
        this.size = _size;
        front = 0;
        rear = 0;
        total = 0;
        queue = new int[this.size];
    }

    public boolean isFull() {
        return size == total;
    }

    public boolean enqueue(int _item) {
        if(!isFull()) {
            total++;
            queue[rear] = _item;
            rear = (rear + 1) % size;
            return true;
        } else{
            return false;
        }
    }

    public int dequeue() {
        int item = queue[front];
        total--;
        front = (front + 1) % size;
        return item;
    }

    public void showAll() {
        int f = front;
        if(total != 0) {
            for (int i = 0; i < total; i++) {
                System.out.println(f + " " + queue[f]);
                f = (f + 1) % size;
            }
        }
    }

    public static void main(String[] args) {
        IntQueue q = new IntQueue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.dequeue();
        q.dequeue();
        q.enqueue(60);
        q.enqueue(70);
        q.showAll();
    }
}
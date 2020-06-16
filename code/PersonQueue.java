package code;
class Person {
    public String name;
    private int roll_no;

    public Person(String _name, int _roll_no) {
        this.name = _name;
        this.roll_no = _roll_no;
    }

    public String toString() {
        return "Name: " + this.name + " Roll NO: " + this.roll_no;
    }
}

public class PersonQueue {
    private Person[] queue;
    private int size;
    private int total;
    private int rear;
    private int front;

    public PersonQueue(int _size) {
        this.size = _size;
        front = 0;
        rear = 0;
        total = 0;
        queue = new Person[this.size];
    }

    public boolean isFull() {
        return size == total;
    }

    public boolean enqueue(Person _item) {
        if(!isFull()) {
            total++;
            queue[rear] = _item;
            rear = (rear + 1) % size;
            return true;
        } else{
            return false;
        }
    }

    public Person dequeue() {
        Person item = queue[front];
        total--;
        front = (front + 1) % size;
        return item;
    }

    public void showAll() {
        int f = front;
        if(total != 0) {
            for (int i = 0; i < total; i++) {
                System.out.println(queue[f]);
                f = (f + 1) % size;
            }
        }
    }

    public static void main(String[] args) {
        PersonQueue q = new PersonQueue(5);
        q.enqueue(new Person("Niranjan", 29));
        q.enqueue(new Person("John", 44));
        q.enqueue(new Person("Deep", 44));
        q.enqueue(new Person("Jack", 44));
        q.dequeue();
        q.dequeue();
        q.showAll();
    }
}
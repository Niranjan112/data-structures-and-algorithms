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

public class PersonStack {
    private Person[] stack;
    private int top;
    private int size;
    
    public PersonStack() {
        top = -1;
        size = 50;
        stack  = new Person[size];
    }

    public PersonStack(int _size) {
        top = -1;
        this.size = _size;
        stack  = new Person[this.size];
    }

    public boolean push(Person _item) {
        if(!isFull()) {
            top++;
            stack[top] = _item;
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        return (stack.length - 1 == size);
    }

    public Person pop() {
        return stack[top--];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public static void main(String[] args) {
        Person p1 = new Person("Niranjan", 29);
        Person p2 = new Person("John", 12);

        PersonStack s = new PersonStack();
        s.push(p1);
        s.push(p2);
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
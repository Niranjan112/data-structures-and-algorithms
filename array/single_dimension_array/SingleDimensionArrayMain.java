package array.single_dimension_array;

public class SingleDimensionArrayMain {
    public static void main(String[] args) {
        System.out.println("Main: Created Empty Array");
        SingleDimensionArray sda = new SingleDimensionArray(5);
        sda.traverseArray();
        sda.insert(0, 10);
        sda.insert(1, 20);
        sda.insert(2, 30);
        sda.insert(3, 40);
        sda.insert(4, 50);
        System.out.println("Main: Array after inserting value");
        sda.traverseArray();
        System.out.println("Main: Getting 4th value");
        sda.getValue(3);
        System.out.println("Main: Trying to get -1 index value");
        sda.getValue(-1);
        System.out.println("Main: Searching for 20");
        sda.searchValue(20);
        System.out.println("Main: Trying to search 11");
        sda.searchValue(11);
        System.out.println("Main: Deleting value of 1st location");
        sda.deleteValue(0);
        System.out.println("Main: After Deleting 1st location");
        sda.traverseArray();
        System.out.println("Main: Deleting the whole Array");
        sda.deleteWholeArray();
        System.out.println("Main: After Deleting whole array");
        sda.traverseArray();
    }
}
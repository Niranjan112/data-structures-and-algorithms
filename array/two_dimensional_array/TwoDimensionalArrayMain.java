package array.two_dimensional_array;

public class TwoDimensionalArrayMain {
    public static void main(String[] args) {
        TwoDimensionalArray tda = new TwoDimensionalArray(2, 3);
        tda.traverseArray();
        tda.insertValue(0, 0, 12);
        tda.insertValue(0, 1, 67);
        tda.insertValue(0, 2, 31);
        tda.insertValue(1, 0, 90);
        tda.insertValue(1, 1, 100);
        tda.insertValue(1, 2, 113);
        tda.traverseArray();
        tda.accessArrayElement(0, 1);
        tda.accessArrayElement(10, 10);
        tda.searchValue(11);
        tda.searchValue(111);
        tda.deleteFromArray(0, 0);
        tda.traverseArray();
    }
}
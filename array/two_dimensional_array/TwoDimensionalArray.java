package array.two_dimensional_array;

public class TwoDimensionalArray {
    int[][] arr = null;

    public TwoDimensionalArray(int rowSize, int colSize) {
        arr = new int[rowSize][colSize];
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    public void traverseArray() {
        try {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        } catch(Exception e) {
            System.out.println("Array does not exist");
        }
    }

    public void insertValue(int rowIndex, int colIndex, int value) {
        try {
            if(arr[rowIndex][colIndex] == Integer.MIN_VALUE) {
                arr[rowIndex][colIndex] = value;
                System.out.println("Value: " + value + " inserted at Row: " + rowIndex + " Column: " + colIndex);
            } else {
                System.out.println("Already occupied");
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index");
        }
    }

    public void accessArrayElement(int rowIndex, int colIndex) {
        try {
            System.out.println();
            System.out.println("Value: " + arr[rowIndex][colIndex] + " is at Row: " + rowIndex + " Column: " + colIndex);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index");
        }
    }

    public void searchValue(int value) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == value) {
                    System.out.println("Value: " + value + " found at Row: " + i + " Column: " + j);
                }
            }
        }
        System.out.println("Value: " + value + " not found");
    }

    public void deleteFromArray(int rowIndex, int colIndex) {
        try {
            System.out.println("Value: " + arr[rowIndex][colIndex] + " deleted from Row: " + rowIndex + " Column: " + colIndex);
            arr[rowIndex][colIndex] = Integer.MIN_VALUE;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid Index");
        }
    }

    public void deleteWholeArray() {
        arr = null;
        System.out.println("Array deleted successfully");
    }
}
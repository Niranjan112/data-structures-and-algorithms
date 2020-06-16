package array.single_dimension_array;

class SingleDimensionArray {
    int[] arr = null;

    public SingleDimensionArray(int sizeOfArray) {
        arr = new int[sizeOfArray];
        for(int i = 0;i < arr.length; i++) {
            arr[i] = Integer.MIN_VALUE;
        }
    }

    public void traverseArray() {
        try {
            for(int i = 0;i < arr.length; i++) {
                System.out.print(arr[i]+" ");
            }
        } catch(Exception e) {
            System.out.println("Array does not exist");
            // e.printStackTrace();
        }
        System.out.println("");
    }

    public void insert(int location, int value) {
        try {
            if(arr[location] == Integer.MIN_VALUE) {
                arr[location] = value;
                System.out.println("Value " + value + " inserted at location:" + location);
            } else {
                System.out.println("Location: " + location + " already occupied");
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bound");
        }
    }

    public void getValue(int location) {
        try {
            System.out.println(arr[location]);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid location");
        }
    }

    public void searchValue(int valueToSearch) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == valueToSearch) {
                System.out.println("Value " + valueToSearch + " at index " + i);
                return;
            }
        }
        System.out.println("Value " + valueToSearch + " not found");
    }

    public void deleteValue(int location) {
        try {
            arr[location] = Integer.MIN_VALUE;
        } catch(Exception e) {
            System.out.println("Invalid index");
        }
    }

    public void deleteWholeArray() {
        arr = null;
        System.out.println("Array deleted successfully");
    }
}
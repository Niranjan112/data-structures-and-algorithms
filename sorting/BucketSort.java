package sorting;

import java.util.*;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr = new int[100];
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            arr[i] = random.nextInt(100) + 100;
        }

        int numberOfBucket = (int) Math.ceil(Math.sqrt(arr.length));
        int maxValue = Integer.MIN_VALUE;

        ArrayList<Integer>[] buckets = new ArrayList[numberOfBucket];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        for(int value: arr) {
            if(value > maxValue) {
                maxValue = value;
            }
        }

        for(int value: arr) {
            int bucketNumber = (int) Math.ceil((value * numberOfBucket) / maxValue);
            buckets[bucketNumber - 1].add(value);
        }

        System.out.println("Sorting and Printing all buckets");
        for(ArrayList<Integer> b: buckets) {
            Collections.sort(b);
            System.out.println(b);
        }

        int index = 0;
        for(ArrayList<Integer> bucket: buckets) {
            for(int value: bucket) {
                arr[index] = value;
                index++;
            }
        }

        System.out.println("\nFinal Sorted Array");
        System.out.println(Arrays.toString(arr));
    }
}
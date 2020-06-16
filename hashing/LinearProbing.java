package hashing;

import java.util.ArrayList;

public class LinearProbing {
    String[] hashTable;
    int noOfCellsUsedInHashTable;

    LinearProbing() {
        hashTable = new String[13];
        noOfCellsUsedInHashTable = 0;
    }

    public int simpleAsciiHashFunction(String x, int M) {
        char ch[] = x.toCharArray();
        int sum = 0;
        for(char c: ch) {
            sum += c;
        }
        return sum % M;
    }

    public double getLoadFactor() {
        double loadFactor = noOfCellsUsedInHashTable * 1.0 / hashTable.length;
        return loadFactor;
    }

    public void insertKeyInHashTable(String value) {

        double loadFactor = getLoadFactor();

        if(loadFactor >= 0.75) {
            System.out.println("Load factor of this HashTable has exceeded 0.75, hence we need to Rehash !\n");
            rehashKeys(value);
        } else {
            System.out.println("Inserting \"" + value + "\" in HashTable...");
            int index = simpleAsciiHashFunction(value, hashTable.length);

            for (int i = index; i < index + hashTable.length; i++) {

                int newIndex = i % hashTable.length;
                if(hashTable[newIndex] == null) {
                    hashTable[newIndex] = value;
                    System.out.println("Index: " + newIndex + " is blank. Inserting there...");
                    System.out.println("Successfully inserted " + "\"" + value + "\"" + " in location: " + newIndex);
                    System.out.println("-------------------------------------------\n");
                    break;
                } else {
                    System.out.println("Index: " + newIndex + " is already occupied. Trying next empty cell...");
                }
            }
        }
        noOfCellsUsedInHashTable++;
    }

    public void rehashKeys(String newValue) {
        noOfCellsUsedInHashTable = 0;
        ArrayList<String> data = new ArrayList<String>();

        for(String s: hashTable) {
            if(s != null) {
                data.add(s);
            }
        }

        data.add(newValue);
        hashTable = new String[hashTable.length * 2];

        for(String s: data) {
            insertKeyInHashTable(s);
        }
    }

    public boolean searchKeyInHashTable(String value) {
        int index = simpleAsciiHashFunction(value, hashTable.length);

        for (int i = 0; i < index + hashTable.length; i++) {
            
            int newIndex = i % hashTable.length;
            if(hashTable[newIndex] != null && hashTable[newIndex].equals(value)) {
                System.out.println("\n" + "\"" + value + "\"" + " found in HashTable at location: " + newIndex);
                return true;
            }
        }

        System.out.println("\n" + "\"" + value + "\"" + " not found in HashTable.");
        return false;
    }

    public void deleteKeyFromHashTable(String value) {
        int index = simpleAsciiHashFunction(value, hashTable.length);

        for (int i = 0; i < index + hashTable.length; i++) {
            
            int newIndex = i % hashTable.length;
            if(hashTable[newIndex] != null && hashTable[newIndex].equals(value)) {
                hashTable[newIndex] = null;
                System.out.println("\n" + "\"" + value + "\"" + " has been found in HashTable." );
                System.out.println("\"" + value + "\"" + " has been deleted from HashTable !" );
                return;
            }
        }

        System.out.println("\nCould not find " + "\"" + value + "\"" + " in HashTable");
    }

    public void displayHashTable() {
        if(hashTable == null) {
            System.out.println("\nHashTable does not exits !");
            return;
        } else {
            System.out.println("\n---------- HashTable ---------");
            for (int i = 0; i < hashTable.length; i++) {
                System.out.println("Index:" + i + ".   Key:" + hashTable[i]);
            }
        }
        System.out.println("\n");
    }

    public void deleteHashTable() {
        System.out.println("Successfully deleted HashTable !");
        hashTable = null;
    }
}
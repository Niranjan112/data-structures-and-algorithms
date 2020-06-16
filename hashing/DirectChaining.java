package hashing;

import java.util.LinkedList;

public class DirectChaining {
    
    LinkedList<String>[] hashTable;

    DirectChaining() {
        hashTable = new LinkedList[13];
    }

    public int simpleAsciiHashFunction(String x, int M) {
        char ch[] = x.toCharArray();
        int sum = 0;
        for(char c: ch) {
            sum += c;
        }
        return sum % M;
    }

    public void insertKeyInHashTable(String value) {
        int index = simpleAsciiHashFunction(value, hashTable.length);

        if(hashTable[index] == null) {
            hashTable[index] = new LinkedList<String>();
            hashTable[index].add(value);
            System.out.println("\nInserted " + value + " at index: " + index);
        } else {
            hashTable[index].add(value);
            System.out.println("\nInserted " + value + " at index: " + index);
        }
    }

    public boolean searchKeyInHashTable(String value) {
        int index = simpleAsciiHashFunction(value, hashTable.length);
        if(hashTable[index] != null && hashTable[index].contains(value)) {
            System.out.println("\n" + "\"" + value + "\"" + " found in HashTable at location: "+index);
            return true;
        } else {
            System.out.println("\n" + "\"" + value + "\"" + " not found in HashTable.");
            return false;
        }
    }

    public void deleteKeyFromHashTable(String value) {
        if(searchKeyInHashTable(value)) {
            int index = simpleAsciiHashFunction(value, hashTable.length);
            hashTable[index].remove(value);
            System.out.println("\"" + value + "\"" + " has been deleted from HashTable !" );
        } else {
            System.out.println("\nCould not find " + "\"" + value + "\"" + " in HashTable");
        }
    }

    public void displayHashTable() {
        if(hashTable == null) {
            System.out.println("\nHashTable does not exits !");
        } else {
            System.out.println("\n---------- HashTable ---------");
            for (int i = 0; i < hashTable.length; i++) {
                System.out.println(i + " : " + hashTable[i]);
            }
        }
    }

    public void deleteHashTable() {
        hashTable = null;
        System.out.println("Successfully deleted HashTable !");
    }
}
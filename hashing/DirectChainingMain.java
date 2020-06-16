package hashing;

public class DirectChainingMain {
    public static void main(String[] args) {
        DirectChaining directChaining = new DirectChaining();

        directChaining.insertKeyInHashTable("hat");
        directChaining.insertKeyInHashTable("mat");
        directChaining.insertKeyInHashTable("lit");
        directChaining.insertKeyInHashTable("bit");
        directChaining.insertKeyInHashTable("quick");
        directChaining.insertKeyInHashTable("fox");
        directChaining.displayHashTable();

        directChaining.deleteKeyFromHashTable("lit");
        directChaining.searchKeyInHashTable("lit");
        directChaining.searchKeyInHashTable("fox");
        directChaining.displayHashTable();
    }
}
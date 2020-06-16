package hashing;

public class LinearProbingMain {
    public static void main(String[] args) {
        LinearProbing lb = new LinearProbing();

        lb.insertKeyInHashTable("The");
        lb.insertKeyInHashTable("quick");
        lb.insertKeyInHashTable("brown");
        lb.insertKeyInHashTable("fox");
        lb.insertKeyInHashTable("over");
        lb.insertKeyInHashTable("lazy");

        lb.displayHashTable();
        lb.searchKeyInHashTable("quick");

        lb.deleteKeyFromHashTable("over");
        lb.searchKeyInHashTable("over");
        lb.displayHashTable();
    }
}
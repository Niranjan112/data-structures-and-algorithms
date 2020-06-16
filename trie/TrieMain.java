package trie;

public class TrieMain {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("air");
        trie.insert("aio");
        trie.insert("arr");
        trie.search("arr");
        trie.delete("arr");
        trie.search("arr");
        trie.search("aik");
        trie.search("hello");
    }
}
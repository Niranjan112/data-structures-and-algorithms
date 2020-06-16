package trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private final TrieNode root;

    private class TrieNode {
        Map<Character, TrieNode> charEntry;
        boolean endOfWord;

        TrieNode() {
            charEntry = new HashMap<>();
            endOfWord = false;
        }
    }

    Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currentNode = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode newNode = currentNode.charEntry.get(ch);
            if(newNode == null) {
                newNode = new TrieNode();
                currentNode.charEntry.put(ch, newNode);
            }
            currentNode = newNode;
        }

        currentNode.endOfWord = true;
        System.out.println("Successfully inserted " + word + " in Trie !");
    }

    public boolean search(String word) {
        TrieNode currentNode = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = currentNode.charEntry.get(ch);
            if(node == null) {
                System.out.println("Word: " + word + " does not exists in Trie !");
                return false;
            }
            currentNode = node;
        }

        if(currentNode.endOfWord) {
            System.out.println("Word: " + word + " exists in Trie !");
        } else {
            System.out.println("Word: " + word + " does not exists in Trie ! But this is a Prefix of another Word !");
        }

        return currentNode.endOfWord;
    }

    public void delete(String word) {
        if(search(word) == true) {
            delete(root, word, 0);
        }
    }

    public boolean delete(TrieNode parentNode, String word, int index) {

        char ch = word.charAt(index);
        TrieNode currentNode = parentNode.charEntry.get(ch);

        boolean canThisNodeBeDeleted;

        if(currentNode.charEntry.size() > 1) {
            delete(currentNode, word, index + 1);
            return false;
        }

        if(index == word.length() - 1) {
            if(currentNode.charEntry.size() >= 1) {
                currentNode.endOfWord = false;
                return false;
            } else {
                System.out.println("Character " + ch + " has no dependency, hence deleting it from last");
                parentNode.charEntry.remove(ch);
                return true;
            }
        }

        if(currentNode.endOfWord) {
            delete(currentNode, word, index + 1);
            return false;
        }

        canThisNodeBeDeleted = delete(currentNode, word, index + 1);
        if(canThisNodeBeDeleted) {
            System.out.println("Character " + ch + " has no dependency, hence deleting it");
            parentNode.charEntry.remove(ch);
            return true;
        } else {
            return false;
        }
    }
}
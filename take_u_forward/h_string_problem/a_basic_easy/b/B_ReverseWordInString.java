package take_u_forward.h_string_problem.a_basic_easy.b;

import java.util.ArrayList;
import java.util.List;

public class B_ReverseWordInString {

  public static void main(String[] args) {
    String sentence = "the sky is blue";
    bruteForceApproach(sentence);
    optimalApproach(sentence);
  }

  public static void bruteForceApproach(String sentence) {
    List<String> words = new ArrayList<>(); // List to store words separated by space
    StringBuilder word = new StringBuilder(); // To store word of a sentence.
    StringBuilder finalSentence = new StringBuilder(); // To store final sentence result.

    for (int i = 0; i < sentence.length(); i++) { // Iterate over all char in sentence
      char currentChar = sentence.charAt(i);

      if(sentence.charAt(i) != ' ') { // If it not a space then add char to word
        word.append(currentChar);
      } else if (!word.isEmpty()) { // If it is a space then add last collected word to words list
        words.add(word.toString());
        word = new StringBuilder(); // Reset/Empty to store new word
      }
    }

    // Just check if word is still not empty then also add pending word in words list.
    // This can happen in example like when there is no space at end in input sentence.
    if(!word.isEmpty()) {
      words.add(word.toString());
    }

    // Iterate over all stored words and from last and append it to finalSentence with a space
    for (int i = words.size() - 1; i >= 0; i--) {
      String currentWord = words.get(i);
      finalSentence.append(currentWord);

      if(i != 0) { // If it is the last word that is getting added then don't put space
        finalSentence.append(" ");
      }
    }

    System.out.println("[Brute] Result String: " + finalSentence.toString());
  }

  public static void optimalApproach(String sentence) {

    StringBuilder word = new StringBuilder(); // To store word of a sentence
    StringBuilder finalSentence = new StringBuilder(); // To store actual reversed sentence

    for (int i = sentence.length() - 1; i >= 0; i--) { // Start from last char to first char
      char currentChar = sentence.charAt(i);

      if(currentChar != ' ') { // If current char is not a space then keep adding it to the word.
        word.append(currentChar);
      } else if(!word.isEmpty()) { // Once the current char is a space, and we have collected the word before space so now add reversed word to the final sentence.
        finalSentence.append(word.reverse()).append(" ");
        word = new StringBuilder(); // Reset the word to empty to collect new word.
      }
    }

    // Just check if word is still not empty then also add pending word in reversed order.
    // This can happen in example like when there is no space at start in input sentence.
    if(!word.isEmpty()) {
      finalSentence.append(word.reverse());
    }

    // According to our algo there can be one space at end in final sentence if input sentence has multiple space at end.
    // If it's there then remove it.
    if(finalSentence.charAt(finalSentence.length() - 1) == ' ') {
      finalSentence.deleteCharAt(finalSentence.length() - 1);
    }

    System.out.println("[Optimal] Result String: " + finalSentence.toString());
  }

}

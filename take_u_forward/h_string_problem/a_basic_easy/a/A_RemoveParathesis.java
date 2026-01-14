package take_u_forward.h_string_problem.a_basic_easy.a;

import java.util.Stack;

public class A_RemoveParathesis {

  public static void main(String[] args) {
    String inputString = "(()())(())(()(()))";

    solution(inputString); // TC: O(n) and SC: O(1)
    solutionUsingStack(inputString); // TC: O(n) and SC: O(1)
  }

  private static void solution(String inputString) {
    StringBuilder result = new StringBuilder();
    int level = 0;

    char openBracket = '(';
    char closeBracket = ')';

    for (char ch : inputString.toCharArray()) {

      if(ch == openBracket) {

        if(level > 0) { // If it's first open bracket at level 0 then ignore to append it
          result.append(openBracket);
        }

        level++; // Increase the level if it's open bracket.
      } else if(ch == closeBracket) {

        level--; // If it's close bracket first decrease the level.

        if(level > 0) { // Now check if level is still greater than 0 and then append it
          result.append(closeBracket);
        }
      }
    }

    System.out.println("Result: " + result.toString());
  }

  private static void solutionUsingStack(String inputString) {
    Stack<Character> stack = new Stack<>();

    StringBuilder result = new StringBuilder();

    char openBracket = '(';
    char closeBracket = ')';

    for (char ch : inputString.toCharArray()) {

      if(ch == openBracket) {

        if(!stack.isEmpty()) { // If Stack is not empty then only append open bracket to result.
          result.append(openBracket);
        }

        stack.push(openBracket); // Always push open bracket at last.
      } else if(ch == closeBracket) {

        stack.pop(); // Pop the open bracket from stack first as it got paired with closing bracket.

        if(!stack.isEmpty()) { // Now check if stack is not empty then only append close bracket to result.
          result.append(closeBracket);
        }
      }
    }

    System.out.println("Result: " + result.toString());
  }
}

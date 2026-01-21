package take_u_forward.h_string_problem.a_basic_easy.c;

public class C_LargestOddNumInString {

  public static void main(String[] args) {
    System.out.println("Largest odd num in str: " + solution("35427"));
  }

  public static String solution(String num) {
    int index = -1;

    // Here we're starting from last because while starting from last when we get first odd number that will be our biggest odd number as sub string.
    for (int i = num.length() - 1; i >= 0; i--) {

      // When both character ASCII value is subtracted it will give actual numeric value which is in char.
      // For example, check image in this package
      int numericValue = num.charAt(i) - '0';

      if(numericValue % 2 == 1) { // if we found odd number then take the index of it and stop.
        index = i;
        break;
      }
    }

    if(index == -1) { // If we didn't get any odd num then return -1;
      return "";
    } else { // If we got odd number then return sub string from 0 to last odd num index + 1
      return num.substring(0, index + 1);
    }
  }
}

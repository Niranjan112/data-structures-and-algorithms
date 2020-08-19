package code;

public class PowerSet {
  public static void main(String args[]) {
      char arr[] = {'a','b','c','d'};
      System.out.println((1 << arr.length));
      
      for(int i = 0; i < (1 << arr.length); i++) {
          for(int j = 0; j < arr.length; j++) {
              if((i & (1 << j)) > 0) {
                  System.out.print(arr[j]);
              }
          }
          System.out.println();
      }
  }
}
package take_u_forward.g_binary_search.b_answer.i;

import java.util.Arrays;

public class I_BookAllocation {

  public static void main(String[] args) {
    int[] books = {25, 46, 28, 49, 24};
    int numberOfStudents = 4;

    System.out.println("Min pages can be allocated to a student with max number of books is: " + bruteForce(books, numberOfStudents));
    System.out.println("Min pages can be allocated to a student with max number of books is: " + optimalApproach(books, numberOfStudents));
  }

  private static int bruteForce(int[] books, int numberOfStudents) {
    if(numberOfStudents > books.length) { // Return because as per question every student should have at least one book
      return -1;
    }

    int maxPagesOfBook = Arrays.stream(books).max().getAsInt(); // Get max pages of a book to start to search for answer
    int sumOfAllBookPages = Arrays.stream(books).sum(); // Sum of all book pages can be the end to stop searching

    for (int minPagesStudentCanHave = maxPagesOfBook; minPagesStudentCanHave <= sumOfAllBookPages; minPagesStudentCanHave++) {
      int countOfStudentGotBook = getCountOfStudentGotBook(books, minPagesStudentCanHave);

      // Note: Check img edge_case_exp.jpg explanation to understand why we check for <= instead of exact ==
      if(countOfStudentGotBook <= numberOfStudents) {
        return minPagesStudentCanHave;
      }
    }

    return maxPagesOfBook;
  }

  private static int getCountOfStudentGotBook(int[] books, int minPagesStudentCanHave) {
    int studentCount = 1; // Initially start with studentCount as 1 as first book will always be allocated
    int pagesAllocated = 0; // Var to track pages allocated to each student.

    for (int pagesOfBook: books) {

      // If pages allocated till now + current pages is still below or equal to min pages we give to student then keep giving more books to the student
      if(pagesAllocated + pagesOfBook <= minPagesStudentCanHave) {
        pagesAllocated += pagesOfBook;
      } else { // Else if it more than min pages allowed then we are done with giving the books to that student
        studentCount++; // Increase the count of student considering we will book to new student now
        pagesAllocated = pagesOfBook; // Also put current book pages to that student to track
      }
    }

    return studentCount;
  }

  public static int optimalApproach(int[] books, int numberOfStudents) {
    // If numbers of students are more than books, impossible
    if (numberOfStudents > books.length) {
      return -1;
    }

    int low = Arrays.stream(books).max().getAsInt();
    int high = Arrays.stream(books).sum();

    int answer = -1;

    while (low <= high) {
      int mid = (low + high) / 2;

      int countOfStudentGotBook = getCountOfStudentGotBook(books, mid);

      if (countOfStudentGotBook <= numberOfStudents) {
        // Valid allocation, let's search for more min pages as answer on left side
        high = mid - 1;
        answer = mid;
      } else {
        // Too many students count, need larger page limit to reduce number of students
        low = mid + 1;
      }
    }

    return answer;
  }
}

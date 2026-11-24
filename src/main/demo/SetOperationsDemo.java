package demo;

import java.util.Arrays;
import practice.SetOperations;

/** A demo of SetOperations on the notes' example, A = {1, 2, 3, 4} and B = {3, 4, 5}. */
public final class SetOperationsDemo {

  private SetOperationsDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    int[] setA = {1, 2, 3, 4};
    int[] setB = {3, 4, 5};
    System.out.println("A: " + Arrays.toString(setA));
    System.out.println("B: " + Arrays.toString(setB));

    // Expect [1, 2, 3, 4, 5].
    System.out.println("union: " + Arrays.toString(SetOperations.union(setA, setB)));

    // Expect [3, 4].
    System.out.println("intersection: " + Arrays.toString(SetOperations.intersection(setA, setB)));

    // Expect [1, 2].
    System.out.println("difference: " + Arrays.toString(SetOperations.difference(setA, setB)));

    // Both arrays are sorted, so the sorted methods apply too. Expect [3, 4].
    System.out.println(
        "sorted intersection: " + Arrays.toString(SetOperations.sortedIntersection(setA, setB)));

    // Expect [1, 2].
    System.out.println(
        "sorted difference: " + Arrays.toString(SetOperations.sortedDifference(setA, setB)));
  }
}

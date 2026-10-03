package practice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/** Tests for the union of two unsorted arrays. */
public class UnionTest {

  @Test
  public void bothArraysEmpty() {
    assertContents(new int[] {},
        SetOperations.union(new int[] {}, new int[] {}));
  }

  @Test
  public void firstArrayEmpty() {
    assertContents(new int[] {5, 3, 4},
        SetOperations.union(new int[] {}, new int[] {5, 3, 4}));
  }

  @Test
  public void secondArrayEmpty() {
    assertContents(new int[] {2, 1, 3},
        SetOperations.union(new int[] {2, 1, 3}, new int[] {}));
  }

  @Test
  public void disjointArraysGiveFirstThenSecond() {
    assertContents(new int[] {4, 1, 9, 2},
        SetOperations.union(new int[] {4, 1}, new int[] {9, 2}));
  }

  @Test
  public void identicalArraysGiveOneCopy() {
    assertContents(new int[] {3, 1, 2},
        SetOperations.union(new int[] {3, 1, 2}, new int[] {3, 1, 2}));
  }

  @Test
  public void sameValuesInADifferentOrderGiveFirstArray() {
    assertContents(new int[] {3, 1, 2},
        SetOperations.union(new int[] {3, 1, 2}, new int[] {2, 3, 1}));
  }

  @Test
  public void sharedValuesAppearOnce() {
    assertContents(new int[] {1, 2, 3, 4, 5},
        SetOperations.union(new int[] {1, 2, 3, 4}, new int[] {3, 4, 5}));
  }

  @Test
  public void newValuesKeepTheirOrderInSecondArray() {
    assertContents(new int[] {4, 1, 3, 9, 2},
        SetOperations.union(new int[] {4, 1, 3}, new int[] {3, 9, 1, 2}));
  }

  // Asserts that actual holds exactly the expected values, in order.
  private static void assertContents(int[] expected, int[] actual) {
    assertEquals(expected.length, actual.length);
    for (int i = 0; i < expected.length; i++) {
      assertEquals(expected[i], actual[i]);
    }
  }
}

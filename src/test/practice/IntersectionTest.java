package practice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/** Tests for the intersection of two unsorted arrays. */
public class IntersectionTest {

  @Test
  public void bothArraysEmpty() {
    assertContents(new int[] {},
        SetOperations.intersection(new int[] {}, new int[] {}));
  }

  @Test
  public void firstArrayEmpty() {
    assertContents(new int[] {},
        SetOperations.intersection(new int[] {}, new int[] {1, 2, 3}));
  }

  @Test
  public void secondArrayEmpty() {
    assertContents(new int[] {},
        SetOperations.intersection(new int[] {1, 2, 3}, new int[] {}));
  }

  @Test
  public void disjointArraysGiveEmpty() {
    assertContents(new int[] {},
        SetOperations.intersection(new int[] {1, 3, 5}, new int[] {2, 4, 6}));
  }

  @Test
  public void identicalArraysGiveOneCopy() {
    assertContents(new int[] {1, 2, 3},
        SetOperations.intersection(new int[] {1, 2, 3}, new int[] {1, 2, 3}));
  }

  @Test
  public void sharedValuesAreKept() {
    assertContents(new int[] {3, 4},
        SetOperations.intersection(new int[] {1, 2, 3, 4}, new int[] {3, 4, 5}));
  }

  @Test
  public void operandOrderDoesNotMatter() {
    assertContents(new int[] {3, 4},
        SetOperations.intersection(new int[] {3, 4, 5}, new int[] {1, 2, 3, 4}));
  }

  @Test
  public void secondArrayInsideFirst() {
    assertContents(new int[] {2, 4},
        SetOperations.intersection(new int[] {1, 2, 3, 4, 5}, new int[] {2, 4}));
  }

  @Test
  public void onlySharedValueAtTheEndOfBoth() {
    assertContents(new int[] {9},
        SetOperations.intersection(new int[] {1, 5, 9}, new int[] {2, 9}));
  }

  @Test
  public void resultKeepsTheOrderOfFirstArray() {
    assertContents(new int[] {4, 1, 3},
        SetOperations.intersection(new int[] {4, 1, 3}, new int[] {3, 9, 1, 4}));
  }

  // Asserts that actual holds exactly the expected values, in order.
  private static void assertContents(int[] expected, int[] actual) {
    assertEquals(expected.length, actual.length);
    for (int i = 0; i < expected.length; i++) {
      assertEquals(expected[i], actual[i]);
    }
  }
}

package practice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/** Tests for the difference of two unsorted arrays. */
public class DifferenceTest {

  @Test
  public void bothArraysEmpty() {
    assertContents(new int[] {},
        SetOperations.difference(new int[] {}, new int[] {}));
  }

  @Test
  public void firstArrayEmpty() {
    assertContents(new int[] {},
        SetOperations.difference(new int[] {}, new int[] {1, 2, 3}));
  }

  @Test
  public void secondArrayEmptyGivesFirstArray() {
    assertContents(new int[] {1, 2, 3},
        SetOperations.difference(new int[] {1, 2, 3}, new int[] {}));
  }

  @Test
  public void disjointArraysGiveFirstArray() {
    assertContents(new int[] {1, 3, 5},
        SetOperations.difference(new int[] {1, 3, 5}, new int[] {2, 4, 6}));
  }

  @Test
  public void identicalArraysGiveEmpty() {
    assertContents(new int[] {},
        SetOperations.difference(new int[] {1, 2, 3}, new int[] {1, 2, 3}));
  }

  @Test
  public void sharedValuesAreRemoved() {
    assertContents(new int[] {1, 2},
        SetOperations.difference(new int[] {1, 2, 3, 4}, new int[] {3, 4, 5}));
  }

  @Test
  public void swappedOperandsGiveADifferentResult() {
    assertContents(new int[] {5},
        SetOperations.difference(new int[] {3, 4, 5}, new int[] {1, 2, 3, 4}));
  }

  @Test
  public void firstArrayInsideSecondGivesEmpty() {
    assertContents(new int[] {},
        SetOperations.difference(new int[] {2, 4}, new int[] {1, 2, 3, 4, 5}));
  }

  @Test
  public void resultKeepsTheOrderOfFirstArray() {
    assertContents(new int[] {1, 7},
        SetOperations.difference(new int[] {4, 1, 3, 7}, new int[] {3, 9, 4}));
  }

  // Asserts that actual holds exactly the expected values, in order.
  private static void assertContents(int[] expected, int[] actual) {
    assertEquals(expected.length, actual.length);
    for (int i = 0; i < expected.length; i++) {
      assertEquals(expected[i], actual[i]);
    }
  }
}

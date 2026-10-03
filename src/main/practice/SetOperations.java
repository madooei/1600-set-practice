package practice;

/** Solutions to the set operations problem, on arrays that hold sets. */
public final class SetOperations {

  private SetOperations() {
    // This class should not be instantiated!
  }

  // Returns a new array holding every value that is in arr1 or in arr2, each
  // value once: the values of arr1 in their order, then the values of arr2
  // that are not in arr1, in their order. Assumes arr1 and arr2 are not null
  // and have no duplicate values of their own.
  public static int[] union(int[] arr1, int[] arr2) {
    int[] result = new int[arr1.length + arr2.length];
    int k = 0;
    for (int i = 0; i < arr1.length; i++) {
      result[k++] = arr1[i];
    }
    for (int j = 0; j < arr2.length; j++) {
      if (!contains(arr1, arr2[j])) {
        result[k++] = arr2[j];
      }
    }
    return trim(result, k);
  }

  // Returns a new array holding the values that are in both arr1 and arr2, in
  // the order they have in arr1. Assumes arr1 and arr2 are not null and have
  // no duplicate values of their own.
  public static int[] intersection(int[] arr1, int[] arr2) {
    int[] result = new int[arr1.length];
    int k = 0;
    for (int i = 0; i < arr1.length; i++) {
      if (contains(arr2, arr1[i])) {
        result[k++] = arr1[i];
      }
    }
    return trim(result, k);
  }

  // Returns a new array holding the values that are in arr1 but not in arr2,
  // in the order they have in arr1. Assumes arr1 and arr2 are not null and
  // have no duplicate values of their own.
  public static int[] difference(int[] arr1, int[] arr2) {
    int[] result = new int[arr1.length];
    int k = 0;
    for (int i = 0; i < arr1.length; i++) {
      if (!contains(arr2, arr1[i])) {
        result[k++] = arr1[i];
      }
    }
    return trim(result, k);
  }

  // Returns a new sorted array holding the values that are in both arr1 and
  // arr2. Assumes arr1 and arr2 are not null, are sorted, and have no
  // duplicate values of their own.
  public static int[] sortedIntersection(int[] arr1, int[] arr2) {
    int[] result = new int[arr1.length];
    int i = 0, j = 0, k = 0;
    while (i < arr1.length && j < arr2.length) {
      if (arr1[i] < arr2[j]) {
        i++;                      // in arr1 only: skip
      } else if (arr1[i] > arr2[j]) {
        j++;                      // in arr2 only: skip
      } else {
        result[k++] = arr1[i++];  // a tie: in both, copy the value once
        j++;
      }
    }
    return trim(result, k);
  }

  // Returns a new sorted array holding the values that are in arr1 but not in
  // arr2. Assumes arr1 and arr2 are not null, are sorted, and have no
  // duplicate values of their own.
  public static int[] sortedDifference(int[] arr1, int[] arr2) {
    int[] result = new int[arr1.length];
    int i = 0, j = 0, k = 0;
    while (i < arr1.length && j < arr2.length) {
      if (arr1[i] < arr2[j]) {
        result[k++] = arr1[i++];  // in arr1, not in arr2: copy
      } else if (arr1[i] > arr2[j]) {
        j++;                      // in arr2 only: skip
      } else {
        i++;                      // a tie: in both, exclude
        j++;
      }
    }
    while (i < arr1.length) {
      result[k++] = arr1[i++];    // what is left of arr1 is not in arr2
    }
    return trim(result, k);
  }

  // Returns true if value is in arr.
  private static boolean contains(int[] arr, int value) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == value) {
        return true;
      }
    }
    return false;
  }

  // Returns a new array holding the first length values of arr.
  private static int[] trim(int[] arr, int length) {
    int[] trimmed = new int[length];
    for (int t = 0; t < length; t++) {
      trimmed[t] = arr[t];
    }
    return trimmed;
  }
}

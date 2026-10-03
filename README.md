# Set — Practice

One practice problem. `SetOperations` computes the union, intersection, and difference of two sets, where each set is given as an `int` array with no duplicate values. Each operation is written for unsorted arrays, and intersection and difference are written again for sorted arrays as a two-pointer walk like the merge.

## Prerequisites

- JDK 17+
- The JUnit jar is already vendored in `lib/`; there is nothing to download.

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  lib/
    junit-platform-console-standalone-6.1.0.jar
  src/
    main/
      practice/
        SetOperations.java              # union, intersection, difference on arrays
    test/
      practice/
        UnionTest.java
        IntersectionTest.java
        DifferenceTest.java
        SortedIntersectionTest.java
        SortedDifferenceTest.java
  scripts/
    test.sh                             # compile and run every JUnit test
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh practice.SortedIntersectionTest` — compiles everything and runs only that test class. Use this while you are working on one operation and the others are still empty.

There is no demo program for this problem; the tests are how you check your work.

## What's here

- `practice.SetOperations` — `union`, `intersection`, and `difference` for two unsorted arrays, and `sortedIntersection` and `sortedDifference` for two sorted arrays. Every method returns a new array and leaves its inputs unchanged. The union of two sorted arrays is not repeated here; it is `SortedUnion.union` in the merge sort practice code.
- `practice.UnionTest`, `practice.IntersectionTest`, `practice.DifferenceTest` — tests for the three operations on unsorted arrays.
- `practice.SortedIntersectionTest`, `practice.SortedDifferenceTest` — tests for the two operations on sorted arrays.

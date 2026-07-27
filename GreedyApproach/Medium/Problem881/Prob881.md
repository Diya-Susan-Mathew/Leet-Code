# LeetCode 881 -- Boats to Save People

## Problem

You are given an array `people` where `people[i]` is the weight of the
`i`th person and an integer `limit` representing the maximum weight a
boat can carry.

-   Each boat can carry **at most two people**.
-   The combined weight of the two people cannot exceed `limit`.

Return the **minimum number of boats** required to carry everyone.

------------------------------------------------------------------------

## Intuition

To minimize the number of boats:

1.  Sort the array in ascending order.
2.  Keep two pointers:
    -   `left` → lightest person
    -   `right` → heaviest person
3.  The heaviest person **must** take a boat.
4.  If the lightest person can fit with the heaviest person, place them
    together.
5.  Otherwise, the heaviest person goes alone.
6.  Continue until everyone has been assigned a boat.

This greedy strategy always gives the minimum number of boats.

------------------------------------------------------------------------

## Algorithm

1.  Sort the array.
2.  Initialize:
    -   `left = 0`
    -   `right = people.length - 1`
    -   `boats = 0`
3.  While `left <= right`:
    -   If `people[left] + people[right] <= limit`
        -   Pair them.
        -   Increment `left`.
    -   Decrement `right` (heaviest person is always used).
    -   Increment `boats`.
4.  Return `boats`.

------------------------------------------------------------------------

## Java Solution

``` java
import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            boats++;
        }

        return boats;
    }
}
```

------------------------------------------------------------------------

## Dry Run

### Input

``` text
people = [3, 2, 2, 1]
limit = 3
```

After sorting:

``` text
[1, 2, 2, 3]
```

  Left   Right   Pair            Boats
  ------ ------- --------------- -------
  1      3       No (1+3 \> 3)   1
  1      2       Yes (1+2 = 3)   2
  2      2       Single 2        3

Answer:

``` text
3
```

------------------------------------------------------------------------

## Why This Greedy Approach Works

-   The heaviest remaining person cannot be paired with anyone heavier.
-   The only possible beneficial pairing is with the lightest remaining
    person.
-   If even the lightest person cannot fit with the heaviest, then the
    heaviest must go alone.
-   Therefore, trying any other pairing cannot reduce the number of
    boats.

------------------------------------------------------------------------

# Complexity Analysis

### Time Complexity

-   Sorting the array takes **O(n log n)**.
-   The two-pointer traversal scans the array once, taking **O(n)**.

Overall:

``` text
O(n log n)
```

------------------------------------------------------------------------

### Space Complexity

-   Ignoring the space used by the sorting algorithm, the algorithm uses
    only a few variables.

Auxiliary space:

``` text
O(1)
```

> Note: Java's `Arrays.sort()` for primitive arrays may use a small
> amount of stack space due to its implementation, but the algorithm
> itself requires constant extra space.

------------------------------------------------------------------------

## Key Pattern

-   **Greedy**
-   **Two Pointers**
-   **Sorting**

This is a classic example of combining **sorting** with the
**two-pointer greedy technique** to achieve the optimal solution.

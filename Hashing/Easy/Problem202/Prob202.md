# LeetCode 202 -- Happy Number

## Problem

A **happy number** is defined by the following process:

1.  Replace the number by the **sum of the squares of its digits**.
2.  Repeat the process.
3.  If the number eventually becomes **1**, it is a happy number.
4.  If the process enters a cycle that never reaches 1, it is not.

Return `true` if `n` is a happy number, otherwise return `false`.

------------------------------------------------------------------------

# Intuition

Each transformation produces another positive integer.

There are only two possibilities:

-   The sequence eventually reaches **1**.
-   The sequence starts repeating a previously seen number, forming a
    cycle.

So the main challenge is detecting whether a cycle exists.

------------------------------------------------------------------------

# Approach 1 -- Brute Force (No Cycle Detection)

## Idea

Keep generating the next number until:

-   you reach `1`, or
-   you stop after some arbitrary number of iterations.

### Drawback

There is no guarantee that a non-happy number will stop before the
chosen limit, so this approach is unreliable.

### Time Complexity

Not well-defined (depends on chosen limit).

### Space Complexity

    O(1)

------------------------------------------------------------------------

# Approach 2 -- HashSet (Cycle Detection)

## Idea

Store every number generated during the process.

-   If we reach `1`, return `true`.
-   If a number appears again, we have entered a cycle, so return
    `false`.

This is the approach used in your solution.

## Java Solution

``` java
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while ((n != 1) && (!set.contains(n))) {
            set.add(n);
            n = getNext(n);
        }

        return n == 1;
    }

    private int getNext(int n) {
        int totalSum = 0;

        while (n > 0) {
            int digit = n % 10;
            totalSum += digit * digit;
            n = n / 10;
        }

        return totalSum;
    }
}
```

### Dry Run

    n = 19

    19 -> 82
    82 -> 68
    68 -> 100
    100 -> 1

    Answer = true

------------------------------------------------------------------------

# Approach 3 -- Floyd's Cycle Detection (Fast & Slow Pointer)

## Idea

Instead of storing visited numbers:

-   Slow pointer moves one step.
-   Fast pointer moves two steps.

If:

-   fast reaches `1` → Happy Number.
-   slow == fast → Cycle exists.

### Java Code

``` java
class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        return fast == 1;
    }

    private int getNext(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }
}
```

------------------------------------------------------------------------

# Complexity Analysis

  -----------------------------------------------------------------------
  Approach                       Time               Space
  ------------------------------ ------------------ ---------------------
  Brute Force                    Not guaranteed     O(1)

  HashSet                        O(log n) per       O(log n)
                                 transformation,    
                                 effectively        
                                 constant           
                                 iterations         

  Floyd's Cycle Detection        O(log n) per       O(1)
                                 transformation,    
                                 effectively        
                                 constant           
                                 iterations         
  -----------------------------------------------------------------------

### Why O(log n)?

For each transformation:

-   We process every digit once.
-   A number with `d` digits has:

```{=html}
<!-- -->
```
    d = O(log n)

Therefore:

    getNext() = O(log n)

The sequence quickly falls below a small constant (for 32-bit integers,
at most 810 after one step for large values), so only a constant number
of transformations occur.

Thus the overall complexity is commonly written as:

-   **Time:** `O(log n)`
-   **Space:** `O(log n)` for the HashSet approach.
-   **Space:** `O(1)` for Floyd's algorithm.

------------------------------------------------------------------------

# Key Pattern

-   Hashing
-   Cycle Detection
-   Floyd's Tortoise and Hare
-   Digit Manipulation

------------------------------------------------------------------------

# Key Insight

The problem is **not** about repeatedly calculating digit squares.

The real challenge is **detecting whether the generated sequence enters
a cycle**. The HashSet approach detects the cycle by remembering
previous numbers, while Floyd's algorithm detects the same cycle using
two pointers without extra memory.

# LeetCode 697: Degree of an Array

## Problem

Given an integer array `nums`, find the length of the shortest contiguous subarray that has the same degree as `nums`.

The **degree** of an array is the highest frequency of any element in it.

## Java Solution
ßß
```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findShortestSubArray(int[] nums) {
        // Map to store the index of the first occurrence of each number
        Map<Integer, Integer> firstSeen = new HashMap<>();

        // Map to store the frequency count of each number
        Map<Integer, Integer> counts = new HashMap<>();

        int degree = 0;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // Record the first time we see this number
            if (!firstSeen.containsKey(num)) {
                firstSeen.put(num, i);
            }

            // Update the frequency count
            counts.put(num, counts.getOrDefault(num, 0) + 1);
            int currentCount = counts.get(num);

            // Case 1: We found a number with a higher frequency (new degree)
            if (currentCount > degree) {
                degree = currentCount;
                minLength = i - firstSeen.get(num) + 1;
            }
            // Case 2: Another number matches the current maximum degree
            else if (currentCount == degree) {
                minLength = Math.min(
                    minLength,
                    i - firstSeen.get(num) + 1
                );
            }
        }

        return minLength;
    }
}
```

## Explanation

### 1. `firstSeen` map

Stores the first index where each number appears.

For example, in `[1, 2, 2, 3, 1]`:

| Number | First index |
|---|---:|
| 1 | 0 |
| 2 | 1 |
| 3 | 3 |

### 2. `counts` map

Stores how many times each number has appeared while iterating through the array.

For `[1, 2, 2, 3, 1]`, the final frequencies are:

| Number | Frequency |
|---|---:|
| 1 | 2 |
| 2 | 2 |
| 3 | 1 |

The degree of this array is `2`.

### 3. `degree`

Tracks the highest frequency seen so far.

- If `currentCount > degree`, a new degree has been found.
- If `currentCount == degree`, the number may provide a shorter subarray with the same degree.

### 4. `minLength`

Tracks the shortest subarray length found so far.

The length for the current number is:

```java
i - firstSeen.get(num) + 1
```

Here:
- `i` is the current (last) index.
- `firstSeen.get(num)` is the first index of the number.
- `+ 1` is needed because array indices start at `0`.

## Example Walkthrough

Input:

```java
nums = [1, 2, 2, 3, 1]
```

| Index `i` | Number | Frequency so far | Degree | Current span length | `minLength` |
|---:|---:|---:|---:|---:|---:|
| 0 | 1 | 1 | 1 | 1 | 1 |
| 1 | 2 | 1 | 1 | 1 | 1 |
| 2 | 2 | 2 | 2 | 2 | 2 |
| 3 | 3 | 1 | 2 | 1 | 2 |
| 4 | 1 | 2 | 2 | 5 | 2 |

Output:

```text
2
```

The subarray `[2, 2]` has length `2`, and its degree matches the original array's degree.

## Complexity Analysis

- **Time complexity:** `O(n)` — each array element is processed once, with average `O(1)` HashMap operations.
- **Space complexity:** `O(n)` — the maps may store information for each distinct number.

## Key Idea to Remember

For every number, remember its **first occurrence** and **frequency**. When scanning the array, use the current index and first occurrence to calculate the shortest span for that number. Track the highest frequency and the smallest valid span.

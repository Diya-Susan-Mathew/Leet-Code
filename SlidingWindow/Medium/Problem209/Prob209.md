# LeetCode 209 — Minimum Size Subarray Sum

## Pattern Used

**Sliding Window — Variable-Size Window**

## Problem

Given an array of **positive integers** `nums` and a positive integer `target`, find the **minimum length of a contiguous subarray** whose sum is greater than or equal to `target`.

If no such subarray exists, return `0`.

### Example

```text
Input:  target = 7
        nums = [2,3,1,2,4,3]

Output: 2

Explanation:
The subarray [4,3] has sum 7 and length 2.
```

## Approach

Use a **variable-size sliding window** with two pointers:

- `left` → start of the window
- `right` → end of the window
- `windowSum` → sum of elements inside the current window
- `minLength` → minimum valid window length found so far

For every `right`:

1. Add `nums[right]` to `windowSum`.
2. Once `windowSum >= target`, the window is valid.
3. Record its length.
4. Shrink the window from the left to find a smaller valid window.
5. Continue expanding with `right`.

The key part is:

```java
while (windowSum >= target) {
    minLength = Math.min(minLength, right - left + 1);
    windowSum -= nums[left];
    left++;
}
```

Because all numbers are **positive**, removing elements from the left always decreases the window sum. This makes the sliding-window approach possible.

## Code

```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int windowSum = 0;

        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];

            while (windowSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                windowSum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
```

## Key Sliding Window Pattern

```text
Expand → Window becomes valid → Record answer → Shrink → Repeat
```

Here, the condition is:

```text
windowSum >= target
```

We keep shrinking while this condition remains true because we want the **smallest possible window**.

## Complexity Analysis

- **Time Complexity:** `O(n)` — Each element is added to the window once and removed at most once.
- **Space Complexity:** `O(1)` — Only a few variables are used.

## Important Observation

This problem is a classic **variable-size sliding window** problem.

The fact that all numbers are **positive** is important because:

```text
Expand right → sum increases
Shrink left  → sum decreases
```

This predictable behavior allows us to efficiently find the minimum valid subarray.

> **Remember: Expand until valid → Record answer → Shrink as much as possible.**

# LeetCode 643 — Maximum Average Subarray I

## Pattern Used
**Fixed-Size Sliding Window**

## Approach
- First, calculate the sum of the first `k` elements.
- Store this as `maxSum`.
- Slide the window one element at a time.
- Add the new element entering the window and subtract the element leaving it.
- Keep track of the maximum window sum.
- Since every window has exactly `k` elements, the maximum sum also gives the maximum average.
- Return `maxSum / k` as a `double`.

> Note: The `if` condition in the original code is unnecessary. The sliding-window logic already handles `k == nums.length` and `k == 1`.

## Code

```java
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int windowSum = 0;

        // Calculate the first window
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        // Slide the window
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i];       // Add entering element
            windowSum -= nums[i - k];   // Remove leaving element

            maxSum = Math.max(windowSum, maxSum);
        }

        return (double) maxSum / k;
    }
}
```

## Complexity Analysis

- **Time Complexity:** `O(n)` — each element is processed once.
- **Space Complexity:** `O(1)` — only a few variables are used.

## Key Pattern

**Fixed-Size Sliding Window:**

`Build first window → Slide → Add new element → Remove old element → Update answer`

# LeetCode 53 --- Maximum Subarray

## Pattern Used

**Kadane's Algorithm --- Dynamic Programming + Space Optimization**

## Problem

Given an integer array `nums`, find the **subarray with the largest
sum** and return its sum.

A **subarray** must contain **contiguous elements**.

### Example

``` text
Input:  [-2,1,-3,4,-1,2,1,-5,4]

Output: 6

Maximum subarray: [4,-1,2,1]
Sum = 4 + (-1) + 2 + 1 = 6
```

------------------------------------------------------------------------

## 1. Brute Force Approach

Try **every possible subarray** and calculate its sum.

We can use **three loops**:

-   First loop → choose the starting index.
-   Second loop → choose the ending index.
-   Third loop → calculate the sum of that subarray.

### Complexity

-   **Time:** `O(n³)`
-   **Space:** `O(1)`

------------------------------------------------------------------------

## 2. Better Approach

We can avoid the third loop.

For every starting index, keep adding elements as we move the ending
index. This allows us to calculate the subarray sum incrementally.

``` text
sum = sum + nums[j]
```

Now only **two loops** are required.

### Complexity

-   **Time:** `O(n²)`
-   **Space:** `O(1)`

------------------------------------------------------------------------

## 3. Optimal Approach --- Kadane's Algorithm

### What is Kadane's Algorithm?

Kadane's Algorithm is a **Dynamic Programming pattern** used to find the
**maximum sum of a contiguous subarray**.

The key idea is:

> At every element, decide whether to **start a new subarray** or
> **continue the previous subarray**.

For every `nums[i]`:

``` java
currentSum = Math.max(nums[i], currentSum + nums[i]);
```

This means:

``` text
Start new:       nums[i]

Continue:        currentSum + nums[i]
```

We choose whichever gives the larger sum.

We also maintain `maxSum` to store the largest sum found so far.

### Code

``` java
class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], nums[i] + currentSum);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
```

### Key Pattern

**Kadane's Algorithm = Extend or Restart**

``` text
currentSum = max(
    current element,
    previous currentSum + current element
)
```

If the previous sum is hurting the current element, **start fresh**.
Otherwise, **continue the existing subarray**.

### Complexity

-   **Time Complexity:** `O(n)` --- The array is traversed only once.
-   **Space Complexity:** `O(1)` --- Only `currentSum` and `maxSum` are
    used.

## Approach Comparison

  Approach                  Time    Space
  -------------------- --------- --------
  Brute Force            `O(n³)`   `O(1)`
  Better                 `O(n²)`   `O(1)`
  Kadane's Algorithm      `O(n)`   `O(1)`

### Pattern to Remember

Whenever a problem asks for the **maximum/minimum sum of a contiguous
subarray**, think:

> **Kadane's Algorithm → Extend or Restart**

# LeetCode 189 — Rotate Array

## Question Description

Given an integer array `nums`, rotate the array to the right by `k` steps.

The rotation should be done **in-place** using `O(1)` extra space.

### Example

```text
Input:  nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
```

---

## Approach — Reversal Algorithm

We can rotate the array using **three reversals**.

For:

```text
[1,2,3,4,5,6,7], k = 3
```

### Step 1: Reverse the entire array

```text
[7,6,5,4,3,2,1]
```

### Step 2: Reverse the first `k` elements

```text
[5,6,7,4,3,2,1]
```

### Step 3: Reverse the remaining elements

```text
[5,6,7,1,2,3,4]
```

Before rotating:

```java
k = k % nums.length;
```

This handles cases where `k` is greater than the array length.

The `reverse()` method swaps elements from both ends until they meet.

---

## Java Solution

```java
class Solution {

    public void rotate(int[] nums, int k) {

        int l = nums.length;

        k = k % l;

        reverse(nums, 0, l - 1);

        reverse(nums, 0, k - 1);

        reverse(nums, k, l - 1);
    }

    private void reverse(int arr[], int left, int right) {

        while (left <= right) {

            int temp = arr[left];

            arr[left] = arr[right];

            arr[right] = temp;

            left++;
            right--;
        }
    }
}
```

---

## Complexity Analysis

**Time Complexity:** `O(n)`

Three reversals are performed, and each element is processed a constant number of times.

**Space Complexity:** `O(1)`

The rotation is performed in-place using only a temporary variable for swapping.

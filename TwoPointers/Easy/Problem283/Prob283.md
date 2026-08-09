# Move Zeroes

## Approach

The idea is to shift all non-zero elements to the front of the array while maintaining their relative order.

1. Initialize a pointer `insertPos = 0`.
2. Traverse the array from left to right.
3. Whenever a non-zero element is found:
   - Place it at `nums[insertPos]`.
   - Increment `insertPos`.
4. After all non-zero elements have been placed, fill the remaining positions in the array with `0`.

This works in-place without using any extra array.

## Java Solution

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }

        while (insertPos < nums.length) {
            nums[insertPos] = 0;
            insertPos++;
        }
    }
}
```

## Complexity Analysis

- **Time Complexity:** **O(n)**
  - The array is traversed once to move all non-zero elements.
  - The remaining positions are filled with zeros in another pass.
  - Overall complexity remains **O(n)**.

- **Space Complexity:** **O(1)**
  - No extra data structure is used.
  - The modifications are performed in-place.

## Key Insight

- Maintain the relative order of non-zero elements.
- Perform the operation in-place using a single pointer.
- Avoid unnecessary swaps by directly overwriting elements and filling the remaining positions with zeros.
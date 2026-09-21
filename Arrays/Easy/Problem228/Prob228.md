# LeetCode – Summary Ranges

## Java Solution

```java
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int begin = 0, end = 0, i = 0;

        while (i < nums.length) {
            begin = i;

            while (i < nums.length - 1 && nums[i] == nums[i + 1] - 1) {
                i++;
            }

            end = i;

            if (nums[begin] == nums[end]) {
                list.add(Integer.toString(nums[begin]));
            } else {
                list.add(nums[begin] + "->" + nums[end]);
            }

            i++;
        }

        return list;
    }
}
```

## Approach

- Start a range at index `i`.
- Move `i` forward while consecutive numbers differ by `1`.
- If the range contains one number, add that number.
- Otherwise, add it in the format `start->end`.
- Continue until all numbers are processed.

## Complexity

- **Time:** `O(n)`
- **Space:** `O(n)` for the output list.

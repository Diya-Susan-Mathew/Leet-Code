# Intersection of Two Arrays II

## Approach — HashMap Frequency

### Key Idea

Use a `HashMap` to store the frequency of each number in one array.

Then iterate through the other array:

- If the number exists and its frequency is greater than `0`, add it to the result.
- Decrease its frequency.
- This handles duplicate elements correctly.

---

## 1. My Own Approach — Space Optimized by Choosing Array

### Code

```java
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        int flag = 0;

        if(nums1.length > nums2.length) {
            flag = 1;
        }

        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        if(flag == 1) {

            for(int num : nums1) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            for(int num : nums2) {
                if(map.containsKey(num)) {

                    map.put(num, map.get(num) - 1);

                    if(map.get(num) == 0) {
                        map.remove(num);
                    }

                    list.add(num);
                }
            }

        } else {

            for(int num : nums2) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            for(int num : nums1) {
                if(map.containsKey(num)) {

                    map.put(num, map.get(num) - 1);

                    if(map.get(num) == 0) {
                        map.remove(num);
                    }

                    list.add(num);
                }
            }
        }

        int[] result = new int[list.size()];

        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
```

### Complexity

- **Time:** `O(n + m)`
- **Space:** `O(max(n, m))` for the HashMap in this implementation.

> Note: This code stores the **larger array** in the HashMap. If you want to optimize space, store the smaller array instead.

---

# 2. Simplified Code

Instead of checking which array is larger, we can simply build the frequency map from `nums1` and process `nums2`.

### Code

```java
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        // Count the frequency of each number in nums1
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Find common elements and decrement their frequency
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {

                list.add(num);

                map.put(num, map.get(num) - 1);
            }
        }

        // Convert ArrayList<Integer> to int[]
        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
```

### Why `map.get(num) > 0`?

Suppose:

```text
nums1 = [1, 1, 2]
nums2 = [1, 1, 1, 2]
```

The map initially contains:

```text
1 → 2
2 → 1
```

When processing `nums2`:

```text
1 → add, frequency becomes 1
1 → add, frequency becomes 0
1 → frequency is 0, so don't add
2 → add, frequency becomes 0
```

Result:

```text
[1, 1, 2]
```

This ensures that we never use an element more times than it occurs.

### Complexity

Let:

- `n = nums1.length`
- `m = nums2.length`

- **Time:** `O(n + m)`
- **Space:** `O(n)` for the HashMap, plus `O(k)` for the result where `k` is the intersection size.

If `nums1` is the larger array, the space can be `O(max(n, m))`.

---

## Key Pattern

### HashMap + Frequency Counting

Useful when:

- Duplicates matter.
- You need to find an intersection.
- You need to track how many times each value occurs.

### Important Pattern

```java
map.put(num, map.getOrDefault(num, 0) + 1);
```

Use this to **count frequencies**.

```java
if (map.containsKey(num) && map.get(num) > 0)
```

Use this to check whether an occurrence is still available.

```java
map.put(num, map.get(num) - 1);
```

Use this to **consume one occurrence**.

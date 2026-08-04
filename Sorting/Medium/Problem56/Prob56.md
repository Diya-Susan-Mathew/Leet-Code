# Merge Intervals (LeetCode 56) – Java Solution

## Approach

1. **Sort** the intervals based on their starting time.
2. Create a list `merged` to store the merged intervals.
3. Initialize `currentInterval` as the first interval and add it to `merged`.
4. Traverse through all intervals:
   - If the current interval overlaps with `currentInterval`
     (`currentEnd >= nextStart`), merge them by updating the end time.
   - Otherwise, start a new interval by updating `currentInterval` and adding it to `merged`.
5. Convert the `ArrayList` into a 2D array and return it.

---

## Java Code

```java
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        ArrayList<int[]> merged = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
```

---

## Complexity Analysis

### Time Complexity

- Sorting the intervals takes **O(n log n)**.
- Traversing the sorted intervals takes **O(n)**.

Overall Time Complexity:

```
O(n log n)
```

---

### Space Complexity

- The `merged` list stores the merged intervals.
- In the worst case (when no intervals overlap), all `n` intervals are stored.

Overall Space Complexity:

```
O(n)
```

> **Note:** The sorting algorithm used by `Arrays.sort()` for object arrays also requires additional space internally, but the dominant extra space used by this solution is the `merged` list.

---

## Example

### Input

```text
[[1,3],[2,6],[8,10],[15,18]]
```

### After Sorting

```text
[[1,3],[2,6],[8,10],[15,18]]
```

### Processing

| Current Interval | Next Interval | Action | Result |
|------------------|--------------|--------|--------|
| [1,3] | [2,6] | Overlap → Merge | [1,6] |
| [1,6] | [8,10] | No Overlap | [1,6], [8,10] |
| [8,10] | [15,18] | No Overlap | [1,6], [8,10], [15,18] |

### Output

```text
[[1,6],[8,10],[15,18]]
```

---

## Key Observation

After sorting by the **starting time**, an interval can only overlap with the **last merged interval**. Therefore, we only need to compare each interval with `currentInterval`, making the merge process a single linear scan.
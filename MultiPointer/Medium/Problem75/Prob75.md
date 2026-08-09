# Pattern : Three Pointers,in-place Partitioning

# Approach 1: Counting Frequencies

Instead of using the Dutch National Flag algorithm, we can solve the problem by counting the occurrences of `0`, `1`, and `2`.

## Algorithm

1. Traverse the array once and count the number of:
   - `0`s
   - `1`s
   - `2`s
2. Traverse the array again:
   - Fill the first `count0` positions with `0`.
   - Fill the next `count1` positions with `1`.
   - Fill the remaining positions with `2`.

---

# Example

**Input**

```text
[2, 0, 2, 1, 1, 0]
```

### Step 1: Count Frequencies

```text
count0 = 2
count1 = 2
count2 = 2
```

### Step 2: Rewrite the Array

```text
[0, 0, 1, 1, 2, 2]
```

---

# Complexity Analysis

### Time Complexity

- First traversal to count frequencies: **O(n)**
- Second traversal to rewrite the array: **O(n)**

**Overall Time Complexity:** **O(n)**

### Space Complexity

- Only three integer variables are used to store the counts.

**Overall Space Complexity:** **O(1)**

---

# Why Use the Dutch National Flag Algorithm?

Although the counting approach is simple and efficient, it requires **two passes** over the array.

The Dutch National Flag algorithm improves this by sorting the array in **a single traversal** while still using **O(1)** extra space.

| Counting Approach | Dutch National Flag |
|-------------------|---------------------|
| Two passes | One pass |
| O(n) Time | O(n) Time |
| O(1) Space | O(1) Space |
| Easier to implement | More optimal for the follow-up requirement |

The counting approach is a great initial solution, while the Dutch National Flag algorithm is preferred when the problem specifically asks for a **one-pass** solution.
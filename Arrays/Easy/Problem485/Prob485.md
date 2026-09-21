# LeetCode 485 — Max Consecutive Ones

## Java Solution

```java
class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {

        int countOnes = 0;

        int max = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {

                countOnes++;

                max = Math.max(countOnes, max);

            } else {

                countOnes = 0;

            }
        }

        return max;
    }
}
```

---

## Intuition

We need to find the **maximum number of consecutive `1`s** in the array.

We keep track of two values:

```java
int countOnes = 0;
int max = 0;
```

- `countOnes` → number of consecutive `1`s in the current sequence.
- `max` → maximum consecutive `1`s found so far.

---

## How It Works

We traverse the array from left to right.

### When the current element is `1`

```java
if (nums[i] == 1) {
    countOnes++;
    max = Math.max(countOnes, max);
}
```

We increase the current consecutive count:

```text
countOnes++
```

Then update `max` if the current sequence is longer.

---

### When the current element is `0`

```java
else {
    countOnes = 0;
}
```

A `0` breaks the sequence of consecutive `1`s.

Therefore, we reset:

```text
countOnes = 0
```

We do **not** reset `max`, because the previous maximum still matters.

---

## Example

Consider:

```text
nums = [1, 1, 0, 1, 1, 1]
```

| Index | Value | `countOnes` | `max` |
|---:|---:|---:|---:|
| 0 | 1 | 1 | 1 |
| 1 | 1 | 2 | 2 |
| 2 | 0 | 0 | 2 |
| 3 | 1 | 1 | 2 |
| 4 | 1 | 2 | 2 |
| 5 | 1 | 3 | 3 |

Final answer:

```text
3
```

---

## Why Do We Reset `countOnes`?

Suppose:

```text
1 1 1 0 1 1
```

Before the `0`:

```text
countOnes = 3
```

The `0` means the previous sequence has ended.

So:

```java
countOnes = 0;
```

Then we start counting the new sequence:

```text
1 → 1
1 → 2
```

But `max` remains `3`.

---

## Important Difference Between `countOnes` and `max`

This is the key idea of the problem.

### `countOnes`

Tracks the **current** consecutive sequence.

```text
Current streak
```

### `max`

Tracks the **best** sequence found anywhere in the array.

```text
Best streak so far
```

So:

```text
0 → reset countOnes
```

but:

```text
0 → don't reset max
```

---

## Complexity

We traverse the array exactly once.

### Time Complexity

```text
O(n)
```

where `n` is the length of the array.

### Space Complexity

```text
O(1)
```

Only two variables are used.

---

## Pattern to Remember

This problem is a simple example of **tracking a running sequence**.

The general pattern is:

```java
int current = 0;
int max = 0;

for (...) {

    if (condition) {
        current++;
        max = Math.max(max, current);
    } else {
        current = 0;
    }
}
```

Whenever you see a problem asking for:

> **Longest consecutive sequence satisfying some condition**

think about maintaining:

```text
current streak
+
maximum streak
```

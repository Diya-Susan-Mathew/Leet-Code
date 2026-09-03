# First Bad Version

## Problem

You are given `n` versions of a product, numbered from `1` to `n`.

At some point, a version becomes bad. Once a version is bad, all versions after it are also bad.

You are given the API:

```java
boolean isBadVersion(int version);
```

Return the **first bad version**.

---

## Approach

This problem can be solved using **Binary Search**.

We maintain two pointers:

* `left = 1`
* `right = n`

For every iteration:

1. Calculate the middle version:

   ```java
   mid = left + (right - left) / 2;
   ```

2. Check whether `mid` is a bad version.

   * If `mid` is bad, the first bad version could be `mid` or somewhere before it.
     So:

     ```java
     right = mid - 1;
     ```
   * If `mid` is not bad, the first bad version must be after `mid`.
     So:

     ```java
     left = mid + 1;
     ```

3. When the loop ends, `left` points to the first bad version.

---

## Java Code

```java
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {

    public int firstBadVersion(int n) {

        int left = 1;
        int right = n;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
```

---

## Example

### Input

```text
n = 5
bad = 4
```

Versions:

```text
1  2  3  4  5
G  G  G  B  B
```

Where:

* `G` = Good version
* `B` = Bad version

Binary search proceeds as follows:

```text
left = 1, right = 5
mid = 3
```

Version `3` is good, so search the right half.

```text
left = 4, right = 5
mid = 4
```

Version `4` is bad, so search the left half.

```text
left = 4, right = 3
```

The loop ends.

Therefore:

```text
Output: 4
```

---

## Why Return `left`?

When the loop ends:

```text
left > right
```

`right` points to the last good version, while `left` points to the first possible bad version.

Therefore:

```java
return left;
```

is the correct answer.

---

## Why Use This Midpoint Formula?

Instead of:

```java
int mid = (left + right) / 2;
```

we use:

```java
int mid = left + (right - left) / 2;
```

This avoids integer overflow when `left` and `right` are very large.

---

## Complexity Analysis

Let `n` be the number of versions.

### Time Complexity

Binary search eliminates approximately half of the search space in every iteration.

```text
Time Complexity: O(log n)
```

### Space Complexity

Only a few integer variables are used.

```text
Space Complexity: O(1)
```

---

## Key Idea

The versions follow a monotonic pattern:

```text
Good Good Good ... Good Bad Bad Bad ... Bad
```

This makes the problem suitable for **Binary Search**.

The goal is to find the **leftmost `true`** value, where:

```text
isBadVersion(version) == true
```

So this is a classic **First Occurrence / Lower Bound** binary search problem.

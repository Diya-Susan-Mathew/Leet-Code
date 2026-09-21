# LeetCode 414 — Third Maximum Number

## Problem

Given an integer array `nums`, return the **third distinct maximum number** in the array.

If the third maximum does not exist, return the **maximum number**.

---

## Approach — TreeSet

We can use Java's `TreeSet` because:

* It stores only **unique elements**.
* It automatically keeps elements in **sorted ascending order**.
* `last()` gives the largest element.
* `pollLast()` removes and returns the largest element.

### Steps

1. Create a `TreeSet<Integer>`.
2. Add every element from the array.
3. If there are fewer than 3 distinct elements, return the largest element using `set.last()`.
4. Remove the largest element twice using `pollLast()`.
5. The remaining largest element is the **third maximum**.
6. Return it.

---

## Code

```java
class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            }
        }

        if (set.size() < 3) {
            return set.last();
        }

        set.pollLast();
        set.pollLast();

        int num = set.pollLast();

        return num;
    }
}
```

---

## Example

### Input

```text
nums = [3, 2, 1]
```

### TreeSet

```text
[1, 2, 3]
```

Remove the largest twice:

```text
[1, 2, 3]
      ↓
[1, 2]
      ↓
[1]
```

Now:

```text
set.pollLast() = 1
```

### Output

```text
1
```

---

## Example with duplicates

### Input

```text
nums = [2, 2, 3, 1]
```

The `TreeSet` removes duplicates:

```text
[1, 2, 3]
```

Remove:

```text
3 → largest
2 → second largest
```

Remaining:

```text
1 → third largest
```

### Output

```text
1
```

---

## Important Edge Case

If there are fewer than 3 **distinct** numbers:

```text
nums = [1, 2]
```

TreeSet:

```text
[1, 2]
```

Since:

```java
set.size() < 3
```

we return:

```java
set.last();
```

Therefore:

```text
Output = 2
```

---

## Time Complexity

Each insertion into a `TreeSet` takes:

```text
O(log n)
```

For `n` elements:

```text
Time: O(n log n)
```

The TreeSet can contain at most `n` distinct elements:

```text
Space: O(n)
```

---

## Note

This condition:

```java
if (!set.contains(num)) {
    set.add(num);
}
```

is actually unnecessary because a `TreeSet` automatically ignores duplicate values.

So the loop can be simplified to:

```java
for (int num : nums) {
    set.add(num);
}
```

The simplified version is:

```java
class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int num : nums) {
            set.add(num);
        }

        if (set.size() < 3) {
            return set.last();
        }

        set.pollLast();
        set.pollLast();

        return set.pollLast();
    }
}
```

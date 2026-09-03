# LeetCode 69 - Sqrt(x)

## Problem

Given a non-negative integer `x`, return the square root of `x` rounded down to the nearest integer.

In other words, return the largest integer `n` such that:

```text
n² <= x
```

### Examples

```text
x = 4
Output: 2
```

Because:

```text
2² = 4
```

```text
x = 8
Output: 2
```

Because:

```text
2² = 4 <= 8
3² = 9 > 8
```

Therefore, the answer is `2`.

---

## Approach: Binary Search

The possible answer lies between `1` and `x`.

We use binary search to find the largest number whose square is less than or equal to `x`.

### Steps

1. Set `low = 1` and `high = x`.
2. Calculate the middle value:
   ```java
   int mid = low + (high - low) / 2;
   ```
3. Calculate `mid * mid`.
4. If `mid * mid == x`, then `mid` is the exact square root.
5. If `mid * mid < x`, `mid` could be the answer, but there may be a larger valid value. Move right:
   ```java
   low = mid + 1;
   ```
6. If `mid * mid > x`, move left:
   ```java
   high = mid - 1;
   ```
7. When the loop ends, `high` contains the largest integer satisfying:
   ```text
   high² <= x
   ```

---

## Java Solution

```java
class Solution {

    public int mySqrt(int x) {

        int low = 1;

        int high = x;

        while(low <= high){

            int mid = low + (high-low)/2;

            long squared = (long)mid*mid;

            if(squared == x){

                return mid;

            }else if(squared < x){

                low = mid+1;

            }else{

                high = mid-1;

            }
        }

        return high;

    }
}
```

---

## Why Do We Return `high`?

This is the most important part of the solution.

Suppose:

```text
x = 8
```

We want:

```text
sqrt(8) = 2.828...
```

Since the answer must be an integer:

```text
answer = 2
```

At the end of binary search:

```text
high = 2
low = 3
```

The loop stops because:

```text
low > high
```

We return:

```java
return high;
```

because `high` represents the **largest value whose square is less than or equal to `x`**.

---

## Dry Run

Let's take:

```text
x = 8
```

Initially:

```text
low = 1
high = 8
```

### Iteration 1

```text
mid = 4
squared = 4² = 16
```

Since:

```text
16 > 8
```

move left:

```text
high = 3
```

### Iteration 2

```text
low = 1
high = 3

mid = 2
squared = 2² = 4
```

Since:

```text
4 < 8
```

we need to search for a larger value:

```text
low = 3
```

### Iteration 3

```text
low = 3
high = 3

mid = 3
squared = 3² = 9
```

Since:

```text
9 > 8
```

move left:

```text
high = 2
```

Now:

```text
low = 3
high = 2
```

The loop ends because:

```text
low > high
```

Return:

```java
return high;
```

Therefore:

```text
2
```

---

## Why Use `long`?

We use:

```java
long squared = (long)mid * mid;
```

instead of:

```java
int squared = mid * mid;
```

because `mid * mid` can cause **integer overflow**.

For example:

```text
46340² = 2,147,395,600
```

which is close to the maximum value of an `int`.

Using `long` makes the multiplication safe:

```java
(long)mid * mid
```

The cast is applied before multiplication, so the multiplication is performed using `long`.

---

## Why Use This Midpoint Formula?

We use:

```java
int mid = low + (high - low) / 2;
```

instead of:

```java
int mid = (low + high) / 2;
```

The second version can overflow if `low + high` becomes larger than the maximum `int` value.

The first version avoids that potential overflow.

---

## Important Binary Search Insight

This problem is slightly different from normal binary search.

We are not searching for an exact value in an array.

Instead, we are searching for:

> **The largest integer whose square is less than or equal to `x`.**

This is a common **Binary Search on Answer** pattern.

For example, for:

```text
x = 20
```

we have:

```text
1² = 1
2² = 4
3² = 9
4² = 16  ← valid
5² = 25  ← too large
```

Therefore:

```text
sqrt(20) = 4
```

The binary search finds this boundary efficiently.

---

## Complexity

### Time Complexity

```text
O(log x)
```

The search space is divided approximately in half after every iteration.

### Space Complexity

```text
O(1)
```

Only a constant number of variables are used.

---

## Key Pattern to Remember

For problems asking for the **largest valid value**, a useful binary-search pattern is:

```java
while (low <= high) {

    int mid = low + (high - low) / 2;

    if (mid satisfies the condition) {
        low = mid + 1;
    } else {
        high = mid - 1;
    }
}

return high;
```

Here, the condition is:

```text
mid² <= x
```

So:

- If `mid² < x` → search for a larger answer.
- If `mid² > x` → search for a smaller answer.
- When the search ends → `high` is the answer.

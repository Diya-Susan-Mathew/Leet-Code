# LeetCode 367 - Valid Perfect Square

## Problem

Given a positive integer `num`, return `true` if `num` is a perfect square. Otherwise, return `false`.

A perfect square is an integer that is the square of another integer.

### Examples

- `16` → `true` because `4 × 4 = 16`
- `14` → `false`

---

## Approach: Binary Search

We can use **binary search** to find an integer whose square is equal to `num`.

### Idea

For a number `num`, the possible square root lies between `1` and `num`.

At every step:

1. Calculate the middle value `mid`.
2. Calculate `mid * mid`.
3. If `mid * mid == num`, return `true`.
4. If `mid * mid < num`, the answer must be on the right side.
5. If `mid * mid > num`, the answer must be on the left side.
6. If the search finishes without finding an exact square, return `false`.

---

## Java Solution

```java
class Solution {

    public boolean isPerfectSquare(int num) {

        int left = 1;
        int right = num;

        while(left <= right){

            int mid = left + (right - left) / 2;

            long squared = (long) mid * mid;

            if(squared == num){

                return true;

            }else if(squared < num){

                left = mid + 1;

            }else{

                right = mid - 1;

            }
        }

        return false;
    }
}
```

---

## Why use `long` for `squared`?

Instead of:

```java
int squared = mid * mid;
```

we use:

```java
long squared = (long) mid * mid;
```

This prevents **integer overflow** when `mid * mid` becomes larger than the maximum value an `int` can store.

For example, if:

```text
mid = 50000
```

then:

```text
mid × mid = 2,500,000,000
```

which is larger than the maximum `int` value:

```text
2,147,483,647
```

So `long` is safer for the multiplication.

---

## Why is this Binary Search?

The values of `mid * mid` are increasing as `mid` increases.

For example, for `num = 16`:

```text
1² = 1
2² = 4
3² = 9
4² = 16  ← found
5² = 25
6² = 36
...
```

This sorted/increasing property allows us to eliminate half of the search space after every comparison.

---

## Dry Run

Suppose:

```text
num = 16
```

Initial:

```text
left = 1
right = 16
```

### Step 1

```text
mid = 8
8² = 64
```

Since:

```text
64 > 16
```

move left:

```text
right = 7
```

### Step 2

```text
mid = 4
4² = 16
```

Since:

```text
16 == 16
```

return:

```text
true
```

---

## Complexity

### Time Complexity

```text
O(log n)
```

Binary search cuts the search space approximately in half at every iteration.

### Space Complexity

```text
O(1)
```

Only a few variables are used.

---

## Key Pattern to Remember

This problem demonstrates the common **Binary Search on Answer** pattern:

```java
while (left <= right) {

    int mid = left + (right - left) / 2;

    if (condition is satisfied) {
        // found answer
    } else if (condition is too small) {
        left = mid + 1;
    } else {
        right = mid - 1;
    }
}
```

The important observation is that we are not searching for a value directly in an array. We are searching for the **integer square root** of `num`.

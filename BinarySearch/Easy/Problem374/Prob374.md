# Guess Number Higher or Lower

## Problem

We are given a number `n`, and a hidden number is picked between `1` and `n`.

We can use the `guess(num)` API:

- `guess(num) == -1` → our guess is higher than the picked number.
- `guess(num) == 1` → our guess is lower than the picked number.
- `guess(num) == 0` → our guess is correct.

The goal is to find the picked number.

---

## Approach

We use **Binary Search** to find the picked number efficiently.

Initially:

```text
left = 1
right = n
```

At every step, calculate:

```text
mid = left + (right - left) / 2
```

Then call `guess(mid)`.

### Case 1: `guess(mid) == -1`

Our guess is higher than the picked number.

The picked number must be to the left of `mid`.

```text
right = mid - 1
```

### Case 2: `guess(mid) == 1`

Our guess is lower than the picked number.

The picked number must be to the right of `mid`.

```text
left = mid + 1
```

### Case 3: `guess(mid) == 0`

The guess is correct.

```text
return mid
```

---

## Why Binary Search?

Instead of checking every number one by one, binary search eliminates approximately half of the possible numbers after every guess.

For example, if `n = 10`:

```text
1  2  3  4  5  6  7  8  9  10
```

We check the middle value first. Based on the result of `guess(mid)`, we eliminate either the left half or the right half.

---

## Example

Suppose:

```text
n = 10
Picked number = 6
```

### Step 1

```text
left = 1
right = 10

mid = 1 + (10 - 1) / 2
    = 5
```

Since `5` is lower than the picked number:

```text
guess(5) = 1
```

So:

```text
left = 6
```

### Step 2

```text
left = 6
right = 10

mid = 6 + (10 - 6) / 2
    = 8
```

Since `8` is higher than the picked number:

```text
guess(8) = -1
```

So:

```text
right = 7
```

### Step 3

```text
left = 6
right = 7

mid = 6 + (7 - 6) / 2
    = 6
```

Now:

```text
guess(6) = 0
```

Therefore:

```text
Answer = 6
```

---

## Understanding the Mid Formula

The middle is calculated using:

```text
mid = left + (right - left) / 2
```

This is mathematically equivalent to:

```text
mid = (left + right) / 2
```

### Derivation

Start with:

```text
left + (right - left) / 2
```

Write `left` with denominator `2`:

```text
2 * left / 2 + (right - left) / 2
```

Combine the fractions:

```text
(2 * left + right - left) / 2
```

Simplify:

```text
(left + right) / 2
```

Therefore:

```text
left + (right - left) / 2
```

and

```text
(left + right) / 2
```

give the same middle value.

### Intuition

Think of it as:

> Start at `left` and move halfway toward `right`.

For example:

```text
left = 10
right = 20
```

Distance between them:

```text
20 - 10 = 10
```

Half of the distance:

```text
10 / 2 = 5
```

Start from `left`:

```text
10 + 5 = 15
```

So:

```text
mid = 15
```

---

## Why Not Simply Use `(left + right) / 2`?

Both formulas are mathematically equivalent, but:

```text
mid = left + (right - left) / 2
```

is safer because it avoids integer overflow.

For example:

```text
left = 2,000,000,000
right = 2,100,000,000
```

Then:

```text
left + right = 4,100,000,000
```

This exceeds the maximum value of a 32-bit signed integer:

```text
2,147,483,647
```

Therefore, `(left + right) / 2` can overflow.

However:

```text
right - left
= 2,100,000,000 - 2,000,000,000
= 100,000,000
```

is safe.

That is why the following form is preferred:

```text
mid = left + (right - left) / 2
```

---

## Algorithm

1. Set `left = 1`.
2. Set `right = n`.
3. Repeat while `left <= right`.
4. Calculate `mid`.
5. Call `guess(mid)`.
6. If the guess is too high, set `right = mid - 1`.
7. If the guess is too low, set `left = mid + 1`.
8. If the guess is correct, return `mid`.
9. If the number is not found, return `-1`.

---

## Complexity Analysis

### Time Complexity

```text
O(log n)
```

Binary search divides the search space approximately in half after every iteration.

### Space Complexity

```text
O(1)
```

Only a constant number of variables are used, so no additional memory is required.

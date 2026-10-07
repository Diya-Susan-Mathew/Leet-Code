# LeetCode 2413 – Smallest Even Multiple

## Problem

Given a positive integer `n`, return the **smallest positive integer** that is a multiple of both `n` and `2`.

### Example

```text
Input:  n = 5
Output: 10

Explanation:
Multiples of 5 are 5, 10, 15, 20...
10 is the smallest one that is also even.
```

---

## Approach

The key observation is to check whether `n` is **even or odd**.

### Case 1: `n` is even

If `n` is already even, then `n` itself is:

* a multiple of `n`
* even
* the smallest possible answer

So:

```java
return n;
```

### Case 2: `n` is odd

If `n` is odd, `n` itself is not even.

The next multiple is:

```text
n × 2
```

Since `2 × n` is always even, this is the smallest even multiple.

So:

```java
return n * 2;
```

---

## Code

```java
class Solution {

    public int smallestEvenMultiple(int n) {

        return (n % 2 == 0) ? n : n * 2;

    }
}
```

---

## Understanding the Ternary Operator

The following:

```java
return (n % 2 == 0) ? n : n * 2;
```

is equivalent to:

```java
if (n % 2 == 0) {
    return n;
} else {
    return n * 2;
}
```

The syntax is:

```text
condition ? value_if_true : value_if_false
```

Here:

```text
n % 2 == 0
     ↓
Is n even?

Yes → return n
No  → return n × 2
```

---

## Dry Run 1

### Input

```text
n = 6
```

Check:

```text
6 % 2 = 0
```

So `6` is even.

Therefore:

```text
answer = 6
```

### Output

```text
6
```

---

## Dry Run 2

### Input

```text
n = 5
```

Check:

```text
5 % 2 = 1
```

So `5` is odd.

Therefore:

```text
answer = 5 × 2
       = 10
```

### Output

```text
10
```

---

## Dry Run 3

### Input

```text
n = 7
```

Multiples of 7:

```text
7, 14, 21, 28...
```

The smallest even multiple is:

```text
14
```

The code calculates:

```text
7 × 2 = 14
```

---

## Key Pattern

This is a **Parity Check** problem.

Whenever you need to determine whether a number is even or odd:

```java
n % 2 == 0
```

means **even**.

```java
n % 2 != 0
```

means **odd**.

### Remember

```text
Even n → answer = n
Odd n  → answer = 2 × n
```

---

## Complexity

### Time Complexity

```text
O(1)
```

Only one modulo operation and one conditional check are performed.

### Space Complexity

```text
O(1)
```

No extra data structure is used.

---

## Main Takeaway

The important idea is not the ternary operator.

The important observation is:

> **If `n` is even, `n` itself is the smallest even multiple. If `n` is odd, multiplying it by 2 gives the smallest even multiple.**

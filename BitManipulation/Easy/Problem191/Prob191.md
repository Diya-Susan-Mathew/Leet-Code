# LeetCode 191 — Number of 1 Bits

## Problem Statement

Given a positive integer `n`, write a function that returns the number of `1` bits in its binary representation.

This is also known as the **Hamming Weight** of the number.

---

## Example 1

### Input

```text
n = 11
```

### Binary Representation

```text
11 = 1011
```

There are three `1`s.

### Output

```text
3
```

---

## Example 2

### Input

```text
n = 128
```

### Binary Representation

```text
128 = 10000000
```

There is one `1`.

### Output

```text
1
```

---

# Java Solution

```java
class Solution {

    public int hammingWeight(int n) {

        int count = 0;

        while(n > 0){

            n = n & n-1;

            count++;

        }

        return count;

    }

}
```

---

# Approach

This solution uses **Brian Kernighan's Algorithm**.

The key operation is:

```java
n = n & (n - 1);
```

It removes the **rightmost set bit (`1`)** from the binary representation of `n`.

Every time we perform this operation, we increment:

```java
count++;
```

When there are no more `1`s, `n` becomes `0`, and the loop stops.

Therefore:

```text
Number of loop iterations = Number of 1 bits
```

---

# Understanding `n & (n - 1)`

Consider:

```text
n = 12
```

Binary:

```text
12 = 1100
```

Now calculate:

```text
n - 1 = 1011
```

Perform AND:

```text
  1100
& 1011
------
  1000
```

The rightmost `1` has been removed.

Perform it again:

```text
  1000
& 0111
------
  0000
```

There were two `1`s in `1100`, so the Hamming Weight is:

```text
2
```

---

# Dry Run

Let's take:

```text
n = 11
```

Binary representation:

```text
11 = 1011
```

### First iteration

```text
n     = 1011
n - 1 = 1010

1011 & 1010 = 1010
```

So:

```text
n = 1010
count = 1
```

### Second iteration

```text
n     = 1010
n - 1 = 1001

1010 & 1001 = 1000
```

So:

```text
n = 1000
count = 2
```

### Third iteration

```text
n     = 1000
n - 1 = 0111

1000 & 0111 = 0000
```

So:

```text
n = 0000
count = 3
```

Now:

```java
while(n > 0)
```

is false.

Return:

```text
3
```

---

# Step-by-Step Code Explanation

## 1. Initialize the counter

```java
int count = 0;
```

This stores the number of `1`s we have found.

---

## 2. Continue while `n` contains bits

```java
while(n > 0)
```

As long as `n` is not zero, there is at least one set bit remaining.

---

## 3. Remove the rightmost `1`

```java
n = n & n-1;
```

This is equivalent to:

```java
n = n & (n - 1);
```

The parentheses make the operation easier to read and understand.

Each execution removes exactly one `1`.

---

## 4. Increase the count

```java
count++;
```

Since one `1` was removed, increase the number of set bits counted.

---

## 5. Return the answer

```java
return count;
```

When `n` becomes `0`, all the `1`s have been removed, so `count` is the Hamming Weight.

---

# Why Does `n & (n - 1)` Remove the Rightmost `1`?

Suppose:

```text
n = 1011000
```

The rightmost `1` is here:

```text
1011 000
    ↑
```

When we subtract `1`:

```text
n     = 1011000
n - 1 = 1010111
```

Now:

```text
  1011000
& 1010111
---------
  1010000
```

The rightmost `1` has disappeared.

This happens because subtracting `1` changes the rightmost `1` into `0` and changes the bits after it to `1`. The AND operation then clears that bit and leaves the bits before it unchanged.

---

# Complexity

Let `k` be the number of `1` bits in `n`.

The loop runs exactly `k` times.

Therefore:

```text
Time Complexity:  O(k)
```

Since `k` can be at most the number of bits in the integer:

```text
Time Complexity: O(log n)
```

The algorithm uses only a few variables:

```text
Space Complexity: O(1)
```

So the final complexity is:

```text
Time Complexity:  O(log n)  [worst case]
Space Complexity: O(1)
```

---

# Important Bit Manipulation Pattern

Remember:

```java
n & (n - 1)
```

### Meaning:

> Removes the rightmost `1` bit.

This is an important bit-manipulation technique and appears in several problems.

### Counting set bits

```java
int count = 0;

while(n > 0){
    n = n & (n - 1);
    count++;
}
```

### Checking whether a number is a power of 2

A positive number is a power of 2 if it contains exactly one `1` bit.

Therefore:

```java
n > 0 && (n & (n - 1)) == 0
```

For example:

```text
8  = 1000 → power of 2
16 = 10000 → power of 2
10 = 1010 → not a power of 2
```

---

# Key Takeaway

The most important thing to remember from this problem is:

```text
n & (n - 1)
        ↓
removes the rightmost set bit
```

Therefore:

```text
Number of times we perform n = n & (n - 1)
=
Number of 1s in the binary representation
```

This technique is called **Brian Kernighan's Algorithm** and is one of the most useful basic patterns in bit manipulation.

# LeetCode 231 — Power of Two

## Problem Statement

Given an integer `n`, return `true` if `n` is a power of two. Otherwise, return `false`.

A number is a power of two if it can be written as:

```text
2^x
```

where `x` is an integer.

Examples of powers of two:

```text
1  = 2^0
2  = 2^1
4  = 2^2
8  = 2^3
16 = 2^4
32 = 2^5
```

---

## Example 1

### Input

```text
n = 16
```

### Output

```text
true
```

### Explanation

```text
16 = 2^4
```

Therefore, `16` is a power of two.

Its binary representation is:

```text
10000
```

It contains exactly **one `1` bit**.

---

## Example 2

### Input

```text
n = 18
```

### Output

```text
false
```

### Explanation

```text
18 = 10010
```

It contains two `1` bits, so it cannot be a power of two.

---

## Example 3

### Input

```text
n = 1
```

### Output

```text
true
```

### Explanation

```text
1 = 2^0
```

Therefore, `1` is a power of two.

---

# Java Solution

```java
class Solution {
    public boolean isPowerOfTwo(int n) {
        int count = 0;
        while(n > 0){
            n = n & n-1;
            count++;
        }
        return count == 1;

    }
}
```

---

# Approach

This solution uses **Brian Kernighan's Algorithm**.

The key idea is:

> A positive number is a power of two if and only if its binary representation contains exactly one `1`.

For example:

```text
1   → 1       → one 1
2   → 10      → one 1
4   → 100     → one 1
8   → 1000    → one 1
16  → 10000   → one 1
```

But:

```text
3  → 11       → two 1s
6  → 110      → two 1s
10 → 1010     → two 1s
12 → 1100     → two 1s
```

So we count the number of set bits (`1`s).

If the count is exactly `1`, the number is a power of two.

---

# Understanding `n & (n - 1)`

The operation:

```java
n = n & (n - 1);
```

removes the **rightmost `1` bit** from `n`.

For example:

```text
n = 8
```

Binary:

```text
1000
```

Then:

```text
n - 1 = 0111
```

Perform AND:

```text
  1000
& 0111
------
  0000
```

Only one operation was required to remove the only `1`.

Therefore:

```text
count = 1
```

and the method returns:

```text
true
```

---

# Dry Run — `n = 16`

Binary representation:

```text
16 = 10000
```

Initially:

```text
count = 0
```

### First iteration

```text
n     = 10000
n - 1 = 01111

10000 & 01111 = 00000
```

So:

```text
n = 0
count = 1
```

The loop stops.

Finally:

```java
return count == 1;
```

which becomes:

```text
1 == 1
```

Therefore:

```text
true
```

---

# Dry Run — `n = 18`

Binary:

```text
18 = 10010
```

Initially:

```text
count = 0
```

### First iteration

```text
n     = 10010
n - 1 = 10001

10010 & 10001 = 10000
```

So:

```text
n = 10000
count = 1
```

### Second iteration

```text
n     = 10000
n - 1 = 01111

10000 & 01111 = 00000
```

So:

```text
n = 0
count = 2
```

Finally:

```java
return count == 1;
```

becomes:

```text
2 == 1
```

Therefore:

```text
false
```

---

# Why Does a Power of Two Have Only One `1`?

Binary numbers make this very easy to see.

Powers of two are:

```text
2^0 = 1      → 1
2^1 = 2      → 10
2^2 = 4      → 100
2^3 = 8      → 1000
2^4 = 16     → 10000
2^5 = 32     → 100000
```

There is exactly one `1` followed by zero or more `0`s.

Therefore:

```text
Power of 2
     ↓
Exactly one set bit
```

---

# Step-by-Step Code Explanation

## 1. Initialize the counter

```java
int count = 0;
```

This stores the number of set bits.

---

## 2. Process the number while it is positive

```java
while(n > 0)
```

As long as there are set bits remaining, continue.

---

## 3. Remove one set bit

```java
n = n & n-1;
```

This removes the rightmost `1`.

---

## 4. Increase the counter

```java
count++;
```

Since one `1` has been removed, increase the count.

---

## 5. Check whether exactly one set bit existed

```java
return count == 1;
```

If there was exactly one `1`, the number is a power of two.

---

# Important Edge Case — `n <= 0`

The code handles non-positive numbers correctly.

For:

```text
n = 0
```

the loop does not execute:

```text
count = 0
```

Then:

```text
count == 1
```

is:

```text
false
```

Similarly, for a negative number, the condition:

```java
while(n > 0)
```

is false, so the method returns `false`.

This is correct because powers of two in this problem are positive.

---

# Complexity

Let `k` be the number of set bits in `n`.

The loop runs exactly `k` times.

Therefore:

```text
Time Complexity: O(k)
```

Since an integer has a fixed number of bits, this can also be viewed as:

```text
O(log n)
```

for the general integer representation.

The algorithm uses only a few variables:

```text
Space Complexity: O(1)
```

Therefore:

```text
Time Complexity:  O(log n)
Space Complexity: O(1)
```

---

# Even Shorter Bit-Manipulation Solution

There is an even shorter way to solve this problem using the same idea.

```java
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
```

## Why Does This Work?

If `n` is a power of two, it has exactly one `1`.

For example:

```text
n     = 1000
n - 1 = 0111

1000 & 0111 = 0000
```

So:

```java
(n & (n - 1)) == 0
```

means that `n` has only one set bit.

The additional condition:

```java
n > 0
```

is necessary because:

```text
0 & (0 - 1) = 0
```

would otherwise incorrectly make `0` appear to be a power of two.

---

# Important Bit Manipulation Pattern

Remember:

```java
n & (n - 1)
```

### Meaning:

> Removes the rightmost set bit (`1`).

This gives two very useful patterns:

### Count set bits

```java
while(n > 0){
    n = n & (n - 1);
    count++;
}
```

### Check whether a positive number is a power of two

```java
n > 0 && (n & (n - 1)) == 0
```

---

# Key Takeaway

The main observation is:

```text
Power of 2
    ↓
Binary representation has exactly one 1
    ↓
n & (n - 1) removes that 1
    ↓
Result becomes 0
```

So the most efficient bit-manipulation check is:

```java
return n > 0 && (n & (n - 1)) == 0;
```

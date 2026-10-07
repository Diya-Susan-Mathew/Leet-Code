# Hamming Distance

## Problem

Given two integers `x` and `y`, return the **Hamming Distance** between them.

The Hamming Distance is the number of positions at which the corresponding bits are **different**.

---

## Example

### Input

```text
x = 1
y = 4
```

Convert to binary:

```text
1 = 001
4 = 100
```

Compare:

```text
001
100
---
101
```

There are **2 different bits**.

Therefore:

```text
Hamming Distance = 2
```

---

# Approach

The key idea is to use **XOR (`^`)**.

```java
int xor_result = x ^ y;
```

XOR gives:

```text
Same bits      → 0
Different bits → 1
```

Therefore, the number of `1`s in:

```text
x ^ y
```

is exactly the Hamming Distance.

---

## Example

```text
x = 1 = 001
y = 4 = 100
```

XOR:

```text
  001
^ 100
-----
  101
```

Number of `1`s = `2`

Therefore:

```text
Hamming Distance = 2
```

---

# Counting the Set Bits

After XOR, we need to count the number of `1`s.

Your solution uses:

```java
xor_result = xor_result & (xor_result - 1);
```

This is called **Brian Kernighan's Algorithm**.

It removes the **rightmost set bit (`1`)** from a number.

---

## How `n & (n - 1)` Works

Suppose:

```text
n = 1011
```

Subtract `1`:

```text
n - 1 = 1010
```

Now:

```text
  1011
& 1010
------
  1010
```

The rightmost `1` has been removed.

So:

```text
1011 → 1010
```

Each time we perform this operation, one `1` disappears.

Therefore, the number of iterations equals the number of set bits.

---

# Code

```java
class Solution {

    public int hammingDistance(int x, int y) {

        int xor_result = x ^ y;

        int hammingDist = 0;

        while (xor_result > 0) {

            xor_result = xor_result & (xor_result - 1);

            hammingDist++;
        }

        return hammingDist;
    }
}
```

---

# Dry Run

Let's take:

```text
x = 1
y = 4
```

### Step 1: XOR

```text
1 = 001
4 = 100

001 ^ 100 = 101
```

So:

```text
xor_result = 101
hammingDist = 0
```

---

### Step 2

```text
101 & 100 = 100
```

```text
xor_result = 100
hammingDist = 1
```

---

### Step 3

```text
100 & 011 = 000
```

```text
xor_result = 000
hammingDist = 2
```

Now:

```text
xor_result = 0
```

The loop stops.

### Answer

```text
2
```

---

# Why XOR?

XOR is perfect for this problem because we only care about **whether the bits are different**.

| x | y | `x ^ y` |
| - | - | ------- |
| 0 | 0 | 0       |
| 0 | 1 | 1       |
| 1 | 0 | 1       |
| 1 | 1 | 0       |

So:

```text
XOR = 1 → bits are different
XOR = 0 → bits are same
```

Therefore:

```text
Number of 1s in XOR
        ↓
Hamming Distance
```

---

# Alternative Java Solution

Java provides a built-in method to count the number of set bits:

```java
Integer.bitCount()
```

So the entire solution can be simplified to:

```java
class Solution {

    public int hammingDistance(int x, int y) {

        return Integer.bitCount(x ^ y);
    }
}
```

This is the shortest solution.

---

# Another Approach: Check Every Bit

We can also check each bit individually.

```java
class Solution {

    public int hammingDistance(int x, int y) {

        int xor_result = x ^ y;
        int hammingDist = 0;

        while (xor_result > 0) {

            if ((xor_result & 1) == 1) {
                hammingDist++;
            }

            xor_result = xor_result >> 1;
        }

        return hammingDist;
    }
}
```

Here:

```java
xor_result & 1
```

checks the **last bit**.

Then:

```java
xor_result >> 1
```

moves to the next bit.

---

# Comparing Approaches

| Approach             | Main Idea       | Time | Space |
| -------------------- | --------------- | ---: | ----: |
| Brian Kernighan      | `n & (n-1)`     | O(k) |  O(1) |
| Check every bit      | `n & 1` + shift | O(b) |  O(1) |
| `Integer.bitCount()` | Java built-in   | O(b) |  O(1) |

Where:

* `k` = number of `1`s in `x ^ y`
* `b` = number of bits in the integer

---

# DSA Pattern

When you see:

> **Find the number of different bits between two numbers**

Think:

```text
Step 1 → XOR the numbers
Step 2 → Count the set bits
```

### Pattern

```java
int xor = x ^ y;
int count = Integer.bitCount(xor);
```

Or manually:

```java
while (xor > 0) {
    xor = xor & (xor - 1);
    count++;
}
```

---

# Connection With Minimum Bit Flips

This problem is closely related to **Minimum Bit Flips**.

Both use exactly the same core idea:

```text
x ^ y
```

Why?

Because:

```text
Different bits → 1
Same bits      → 0
```

Therefore:

```text
Hamming Distance
       =
Number of bit flips required
```

For example:

```text
x = 10 = 1010
y =  7 = 0111

x ^ y = 1101
```

There are `3` set bits.

So:

```text
Hamming Distance = 3
Minimum Bit Flips = 3
```

---

# Key Takeaways

### 1. XOR identifies different bits

```java
x ^ y
```

### 2. Count the `1`s

```text
Number of 1s = Hamming Distance
```

### 3. `n & (n - 1)` removes the rightmost `1`

```java
n = n & (n - 1);
```

### 4. Java provides a built-in method

```java
Integer.bitCount(n)
```

---

# Pattern to Remember

```text
Two numbers
     ↓
    XOR
     ↓
Different bits become 1
     ↓
Count the 1s
     ↓
Hamming Distance
```

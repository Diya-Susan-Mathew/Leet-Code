# Find Complement

## Problem

Given a positive integer `num`, return its **bitwise complement**.

Complement means:

```text
0 → 1
1 → 0
```

For example:

```text
num = 5

5 = 101
Complement = 010

Answer = 2
```

---

## Approach

We cannot simply use `~num` because Java `int` uses **32 bits**, while the problem only wants to complement the bits present in `num`.

### Step 1: Create a Mask

Create a number containing all `1`s with the same number of bits as `num`.

For:

```text
num = 101
```

we need:

```text
mask = 111
```

We create it using:

```java
mask = (mask << 1) + 1;
```

This produces:

```text
1 → 11 → 111 → 1111 → ...
```

### Step 2: XOR with the Mask

```text
  111
^ 101
-----
  010
```

XOR flips the bits because:

```text
1 ^ 1 = 0
1 ^ 0 = 1
```

---

## Code

```java
class Solution {

    public int findComplement(int num) {

        int mask = 1;

        if (num < 0) {
            return 0;
        }

        while (mask < num) {
            mask = (mask << 1) + 1;
        }

        return mask ^ num;
    }
}
```

---

## Dry Run

For:

```text
num = 5
```

Binary:

```text
101
```

Build the mask:

```text
mask = 1
mask = 11
mask = 111
```

Now:

```text
  111
^ 101
-----
  010
```

`010` is `2`.

### Answer

```text
2
```

---

## Important Pattern

### Create all-ones mask

```java
mask = (mask << 1) + 1;
```

### Find complement

```java
mask ^ num
```

Think:

```text
Number
   ↓
Create 111...111 mask
   ↓
XOR
   ↓
Complement
```

---

## Complexity

If `n` has `b` bits:

```text
Time:  O(b) = O(log n)
Space: O(1)
```

### Key Takeaway

**Don't use `~num` directly.**

Use:

```text
Complement = all-1s mask XOR num
```
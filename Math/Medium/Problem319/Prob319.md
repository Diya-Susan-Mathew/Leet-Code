# LeetCode 319 — Bulb Switch

## Problem

There are `n` bulbs initially turned **OFF**.

You make `n` rounds:

* **Round 1:** Toggle every bulb.
* **Round 2:** Toggle every 2nd bulb.
* **Round 3:** Toggle every 3rd bulb.
* ...
* **Round n:** Toggle only bulb `n`.

Return the number of bulbs that are **ON** after all rounds.

---

## Example

For `n = 5`:

| Round | Bulbs Toggled |
| ----- | ------------- |
| 1     | 1, 2, 3, 4, 5 |
| 2     | 2, 4          |
| 3     | 3             |
| 4     | 4             |
| 5     | 5             |

Final state:

```text
Bulb 1 → ON
Bulb 2 → OFF
Bulb 3 → OFF
Bulb 4 → OFF
Bulb 5 → ON
```

Answer = `2`

---

# Key Observation ⭐

Instead of simulating every round, think about **how many times each bulb is toggled**.

A bulb `x` is toggled whenever the round number is a **factor of x**.

For example:

```text
Bulb 12

Factors of 12:
1, 2, 3, 4, 6, 12
```

So bulb `12` is toggled **6 times**.

Since it starts OFF:

* Even number of toggles → OFF
* Odd number of toggles → ON

Therefore, a bulb is ON only if it has an **odd number of factors**.

---

# When Does a Number Have an Odd Number of Factors?

Normally, factors come in pairs.

For example, `12`:

```text
1 × 12
2 × 6
3 × 4
```

The factors are:

```text
1, 2, 3, 4, 6, 12
```

They form pairs:

```text
(1, 12)
(2, 6)
(3, 4)
```

So there are `6` factors → even.

---

## Perfect Squares Are Different

Consider `9`:

```text
1 × 9
3 × 3
```

The factor `3` is paired with itself.

So the factors are:

```text
1, 3, 9
```

There are `3` factors → odd.

Therefore:

> **Only perfect squares have an odd number of factors.**

---

# Therefore...

The bulbs that remain ON are exactly the bulbs whose numbers are **perfect squares**.

For example, if:

```text
n = 10
```

Perfect squares ≤ 10 are:

```text
1, 4, 9
```

So the answer is:

```text
3
```

---

# How Many Perfect Squares Are ≤ n?

We simply calculate:

```text
√n
```

For example:

```text
n = 10

√10 = 3.16
```

There are `3` perfect squares ≤ 10:

```text
1² = 1
2² = 4
3² = 9
```

So:

```text
floor(√10) = 3
```

---

# Java Solution

```java
class Solution {

    public int bulbSwitch(int n) {

        return (int)Math.sqrt(n);

    }
}
```

---

# Understanding the Code

### `Math.sqrt(n)`

Calculates the square root of `n`.

For example:

```java
Math.sqrt(10)
```

gives approximately:

```text
3.162277...
```

### `(int)`

Casting a `double` to `int` removes the decimal part.

```java
(int) 3.162277
```

becomes:

```text
3
```

Therefore:

```java
return (int)Math.sqrt(n);
```

returns the number of perfect squares from `1` to `n`.

---

# Dry Run

Suppose:

```text
n = 25
```

Calculate:

```text
√25 = 5
```

Perfect squares:

```text
1² = 1
2² = 4
3² = 9
4² = 16
5² = 25
```

There are `5` perfect squares.

Therefore:

```text
Answer = 5
```

---

# Another Example

Suppose:

```text
n = 20
```

```text
√20 ≈ 4.47
```

After casting:

```java
(int)4.47 = 4
```

Perfect squares ≤ 20:

```text
1, 4, 9, 16
```

Therefore:

```text
Answer = 4
```

---

# Why We Don't Simulate

A brute-force solution would toggle bulbs repeatedly.

For large `n`, this would take a lot of operations.

Instead, we use the mathematical observation:

```text
Bulb is ON
      ↓
Odd number of toggles
      ↓
Odd number of factors
      ↓
Perfect square
      ↓
Count perfect squares ≤ n
      ↓
floor(√n)
```

---

# Complexity

### Time Complexity

```text
O(1)
```

We only calculate the square root.

### Space Complexity

```text
O(1)
```

No extra data structures are used.

---

# Pattern to Remember 🧠

This is a **Mathematical Observation / Number Theory** problem.

The important chain to remember is:

```text
Factors → Toggle count → Odd/Even → Perfect Square → √n
```

### ⭐ Core Concept

> **A number has an odd number of factors if and only if it is a perfect square.**

That's the main trick behind this problem.

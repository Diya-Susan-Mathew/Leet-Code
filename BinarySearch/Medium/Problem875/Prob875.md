# LeetCode 875 — Koko Eating Bananas

## Java Solution

```java
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int max = piles[0];

        for (int i = 0; i < piles.length; i++) {
            if (piles[i] >= max) {
                max = piles[i];
            }
        }

        int right = max;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long total = countBananas(piles, mid);

            if (total <= h) {
                right = mid - 1;
            } else if (total > h) {
                left = mid + 1;
            }
        }

        return left;
    }

    private long countBananas(int pile[], int BananaCount) {
        long totalHours = 0;

        for (int i = 0; i < pile.length; i++) {
            totalHours += (pile[i] + BananaCount - 1) / BananaCount;
        }

        return totalHours;
    }
}
```

## Intuition

We need the **minimum eating speed** `k` such that Koko can finish all bananas within `h` hours.

Instead of trying every speed, we use **Binary Search on the Answer**.

The key observation is:

> If Koko can finish all bananas at speed `k`, she can also finish them at any speed greater than `k`.

So the answers have a pattern like:

```text
1  2  3  4  5  6  7
X  X  X  ✓  ✓  ✓  ✓
```

We need to find the **first valid speed**.

---

## Step 1 — Find the Search Range

The minimum possible speed is:

```java
int left = 1;
```

The maximum possible speed is the largest pile:

```java
int right = max;
```

So:

```text
Search space = [1, maximum pile]
```

---

## Step 2 — Calculate the Middle Speed

```java
int mid = left + (right - left) / 2;
```

`mid` is our current possible eating speed.

We then calculate how many hours Koko needs at this speed:

```java
long total = countBananas(piles, mid);
```

---

## Step 3 — Calculate Required Hours

For every pile, we calculate:

```text
ceil(pile / speed)
```

The code uses:

```java
(pile[i] + BananaCount - 1) / BananaCount
```

This is an integer way to calculate ceiling division.

### Example

Suppose:

```text
pile = 10
speed = 3
```

Then:

```text
ceil(10 / 3) = 4
```

Using the formula:

```text
(10 + 3 - 1) / 3
= 12 / 3
= 4
```

Another example:

```text
pile = 9
speed = 3

(9 + 3 - 1) / 3
= 11 / 3
= 3
```

The helper method adds these hours for every pile.

---

## Step 4 — Binary Search Decision

If:

```java
total <= h
```

Koko can finish within the allowed time.

Therefore, `mid` works, but we want an even smaller speed:

```java
right = mid - 1;
```

If:

```java
total > h
```

Koko is too slow.

We need a larger speed:

```java
left = mid + 1;
```

---

## Example

Given:

```text
piles = [3, 6, 7, 11]
h = 8
```

Initial range:

```text
left = 1
right = 11
```

### Step 1

```text
mid = 6
```

Hours needed:

```text
3  → 1 hour
6  → 1 hour
7  → 2 hours
11 → 2 hours

Total = 6
```

Since:

```text
6 <= 8
```

speed `6` works.

Try smaller:

```text
right = 5
```

### Step 2

```text
left = 1
right = 5
mid = 3
```

Hours:

```text
3  → 1
6  → 2
7  → 3
11 → 4

Total = 10
```

Since:

```text
10 > 8
```

speed `3` is too slow.

Therefore:

```text
left = 4
```

### Step 3

```text
left = 4
right = 5
mid = 4
```

Hours:

```text
3  → 1
6  → 2
7  → 2
11 → 3

Total = 8
```

Speed `4` works.

So:

```text
right = 3
```

Now:

```text
left = 4
right = 3
```

The loop ends.

Therefore:

```java
return left;
```

returns:

```text
4
```

---

## Why Do We Return `left`?

At the end:

```text
right < left
```

When a speed works, we move `right` to the left:

```java
right = mid - 1;
```

This keeps searching for a smaller valid speed.

Eventually, `left` points to the **smallest speed that works**.

This is a common pattern for:

> Find the minimum value that satisfies a condition.

---

## Complexity

Let:

```text
n = piles.length
M = maximum pile
```

For every binary-search step, we scan all piles:

```text
O(n)
```

The number of binary-search steps is:

```text
O(log M)
```

Therefore:

### Time Complexity

```text
O(n log M)
```

### Space Complexity

```text
O(1)
```

---

## Key Takeaways

### 1. Identify the answer range

```java
left = 1;
right = max pile;
```

### 2. Binary search the answer

```java
int mid = left + (right - left) / 2;
```

### 3. Check whether `mid` works

```java
long total = countBananas(piles, mid);
```

### 4. If it works, search smaller

```java
right = mid - 1;
```

### 5. If it doesn't work, search larger

```java
left = mid + 1;
```

### 6. Return the first valid value

```java
return left;
```

---

## General Pattern — Binary Search on Answer

This problem follows this template:

```java
int left = minimumPossibleAnswer;
int right = maximumPossibleAnswer;

while (left <= right) {

    int mid = left + (right - left) / 2;

    if (mid satisfies the condition) {
        right = mid - 1;
    } else {
        left = mid + 1;
    }
}

return left;
```

Whenever a problem asks for the **minimum value such that a condition becomes true**, and the condition is monotonic, think:

**Binary Search on Answer.**

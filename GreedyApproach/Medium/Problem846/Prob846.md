# Hand of Straights

## Problem

You are given an integer array `hand` where `hand[i]` is the value of a card in your hand.

You want to rearrange the cards into groups of size `groupSize`, where each group consists of consecutive cards.

Return `true` if it is possible to rearrange the cards into such groups, otherwise return `false`.

---

## Approach

We use a `TreeMap` to store the frequency of each card.

### Steps

1. If the total number of cards is not divisible by `groupSize`, return `false`.
2. Store the frequency of each card in a `TreeMap`.

   * `TreeMap` keeps the keys sorted.
3. Traverse the keys in ascending order.
4. For every card:

   * If its remaining frequency is greater than `0`, it must be the starting card of a new group.
   * Let `currentValue` be its frequency.
   * We need `currentValue` copies of every consecutive card:

     ```
     key, key + 1, key + 2, ..., key + groupSize - 1
     ```
   * If any required card does not have enough copies, return `false`.
   * Otherwise, decrease the frequency of each card by `currentValue`.
5. If all cards can be grouped successfully, return `true`.

---

## Java Code

```java
class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        if (hand.length % groupSize != 0) {
            return false;
        }

        for (int value : hand) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        for (int key : map.keySet()) {

            int currentValue = map.get(key);

            if (currentValue > 0) {

                for (int i = key; i < key + groupSize; i++) {

                    if (map.getOrDefault(i, 0) < currentValue) {
                        return false;
                    }

                    map.put(i, map.get(i) - currentValue);
                }
            }
        }

        return true;
    }
}
```

---

## Example

### Input

```text
hand = [1,2,3,6,2,3,4,7,8]
groupSize = 3
```

### Groups

```text
[1,2,3]
[2,3,4]
[6,7,8]
```

Since every group contains `3` consecutive cards:

```text
Output: true
```

---

## Why `TreeMap`?

A `TreeMap` stores keys in sorted order.

For example:

```text
hand = [2,3,4,1,2,3]
```

The map will contain:

```text
1 -> 1
2 -> 2
3 -> 2
4 -> 1
```

Processing the cards in sorted order ensures that the smallest available card is always handled first.

If the smallest available card is `1`, it cannot be placed later in another group. Therefore, we must start a group from `1`.

---

## Complexity Analysis

Let `n` be the number of cards.

### Time Complexity

Building the `TreeMap` takes:

```text
O(n log n)
```

Processing the groups takes at most:

```text
O(n log n)
```

Therefore:

```text
Time Complexity: O(n log n)
```

### Space Complexity

The `TreeMap` can contain up to `n` distinct card values:

```text
Space Complexity: O(n)
```

---

## Key Idea

The most important observation is:

> The smallest available card must be the starting card of a consecutive group.

Using a `TreeMap` lets us efficiently find and process cards in sorted order.

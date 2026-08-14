# LeetCode 904 - Fruit Into Baskets

## Problem

You are visiting a farm with a row of fruit trees represented by an integer array `fruits`.

Each element represents the type of fruit produced by that tree.

You have two baskets, and each basket can hold only one type of fruit.

Starting from any tree, you must pick fruit from every consecutive tree until you stop.

Return the maximum number of fruits you can collect.

### Example

**Input:**
`fruits = [1,2,1]`

**Output:**
`3`

**Explanation:**

We can collect all three fruits because there are only two different fruit types:

`[1,2,1]`

---

## Approach

We use the **Sliding Window + HashMap** technique.

The HashMap stores the frequency of each fruit type inside the current window.

`fruit type → frequency`

Since we have only two baskets, the window can contain at most **two distinct fruit types**.

### Step 1: Expand the Window

Move `right` through the array and add the current fruit to the HashMap.

```java
map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
```

### Step 2: Shrink the Window

If the HashMap contains more than two different fruit types:

```java
while (map.size() > 2)
```

we move `left` forward.

We decrease the frequency of `fruits[left]`.

If its frequency becomes `0`, we remove it from the HashMap.

### Step 3: Calculate Maximum Length

Once the window contains at most two fruit types, calculate its length:

```java
right - left + 1
```

Then update the maximum length:

```java
maxLength = Math.max(maxLength, right - left + 1);
```


---

## Important Correction

In the original code, you wrote:

```java
map.put(fruits[right], map.getOrDefault(fruits, 0) + 1);
```

This is incorrect because `fruits` is the entire array.

The correct statement is:

```java
map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
```

### Why?

The HashMap stores:

`fruit type → frequency`

Therefore, we need to use the current fruit `fruits[right]` as the key.

---

## Dry Run

Consider:

`fruits = [1,2,1,2,3]`

### Step 1

Window: `[1]`

Map: `{1=1}`

Length: `1`

### Step 2

Window: `[1,2]`

Map: `{1=1, 2=1}`

Length: `2`

### Step 3

Window: `[1,2,1]`

Map: `{1=2, 2=1}`

Length: `3`

### Step 4

Window: `[1,2,1,2]`

Map: `{1=2, 2=2}`

Length: `4`

So:

`maxLength = 4`

### Step 5

Add `3`:

Window: `[1,2,1,2,3]`

Map: `{1=2, 2=2, 3=1}`

Now there are three different fruit types.

Since we can have only two baskets, we shrink the window from the left until it contains at most two different fruit types.

---

## Why Sliding Window?

The problem asks for the **longest contiguous subarray** containing at most two distinct values.

This is a common **Sliding Window** pattern.

We maintain the condition:

`Number of distinct fruit types <= 2`

When the condition becomes invalid:

`map.size() > 2`

we move `left` forward until the window becomes valid again.

---

## Complexity

### Time Complexity

**O(n)**

Each element is added to the HashMap once and removed from the window at most once.

### Space Complexity

**O(1)**

The HashMap contains at most a small number of fruit types because the window is immediately reduced when there are more than two distinct types.

---

## Pattern

**Sliding Window + HashMap**

This pattern is useful for problems involving:

- Longest subarray
- At most `K` distinct elements
- Frequency counting
- Consecutive elements
- Subarrays with constraints

### Key Idea

> Maintain a sliding window containing at most two distinct fruit types. Expand the window using `right` and shrink it using `left` whenever the number of distinct types becomes greater than two.

---

## LeetCode

**Problem:** [904. Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets/)

**Difficulty:** Medium

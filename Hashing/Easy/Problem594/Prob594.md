# LeetCode 594 - Longest Harmonious Subsequence

## 📝 Problem

A **harmonious subsequence** is a subsequence where the difference between its maximum and minimum values is exactly `1`.

Given an integer array `nums`, return the length of the longest harmonious subsequence.

### Example

**Input:**

```text
nums = [1,3,2,2,5,2,3,7]
```

**Output:**

```text
5
```

**Explanation:**

The longest harmonious subsequence is:

```text
[3,2,2,2,3]
```

The maximum is `3` and the minimum is `2`, so:

```text
3 - 2 = 1
```

Therefore, the answer is `5`.

---

## 💡 Approach

Use a **HashMap** to store the frequency of every number.

1. Count how many times each number appears.
2. For every number `key`, check whether `key + 1` exists.
3. If it exists, the two numbers form a harmonious subsequence.
4. Calculate:

```text
frequency(key) + frequency(key + 1)
```

5. Keep track of the maximum length.

### Example

For:

```text
[1,3,2,2,5,2,3,7]
```

The frequency map is:

```text
1 → 1
2 → 3
3 → 2
5 → 1
7 → 1
```

For `key = 2`:

```text
frequency(2) + frequency(3)
= 3 + 2
= 5
```

So the maximum length is `5`.

---

## 💻 Java Solution

```java
class Solution {
    public int findLHS(int[] nums) {
        int maxLength = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                int length = map.get(key) + map.get(key + 1);
                maxLength = Math.max(length, maxLength);
            }
        }

        return maxLength;
    }
}
```

---

## ⏱️ Complexity

* **Time:** `O(n)`
* **Space:** `O(n)`

---

## 🔑 Pattern

**HashMap + Frequency Counting**

### Key Idea

> Count the frequency of each number, then check consecutive values (`key` and `key + 1`) and maximize their combined frequency.

---

## 🧠 What I Learned

* Using `HashMap` for frequency counting.
* Using `getOrDefault()` to simplify frequency updates.
* Checking relationships between consecutive values.
* Finding the maximum frequency combination efficiently.

---

## 🔗 LeetCode

**Problem:** 594. Longest Harmonious Subsequence

**Difficulty:** Easy

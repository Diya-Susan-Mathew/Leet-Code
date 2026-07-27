# LeetCode 169 -- Majority Element (HashMap Approach)

## Problem

Given an integer array `nums`, return the **majority element**.

The majority element is the element that appears **more than** `n / 2`
times, where `n` is the size of the array.

It is guaranteed that the majority element always exists.

------------------------------------------------------------------------

# Intuition

The majority element appears more than half of the time.

So, if we count the frequency of every element, the one whose frequency
is greater than `n / 2` is the answer.

A **HashMap** is ideal because it stores:

-   **Key** → Array element
-   **Value** → Frequency of that element

------------------------------------------------------------------------

# Algorithm

1.  Create a `HashMap<Integer, Integer>`.
2.  Traverse the array.
3.  If the number is not present in the map, insert it with frequency
    `1`.
4.  Otherwise, increment its frequency.
5.  Traverse the keys of the map.
6.  Return the key whose frequency is greater than `n / 2`.

------------------------------------------------------------------------

# Java Solution

``` java
class Solution {
    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int max = nums.length / 2;

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        for (int key : map.keySet()) {
            if (map.get(key) > max) {
                return key;
            }
        }

        return -1;
    }
}
```

------------------------------------------------------------------------

# Dry Run

### Input

``` text
nums = [2,2,1,1,1,2,2]
```

## Building the HashMap

    Element HashMap
  --------- ------------
          2 {2=1}
          2 {2=2}
          1 {2=2, 1=1}
          1 {2=2, 1=2}
          1 {2=2, 1=3}
          2 {2=3, 1=3}
          2 {2=4, 1=3}

Now:

``` text
max = 7 / 2 = 3
```

Traverse the keys:

-   key = 2 → frequency = 4 → 4 \> 3 ✅ Return 2
-   key = 1 → frequency = 3 → not greater than 3

Answer:

``` text
2
```

------------------------------------------------------------------------

# Why `map.keySet()`?

``` java
for (int key : map.keySet()) {
    if (map.get(key) > max) {
        return key;
    }
}
```

-   `map.keySet()` returns all unique numbers stored in the map.
-   `map.get(key)` returns the frequency of that number.
-   When the frequency exceeds `n / 2`, that key is the majority element
    and is returned.

------------------------------------------------------------------------

# Complexity Analysis

## Time Complexity

-   Building the HashMap: **O(n)**
-   Traversing all keys: **O(k)**, where `k` is the number of distinct
    elements.

Overall:

``` text
O(n)
```

since `k ≤ n`.

------------------------------------------------------------------------

## Space Complexity

The HashMap stores one entry for each distinct element.

``` text
O(k)
```

Worst case:

``` text
O(n)
```

------------------------------------------------------------------------

# Key Pattern

-   HashMap
-   Frequency Counting

------------------------------------------------------------------------

# Better Approach

Although the HashMap solution is easy to understand, the optimal
solution is the **Boyer--Moore Voting Algorithm**, which solves the
problem in:

-   **Time:** `O(n)`
-   **Space:** `O(1)`

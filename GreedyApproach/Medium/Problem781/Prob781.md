# LeetCode 781 -- Rabbits in Forest

## Problem

Each rabbit answers how many **other rabbits** have the same color.

If a rabbit answers `x`, then there are exactly `x + 1` rabbits of that
color.

Return the minimum number of rabbits in the forest.

------------------------------------------------------------------------

## Intuition

If a rabbit answers `x`, it belongs to a group of size:

    x + 1

Whenever we encounter a new answer `x`, we create a new group and add
`x + 1` rabbits to the answer.

A `HashMap` stores the **remaining empty spots** in the current group.

------------------------------------------------------------------------

## Java Solution

``` java
class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> FreqMap = new HashMap<>();
        int Rabbitcount = 0;

        for(int ans : answers){
            if(!FreqMap.containsKey(ans) || FreqMap.get(ans) == 0){
                Rabbitcount = Rabbitcount + ans + 1;
                FreqMap.put(ans, ans);
            }else{
                FreqMap.put(ans, FreqMap.get(ans)-1);
            }
        }
        return Rabbitcount;
    }
}
```

------------------------------------------------------------------------

## Meaning of the HashMap

-   **Key** = rabbit's answer (`ans`)
-   **Value** = remaining rabbits that can still join the current group

Example:

For answer `2`:

-   Group size = 3
-   First rabbit creates the group.
-   Remaining spots = 2.

```{=html}
<!-- -->
```
    FreqMap.put(2, 2);

Each additional rabbit decreases the remaining spots.

When the remaining spots become `0`, the next rabbit with answer `2`
starts a new group.

------------------------------------------------------------------------

## Dry Run

Input:

    answers = [1, 1, 2]

  Rabbit   Answer   Action              Remaining     Total
  -------- -------- ------------------- ----------- -------
  1        1        Create group of 2   1                 2
  2        1        Join group          0                 2
  3        2        Create group of 3   2                 5

Answer = **5**

------------------------------------------------------------------------

# Complexity Analysis

## Time Complexity

Each rabbit is processed once.

    O(n)

## Space Complexity

The HashMap stores one entry per distinct answer.

    O(k)

where `k` is the number of distinct answers.

Worst case:

    O(n)

------------------------------------------------------------------------

## Key Pattern

-   Greedy
-   HashMap
-   Grouping / Bucket Formation

**Key Insight:** The HashMap stores the **remaining capacity of a
group**, not the frequency of answers.

# Sort Characters By Frequency

## Problem

Given a string `s`, sort it in decreasing order based on the frequency of each character.

The frequency of a character is the number of times it appears in the string.

If multiple answers are possible, any valid answer is acceptable.

---

## Approach

We use a `HashMap` to store the frequency of each character.

### Steps

1. Create a `HashMap<Character, Integer>`.
2. Traverse the string and count the frequency of every character.
3. Create a `StringBuilder` to store the result.
4. While the map is not empty:

   * Find the character with the highest frequency.
   * Append that character to the result `maxFreq` times.
   * Remove that character from the map.
5. Return the resulting string.

---

## Java Code

```java
import java.util.*;

class Solution {
    public String frequencySort(String s) {

        // Count frequency
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        while (!map.isEmpty()) {

            // Find character with maximum frequency
            char maxChar = 0;
            int maxFreq = 0;

            for (char c : map.keySet()) {
                if (map.get(c) > maxFreq) {
                    maxFreq = map.get(c);
                    maxChar = c;
                }
            }

            // Add character maxFreq times
            for (int i = 0; i < maxFreq; i++) {
                sb.append(maxChar);
            }

            // Remove it from the map
            map.remove(maxChar);
        }

        return sb.toString();
    }
}
```

---

## Example

### Input

```text
s = "tree"
```

### Frequency Map

```text
t -> 1
r -> 1
e -> 2
```

### First Iteration

The character with the highest frequency is:

```text
e -> 2
```

Append `e` twice:

```text
result = "ee"
```

Remove `e` from the map.

### Second Iteration

Remaining characters:

```text
t -> 1
r -> 1
```

Suppose `t` is selected first:

```text
result = "eet"
```

Then:

```text
result = "eetr"
```

Therefore, one valid output is:

```text
"eetr"
```

---

## Why Does This Work?

At every step, we select the character with the **highest remaining frequency**.

Therefore, characters are added to the result in decreasing order of frequency.

For example:

```text
Frequency

e -> 3
a -> 2
t -> 1
```

The result will be:

```text
eeea at
```

or:

```text
eeea t
```

depending on the characters, with all characters of higher frequency appearing before characters of lower frequency.

If two characters have the same frequency, their relative order does not matter because multiple valid answers are allowed.

---

## Complexity Analysis

Let:

* `n` = length of the string
* `k` = number of distinct characters

### Building the Frequency Map

We traverse the string once:

```text
O(n)
```

### Finding the Maximum

For every distinct character, we scan the map.

In the worst case:

```text
k + (k - 1) + (k - 2) + ... + 1
```

which is:

```text
O(k²)
```

### Building the Result

Every character is appended exactly once to the result:

```text
O(n)
```

Therefore, the overall time complexity is:

```text
Time Complexity: O(n + k²)
```

Since `k` is the number of distinct characters, and for a limited character set `k` is bounded, this approach is efficient in practice.

### Space Complexity

The `HashMap` stores `k` distinct characters, and the `StringBuilder` stores the final string.

```text
Space Complexity: O(n + k)
```

Usually this is simplified to:

```text
Space Complexity: O(n)
```

---

## Key Idea

The main idea is:

```text
Count frequency
      ↓
Find maximum frequency character
      ↓
Add it to result
      ↓
Remove it from map
      ↓
Find next maximum
      ↓
Repeat
```

This is a straightforward **HashMap + Greedy** approach.

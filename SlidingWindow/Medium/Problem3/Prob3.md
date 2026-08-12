# LeetCode 3 - Longest Substring Without Repeating Characters

## Problem

Given a string `s`, find the length of the **longest substring without repeating characters**.

### Example

```text
Input:  s = "abcabcbb"
Output: 3
```

The longest substring without repeating characters is:

```text
"abc"
```

Its length is `3`.

---

# Approach: Sliding Window + HashSet

We use a **sliding window** to keep track of a substring that contains **no duplicate characters**.

The window is represented by two pointers:

```text
left                    right
 ↓                         ↓
[a, b, c, ...]
```

We also use a `HashSet<Character>` to store the characters currently inside the window.

### How it works

1. Start both `left` and `right` at `0`.
2. Move `right` through the string.
3. If the current character is **not already in the set**, add it.
4. If the current character is already in the set, we have a duplicate.
5. Move `left` forward and remove characters from the set until the duplicate is removed.
6. Add the current character.
7. Calculate the current window length and update `maxLength`.

---

## Why do we use `while`?

This is an important part of the solution:

```java
while(set.contains(s.charAt(right))){
    set.remove(s.charAt(left));
    left++;
}
```

We use `while` instead of `if` because sometimes we need to remove **more than one character** before the duplicate disappears.

For example:

```text
s = "abba"
```

When `right` reaches the second `b`:

```text
[a, b, b]
 ↑     ↑
left  right
```

`b` is already in the set.

First, remove `a`:

```text
[b, b]
 ↑
left
```

There is still a `b` in the set, so we remove the first `b` too.

Now the duplicate is gone, and we can add the new `b`.


---

# Dry Run

Consider:

```text
s = "abcabcbb"
```

### Start

```text
left = 0
maxLength = 0
set = {}
```

### `right = 0`

Character = `a`

```text
set = {a}
window = "a"
length = 1
```

`maxLength = 1`

---

### `right = 1`

Character = `b`

```text
set = {a, b}
window = "ab"
length = 2
```

`maxLength = 2`

---

### `right = 2`

Character = `c`

```text
set = {a, b, c}
window = "abc"
length = 3
```

`maxLength = 3`

---

### `right = 3`

Character = `a`

`a` is already in the set.

So we enter:

```java
while(set.contains(s.charAt(right)))
```

Remove `s[left]`, which is `a`:

```text
set = {b, c}
left = 1
```

Now add the new `a`:

```text
set = {b, c, a}
window = "bca"
length = 3
```

`maxLength` remains `3`.

The same process continues for the remaining characters.

Final answer:

```text
3
```

---

# Why `right - left + 1`?

The current window is from index `left` to index `right`.

Therefore, its length is:

```text
right - left + 1
```

For example:

```text
index:   0 1 2
         a b c
         ↑   ↑
       left right
```

Length:

```text
2 - 0 + 1 = 3
```

So we use:

```java
maxLength = Math.max(maxLength, right - left + 1);
```

---

# Complexity

## Time Complexity: O(n)

Although there is a `while` loop inside the `for` loop, the overall complexity is still **O(n)**.

Why?

- `right` moves from left to right through the string once.
- `left` also only moves forward.
- Each character can be added to and removed from the `HashSet` at most once.

Therefore:

```text
Time = O(n)
```

where `n` is the length of the string.

## Space Complexity: O(min(n, character set size))

The `HashSet` stores the characters currently in the window.

For a general string:

```text
Space = O(n)
```

In Java, if the input is restricted to a fixed character set such as ASCII, the space can effectively be considered:

```text
O(1)
```

---

# Is There a Better Approach?

Yes. There is a more optimized version using a **HashMap** (or an integer array for fixed character sets).

Instead of removing characters one by one with:

```java
while(set.contains(s.charAt(right))){
    set.remove(s.charAt(left));
    left++;
}
```

we can store the **last index where each character appeared**.

For example:

```text
s = "abba"

a → 0
b → 1
```

When we encounter the second `b` at index `2`, we already know that the previous `b` was at index `1`.

So we can jump `left` directly:

```text
left = previousIndexOfB + 1
     = 1 + 1
     = 2
```

Instead of moving `left` one step at a time.

### Optimized HashMap approach

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);

            if(map.containsKey(ch)){
                left = Math.max(left, map.get(ch) + 1);
            }

            map.put(ch, right);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
```

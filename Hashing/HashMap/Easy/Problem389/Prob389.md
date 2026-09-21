# LeetCode 389 — Find the Difference

## Problem Idea

We are given two strings:

- `s` contains the original characters.
- `t` contains all characters from `s` plus **one extra character**.
- We need to find the extra character.

Example:

```text
s = "abcd"
t = "abcde"

Answer = 'e'
```

There are multiple ways to solve this problem. The three approaches below use different ideas.

---

# Approach 1 — My Code: HashMap Frequency Counting

```java
class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();

        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        for(char c : s.toCharArray()){
            map.put(c,map.get(c)-1);

            if(map.get(c) == 0){
                map.remove(c);
            }
        }

        for(char c : map.keySet()){
            return c;
        }

        return ' ';
    }
}
```

## Intuition

This approach uses a `HashMap` to store the **frequency of each character**.

### Step 1: Count characters in `t`

```java
for(char c : t.toCharArray()){
    map.put(c, map.getOrDefault(c,0)+1);
}
```

For:

```text
s = "abcd"
t = "abcde"
```

the map becomes:

```text
a → 1
b → 1
c → 1
d → 1
e → 1
```

### Step 2: Remove the characters belonging to `s`

```java
for(char c : s.toCharArray()){
    map.put(c,map.get(c)-1);

    if(map.get(c) == 0){
        map.remove(c);
    }
}
```

Processing `"abcd"`:

```text
a → 1 - 1 = 0 → remove
b → 1 - 1 = 0 → remove
c → 1 - 1 = 0 → remove
d → 1 - 1 = 0 → remove
e → remains 1
```

Now the map is:

```text
e → 1
```

Therefore, the remaining key is the extra character.

### Step 3: Return the remaining key

```java
for(char c : map.keySet()){
    return c;
}
```

There should only be one character left, so the first key is the answer.

---

# Approach 2 — Frequency Array

```java
class Solution {
    public char findTheDifference(String s, String t) {
        int[] count = new int[26];

        for (char c : t.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            count[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return (char) ('a' + i);
            }
        }

        return ' ';
    }
}
```

## Intuition

Instead of using a `HashMap`, we use an array of size `26`.

Each index represents a lowercase English letter:

```text
index:   0  1  2  3  ... 25
letter:  a  b  c  d  ... z
```

The expression:

```java
c - 'a'
```

converts a character into its array index.

For example:

```text
'a' - 'a' = 0
'b' - 'a' = 1
'c' - 'a' = 2
'd' - 'a' = 3
```

We:

1. Add `1` for every character in `t`.
2. Subtract `1` for every character in `s`.
3. The character whose count is not zero is the extra character.

---

# Approach 3 — XOR / Bit Manipulation

```java
class Solution {
    public char findTheDifference(String s, String t) {
        char result = 0;

        for (char c : s.toCharArray()) {
            result ^= c;
        }

        for (char c : t.toCharArray()) {
            result ^= c;
        }

        return result;
    }
}
```

## Intuition

This uses the properties of XOR:

```text
x ^ x = 0
x ^ 0 = x
```

So identical characters cancel each other.

For:

```text
s = "abcd"
t = "abcde"
```

we effectively calculate:

```text
a ^ b ^ c ^ d ^ a ^ b ^ c ^ d ^ e
```

The matching characters cancel:

```text
(a ^ a) = 0
(b ^ b) = 0
(c ^ c) = 0
(d ^ d) = 0
```

Only:

```text
e
```

remains.

---

# Time Complexity Comparison

Let `n = s.length()`.

Since `t` has one additional character, `t.length() = n + 1`.

## My HashMap Approach

There are three loops:

```java
for(char c : t.toCharArray())
```

→ `O(n)`

```java
for(char c : s.toCharArray())
```

→ `O(n)`

```java
for(char c : map.keySet())
```

The map contains at most 26 distinct lowercase characters, so this is:

→ `O(26)` = `O(1)`

Overall:

```text
O(n) + O(n) + O(1)
= O(n)
```

### Time Complexity: `O(n)`

---

## Frequency Array Approach

There are also three loops:

```java
for (char c : t.toCharArray())
```

→ `O(n)`

```java
for (char c : s.toCharArray())
```

→ `O(n)`

```java
for (int i = 0; i < 26; i++)
```

→ `O(26)` = `O(1)`

Overall:

```text
O(n)
```

### Time Complexity: `O(n)`

---

## XOR Approach

Two loops process the strings:

```java
for (char c : s.toCharArray())
```

→ `O(n)`

```java
for (char c : t.toCharArray())
```

→ `O(n)`

Overall:

```text
O(n)
```

### Time Complexity: `O(n)`

---

# Space Complexity Comparison

| Approach | Extra Space | Why? |
|---|---:|---|
| My HashMap | `O(1)` | At most 26 distinct lowercase letters |
| Frequency Array | `O(1)` | Fixed array of size 26 |
| XOR | `O(1)` | Only one variable, `result` |

Technically, all three are `O(1)` **under the problem's lowercase-English-letter constraint**.

If the character set were allowed to grow with the input, a HashMap could require `O(k)` space, where `k` is the number of distinct characters.

---

# Full Comparison

| Approach | Main Idea | Time | Space | Extra Data Structure |
|---|---|---:|---:|---|
| **My Code** | HashMap frequency counting | `O(n)` | `O(1)`* | `HashMap` |
| Frequency Array | Array frequency counting | `O(n)` | `O(1)` | `int[26]` |
| XOR | Matching values cancel | `O(n)` | `O(1)` | None |

`*` Because there are only 26 possible lowercase letters.

---

# Which Approach Is Best?

## 1. My HashMap Approach

### Advantages

- Easy to understand.
- Works naturally with frequency counting.
- Good practice for `HashMap`.
- The logic is very general.

### Disadvantages

- More code than XOR.
- HashMap operations have more overhead than direct array access.
- For this particular problem, the character set is known to be only 26 lowercase letters, so a HashMap is unnecessary.

---

## 2. Frequency Array

This is a good middle ground.

It keeps the **frequency-counting idea** but avoids the overhead of a `HashMap`.

Instead of:

```java
Map<Character, Integer> map
```

we use:

```java
int[] count = new int[26];
```

Because the alphabet is fixed at 26 characters, direct array indexing is efficient.

---

## 3. XOR

The XOR solution is the most compact and uses no frequency data structure.

The key pattern to recognize is:

```text
same value ^ same value = 0
```

So when everything occurs in pairs except one element, XOR can often find the unpaired element.

---

# Important DSA Pattern to Remember

When you see:

> Every element appears twice except one.

Think:

```text
XOR
```

Example:

```text
[4, 1, 2, 1, 2]
```

Then:

```text
4 ^ 1 ^ 2 ^ 1 ^ 2
```

becomes:

```text
4 ^ (1 ^ 1) ^ (2 ^ 2)
= 4
```

When you see:

> Count how many times each character/number appears.

Think:

```text
HashMap
```

or, when the range is small and fixed:

```text
Frequency Array
```

---

# My Takeaway

My solution is a **HashMap frequency-counting solution**.

The thought process is:

```text
Count everything in t
        ↓
Subtract everything in s
        ↓
The extra character remains
```

The frequency-array solution uses the **same fundamental idea**, but replaces the HashMap with a fixed `int[26]`.

The XOR solution is fundamentally different:

```text
XOR everything in s and t
        ↓
Matching characters cancel
        ↓
Extra character remains
```

All three have:

```text
Time  → O(n)
Space → O(1) under the lowercase-English-letter constraint
```

For learning DSA, the most important thing is not just memorizing the shortest solution. It is recognizing the three patterns:

```text
Frequency counting → HashMap
Small fixed range → Frequency Array
Pairs + one unmatched element → XOR
```

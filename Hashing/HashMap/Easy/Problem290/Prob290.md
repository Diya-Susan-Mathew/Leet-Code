# LeetCode 290 — Word Pattern

## Problem

Given a pattern and a string of words, determine whether the words follow the same pattern.

Example:

```text
pattern = "abba"
s = "dog cat cat dog"
```

Mapping:

```text
a → dog
b → cat
b → cat
a → dog
```

So the answer is `true`.

---

# My Solution

```java
class Solution {

    public boolean wordPattern(String pattern, String s) {

        Map<Character,String> letterToWord = new HashMap<>();

        Map<String,Character> wordToLetter = new HashMap<>();

        String[] words = s.split(" ");

        if(pattern.length() != words.length){
            return false;
        }

        for(int i=0;i<pattern.length();i++){

            char c = pattern.charAt(i);
            String word = words[i];

            if(letterToWord.containsKey(c) &&
               !(letterToWord.get(c).equals(word))){
                return false;
            }

            if(wordToLetter.containsKey(word) &&
               !(wordToLetter.get(word).equals(c))){
                return false;
            }

            letterToWord.put(c,word);
            wordToLetter.put(word,c);
        }

        return true;
    }
}
```

---

# Intuition

The key idea is that the pattern requires a **one-to-one relationship** between a character and a word.

We therefore maintain two mappings:

```text
Character → Word
Word → Character
```

These are represented by:

```java
Map<Character, String> letterToWord
Map<String, Character> wordToLetter
```

The first map checks that the **same character always maps to the same word**.

The second map checks that the **same word always maps to the same character**.

This two-way checking is what makes the solution work.

---

# Step 1 — Split the String

```java
String[] words = s.split(" ");
```

For:

```text
s = "dog cat cat dog"
```

we get:

```text
words[0] = "dog"
words[1] = "cat"
words[2] = "cat"
words[3] = "dog"
```

So we can compare:

```text
index     0     1     2     3
pattern   a     b     b     a
word      dog   cat   cat   dog
```

---

# Step 2 — Check the Number of Words

```java
if(pattern.length() != words.length){
    return false;
}
```

The number of pattern characters must equal the number of words.

For example:

```text
pattern = "abba"        → 4 characters
s = "dog cat cat"       → 3 words
```

These cannot match, so we immediately return `false`.

---

# Step 3 — Get the Current Pair

```java
char c = pattern.charAt(i);
String word = words[i];
```

At each index we get a pair:

```text
character ↔ word
```

For example:

```text
a ↔ dog
b ↔ cat
```

---

# Step 4 — Check Character → Word

```java
if(letterToWord.containsKey(c) &&
   !(letterToWord.get(c).equals(word))){
    return false;
}
```

This asks:

> Has this character already been assigned a word?

If yes, it must be assigned to the **same** word.

For example, suppose we already have:

```text
a → dog
```

and later encounter:

```text
a → fish
```

That is invalid because `a` cannot represent both `dog` and `fish`.

So we return:

```text
false
```

---

# Step 5 — Check Word → Character

```java
if(wordToLetter.containsKey(word) &&
   !(wordToLetter.get(word).equals(c))){
    return false;
}
```

This asks:

> Has this word already been assigned to a different character?

Consider:

```text
pattern = "ab"
s = "dog dog"
```

First:

```text
a ↔ dog
```

is stored.

Then we encounter:

```text
b ↔ dog
```

The first map does not detect a problem because `b` has not been mapped yet.

But the second map contains:

```text
dog → a
```

while we are trying to create:

```text
dog → b
```

So the pattern is invalid.

This is why **two HashMaps are necessary**.

---

# Step 6 — Store Both Directions

If both checks pass:

```java
letterToWord.put(c,word);
wordToLetter.put(word,c);
```

For:

```text
a ↔ dog
```

we store:

```text
letterToWord:
a → dog

wordToLetter:
dog → a
```

This allows us to validate the relationship from either direction.

---

# Dry Run

Consider:

```text
pattern = "abba"
s = "dog cat cat dog"
```

### i = 0

```text
a ↔ dog
```

Maps:

```text
a → dog
dog → a
```

### i = 1

```text
b ↔ cat
```

Maps:

```text
a → dog
b → cat

dog → a
cat → b
```

### i = 2

```text
b ↔ cat
```

Already mapped:

```text
b → cat
cat → b
```

Both agree, so continue.

### i = 3

```text
a ↔ dog
```

Again:

```text
a → dog
dog → a
```

No conflict.

Finally:

```java
return true;
```

---

# Complexity Analysis

Let:

```text
n = pattern.length()
m = s.length()
```

## `split(" ")`

```java
String[] words = s.split(" ");
```

This processes the input string, so it takes:

```text
O(m)
```

time and creates the words array, requiring space proportional to the input:

```text
O(m)
```

---

## Length Check

```java
if(pattern.length() != words.length)
```

This is:

```text
O(1)
```

---

## Main Loop

```java
for(int i = 0; i < pattern.length(); i++)
```

The loop runs `n` times.

Inside it, we perform `HashMap` operations such as:

```java
containsKey()
get()
put()
```

These are **O(1) average time**.

Therefore the loop is:

```text
O(n)
```

---

# Overall Time Complexity

Combining the work:

```text
split()     → O(m)
main loop   → O(n)
```

Therefore:

```text
Time = O(n + m)
```

If `N` represents the total input size, we can simply write:

```text
Time = O(N)
```

---

# Space Complexity

We create:

```java
String[] words
```

which stores the words from `s`.

We also maintain two HashMaps:

```java
Map<Character, String>
Map<String, Character>
```

Therefore the auxiliary space is:

```text
O(n + m)
```

More specifically, the maps store the distinct character/word relationships, while the `words` array stores the split words.

### Space Complexity

```text
O(n + m)
```

---

# Complexity Summary

| Part | Time | Space |
|---|---:|---:|
| `s.split(" ")` | `O(m)` | `O(m)` |
| Length check | `O(1)` | `O(1)` |
| Main loop | `O(n)` average | `O(n)` |
| **Overall** | **O(n + m)** | **O(n + m)** |

where:

```text
n = pattern length
m = length of s
```

---

# Important DSA Pattern

This problem is an example of a **bijection / one-to-one mapping**.

We need both:

```text
Character → Word
```

and:

```text
Word → Character
```

Therefore:

```text
Two-way relationship
        ↓
Two HashMaps
```

A useful rule to remember:

> If two different types of values must have a one-to-one relationship, consider maintaining mappings in both directions.

---

# Key Takeaways

### `split(" ")`

Converts:

```text
"dog cat cat dog"
```

into:

```text
["dog", "cat", "cat", "dog"]
```

### `charAt(i)`

Gets the pattern character at index `i`.

```java
char c = pattern.charAt(i);
```

### First HashMap

```text
Character → Word
```

Ensures the same character always maps to the same word.

### Second HashMap

```text
Word → Character
```

Ensures the same word cannot map to multiple characters.

### Final Complexity

```text
Time  → O(n + m)
Space → O(n + m)
```

The `HashMap` operations are considered **O(1) average time**.

---

# Pattern to Remember

```text
One-to-one relationship
        ↓
Check both directions
        ↓
Use two HashMaps
```

For this problem:

```text
'a' ↔ "dog"
'b' ↔ "cat"
```

So we maintain:

```text
Map<Character, String>
Map<String, Character>
```

# LeetCode 316 - Remove Duplicate Letters (Java)

## Problem

Given a string `s`, remove duplicate letters so that:

1. Every letter appears **exactly once**.
2. The resulting string is the **smallest in lexicographical order** among all possible results.

### Example

```text
Input:  "bcabc"
Output: "abc"
```

```text
Input:  "cbacdcbc"
Output: "acdb"
```

---

# Intuition

The challenge is not just removing duplicates.

For example,

```text
Input: cbacdcbc
```

Simply removing duplicates while keeping the first occurrence gives

```text
cbad
```

But the correct answer is

```text
acdb
```

So we need a strategy that keeps the answer as **small as possible in lexicographical order** while ensuring every character appears exactly once.

This naturally leads to a **greedy** approach.

Whenever we encounter a smaller character, we should try to place it earlier in the answer.

However, we can only remove a previously chosen character if it appears again later in the string.

This is why we need:

- the **last occurrence** of every character
- a **stack** to build the answer
- a **visited array** to avoid duplicates

---

# Approach

## Step 1: Store the last occurrence of every character

We first record the last index where each character appears.

```java
int[] last = new int[26];

for (int i = 0; i < s.length(); i++) {
    last[s.charAt(i) - 'a'] = i;
}
```

Example:

```text
String = cbacdcbc

Character    Last Index
c               7
b               6
a               2
d               4
```

Knowing the last occurrence tells us whether it is safe to remove a character from the stack.

---

## Step 2: Keep track of characters already included

```java
boolean[] seen = new boolean[26];
```

If a character has already been added to the stack, we simply skip it.

---

## Step 3: Build the answer using a stack

The stack stores the characters of the final answer.

For every character:

### Case 1

If it is already in the stack

```java
if (seen[ch - 'a'])
    continue;
```

Skip it because every character should appear only once.

---

### Case 2

If the current character is smaller than the stack's top

We ask two questions:

- Is the top character larger?
- Will that character appear again later?

If both are true, we remove it.

```java
while (!stack.isEmpty()
        && stack.peek() > ch
        && last[stack.peek() - 'a'] > i) {

    seen[stack.pop() - 'a'] = false;
}
```

Why?

Suppose

```text
Stack : [c]
Current : b
```

Since

```text
c > b
```

and another `c` exists later,

we can safely remove `c` and place `b` first.

This produces a lexicographically smaller answer.

---

### Case 3

Push the current character

```java
stack.push(ch);
seen[ch - 'a'] = true;
```

---

# Dry Run

Input

```text
cbacdcbc
```

| Current | Stack | Action |
|---------|--------|--------|
| c | c | Push |
| b | b | Pop c, Push b |
| a | a | Pop b, Push a |
| c | ac | Push |
| d | acd | Push |
| c | acd | Skip |
| b | acdb | Cannot pop d (last occurrence already passed), Push b |
| c | acdb | Skip |

Final answer

```text
acdb
```

---

# Java Solution

```java
class Solution {
    public String removeDuplicateLetters(String s) {

        // Store the last occurrence of each character
        int[] last = new int[26];

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        // Track whether a character is already in the stack
        boolean[] seen = new boolean[26];

        // Stack to build the answer
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Skip duplicate characters
            if (seen[ch - 'a']) {
                continue;
            }

            // Remove larger characters if they appear again later
            while (!stack.isEmpty()
                    && stack.peek() > ch
                    && last[stack.peek() - 'a'] > i) {

                seen[stack.pop() - 'a'] = false;
            }

            // Add current character
            stack.push(ch);
            seen[ch - 'a'] = true;
        }

        // Convert stack to string
        StringBuilder answer = new StringBuilder();

        for (char c : stack) {
            answer.append(c);
        }

        return answer.toString();
    }
}
```

---

# Why does the `while` loop work?

```java
while (!stack.isEmpty()
        && stack.peek() > ch
        && last[stack.peek() - 'a'] > i)
```

Each condition is important.

### 1. `!stack.isEmpty()`

Avoids accessing an empty stack.

---

### 2. `stack.peek() > ch`

The current character is smaller.

Replacing the larger character with the smaller one makes the answer lexicographically smaller.

Example

```text
Current Answer : cb

Better Answer  : bc
```

---

### 3. `last[stack.peek() - 'a'] > i`

Only remove the top character if it appears again later.

Otherwise, we would lose it permanently.

Example

```text
Current Stack : acd
Current Char  : b
```

Even though

```text
d > b
```

we cannot remove `d` because this is its last occurrence.

---

# Why do we use `seen[]`?

Without `seen`, duplicate characters would be inserted into the stack.

Example

```text
Input

bcabc
```

Without `seen`

```text
bcabc
```

With `seen`

```text
abc
```

---

# Complexity Analysis

### Time Complexity

```
O(n)
```

Reason:

- Every character is pushed onto the stack at most once.
- Every character is popped from the stack at most once.

Although there is a `while` loop inside the `for` loop, the total number of pop operations across the entire algorithm is at most `n`.

Hence,

```
Time Complexity = O(n)
```

---

### Space Complexity

```
O(n)
```

Reason:

- Stack can contain at most `n` characters.
- `last` array has fixed size `26`.
- `seen` array has fixed size `26`.

Overall,

```
Space Complexity = O(n)
```

---

# Key Takeaways

- Use a **stack** to build the answer.
- Store the **last occurrence** of every character.
- Use a **visited (`seen`) array** to avoid duplicates.
- Remove larger characters only if they appear again later.
- Each character is pushed and popped at most once, giving an **O(n)** solution.

---

# Pattern Learned

This problem is a classic example of a **Greedy + Monotonic Stack** pattern.

The general strategy is:

1. Iterate through the elements.
2. Skip duplicates.
3. While the current element is better (smaller) than the top of the stack **and** the top can safely be used later, remove the top.
4. Push the current element.
5. Build the final answer from the stack.

This pattern is useful for several other LeetCode problems, such as:

- 402. Remove K Digits
- 1081. Smallest Subsequence of Distinct Characters
- 321. Create Maximum Number
- 1673. Find the Most Competitive Subsequence
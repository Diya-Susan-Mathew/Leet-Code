# Backspace String Compare

**LeetCode:** 844 — Backspace String Compare  
**Difficulty:** Easy  
**Pattern:** Stack, StringBuilder  
**Language:** Java

---

## 1. Problem

Given two strings `s` and `t`, determine whether they are equal after applying backspaces.

The character:

```text
#
```

represents a backspace.

A backspace removes the character immediately before it, if one exists.

### Example 1

```text
Input:
s = "ab#c"
t = "ad#c"

Output:
true
```

Explanation:

```text
s = "ab#c"
       ↓
     "ac"

t = "ad#c"
       ↓
     "ac"
```

Therefore:

```text
"ac" == "ac"
```

---

# 2. Approach

We can use a `StringBuilder` as a **stack**.

For every character:

### If it is not `#`

Add it to the `StringBuilder`:

```java
sb.append(currentChar);
```

This is equivalent to:

```text
push()
```

### If it is `#`

Remove the last character, if the `StringBuilder` is not empty:

```java
sb.deleteCharAt(length - 1);
```

This is equivalent to:

```text
pop()
```

---

# 3. Your Solution

```java
class Solution {
    public boolean backspaceCompare(String s, String t) {

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        // Process string s
        for (int i = 0; i < s.length(); i++) {

            int length = sb1.length();

            if (s.charAt(i) != '#') {
                sb1.append(s.charAt(i));

            } else if (length > 0) {
                sb1.deleteCharAt(length - 1);
            }
        }

        String newS = sb1.toString();

        // Process string t
        for (int i = 0; i < t.length(); i++) {

            int length = sb2.length();

            if (t.charAt(i) != '#') {
                sb2.append(t.charAt(i));

            } else if (length > 0) {
                sb2.deleteCharAt(length - 1);
            }
        }

        String newT = sb2.toString();

        return newT.equals(newS);
    }
}
```

---

# 4. Dry Run

Consider:

```text
s = "ab#c"
```

Process each character:

| Character | Operation | StringBuilder |
|---|---|---|
| `a` | append | `"a"` |
| `b` | append | `"ab"` |
| `#` | delete `b` | `"a"` |
| `c` | append | `"ac"` |

Final:

```text
s → "ac"
```

Now:

```text
t = "ad#c"
```

| Character | Operation | StringBuilder |
|---|---|---|
| `a` | append | `"a"` |
| `d` | append | `"ad"` |
| `#` | delete `d` | `"a"` |
| `c` | append | `"ac"` |

Final:

```text
t → "ac"
```

Therefore:

```text
"ac".equals("ac")
```

Result:

```text
true
```

---

# 5. Important Part of the Code

This section is the core logic:

```java
if (s.charAt(i) != '#') {
    sb1.append(s.charAt(i));

} else if (length > 0) {
    sb1.deleteCharAt(length - 1);
}
```

Think of it as:

```text
        Current character
              ↓
       Is it a '#'? 
        /         \
      No           Yes
      ↓             ↓
    Push       Is stack empty?
                  /     \
                No       Yes
                ↓         ↓
              Pop       Ignore
```

---

# 6. StringBuilder as a Stack

This is the same technique used in **LeetCode 1047 — Remove All Adjacent Duplicates In String**.

| Stack operation | StringBuilder |
|---|---|
| `push(c)` | `append(c)` |
| `peek()` | `charAt(length - 1)` |
| `pop()` | `deleteCharAt(length - 1)` |
| `isEmpty()` | `length() == 0` |

So we can think of:

```text
StringBuilder
     ↓
Stack of characters
```

without actually creating a `Stack<Character>`.

---

# 7. Edge Case

Consider:

```text
s = "###a"
```

There are more backspaces than characters.

Initially:

```text
""
```

First `#`:

```text
""
```

Second `#`:

```text
""
```

Third `#`:

```text
""
```

Then:

```text
a → "a"
```

This is why we check:

```java
length > 0
```

before deleting.

Otherwise, we would try to delete from an empty `StringBuilder`.

---

# 8. Complexity

Let:

```text
n = length of s
m = length of t
```

### Time Complexity

We process every character once:

```text
O(n + m)
```

### Space Complexity

The `StringBuilder`s can store up to the length of the input:

```text
O(n + m)
```

---

# 9. Possible Simplification

You don't need:

```java
return newT.equals(newS) ? true : false;
```

because `equals()` already returns a boolean.

Instead:

```java
return newT.equals(newS);
```

This is cleaner and exactly equivalent.

---

# 10. Key Pattern to Remember

This is another **Stack + StringBuilder** problem.

The important idea is:

> **When a character represents an undo/backspace operation, remove the most recently added character.**

Pattern:

```text
Normal character
      ↓
    PUSH

Backspace #
      ↓
     POP
```

This pattern is useful for problems involving:

- Backspaces
- Undo operations
- Adjacent duplicates
- Removing characters
- Cancelling operations
- Stack-based string processing

---

# 11. Interview Takeaway

When you see a problem where:

```text
"#" = undo / backspace
```

immediately think:

```text
StringBuilder as Stack
```

Then:

```java
append()          → push
deleteCharAt()    → pop
charAt(last)      → peek
length() == 0     → empty
```

### Core Pattern

```text
Read characters from left → right
             ↓
     Maintain a stack
             ↓
   Normal character → push
   Backspace        → pop
             ↓
       Compare results
```

This is a very useful **Easy-level Stack pattern** to master before moving into harder stack problems.
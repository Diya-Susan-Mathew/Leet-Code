# LeetCode 345: Reverse Vowels of a String

## Problem
Given a string `s`, reverse only its vowels (`a`, `e`, `i`, `o`, `u`, including uppercase forms).

## Approach 1: Your Solution — Stack

```java
import java.util.Stack;

class Solution {
    public String reverseVowels(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'u' || s.charAt(i) == 'U' ||
                s.charAt(i) == 'o' || s.charAt(i) == 'O' ||
                s.charAt(i) == 'a' || s.charAt(i) == 'A' ||
                s.charAt(i) == 'e' || s.charAt(i) == 'E' ||
                s.charAt(i) == 'i' || s.charAt(i) == 'I') {
                stack.push(s.charAt(i));
            }
        }

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 'u' || sb.charAt(i) == 'U' ||
                sb.charAt(i) == 'o' || sb.charAt(i) == 'O' ||
                sb.charAt(i) == 'a' || sb.charAt(i) == 'A' ||
                sb.charAt(i) == 'e' || sb.charAt(i) == 'E' ||
                sb.charAt(i) == 'i' || sb.charAt(i) == 'I') {
                sb.setCharAt(i, stack.pop());
            }
        }

        return sb.toString();
    }
}
```

### Explanation
1. Create a stack to store vowels and a `StringBuilder` to modify the string.
2. Traverse the string and push every vowel onto the stack.
3. Traverse it again. When a vowel is found, pop the top vowel and place it at that position.
4. Return the modified string.

A stack follows **LIFO (Last In, First Out)**. Therefore, vowels come out in the reverse order in which they were pushed.

### Complexity
- **Time:** `O(n)` — two traversals.
- **Space:** `O(n)` — the stack and `StringBuilder` can store up to `n` characters.

---

## Approach 2: Two Pointers — Alternative with Less Extra Storage

```java
class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int left = 0, right = chars.length - 1;

        while (left < right) {
            while (left < right && vowels.indexOf(chars[left]) == -1) {
                left++;
            }
            while (left < right && vowels.indexOf(chars[right]) == -1) {
                right--;
            }

            // Swap vowels
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }
}
```

### Explanation
1. `toCharArray()` creates a mutable character array, since Java strings cannot be changed directly.
2. `vowels` contains lowercase and uppercase vowels.
3. `left` starts at the beginning; `right` starts at the end.
4. Move `left` until it finds a vowel. Move `right` until it finds a vowel.
5. Swap those vowels, then move both pointers inward.
6. Return the character array as a new string.

`vowels.indexOf(chars[left]) == -1` means the character is not present in the vowel string.

### Example
Input:
```text
s = "hello"
```
The vowels `e` and `o` are swapped.

Output:
```text
"holle"
```

Another example:
```text
s = "IceCreAm"
```
Output:
```text
"AceCreIm"
```

### Complexity
- **Time:** `O(n)` — the pointers move inward through the string.
- **Space:** `O(n)` for the character array; the two-pointer logic itself uses `O(1)` extra space beyond that array.

---

## Comparison

| Feature | Stack approach | Two-pointer approach |
|---|---|---|
| Main idea | Store vowels, then pop in reverse order | Find vowels from both ends and swap |
| Time | `O(n)` | `O(n)` |
| Extra storage | `O(n)` for stack and builder | `O(n)` for the character array; `O(1)` extra for pointer logic |
| Main concept | Stack / LIFO | Two pointers |

## Key Idea to Remember
- **Stack:** Collect vowels, then replace each vowel by popping from the stack.
- **Two pointers:** Find a vowel from each end and swap them. This avoids using a separate stack.

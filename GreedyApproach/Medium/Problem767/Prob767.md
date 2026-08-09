# Approach (Greedy)

1. **Count the frequency** of each character using an array of size `26`.
2. **Find the character with the highest frequency.**
3. **Check if a valid reorganization is possible.**
   - If the maximum frequency is greater than `(n + 1) / 2`, it is impossible to rearrange the string without placing two identical characters adjacent to each other. Return an empty string.
4. **Place the most frequent character first** at all even indices (`0, 2, 4, ...`).
   - This maximizes the distance between its occurrences and prevents adjacent duplicates.
5. **Fill the remaining characters** in the remaining even positions.
   - Once all even positions are occupied, continue filling the odd positions (`1, 3, 5, ...`).
6. **Construct and return** the final string from the character array.

---

# Why the Greedy Approach Works

- The character with the highest frequency is the most difficult to place.
- By placing it first in the even indices, we maximize the distance between its occurrences.
- The feasibility check (`maxCount <= (n + 1) / 2`) guarantees that there will always be enough remaining positions to place the other characters without creating adjacent duplicates.

---

# Time Complexity

- Counting character frequencies: **O(n)**
- Finding the maximum frequency: **O(26) = O(1)**
- Filling the result array: **O(n)**

**Overall Time Complexity:** **O(n)**

---

# Space Complexity

- Frequency array of size 26: **O(1)**
- Result character array of size `n`: **O(n)**

**Overall Space Complexity:** **O(n)**
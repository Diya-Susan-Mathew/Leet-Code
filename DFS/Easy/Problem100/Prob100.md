# Approach

1. **Handle the base cases:**
   - If both nodes are `null`, the trees are identical at this position, so return `true`.
   - If only one node is `null`, the tree structures differ, so return `false`.

2. **Compare the current nodes:**
   - If the values of the current nodes are different, return `false`.

3. **Recursively compare the subtrees:**
   - Compare the left subtrees using `isSameTree(p.left, q.left)`.
   - Compare the right subtrees using `isSameTree(p.right, q.right)`.
   - The trees are identical only if **both** recursive calls return `true`.

---

# Time Complexity

- **O(n)**, where `n` is the number of nodes in the trees.
- Each node is visited exactly once during the recursive traversal.

---

# Space Complexity

- **O(h)**, where `h` is the height of the tree, due to the recursion call stack.
- **Best Case (Balanced Tree):** `O(log n)`
- **Worst Case (Skewed Tree):** `O(n)`
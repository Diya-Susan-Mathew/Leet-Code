# LeetCode 104 - Maximum Depth of Binary Tree

## Problem

Given the root of a binary tree, return its **maximum depth**.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

### Example

```text
       1
      / \
     2   3
    /
   4
```

The longest path is:

```text
1 → 2 → 4
```

Therefore, the maximum depth is `3`.

---

## Approach: Recursion / DFS

We use **Depth-First Search (DFS)** with recursion.

For every node:

1. If the node is `null`, return `0`.
2. Find the maximum depth of the left subtree.
3. Find the maximum depth of the right subtree.
4. Take the larger depth.
5. Add `1` for the current node.

### Formula

```text
depth = 1 + max(leftDepth, rightDepth)
```

---

## Java Solution

```java
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
```

---

## Base Case

```java
if(root == null){
    return 0;
}
```

When we reach a `null` child, there is no node there, so its depth is `0`.

For a leaf node:

```text
depth = 1 + max(0, 0)
      = 1
```

---

## Recursive Case

The main line is:

```java
return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
```

It does three things:

- `maxDepth(root.left)` → depth of the left subtree
- `maxDepth(root.right)` → depth of the right subtree
- `Math.max(...)` → choose the deeper subtree
- `1 +` → count the current node

---

## Dry Run

Consider:

```text
       1
      / \
     2   3
    /
   4
```

### Node 4

```text
left = null  → 0
right = null → 0

depth(4) = 1 + max(0, 0)
         = 1
```

### Node 2

```text
left = 4 → 1
right = null → 0

depth(2) = 1 + max(1, 0)
         = 2
```

### Node 3

```text
left = null  → 0
right = null → 0

depth(3) = 1
```

### Node 1

```text
left = 2 → 2
right = 3 → 1

depth(1) = 1 + max(2, 1)
         = 3
```

Final answer:

```text
3
```

---

## Why `Math.max()`?

We want the **longest path** from the root to a leaf.

Therefore, we choose the subtree with the greater depth:

```java
Math.max(leftDepth, rightDepth)
```

For example:

```text
leftDepth  = 4
rightDepth = 2
```

We choose `4`, then add `1` for the current node:

```text
1 + 4 = 5
```

---

## Complexity

### Time Complexity

```text
O(n)
```

Every node is visited exactly once.

### Space Complexity

```text
O(h)
```

where `h` is the height of the tree.

This is the recursion stack.

- Balanced tree: `O(log n)`
- Completely skewed tree: `O(n)`

---

## Key Pattern to Remember

This problem demonstrates a common **binary tree recursion pattern**:

```java
if(root == null){
    return 0;
}

return 1 + Math.max(
    solve(root.left),
    solve(root.right)
);
```

The key idea is:

> **The depth of a node is 1 plus the maximum depth of its two subtrees.**

For this problem:

```java
return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
```

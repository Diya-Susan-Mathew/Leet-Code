# LeetCode 36 — Valid Sudoku

## Java Solution

```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {

                char c = board[row][col];

                if (c == '.') {
                    continue;
                }

                // Check duplicate in the same row
                String str = c + "row" + row;

                if (!set.add(str)) {
                    return false;
                }

                // Check duplicate in the same column
                String str1 = c + "col" + col;

                if (!set.add(str1)) {
                    return false;
                }

                // Check duplicate in the same 3x3 box
                String str2 = c + "" + row / 3 + "-" + col / 3;

                if (!set.add(str2)) {
                    return false;
                }
            }
        }

        return true;
    }
}
```

> **Note:** In the original code, `return false;x` contains an extra `x`. It should be `return false;`.

---

## Idea

The goal is to check whether every number from `1` to `9` appears at most once in:

1. Each row
2. Each column
3. Each 3×3 box

We use a single `HashSet<String>` to remember what has already appeared.

For every non-empty cell, we create three unique strings.

### 1. Row check

```java
String str = c + "row" + row;
```

Example:

```text
5row2
```

This means:

> Number `5` has appeared in row `2`.

If `5` appears again in row `2`, the same string is generated and `set.add()` returns `false`.

---

### 2. Column check

```java
String str1 = c + "col" + col;
```

Example:

```text
5col4
```

This means:

> Number `5` has appeared in column `4`.

If the same number appears again in that column, a duplicate is detected.

---

### 3. 3×3 Box check

```java
String str2 = c + "" + row / 3 + "-" + col / 3;
```

The expressions:

```java
row / 3
col / 3
```

identify which 3×3 box the cell belongs to.

For example:

| Row | Column | Box |
|---:|---:|---|
| 0 | 0 | 0-0 |
| 1 | 2 | 0-0 |
| 2 | 1 | 0-0 |
| 3 | 4 | 1-1 |
| 5 | 8 | 1-2 |
| 7 | 7 | 2-2 |

So:

```java
String str2 = c + "" + row / 3 + "-" + col / 3;
```

could produce:

```text
5-0-0
```

meaning:

> Number `5` has appeared in the top-left 3×3 box.

---

## Why `set.add()` is useful

`HashSet.add()` returns:

- `true` → element was not already present
- `false` → element already exists

So:

```java
if (!set.add(str)) {
    return false;
}
```

means:

> If this row/column/box combination already exists, the Sudoku is invalid.

---

## Example

Suppose we encounter:

```text
5
```

at:

```text
row = 0
col = 2
```

We add:

```text
5row0
5col2
50-0
```

If later another `5` appears at:

```text
row = 0
col = 7
```

we generate:

```text
5row0
5col7
52-0
```

`5row0` is already in the set, so:

```java
set.add("5row0")
```

returns `false`.

Therefore:

```java
return false;
```

---

## Time Complexity

There are exactly 81 cells in a Sudoku board.

For each non-empty cell, we perform constant-time `HashSet` operations.

**Time:** `O(81)` → effectively `O(1)` for a standard Sudoku board.

**Space:** `O(81)` → effectively `O(1)` for a standard Sudoku board.

---

## Important Java Point

This line:

```java
String str2 = c + "" + row / 3 + "-" + col / 3;
```

uses `""` to make sure the expression is treated as String concatenation.

You can make it clearer by writing:

```java
String str2 = c + "box" + row / 3 + "-" + col / 3;
```

For example:

```text
5box0-0
```

This is easier to understand because it explicitly tells us that the string represents a box.

---

## Core Pattern to Remember

For HashSet-based Sudoku:

```text
number + row
number + column
number + box
```

For every number, check all three.

If any one already exists → **invalid Sudoku**.

Otherwise → **valid Sudoku**.

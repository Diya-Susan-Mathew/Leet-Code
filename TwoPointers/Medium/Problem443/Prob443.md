# String Compression

## Problem

Given an array of characters `chars`, compress it using the following rules:

- Consecutive repeating characters should be represented by the character followed by its count.
- If a character appears only once, write only the character.
- The compression must be done **in-place**.
- Return the new length of the compressed array.

### Example

Input:

```text
["a","a","b","b","c","c","c"]
```

Compressed result:

```text
["a","2","b","2","c","3"]
```

Returned length:

```text
6
```

---

## Approach

We use **two pointers**:

- `read` → reads through the character array.
- `write` → writes the compressed result back into the same array.

We process one group of identical characters at a time.

### Step 1: Initialize the pointers

```text
read = 0
write = 0
```

`read` tells us which character we are currently examining.

`write` tells us where to place the compressed result.

---

### Step 2: Select the current character

We store the current character:

```text
currentchar = chars[read]
```

Then we use another loop to count how many times that character occurs consecutively.

---

### Step 3: Count consecutive characters

The inner loop continues while:

```text
currentchar == chars[read]
```

For every matching character:

- Increment `read`.
- Increment `count`.

For example:

```text
a a a b
```

When processing `a`:

```text
count = 3
read = 3
```

---

### Step 4: Write the character

After counting the group, write the character at the `write` position:

```text
chars[write++] = currentchar
```

The `write++` means:

1. Write the character at the current `write` position.
2. Move `write` to the next position.

---

### Step 5: Write the count

If the character appeared more than once:

```text
if (count > 1)
```

we convert the count into a string.

For example:

```text
count = 3
```

becomes:

```text
"3"
```

For a larger count:

```text
count = 12
```

becomes:

```text
"12"
```

Each digit is then written into the array.

The count is not written when `count == 1`.

For example:

```text
a
```

stays:

```text
a
```

while:

```text
a a a
```

becomes:

```text
a 3
```

---

## Example Walkthrough

Consider:

```text
chars = ["a","a","b","b","c","c","c"]
```

Initially:

```text
read = 0
write = 0
```

### Group 1: `aa`

Current character:

```text
a
```

Count:

```text
2
```

Write:

```text
a 2
```

Now:

```text
write = 2
read = 2
```

### Group 2: `bb`

Current character:

```text
b
```

Count:

```text
2
```

Write:

```text
b 2
```

Now the compressed array starts as:

```text
a 2 b 2
```

### Group 3: `ccc`

Current character:

```text
c
```

Count:

```text
3
```

Write:

```text
c 3
```

Final compressed array:

```text
["a","2","b","2","c","3"]
```

The value of `write` is:

```text
6
```

Therefore, the method returns:

```text
6
```

---

## Important Part of the Code

The following condition:

```text
if (count > 1)
```

is important because characters that occur only once should not have `1` written after them.

For example:

```text
a
```

should remain:

```text
a
```

not:

```text
a1
```

Similarly:

```text
a a b c c
```

becomes:

```text
a2bc2
```

---

## Why Does This Work In-Place?

We use the same `chars` array for both reading and writing.

The `read` pointer moves through the original data, while the `write` pointer stores the compressed data.

Since compression never requires more space than the original array, we can safely overwrite positions that have already been processed.

For example:

```text
Original:

a a b b c c c
```

After compression:

```text
a 2 b 2 c 3
```

The result occupies fewer positions than the original array.

---

## Algorithm

1. Initialize `read = 0`.
2. Initialize `write = 0`.
3. While `read` is less than the array length:
   - Store `chars[read]` as the current character.
   - Count all consecutive occurrences of that character.
   - Write the character at the `write` position.
   - If the count is greater than `1`, convert the count to a string.
   - Write each digit of the count into the array.
4. Return `write`.

---

## Complexity Analysis

### Time Complexity

```text
O(n)
```

The `read` pointer moves through the array once.

The total number of digits written across all groups is also bounded by `O(n)`.

Therefore, the overall time complexity is:

```text
O(n)
```

### Space Complexity

```text
O(1)
```

The compression is performed directly inside the input array.

The main algorithm uses only a constant number of variables.

---

## Key Concept

The main idea is:

```text
READ → COUNT → WRITE
```

For every group of identical characters:

```text
1. Read the character.
2. Count how many times it appears consecutively.
3. Write the character.
4. Write the count if it is greater than 1.
```

This **two-pointer technique** allows us to compress the array without using another character array.

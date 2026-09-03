# Repeated DNA Sequences

## Problem

Given a DNA string `s`, find all **10-letter-long sequences** that occur more than once.

### Example

Input:
`AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT`

Output:
`["AAAAACCCCC", "CCCCCAAAAA"]`

## Approach

1. Create a `HashSet` called `seen` to store every 10-character sequence.
2. Create another `HashSet` called `result` to store repeated sequences.
3. Traverse the string using a sliding window of size `10`.
4. Extract the current 10-character substring.
5. Try to add it to `seen`:
   - If it is added successfully → first occurrence.
   - If it already exists → repeated sequence, so add it to `result`.
6. Convert `result` to an `ArrayList` and return it.

## Why Two Sets?

- `seen` → keeps track of sequences already encountered.
- `result` → stores only repeated sequences and prevents duplicates.

## Complexity

- **Time:** O(n)
- **Space:** O(n)
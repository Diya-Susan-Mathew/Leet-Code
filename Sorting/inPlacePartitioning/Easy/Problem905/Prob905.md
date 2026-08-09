# Pattern Used: Two Pointers (Partitioning)

## Approach

This problem can be solved using the **Two Pointers** pattern, specifically the **partitioning** technique.

- Initialize two pointers:
  - `low` at the beginning of the array.
  - `high` at the end of the array.
- Traverse the array while `low <= high`.
- If the element at `low` is **even**, it is already in the correct partition, so simply move `low` forward.
- If the element at `low` is **odd**, swap it with the element at `high` and move `high` backward.
- Do **not** increment `low` after a swap because the element brought from the `high` position has not been checked yet. It could be either even or odd, so it must be processed in the next iteration.
- Continue until the two pointers meet.

This partitions the array such that all even numbers appear before all odd numbers. The relative order of the numbers is **not preserved**.

---

# Complexity Analysis

### Time Complexity: **O(n)**

- Each element is processed at most once.
- Both pointers move toward each other, resulting in a single traversal of the array.

**Overall Time Complexity:** **O(n)**

### Space Complexity: **O(1)**

- The sorting is performed **in-place** using only a few extra variables (`low`, `high`, and `temp`).

**Overall Space Complexity:** **O(1)**
# LeetCode 219 — Contains Duplicate II

## Approach
Use a **Sliding Window + HashSet**.

- Maintain a `HashSet` containing the previous `k` elements.
- For every element:
  - If the window size exceeds `k`, remove the element that falls outside the window.
  - Try to add the current element.
  - If `add()` returns `false`, the element already exists in the window → duplicate found.
- Return `false` if no nearby duplicate exists.

## Key Point

`window.add(nums[i])` returns:
- `true` → element was not present.
- `false` → element was already present.

So:

`if(!window.add(nums[i]))`

means a duplicate exists within distance `k`.

## Complexity
- **Time:** O(n)
- **Space:** O(k)

## Pattern
**Sliding Window + HashSet**
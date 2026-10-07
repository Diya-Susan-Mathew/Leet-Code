# FizzBuzz

## Problem

Given an integer `n`, return a list of strings from `1` to `n` following these rules:

* If the number is divisible by **both 3 and 5**, add `"FizzBuzz"`.
* If the number is divisible by **3**, add `"Fizz"`.
* If the number is divisible by **5**, add `"Buzz"`.
* Otherwise, add the number itself as a string.

### Example

**Input:**

```text
n = 15
```

**Output:**

```text
["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
```

---

## Approach

We iterate from `1` to `n`.

For every number `i`:

1. Check if `i` is divisible by **both 3 and 5**.
2. Otherwise, check if it is divisible by **3**.
3. Otherwise, check if it is divisible by **5**.
4. If none of these conditions are true, add `i` as a string.

### Why check both 3 and 5 first?

A number like `15` is divisible by both `3` and `5`.

If we check:

```java
if(i % 3 == 0)
```

first, `15` would become `"Fizz"` instead of `"FizzBuzz"`.

Therefore, the **combined condition must come first**.

---

## Code

```java
class Solution {
    public List<String> fizzBuzz(int n) {

        List<String> list = new ArrayList<>();

        for(int i = 1; i <= n; i++) {

            if((i % 3 == 0) && (i % 5 == 0)) {
                list.add("FizzBuzz");

            } else if(i % 3 == 0) {
                list.add("Fizz");

            } else if(i % 5 == 0) {
                list.add("Buzz");

            } else {
                list.add("" + i);
            }
        }

        return list;
    }
}
```

---

## Dry Run

For `n = 15`:

| `i` | Condition               | Added        |
| --: | ----------------------- | ------------ |
|   1 | Not divisible by 3 or 5 | `"1"`        |
|   2 | Not divisible by 3 or 5 | `"2"`        |
|   3 | Divisible by 3          | `"Fizz"`     |
|   4 | Not divisible by 3 or 5 | `"4"`        |
|   5 | Divisible by 5          | `"Buzz"`     |
|   6 | Divisible by 3          | `"Fizz"`     |
|  10 | Divisible by 5          | `"Buzz"`     |
|  12 | Divisible by 3          | `"Fizz"`     |
|  15 | Divisible by both       | `"FizzBuzz"` |

---

## Important Pattern

This problem mainly tests **conditional statements + divisibility**.

### Modulo operator

```java
i % 3 == 0
```

means:

> `i` is perfectly divisible by 3.

For example:

```text
9 % 3 = 0  → divisible
10 % 3 = 1 → not divisible
```

---

## Complexity

### Time Complexity

```text
O(n)
```

We visit every number from `1` to `n` once.

### Space Complexity

```text
O(n)
```

The result list stores `n` elements.

---

## Key Takeaway

**Always check the most specific condition first.**

```text
Both 3 and 5
       ↓
     Only 3
       ↓
     Only 5
       ↓
     Neither
```

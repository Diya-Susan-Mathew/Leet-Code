# LeetCode 338 — Counting Bits

## Problem Statement

Given an integer `n`, return an array `ans` of length `n + 1` such that:

```text
ans[i] = the number of 1's in the binary representation of i
```

for every `0 <= i <= n`.

The answer should be calculated for every number from `0` to `n`.

---

## Example 1

### Input

```text
n = 2
```

### Output

```text
[0,1,1]
```

### Explanation

The binary representations are:

```text
0 → 0    → 0 ones
1 → 1    → 1 one
2 → 10   → 1 one
```

Therefore:

```text
[0, 1, 1]
```

---

## Example 2

### Input

```text
n = 5
```

### Output

```text
[0,1,1,2,1,2]
```

### Explanation

```text
0 → 0      → 0 ones
1 → 1      → 1 one
2 → 10     → 1 one
3 → 11     → 2 ones
4 → 100    → 1 one
5 → 101    → 2 ones
```

Therefore:

```text
[0, 1, 1, 2, 1, 2]
```

---

# Java Solution

```java
class Solution {

    public int[] countBits(int n) {

        int[] nums = new int[n+1];

        nums[0] = 0;

        for(int i=1;i<=n;i++){

            int count = 0;

            int num=i;

            while(num > 0){

                num = num & (num-1);

                count++;

            }

            nums[i] = count;

        }

        return nums;

    }

}
```

# Approach

This solution uses **Brian Kernighan's Algorithm** to count the number of set bits (`1`s) in the binary representation of each number.

The key operation is:

```java
num = num & (num - 1);
```

This operation removes the **rightmost set bit** (`1`) from `num`.

Every time we perform this operation, we increment:

```java
count++;
```

When `num` becomes `0`, all the set bits have been removed, so `count` is the number of `1`s.

---

# Understanding `num & (num - 1)`

Consider:

```text
num = 12
```

Binary representation:

```text
12 = 1100
```

Now:

```text
num - 1 = 1011
```

Perform AND:

```text
  1100
& 1011
------
  1000
```

The rightmost `1` has been removed.

Again:

```text
  1000
& 0111
------
  0000
```

There were two `1`s in `1100`, so the count is:

```text
2
```

Therefore:

```text
12 → 1100 → 2 set bits
```

---

# How the Code Works

## Step 1: Create the answer array

```java
int[] nums = new int[n+1];
```

We need answers for:

```text
0, 1, 2, ..., n
```

So the array needs `n + 1` positions.

For example, if:

```text
n = 5
```

we need:

```text
nums[0]
nums[1]
nums[2]
nums[3]
nums[4]
nums[5]
```

---

## Step 2: Initialize `nums[0]`

```java
nums[0] = 0;
```

Because:

```text
0 → 0
```

contains zero `1`s.

---

## Step 3: Iterate from 1 to n

```java
for(int i=1;i<=n;i++){
```

For every number, we count its set bits.

---

## Step 4: Copy the current number

```java
int num = i;
```

We use a separate variable because we are going to modify `num`.

---

## Step 5: Remove set bits

```java
while(num > 0){

    num = num & (num-1);

    count++;

}
```

Every iteration removes exactly one `1`.

Therefore, the number of iterations equals the number of set bits.

---

## Step 6: Store the result

```java
nums[i] = count;
```

After counting all the set bits of `i`, store the result in the answer array.

---

# Dry Run

Suppose:

```text
n = 5
```

We calculate each number.

### i = 1

```text
1 = 1
```

```text
1 & 0 = 0
```

One operation:

```text
count = 1
```

So:

```text
nums[1] = 1
```

---

### i = 2

```text
2 = 10
```

```text
10 & 01 = 00
```

One operation:

```text
count = 1
```

So:

```text
nums[2] = 1
```

---

### i = 3

```text
3 = 11
```

First operation:

```text
11 & 10 = 10
```

Second operation:

```text
10 & 01 = 00
```

Therefore:

```text
count = 2
```

So:

```text
nums[3] = 2
```

---

### i = 4

```text
4 = 100
```

```text
100 & 011 = 000
```

Therefore:

```text
count = 1
```

So:

```text
nums[4] = 1
```

---

### i = 5

```text
5 = 101
```

First operation:

```text
101 & 100 = 100
```

Second operation:

```text
100 & 011 = 000
```

Therefore:

```text
count = 2
```

So:

```text
nums[5] = 2
```

Final result:

```text
[0, 1, 1, 2, 1, 2]
```

---

# Why This Works

The expression:

```java
num & (num - 1)
```

always removes exactly **one set bit** from `num`.

For example:

```text
10110
 ↓
10100
 ↓
10000
 ↓
00000
```

There were three `1`s, and therefore the operation was performed three times.

So:

```text
number of loop iterations = number of set bits
```

---

# Complexity

For a single number `i`, Brian Kernighan's algorithm takes:

```text
O(number of set bits in i)
```

Since the solution processes every number from `1` to `n`, the worst-case time complexity is:

```text
O(n log n)
```

because an integer can contain at most `O(log n)` bits.

### Space Complexity

The result array contains `n + 1` elements:

```text
O(n)
```

Apart from the output array, the algorithm uses constant extra space:

```text
O(1)
```

So:

```text
Time Complexity:  O(n log n)
Space Complexity: O(n)
```

---

# Important Bit Manipulation Pattern

Remember this operation:

```java
n & (n - 1)
```

### It removes the rightmost `1`.

This technique is useful for:

- Counting set bits
- Checking whether a number is a power of 2
- Bit manipulation problems
- Finding the number of set bits efficiently

For example:

```java
while(n > 0){
    n = n & (n - 1);
    count++;
}
```

is a standard way to count the number of `1`s in the binary representation of a number.

---

# Key Takeaway

The main idea behind this solution is:

```text
n & (n - 1)
        ↓
removes the rightmost set bit
```

Therefore:

```text
Number of times we can perform
n = n & (n - 1)

= Number of 1s in the binary representation of n
```

For LeetCode 338, we simply apply this technique to every number from:

```text
0 → n
```

and store each count in the result array.

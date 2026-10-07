# Find Common Restaurant

## Problem

Given two arrays of strings `list1` and `list2`, find all the common strings with the **smallest index sum**.

The index sum for a common restaurant is:

```text
index in list1 + index in list2
```

If multiple restaurants have the same minimum index sum, return all of them.

---

## Approach

### 1. Store `list1` in a HashMap

We store each restaurant from `list1` along with its index:

```java
HashMap<String,Integer> map = new HashMap<>();

for(int i = 0; i < list1.length; i++){
    map.put(list1[i], i);
}
```

This allows us to find the index of a restaurant in `list1` in **O(1)** average time.

### 2. Traverse `list2`

For every restaurant in `list2`, check whether it exists in the HashMap.

```java
if(map.containsKey(list2[i])){
```

If it exists, calculate the index sum:

```java
int sum = map.get(list2[i]) + i;
```

### 3. Maintain the minimum index sum

Initially:

```java
int minSum = Integer.MAX_VALUE;
```

If the current sum is smaller than `minSum`, clear the previous results and add the current restaurant:

```java
if(sum < minSum){
    minSum = sum;
    result.clear();
    result.add(list2[i]);
}
```

If the current sum is equal to the minimum, add the restaurant without clearing the previous results:

```java
else if(sum == minSum){
    result.add(list2[i]);
}
```

### 4. Convert the ArrayList to an array

The required return type is `String[]`, so convert the `ArrayList`:

```java
return result.toArray(new String[result.size()]);
```

---

## Code

```java
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> map = new HashMap<>();

        for(int i = 0; i < list1.length; i++){
            map.put(list1[i], i);
        }

        int minSum = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();

        for(int i = 0; i < list2.length; i++){
            if(map.containsKey(list2[i])){
                int sum = map.get(list2[i]) + i;

                if(sum < minSum){
                    minSum = sum;
                    result.clear();
                    result.add(list2[i]);
                }
                else if(sum == minSum){
                    result.add(list2[i]);
                }
            }
        }

        return result.toArray(new String[result.size()]);
    }
}
```

---

## Example

### Input

```text
list1 = ["Shogun","Tapioca Express","Burger King","KFC"]
list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
```

`Shogun` appears at:

```text
list1 → index 0
list2 → index 3
```

Therefore:

```text
index sum = 0 + 3 = 3
```

So the answer is:

```text
["Shogun"]
```

---

## Complexity

Let:

- `n` = length of `list1`
- `m` = length of `list2`

### Time Complexity

- Building the HashMap: **O(n)**
- Traversing `list2`: **O(m)** average

Therefore:

```text
O(n + m)
```

### Space Complexity

The HashMap stores all elements of `list1`:

```text
O(n)
```

The result list can contain multiple restaurants, so total auxiliary space is:

```text
O(n + k)
```

where `k` is the number of restaurants in the result.

---

## Key Pattern

This problem is a good example of the:

**HashMap + Minimum Tracking pattern**

The general idea is:

1. Store values and their useful information in a HashMap.
2. Traverse the second collection.
3. Check for common elements.
4. Calculate the required score.
5. Keep track of the minimum score.
6. Store all elements having that minimum score.

This pattern is useful for many problems involving **two arrays + common elements + index/value comparison**.

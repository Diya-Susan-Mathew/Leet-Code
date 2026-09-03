# LeetCode 49 — Group Anagrams

## Java Solution

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String str : strs){
            char[] chars = str.toCharArray();

            Arrays.sort(chars);

            String key = new String(chars);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
```

---

## Approach

The main idea is to use a **HashMap** to group strings that are anagrams.

Anagrams contain the same characters with the same frequencies.

For example:

```text
eat → aet
tea → aet
ate → aet
```

After sorting their characters, all three strings produce the same value:

```text
"aet"
```

So we can use the sorted string as the **key** in the HashMap.

The HashMap looks like:

```text
Key    → Value
-------------------------------
"aet"  → ["eat", "tea", "ate"]
"ant"  → ["tan", "nat"]
"abt"  → ["bat"]
```

---

## Step-by-Step Logic

### 1. Create a HashMap

```java
Map<String,List<String>> map = new HashMap<>();
```

The map stores:

```text
sorted string → list of anagrams
```

For example:

```text
"aet" → ["eat", "tea"]
```

---

### 2. Traverse Every String

```java
for(String str : strs)
```

We process each string one by one.

For example:

```text
eat
tea
tan
ate
nat
bat
```

---

### 3. Convert the String to a Character Array

```java
char[] chars = str.toCharArray();
```

For:

```text
"eat"
```

we get:

```text
['e', 'a', 't']
```

---

### 4. Sort the Characters

```java
Arrays.sort(chars);
```

Now:

```text
['e', 'a', 't']
```

becomes:

```text
['a', 'e', 't']
```

---

### 5. Create the Key

```java
String key = new String(chars);
```

The character array:

```text
['a', 'e', 't']
```

becomes:

```text
"aet"
```

This `"aet"` is the key for the group.

---

## 6. Check Whether the Key Already Exists

```java
if (!map.containsKey(key)) {
    map.put(key, new ArrayList<>());
}
```

This means:

> If this sorted string has not appeared before, create an empty list for it.

For example, when processing `"eat"`:

```text
key = "aet"
```

Initially:

```text
map = {}
```

Since `"aet"` doesn't exist:

```java
map.put("aet", new ArrayList<>());
```

Now:

```text
"aet" → []
```

---

## 7. Add the Original String

```java
map.get(key).add(str);
```

`map.get(key)` retrieves the list associated with the key.

For `"eat"`:

```text
map.get("aet")
```

gives:

```text
[]
```

Then:

```java
.add("eat");
```

makes it:

```text
"aet" → ["eat"]
```

---

## Dry Run

Consider:

```text
strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
```

### String 1: `"eat"`

Sorted:

```text
eat → aet
```

Map:

```text
"aet" → ["eat"]
```

---

### String 2: `"tea"`

Sorted:

```text
tea → aet
```

`"aet"` already exists, so we don't create a new list.

Add `"tea"`:

```text
"aet" → ["eat", "tea"]
```

---

### String 3: `"tan"`

Sorted:

```text
tan → ant
```

`"ant"` doesn't exist, so create a new list:

```text
"ant" → ["tan"]
```

Map:

```text
"aet" → ["eat", "tea"]
"ant" → ["tan"]
```

---

### String 4: `"ate"`

Sorted:

```text
ate → aet
```

Add it to the `"aet"` group:

```text
"aet" → ["eat", "tea", "ate"]
```

---

### String 5: `"nat"`

Sorted:

```text
nat → ant
```

Add it to the `"ant"` group:

```text
"ant" → ["tan", "nat"]
```

---

### String 6: `"bat"`

Sorted:

```text
bat → abt
```

Create a new group:

```text
"abt" → ["bat"]
```

---

## Final HashMap

```text
"aet" → ["eat", "tea", "ate"]
"ant" → ["tan", "nat"]
"abt" → ["bat"]
```

---

## Returning the Answer

```java
return new ArrayList<>(map.values());
```

`map.values()` contains all the lists:

```text
[
    ["eat", "tea", "ate"],
    ["tan", "nat"],
    ["bat"]
]
```

We convert the collection returned by `map.values()` into an `ArrayList`.

---

## Why Does This Work?

Two strings are anagrams if their sorted characters are identical.

For example:

```text
"listen" → "eilnst"
"silent" → "eilnst"
```

Therefore:

```text
listen and silent
        ↓
same sorted key
        ↓
same HashMap group
```

Non-anagrams produce different sorted keys.

For example:

```text
"eat" → "aet"
"bat" → "abt"
```

Since:

```text
"aet" ≠ "abt"
```

they go into different groups.

---

## Understanding These Two Lines Together

```java
if (!map.containsKey(key)) {
    map.put(key, new ArrayList<>());
}

map.get(key).add(str);
```

Think of them as:

```text
Does the group exist?
       ↓
     NO
       ↓
Create an empty group
       ↓
Add the string to the group
```

Example:

```java
key = "aet"
str = "eat"
```

First:

```java
if (!map.containsKey("aet")) {
    map.put("aet", new ArrayList<>());
}
```

Now:

```text
"aet" → []
```

Then:

```java
map.get("aet").add("eat");
```

Now:

```text
"aet" → ["eat"]
```

---

## Complexity

Let:

- `N` = number of strings
- `K` = maximum length of a string

For every string, we sort its characters.

Sorting one string takes:

```text
O(K log K)
```

For `N` strings:

```text
Time Complexity = O(N × K log K)
```

HashMap operations such as `containsKey()`, `put()`, and `get()` are approximately `O(1)` on average.

### Space Complexity

The HashMap stores the strings:

```text
O(N × K)
```

There is also temporary space for the character array used while processing each string.

---

## Key Pattern to Remember

For **Group Anagrams**:

```text
String
   ↓
Convert to char[]
   ↓
Sort
   ↓
Create String
   ↓
Use as HashMap key
   ↓
Add original string to the list
```

### Most Important Idea

```java
String key = new String(chars);
```

The **sorted string is not what we store as the answer**.

It is only used as a **common identifier (key)** for all anagrams.

We store the **original strings**:

```text
"aet" → ["eat", "tea", "ate"]
```

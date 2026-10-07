# LeetCode 383 — Ransom Note

## Problem

Given two strings `ransomNote` and `magazine`, return `true` if `ransomNote` can be constructed using the letters from `magazine`.

Each letter in `magazine` can be used **only once**.

---

## My Approach — HashMap

### Idea

Store the frequency of every character in `magazine` using a `HashMap`.

Then traverse `ransomNote`:

* If the character exists and its frequency is greater than `0`, use it and decrease the count.
* If its frequency becomes `0`, it cannot be used again.
* If the character doesn't exist, return `false`.

### Code

```java
class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character,Integer> mapMagazine = new HashMap<>();

        for(char c : magazine.toCharArray()){

            mapMagazine.put(c,mapMagazine.getOrDefault(c,0)+1);

        }

        for(char c : ransomNote.toCharArray()){

            if(mapMagazine.containsKey(c) && (mapMagazine.get(c) >0)){

                mapMagazine.put(c,mapMagazine.get(c)-1);

            }else if(mapMagazine.containsKey(c) && mapMagazine.get(c) == 0){

                mapMagazine.remove(c);

                return false;

            }else{

                return false;

            }

        }

        return true;

    }

}
```

### Complexity

* **Time:** `O(n + m)`
* **Space:** `O(k)`

where `k` is the number of distinct characters.

---

# Optimal Approach — Frequency Array

Since the problem contains only lowercase English letters (`a-z`), we don't need a `HashMap`.

There are only **26 possible characters**, so we can use an integer array of size `26`.

### Idea

1. Count every character in `magazine`.
2. For every character in `ransomNote`, decrease its count.
3. If the count becomes negative, there aren't enough characters.

### Code

```java
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        if(ransomNote.length() > magazine.length()){
            return false;
        }

        int[] freq = new int[26];

        for(char c : magazine.toCharArray()){
            freq[c - 'a']++;
        }

        for(char c : ransomNote.toCharArray()){
            if(--freq[c - 'a'] < 0){
                return false;
            }
        }

        return true;
    }
}
```

### Complexity

* **Time:** `O(n + m)`
* **Space:** `O(1)`

The space is `O(1)` because the array always has only **26 elements**.

---

## Why the Array Solution Is Better Here

Your HashMap solution is **correct and has good time complexity**.

However, the frequency-array solution is better for this specific problem because:

* Only `a-z` are possible.
* We know the character range beforehand.
* Array access is simpler and faster than HashMap operations.
* No hashing or `containsKey()` calls are needed.
* Space is constant: only `26` integers.

### Important Pattern

> **If the input contains a fixed, small character set, consider using a frequency array instead of a HashMap.**

Examples:

```text
a-z        → int[26]
A-Z        → int[52]
ASCII      → int[128] or int[256]
```

---

## Key Learning

Your solution shows that you understood the main pattern correctly:

**Character Frequency → Store counts → Consume counts**

The main improvement is recognizing the constraint:

```text
Only lowercase English letters
        ↓
Only 26 possibilities
        ↓
Use int[26]
```

So your approach is **correct**, while the frequency-array approach is the more optimized and cleaner solution for this particular problem.

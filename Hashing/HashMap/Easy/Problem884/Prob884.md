# Uncommon Words from Two Sentences

**LeetCode Problem:** Uncommon Words from Two Sentences

## Approach

Use a **HashMap** to count the frequency of every word appearing in both sentences.

### Steps

1. Split `s1` into words and add each word to the `HashMap`.
2. Split `s2` into words and update the same `HashMap`.
3. Traverse the `HashMap`.
4. If a word has a frequency of exactly `1`, it is an uncommon word.
5. Add those words to an `ArrayList`.
6. Convert the `ArrayList` into a `String[]` and return it.

## Java Solution

```java
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> countWords = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();

        for (String word : s1.split(" ")) {
            countWords.put(word, countWords.getOrDefault(word, 0) + 1);
        }

        for (String word : s2.split(" ")) {
            countWords.put(word, countWords.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : countWords.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }

        return result.toArray(new String[0]);
    }
}
```

## Example

### Input

```text
s1 = "this apple is sweet"
s2 = "this apple is sour"
```

### Word Frequencies

| Word | Frequency |
|------|-----------|
| this | 2 |
| apple | 2 |
| is | 2 |
| sweet | 1 |
| sour | 1 |

### Output

```text
["sweet", "sour"]
```

## Complexity

- **Time:** `O(n + m)`
- **Space:** `O(n + m)`

Where `n` and `m` are the number of words in `s1` and `s2`.

## Key Concept

> A word is **uncommon** if it appears exactly once across both sentences combined.

**Pattern:** HashMap / Frequency Counting
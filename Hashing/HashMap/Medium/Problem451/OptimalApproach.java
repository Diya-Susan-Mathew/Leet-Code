import java.util.*;

class Solution {
    public String frequencySort(String s) {

        // Step 1: Count frequency
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 2: Create buckets
        List<Character>[] buckets = new List[s.length() + 1];

        for (char c : map.keySet()) {

            int freq = map.get(c);

            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }

            buckets[freq].add(c);
        }

        // Step 3: Build result
        StringBuilder sb = new StringBuilder();

        for (int freq = s.length(); freq >= 1; freq--) {

            if (buckets[freq] != null) {

                for (char c : buckets[freq]) {

                    for (int i = 0; i < freq; i++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }
}
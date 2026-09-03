import java.util.*;

class Solution {
    public String frequencySort(String s) {

        // Count frequency
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        while (!map.isEmpty()) {

            // Find character with maximum frequency
            char maxChar = 0;
            int maxFreq = 0;

            for (char c : map.keySet()) {
                if (map.get(c) > maxFreq) {
                    maxFreq = map.get(c);
                    maxChar = c;
                }
            }

            // Add character maxFreq times
            for (int i = 0; i < maxFreq; i++) {
                sb.append(maxChar);
            }

            // Remove it from the map
            map.remove(maxChar);
        }

        return sb.toString();
    }
}
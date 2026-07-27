//Better Solution

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (countMap.get(ch) == 1) {
                return i;
            }
        }
        return -1;
    }
}


//Optimal Solution

class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];

    for (char c : s.toCharArray()) {
        freq[c - 'a']++;
    }

    for (int i = 0; i < s.length(); i++) {
        if (freq[s.charAt(i) - 'a'] == 1) {
            return i;
        }
    }

    return -1;
    }
}
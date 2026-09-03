class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        if(s == null || s.length() < minSize){
            return 0;
        }
        Map<String,Integer> CountMap = new HashMap<>();
        int uniqueLetters = 0;
        int[] charFreq = new int[26];
        int maxOccurences=0;
        for(int i=0;i<minSize;i++){
            char c = s.charAt(i);
            if(charFreq[c -'a'] == 0){
                uniqueLetters++;
            }
            charFreq[c -'a']++;
        }
        if(uniqueLetters <= maxLetters){
            String sub = s.substring(0,minSize);
            CountMap.put(sub,1);
            maxOccurences = 1;
        }
        for(int i=minSize;i<s.length();i++){
            char oldChar = s.charAt(i-minSize);
            charFreq[oldChar-'a']--;
            if(charFreq[oldChar - 'a'] == 0){
                uniqueLetters--;
            }

            char newChar = s.charAt(i);
            if(charFreq[newChar-'a'] == 0){
                uniqueLetters++;
            }
            charFreq[newChar - 'a']++;
            if(uniqueLetters <= maxLetters){
                String sub = s.substring(i-minSize+1,i+1);
                int count = CountMap.getOrDefault(sub,0) + 1;
                CountMap.put(sub,count);
                maxOccurences = Math.max(maxOccurences,count);
            }
        }
        return maxOccurences;
    }
}
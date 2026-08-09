class Solution {
    public String reorganizeString(String s) {
        int[] charCount = new int[26];
        for(char c : s.toCharArray()){
            charCount[c-'a']++;
        }
        int maxCount = 0;
        int maxIndex = 0;
        for(int i=0;i<charCount.length;i++){
            if(charCount[i] > maxCount){
                maxCount = charCount[i];
                maxIndex = i;
            }
        }
        if(maxCount > (s.length()+1)/2 ){
            return "";
        }
        int index = 0;
        char[] result = new char[s.length()];
        while(charCount[maxIndex] > 0){
            result[index] = (char)(maxIndex + 'a');
            index = index+2;
            charCount[maxIndex]-=1;
        }
        for(int i=0;i<charCount.length;i++){
            while(charCount[i] > 0){
                if(index >= result.length){
                index = 1;
            }
                result[index] = (char)(i + 'a');
                index = index + 2;
                charCount[i]-=1;
            }
        }
        return new String(result);
    }
}
class Solution {
    public int scoreOfString(String s) {
        int value;
        int sum=0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i) > s.charAt(i+1)){
                value = (int)s.charAt(i) - (int)s.charAt(i+1);
            }else{
                value = (int)s.charAt(i+1) - (int)s.charAt(i);
            }
            sum += value;
        }
        return sum;
    }
}
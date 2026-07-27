class Solution {
    public void reverseString(char[] s) {
        char temp;
        int lp=0,rp=s.length-1;
        while(lp<=rp){
            temp = s[lp];
            s[lp] = s[rp];
            s[rp] = temp;
            lp++;
            rp--;
        }

    }
}
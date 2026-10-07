class Solution {
    public int findComplement(int num) {
        int mask = 1;
        if(num < 0){
            return 0;
        }
        while(mask < num){
            mask = (mask << 1) + 1;
        }
        return mask^num;
    }
}
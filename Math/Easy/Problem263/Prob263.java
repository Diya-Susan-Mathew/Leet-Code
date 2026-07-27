class Solution {
    public boolean isUgly(int n) {
        if(n<=0){
            return false;
        }
        int[] factor = {2,3,5};
        for(int i=0;i<3;i++){
            while((n%factor[i]) == 0){
                n = n/factor[i];
            }
        }
        return n==1?true:false;

    }
}
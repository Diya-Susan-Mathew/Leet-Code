class Solution {
    public int mySqrt(int x) {
        int low = 1;
        int high = x;
        while(low <= high){
            int mid = low + (high-low)/2;
            long squared = (long)mid*mid;
            if(squared == x){
                return mid;
            }else if(squared < x){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return high;
    }
}
class Solution {
    public int longestOnes(int[] nums, int k) {
        int countZeroes = 0;
        int left = 0;
        int maxLength = Integer.MIN_VALUE;
        for(int right = 0;right < nums.length;right++){
            if(nums[right] == 0){
                countZeroes++;
            }
            while(countZeroes > k){
                if(nums[left] == 0){
                    countZeroes--;
                }
                left++;
            }
            maxLength = Math.max(maxLength,right-left+1);
        }
        return maxLength != 0?maxLength:0;
    }
}
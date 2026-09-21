class Solution {
    public int minOperations(int[] nums, int x) {
        long totalSum = 0;
        for(int i=0;i<nums.length;i++){
            totalSum += nums[i];
        }
        long requiredSum = totalSum - x;
        if(requiredSum < 0){
            return -1;
        }
        int left = 0;
        int maxLength = -1;
        long currSum = 0;
        for(int right = 0;right<nums.length;right++){
            currSum += nums[right];
            while((currSum > requiredSum) && (left <= right)){
                currSum-=nums[left];
                left++;
            }
            if(currSum == requiredSum){
                maxLength = Math.max(maxLength,right-left+1);
            }
        }
        return maxLength == -1 ? -1 : nums.length - maxLength;
    }
}
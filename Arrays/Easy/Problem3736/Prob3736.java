class Solution {
    public int minMoves(int[] nums) {
        int arraySum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            arraySum+=nums[i];
            if(max < nums[i]){
                max = nums[i];
            }
        }
        int expectedSum = max * nums.length;
        return expectedSum - arraySum;
    }
}
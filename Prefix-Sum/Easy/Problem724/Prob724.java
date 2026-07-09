class Solution {
    public int pivotIndex(int[] nums) {
        int leftprefix=0,rightprefix=0;
        int pivot;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        for(int i=0;i<nums.length;i++){
            pivot = i;
            if(pivot == 0){
                leftprefix = 0;
            }else if(pivot != 0){
                leftprefix = leftprefix + nums[pivot-1];
            }
            rightprefix = sum - nums[pivot] - leftprefix;
            if(leftprefix == rightprefix){
                    return pivot;
            }
            rightprefix = 0;
        }
        return -1;
    }
}
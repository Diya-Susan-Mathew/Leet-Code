class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int low = 0;
        int high = nums.length -1;
        while(low <= high){
            if(nums[low] % 2 == 0){
                low++;
            }else{
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
        return nums;
    }
}
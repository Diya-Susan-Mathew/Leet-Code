class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int[] result = new int[nums.length];

        for(int num : nums) {
            count[num]++;
        }

        for(int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                result[i] = 0;
            } else {
                result[i] = count[nums[i] - 1];
            }
        }

        return result;
    }
}
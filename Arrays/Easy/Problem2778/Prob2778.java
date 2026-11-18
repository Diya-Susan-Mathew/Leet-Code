class Solution {
    public int sumOfSquares(int[] nums) {
        int sum = 0;
        int length = nums.length;

        for (int i = 1; i <= length; i++) {
            if (length % i == 0) {
                sum += nums[i - 1] * nums[i - 1];
            }
        }

        return sum;
    }
}
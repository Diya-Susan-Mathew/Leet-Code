class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int WeightSum = 0;
        for(int i=0;i<weights.length;i++){
            WeightSum += weights[i];
            if(weights[i] > max){
                max = weights[i];
            }
        }
        int left = max;
        int right = WeightSum;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(isPossible(weights,days,mid)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    public boolean isPossible(int[] weights,int days,int capacity){
        int sum = 0;
        int countDays = 1;
        for(int i=0;i<weights.length;i++){
            if(sum + weights[i] <= capacity){
                sum+= weights[i];
            }else{
                countDays++;
                sum = weights[i];
            }
        }
        if(countDays <= days){
            return true;
        }
        else{
            return false;
        }
    }
}
class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long left = Integer.MAX_VALUE;
        for(int i=0;i<time.length;i++){
            if(time[i]<left){
                left = time[i];
            }
        }
        long right = totalTrips * left;
        while(left <= right){
            long mid = left + (right-left)/2;
            if(isPossible(time,totalTrips,mid)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    public boolean isPossible(int[] time,int totalTrips,long tripTime){
        long total = 0;
        for(int i=0;i<time.length;i++){
            total+=tripTime/time[i];
        }
        return total>=totalTrips?true:false;
    }
}
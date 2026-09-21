class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int max = piles[0];
        for(int i=0;i<piles.length;i++){
            if(piles[i] >= max){
                max = piles[i];
            }
        }
        int right = max;
        while(left <= right){
            int mid = left + (right - left)/2;
            long total = countBananas(piles,mid);
            if(total <= h){
                right = mid-1;
            }else if(total > h){
                left = mid+1;
            }
        }
        return left;
    
    }
    private long countBananas(int pile[],int BananaCount){
        long totalHours = 0;
        for(int i=0;i<pile.length;i++){
            totalHours += (pile[i]+BananaCount-1)/BananaCount;
        }
        return totalHours;
    }
}
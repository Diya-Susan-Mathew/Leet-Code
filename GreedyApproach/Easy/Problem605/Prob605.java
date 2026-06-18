class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i] == 0){
                boolean leftside = (i==0)||(flowerbed[i-1]==0);
                boolean rightside = (i==flowerbed.length-1)||(flowerbed[i+1]==0);
                if(leftside && rightside){
                    flowerbed[i] = 1;
                    count++;
                }
                if(count >= n){
                    return true;
                }
            }
        }
        return count >=n;
    }
}
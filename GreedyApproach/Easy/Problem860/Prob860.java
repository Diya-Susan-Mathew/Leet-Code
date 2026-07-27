class Solution {
    public boolean lemonadeChange(int[] bills) {
        int count5=0,count10=0,count20=0;
        for(int bill : bills){
            if(bill == 5){
                count5++;
            }
            else if((bill == 10)){
                count10++;
                if(count5 >=1){
                    count5--;
                }else{
                    return false;
                }
            }else if((bill == 20)){
                count20++;
                if((count10>=1) && (count5 >= 1)){
                    count10--;
                    count5--;
                }else if(count5>=3){
                    count5 = count5 - 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
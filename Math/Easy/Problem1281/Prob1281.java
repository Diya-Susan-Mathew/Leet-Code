class Solution {
    public int subtractProductAndSum(int n) {
        int num=0;
        int sum = 0;
        int pdt = 1;
        while(n >0){
            num = n % 10;
            sum+=num;
            pdt*=num;
            n = n/10;
        }
        return pdt-sum;
    }
}
class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int origNo = x;
        int sum = 0;
        while(x != 0){
            int digit = x % 10;
            sum+=digit;
            x = x/10;
        }
        return origNo%sum == 0 ? sum : -1;
    }
}
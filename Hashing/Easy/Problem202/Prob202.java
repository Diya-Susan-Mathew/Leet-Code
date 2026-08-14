class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while((n != 1) && (!set.contains(n))){
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int digit = n % 10;
            totalSum += digit * digit;
            n = n / 10;
        }
        return totalSum;
    }
}
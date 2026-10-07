class Solution {
    public int countOdds(int low, int high) {
        int countUptoHigh = (high+1)/2;
        int countBeforeLow = low/2;
        int oddNos = countUptoHigh - countBeforeLow;
        return oddNos;

        // return (high+1)/2 - low/2;
    }
}
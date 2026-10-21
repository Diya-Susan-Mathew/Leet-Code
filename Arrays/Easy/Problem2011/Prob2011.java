class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int value = 0;
        for (String op : operations) {
            if (op.charAt(1) == '+') {
                value++;
            } else {
                value--;
            }
        }
        return value;
    }
}

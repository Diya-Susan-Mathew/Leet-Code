import java.util.TreeMap;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        
        // TreeMap keeps the card values automatically sorted
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int card : hand) {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }
        
        for (int card : count.keySet()) {
            int currentCount = count.get(card);
            if (currentCount > 0) {
                // Check for consecutive group cards
                for (int i = card; i < card + groupSize; i++) {
                    if (count.getOrDefault(i, 0) < currentCount) {
                        return false;
                    }
                    count.put(i, count.get(i) - currentCount);
                }
            }
        }
        return true;
    }
}

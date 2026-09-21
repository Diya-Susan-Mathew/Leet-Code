import java.util.Scanner;

public class Prob1482 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();

        // 1. Get the size of the bloomDay array
        System.out.print("Enter the number of flowers (array size): ");
        int n = scanner.nextInt();

        // 2. Get the array elements
        int[] bloomDay = new int[n];
        System.out.println("Enter the bloom day for each flower:");
        for (int i = 0; i < n; i++) {
            bloomDay[i] = scanner.nextInt();
        }

        // 3. Get m (number of bouquets)
        System.out.print("Enter the number of bouquets needed (m): ");
        int m = scanner.nextInt();

        // 4. Get k (flowers per bouquet)
        System.out.print("Enter the number of adjacent flowers per bouquet (k): ");
        int k = scanner.nextInt();

        // Calculate and print the result
        int result = solution.minDays(bloomDay, m, k);
        System.out.println("\nMinimum days needed: " + result);

        // Close the scanner to prevent memory leaks
        scanner.close();
    }
}

class Solution {     
    public int minDays(int[] bloomDay, int m, int k) {         
        if ((long)m * k > bloomDay.length) {             
            return -1; 
        }         
        int min = Integer.MAX_VALUE;         
        for (int i = 0; i < bloomDay.length; i++) {             
            if (bloomDay[i] < min) {                 
                min = bloomDay[i];             
            }         
        }         
        int max = Integer.MIN_VALUE;         
        for (int i = 0; i < bloomDay.length; i++) {             
            if (bloomDay[i] > max) {                 
                max = bloomDay[i];             
            }         
        }         
        int left = min;         
        int right = max;         
        while (left <= right) {             
            int mid = left + (right - left) / 2;             
            boolean possible = isPossible(bloomDay, mid, m, k);             
            if (possible) {                 
                right = mid - 1;             
            } else {                 
                left = mid + 1;             
            }         
        }         
        return left;     
    }     

    public boolean isPossible(int[] bloomDay, int day, int m, int k) {         
        int counter = 0;         
        int noOfBouq = 0;         
        for (int i = 0; i < bloomDay.length; i++) {             
            if (bloomDay[i] <= day) {                 
                counter++;                 
                if (counter == k) {                     
                    noOfBouq++;                     
                    counter = 0;                  
                }             
            } else {                 
                noOfBouq += counter / k;                 
                counter = 0;             
            }         
        }         
        return noOfBouq >= m;       
    } 
}

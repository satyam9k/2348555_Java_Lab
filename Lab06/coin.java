package lab_java;

import java.util.concurrent.CountDownLatch;

public class coin {

    // Main method to demonstrate the code
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int sum = 5;
        int combinations = countCombinationsTwoThreads(coins, sum);
        System.out.println("Number of ways to make sum " + sum + " : " + combinations);
    }

    // Counts combinations using two threads for potential parallelism
    public static int countCombinationsTwoThreads(int[] coins, int sum) {
        CountDownLatch latch1 = new CountDownLatch(1);
        CountDownLatch latch2 = new CountDownLatch(1);
        int[] results = new int[2];

        // Thread 1: Explore combinations starting from index 0
        Thread thread1 = new Thread(() -> {
            results[0] = countCombinationsRecursive(coins, 0, sum);
            latch1.countDown(); // Signal completion of thread 1
        });

        // Thread 2: Explore combinations starting from index 1, but wait for thread 1 to finish first
        Thread thread2 = new Thread(() -> {
            try {
                latch1.await(); // Wait for thread 1 to complete
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            results[1] = countCombinationsRecursive(coins, 1, sum);
            latch2.countDown(); // Signal completion of thread 2
        });

        thread1.start();
        thread2.start();

        try {
            latch2.await(); // Wait for both threads to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Combine results from both threads
        return results[0] + results[1];
    }

    // Recursive method to count combinations with given coins and remaining sum
    private static int countCombinationsRecursive(int[] coins, int index, int remainingSum) {
        if (remainingSum == 0) {
            return 1; // Base case: Found a valid combination
        }

        if (index < 0 || remainingSum < 0) {
            return 0; // Invalid case: No combination possible
        }

        return countCombinationsRecursive(coins, index, remainingSum - coins[index]) +
               countCombinationsRecursive(coins, index - 1, remainingSum);
    }
}

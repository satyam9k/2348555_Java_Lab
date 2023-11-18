public class ShareTrader {

    // Returns maximum profit with two transactions on a given list of stock prices
    static int maxProfit(int[] price, int n) {
        int[] profit = new int[n]; // Create and initialize profit array

        // Get the maximum profit with only one transaction allowed
        int maxPrice = price[n - 1]; // Initialize maxPrice with the last price
        for (int i = n - 2; i >= 0; i--) { // Iterate from the second-last price to the first price
            maxPrice = Math.max(maxPrice, price[i]); // Update maxPrice with the maximum of current price and previous maxPrice
            profit[i] = Math.max(profit[i + 1], maxPrice - price[i]); // Calculate profit for current price
        }

        // Get the maximum profit with two transactions allowed
        int minPrice = price[0]; // Initialize minPrice with the first price
        for (int i = 1; i < n; i++) { // Iterate from the second price to the last price
            minPrice = Math.min(minPrice, price[i]); // Update minPrice with the minimum of current price and previous minPrice
            profit[i] = Math.max(profit[i - 1], profit[i] + (price[i] - minPrice)); // Calculate profit for current price
        }

        return profit[n - 1]; // Return the maximum profit from the last index of profit array
    }

    // Driver Code
    public static void main(String[] args) {
        // Test_Case 1
        int[] price1 = {10, 22, 5, 75, 65, 80};
        int n1 = price1.length;
        System.out.println("Maximum Profit for Test Case 1 = " + maxProfit(price1, n1));

        // Test_Case 2
        int[] price2 = {2, 30, 15, 10, 8, 25, 80};
        int n2 = price2.length;
        System.out.println("Maximum Profit for Test Case 2 = " + maxProfit(price2, n2));
    }
}

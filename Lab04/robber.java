import java.util.Arrays;

// Abstract class Robber
abstract class Robber {

    // Abstract method for robbing class
    abstract void RobbingClass();

    // Default method for MachineLearning
    void MachineLearning() {
        System.out.println("I love MachineLearning.");
    }

    // Abstract method RowHouses
    abstract int RowHouses(int[] money);

    // Abstract method RoundHouses
    abstract int RoundHouses(int[] money);

    // Abstract method SquareHouse
    abstract int SquareHouse(int[] money);

    // Abstract method MultiHouseBuilding
    abstract int MultiHouseBuilding(int[] type1, int[] type2, int[] type3, int[] type4);
}

// Class JAVAProfessionalRobber inheriting from Robber
class JAVAProfessionalRobber extends Robber {

    // Implementation of RobbingClass
    void RobbingClass() {
        System.out.println("MScAI&ML");
    }

    // Implementation of RowHouses 
    int RowHouses(int[] money) {
        int n = money.length;
        if (n == 0) return 0;
        if (n == 1) return money[0];

        // Use two variables to keep track of previous and current maximum amounts
        int prevMax = money[0];
        int currentMax = Math.max(money[0], money[1]);

        for (int i = 2; i < n; i++) {
            int temp = currentMax;
            currentMax = Math.max(currentMax, prevMax + money[i]);
            prevMax = temp;
        }

        return currentMax;
    }

    // Implementation of RoundHouses 
    int RoundHouses(int[] money) {
        int n = money.length;
        if (n == 0) return 0;
        if (n == 1) return money[0];

        // Consider two cases: Rob first house or not
        return Math.max(RowHouses(Arrays.copyOfRange(money, 0, n - 1)),
                        RowHouses(Arrays.copyOfRange(money, 1, n)));
    }

    // Implementation of SquareHouse 
    int SquareHouse(int[] money) {
        int n = money.length;
        if (n == 0) return 0;
        if (n == 1) return money[0];

        // Use two variables to keep track of previous and current maximum amounts
        int prevMax = money[0];
        int currentMax = Math.max(money[0], money[1]);

        for (int i = 2; i < n; i++) {
            int temp = currentMax;
            currentMax = Math.max(currentMax, prevMax + money[i]);
            prevMax = temp;
        }

        return currentMax;
    }

    // Implementation of MultiHouseBuilding 
    int MultiHouseBuilding(int[] type1, int[] type2, int[] type3, int[] type4) {
        // Use an array to store the maximum amount for each type
        int[] maxAmount = new int[4];
        maxAmount[0] = RowHouses(type1);
        maxAmount[1] = RowHouses(type2);
        maxAmount[2] = RowHouses(type3);
        maxAmount[3] = RowHouses(type4);

        // Sort the array to get the top two maximum amounts
        Arrays.sort(maxAmount);

        // Return the sum of the top two maximum amounts
        return maxAmount[3] + maxAmount[2];
    }
}

// Main class for testing
class Main {
    public static void main(String[] args) {
        // Create an instance of JAVAProfessionalRobber
        JAVAProfessionalRobber robber = new JAVAProfessionalRobber();

        // Test cases
        robber.RobbingClass();
        robber.MachineLearning();
        System.out.println("RowHouses([1,2,3,0]) -> " + robber.RowHouses(new int[]{1, 2, 3, 0}));
        System.out.println("RoundHouses([1,2,3,4]) -> " + robber.RoundHouses(new int[]{1, 2, 3, 4}));
        System.out.println("SquareHouse([5,10,2,7]) -> " + robber.SquareHouse(new int[]{5, 10, 2, 7}));
        System.out.println("MultiHouseBuilding([5,3,8,2],[10,12,7,6],[4,9,11,5],[8,6,3,7]) -> " +
                robber.MultiHouseBuilding(new int[]{5, 3, 8, 2}, new int[]{10, 12, 7, 6},
                        new int[]{4, 9, 11, 5}, new int[]{8, 6, 3, 7}));
    }
}




package Lab05b;
// WaterConservationSystem interface
public interface WaterConservationSystem {
    int calculateTrappedWater(int[] blockHeights);
}

// RainySeasonConservation abstract class implementing WaterConservationSystem interface
abstract class RainySeasonConservation implements WaterConservationSystem {
    
}

// CityBlockConservation class extending RainySeasonConservation
class CityBlockConservation extends RainySeasonConservation {

    @Override
    public int calculateTrappedWater(int[] blockHeights) {
        if (blockHeights == null || blockHeights.length <= 2) {
            return 0; // No trapped water if there are less than 3 blocks
        }

        int n = blockHeights.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Calculate the maximum height to the left of each block
        leftMax[0] = blockHeights[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], blockHeights[i]);
        }

        // Calculate the maximum height to the right of each block
        rightMax[n - 1] = blockHeights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], blockHeights[i]);
        }

        // Calculate trapped water for each block
        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            trappedWater += Math.max(0, Math.min(leftMax[i], rightMax[i]) - blockHeights[i]);
        }

        return trappedWater;
    }

    
}

// Main class for testing
class Main {
    public static void main(String[] args) {
        // Test Case 1
        int[] heights1 = {3, 0, 0, 2, 0, 4};
        WaterConservationSystem conservationSystem1 = new CityBlockConservation();
        int result1 = conservationSystem1.calculateTrappedWater(heights1);
        System.out.println("Test Case 1 Result: " + result1); // Expected output: 10

        // Test Case 2
        int[] heights2 = {3, 0, 2, 0, 4};
        WaterConservationSystem conservationSystem2 = new CityBlockConservation();
        int result2 = conservationSystem2.calculateTrappedWater(heights2);
        System.out.println("Test Case 2 Result: " + result2); // Expected output: 7
    }
}

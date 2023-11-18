import java.util.*;

public class MostFrequentNumbers {
    static int[] array;

    public static void main(String[] args) {
        // Test Case 1
        array = new int[]{3, 1, 4, 4, 5, 2, 6, 1};
        int k1 = 2;
        printTopK(k1);

        // Test Case 2
        array = new int[]{7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
        int k2 = 4;
        printTopK(k2);
    }

    public static void printTopK(int k) {
        if (k > array.length) {
            System.out.println("k is greater than the array length.");
            return;
        }

        int n = array.length;
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            count.put(array[i], count.getOrDefault(array[i], 0) + 1);
        }

        int[] countArr = new int[count.size()];
        int[] numbers = new int[count.size()];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            countArr[index] = entry.getValue();
            numbers[index] = entry.getKey();
            index++;
        }

        partitionSort(numbers, countArr, 0, countArr.length - 1, k);

        for (int i = 0; i < k; i++) {
            System.out.print(numbers[i] + " ");
        }
    }

    public static void partitionSort(int[] numbers, int[] count, int low, int high, int k) {
        if (low < high) {
            int pi = partition(numbers, count, low, high);

            if (pi == k - 1) {
                for (int i = 0; i < k; i++) {
                    System.out.print(numbers[i] + " ");
                }
                System.out.println();
            } else if (pi > k - 1) {
                partitionSort(numbers, count, low, pi - 1, k);
            } else {
                partitionSort(numbers, count, pi + 1, high, k);
            }
        }
    }

    public static int partition(int[] numbers, int[] count, int low, int high) {
        int pivotIndex = count[high];
        int pivotFrequency = numbers[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (count[j] > pivotIndex || (count[j] == pivotIndex && numbers[j] > pivotFrequency)) {
                i++;
                swap(numbers, count, i, j);
            }
        }

        swap(numbers, count, i + 1, high);
        return i + 1;
    }

    public static void swap(int[] numbers, int[] count, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;

        int tempCount = count[i];
        count[i] = count[j];
        count[j] = tempCount;
    }
}
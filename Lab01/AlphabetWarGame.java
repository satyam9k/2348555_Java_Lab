public class AlphabetWarGame {
    private static final String LEFT_SIDE = "wpsb";
    private static final String RIGHT_SIDE = "mqdz";

    private int[] strengths;

    // Constructor with default strengths
    public AlphabetWarGame() {
        this.strengths = new int[]{4, 3, 2, 1, 4, 3, 2, 1};
    }

    // Constructor with custom strengths
    public AlphabetWarGame(int[] customStrengths) {
        if (customStrengths.length == 8) {
            this.strengths = customStrengths;
        } else {
            // If the provided array does not have the correct length, use default strengths
            System.out.println("Invalid custom strengths. Using default strengths.");
            this.strengths = new int[]{4, 3, 2, 1, 4, 3, 2, 1};
        }
    }

    // Method to determine the winner based on a single word
    public void alphabetWar(String word) {
        int leftStrength = 0;
        int rightStrength = 0;

        for (char letter : word.toCharArray()) {
            if (LEFT_SIDE.contains(String.valueOf(letter))) {
                leftStrength += strengths[LEFT_SIDE.indexOf(letter)];
            } else if (RIGHT_SIDE.contains(String.valueOf(letter))) {
                rightStrength += strengths[RIGHT_SIDE.indexOf(letter)];
            }
        }

        if (leftStrength > rightStrength) {
            System.out.println("Left side wins!");
        } else if (rightStrength > leftStrength) {
            System.out.println("Right side wins!");
        } else {
            System.out.println("Let's fight again!");
        }
    }

    // Method to determine the winner based on separate left and right words
    public void alphabetWar(String leftWord, String rightWord) {
        int leftStrength = calculateStrength(leftWord, LEFT_SIDE);
        int rightStrength = calculateStrength(rightWord, RIGHT_SIDE);

        if (leftStrength > rightStrength) {
            System.out.println("Left side wins!");
        } else if (rightStrength > leftStrength) {
            System.out.println("Right side wins!");
        } else {
            System.out.println("Let's fight again!");
        }
    }

    private int calculateStrength(String word, String side) {
        int strength = 0;

        for (char letter : word.toCharArray()) {
            if (side.contains(String.valueOf(letter))) {
                strength += strengths[side.indexOf(letter)];
            }
        }

        return strength;
    }

    public static void main(String[] args) {
        // Create an instance of AlphabetWarGame with default strengths
        AlphabetWarGame game = new AlphabetWarGame();

        // Example 1: Use single-word method
        game.alphabetWar("z");  // Right side wins!

        // Example 2: Use separate words method
        game.alphabetWar("wwwwww", "z");  // Left side wins!

        // Example 3: Create a custom game with custom strengths
        AlphabetWarGame customGame = new AlphabetWarGame(new int[]{5, 4, 3, 2, 5, 4, 3, 2});
        customGame.alphabetWar("wwwwwwz");  // Left side wins with custom strengths!

        // Example 4: Use separate words method with "zdqmwpbs"
        game.alphabetWar("zdqmwpbs");  // Let's fight again!
    }
}

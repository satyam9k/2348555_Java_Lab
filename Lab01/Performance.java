import java.io.*;

class Performance {
    int mark[] = new int[10];  // Array to store marks for 10 students
    int mode = 0;              // Variable to store mode
    int freqAtMode = 0;        // Variable to store frequency at mode

    // Constructor to initialize the Performance object
    public Performance() {
        // No specific initialization needed in this case
    }

    // Method to read marks from the user, ensuring they are within the specified range
    public void readMarks() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(isr);

        for (int i = 0; i < 10; i++) {
            int currentMark;
            // Keep asking for input until a valid mark within the specified range is provided
            do {
                System.out.print("Enter Marks for student " + (i + 1) + ": ");
                currentMark = Integer.parseInt(in.readLine());
            } while (currentMark < 0 || currentMark > 100);

            mark[i] = currentMark;
        }
    }

    // Method to find the highest mark in the class
    public int highestMark() {
        int highest = mark[0];

        for (int i = 1; i < mark.length; i++) {
            if (mark[i] > highest) {
                highest = mark[i];
            }
        }

        return highest;
    }

    // Method to find the least mark in the class
    public int leastMark() {
        int least = mark[0];

        for (int i = 1; i < mark.length; i++) {
            if (mark[i] < least) {
                least = mark[i];
            }
        }

        return least;
    }

    // Method to calculate the mode and frequency at mode
    public void calcModeAndFrequency() {
        int f, i, j;
        for (i = 0; i < 10; i++) {
            f = 0;
            for (j = 0; j < 10; j++) {
                if (mark[i] == mark[j])
                    f++;
            }
            if (f >= freqAtMode && mark[i] >= mode) {
                mode = mark[i];
                freqAtMode = f;
            }
        }
    }

    // Method to display the results
    public void display() {
        System.out.println("Highest Mark: " + highestMark());
        System.out.println("Least Mark: " + leastMark());
        System.out.println("Mode: " + mode);
        System.out.println("Frequency at Mode: " + freqAtMode);
    }

    // Main method to execute the program
    public static void main(String[] args) throws IOException {
        Performance performance = new Performance();
        performance.readMarks();
        performance.calcModeAndFrequency();
        performance.display();
    }
}

import java.util.*;

public class Exercise_21_06 {
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Create a list and two sets
        Map<Integer, Integer> map = new HashMap<>(); // Stores results

        // Prompt the user to enter a number of integers
        System.out.println("Enter a number of integers."
                + "\nInput ends when the input is 0:");

        int key;
        while ((key = input.nextInt()) != 0) {
            if (!map.containsKey(key)) {
                map.put(key, 1);
            }
            else {
                int frequency = map.get(key);
                frequency++;
                map.put(key, frequency);
            }
        }

        // Find the maximum occurrence
        int max = Collections.max(map.values());

        // Display the integers that have the most occurences
        System.out.print("The most occurrences integers are: ");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                System.out.print(entry.getKey() + " ");
            }
        }
        System.out.println();
    }
}
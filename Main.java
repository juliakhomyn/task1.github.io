import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array elements separated by \' ,\'");
        String input = sc.nextLine();
        String[] str = input.split(", ");
        List<String> array = Arrays.asList(str);
        System.out.println(arrayChallanger(array));
    }

    static String arrayChallanger(List<String> arr) {
        StringBuilder result = new StringBuilder();
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            array.add(Integer.parseInt(arr.get(i)));
        }
        // Array for elements without pairs
        List<Integer> wrong = new ArrayList<>();
        // If quantity of elements in array is odd returns "invalid array"
        if (array.size() % 2 != 0) {
            return "invalid array";
        }
        for (int i = 0; i < array.size(); i += 2) {
            // Shows if the reversed pair is found in the array
            boolean isFound = false;
            // Checks if the pair is the last element
            // If yes, checking starts from second last pair
            // If no, checking starts from the last pair
            int check = array.size() - 1 - ((i == array.size() - 2) ? 2 : 0);
            for (int j = check; j > 0; j -= 2) {
                // Comparising pairs
                // If pair is reversed, stops the cycle
                if (array.get(i).equals(array.get(j)) && array.get(i + 1).equals(array.get(j - 1))) {
                    isFound = true;
                    break;
                }
            }
            // If reversed pair is not found,
            // ckecked pair is added to the array of elements without pairs
            if (!isFound) {
                wrong.add(array.get(i));
                wrong.add(array.get(i + 1));
            }
        }
        // If there are pairs in the array of elements without pairs,
        // add all single pair to the string, divided by a comma
        // If there is no single pairs return "yes"
        if (!wrong.isEmpty()) {
            for (int i = 0; i < wrong.size(); i++) {
                result.append(wrong.get(i));
                if (i != wrong.size() - 1) {
                    result.append(", ");
                }
            }
        } else result.append("yes");
        return result.toString();
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array elements separated by ,");
        String input = sc.nextLine();
        String[] str = input.split(", ");
        List<String> array = Arrays.asList(str);
        System.out.println(arrayChallanger(array));
    }

    static String arrayChallanger(List<String> arr) {
        String rez = "";
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < arr.size(); i++) {
            array.add(Integer.parseInt(arr.get(i)));
        }
        ArrayList<Integer> wrong = new ArrayList<Integer>();
        if (array.size() % 2 != 0) return "no";
        for (int i = 0; i < array.size(); i += 2) {
            boolean find = false;
            int check = array.size() - 1 - ((i == array.size() - 2) ? 2 : 0);
            for (int j = check; j > 0; j -= 2) {
                if (array.get(i).equals(array.get(j)) && array.get(i + 1).equals(array.get(j - 1))) {
                    find = true;
                    break;
                }
            }
            if (!find) {
                wrong.add(array.get(i));
                wrong.add(array.get(i + 1));
            }
        }
        if (!wrong.isEmpty()) {
            for (int i = 0; i < wrong.size(); i++) {
                rez += wrong.get(i);
                if (i != wrong.size() - 1) rez += ", ";
            }
        } else rez = "yes";
        return rez;
    }

}

import java.util.*;
import java.util.stream.StreamSupport;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        ArrayList<Integer> array = new ArrayList<>();
        while (scanner.hasNextInt()) {
            array.add(scanner.nextInt());
        }
        n = array.get(array.size() - 1);
        array.remove(array.size() - 1);
        Collections.sort(array);
        int lowestDistance = Integer.MAX_VALUE;

        for (int i = 0; i < array.size(); i++) {
            if (Math.abs(n - array.get(i)) < lowestDistance) {
                lowestDistance = Math.abs(n - array.get(i));
            }
        }

        for (int i = 0; i < array.size(); i++) {
            if (Math.abs(n - array.get(i)) == lowestDistance) {
                System.out.print(array.get(i) + " ");
            }
        }


    }
}
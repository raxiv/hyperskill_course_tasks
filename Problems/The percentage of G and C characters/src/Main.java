import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String enteredString = scanner.nextLine();



        int numberOfGc = 0;
        for (int i = 0; i < enteredString.length(); i++) {
            enteredString = enteredString.toUpperCase();
            if (enteredString.charAt(i) == 'G' || enteredString.charAt(i) == 'C') {
                numberOfGc++;
            }

        }

        double result = (double) numberOfGc/enteredString.length() *100;

        System.out.println(result);

        // put your code here
    }
}
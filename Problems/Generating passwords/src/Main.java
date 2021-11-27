import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        int upperCaseLetters = scanner.nextInt();
        int lowerCaseLetters = scanner.nextInt();
        int numberOfDigits = scanner.nextInt();
        int numberOfSymbols = scanner.nextInt();

        char a = 'A';
        char b = 'a';
        int number = 0;


        StringBuilder password = new StringBuilder();

        for (int i = 0; i < upperCaseLetters; i++) {
            password.append(a);
            a += 1;
            if (a == 'T') {
                a = 'A';
            }
        }

        for (int i = 0; i < lowerCaseLetters; i++) {
            password.append(b);
            b += 1;
            if (b == 't') {
                b = 'a';
            }
        }

        for (int i = 0; i < numberOfDigits; i++) {
            password.append(number);
            number++;
            if (number == 7) {
                number = 0;
            }
        }

        for (int i = password.length(); i < numberOfSymbols; i++) {
            password.append(a);
            a += 1;
        }


        System.out.println(password.toString());


    }
}
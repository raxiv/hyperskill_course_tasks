// Don't delete scanner import

import java.util.Scanner;

class Name {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        createFullName(first, second);
        // use this program as a source of inspiration for your method

    }

    //implement your method here
    public static String createFullName(String firstName, String lastName) {


        return firstName + " " + lastName;

    }
}
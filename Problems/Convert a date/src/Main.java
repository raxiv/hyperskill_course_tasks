import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String myDate = scanner.nextLine();

        String[] myDateToArray = myDate.split("-");

        String newDate = myDateToArray[1] + "/" + myDateToArray[2] + "/" + myDateToArray[0];

        System.out.println(newDate);

    }
}
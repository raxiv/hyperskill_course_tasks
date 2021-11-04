import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] inputString = input.split(" ");

        String  text = inputString[0];
        String number = inputString[1];
        int myNumber = Integer.parseInt(number);
        String[] text2 = text.split("");







        String newOne = "";

        if (myNumber > text.length()) {
            System.out.println(text);
        } else {
            newOne = text.substring(myNumber) + text.substring(0,myNumber);


        }
        System.out.println(newOne);


    }
}
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();


        boolean flag = true;

        for (int i = 0; i < input.length() - 1; i++) {
            char a = input.charAt(i);
            char b = input.charAt(i+1);
            if (a==b-1) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }

        System.out.println(flag);
    }
}
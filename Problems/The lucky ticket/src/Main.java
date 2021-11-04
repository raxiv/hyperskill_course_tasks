import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String ticket = scanner.nextLine();

        int first3sum = 0;
        int second3sum = 0;


        for (int i = 0; i <ticket.length()/2 ; i++) {
            first3sum+=ticket.charAt(i);
            second3sum+=ticket.charAt(i + 3);
        }

        if (first3sum == second3sum) {
            System.out.println("Lucky");
        } else {
            System.out.println("Regular");
        }
    }
}
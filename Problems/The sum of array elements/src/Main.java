import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int size = scanner.nextInt();
        int[] array = new int[size];

        for (int i = 0; i <array.length ; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i <array.length ; i++) {
            sum+=array[i];
        }
        System.out.println(sum);

    }
}
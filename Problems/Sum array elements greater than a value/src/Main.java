import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int sizeOfArray = scanner.nextInt();

        int[] array = new int[sizeOfArray];

        for (int i = 0; i < sizeOfArray; i++) {
            array[i] = scanner.nextInt();
        }

        int number = scanner.nextInt();
        int sum = 0;

        for (int i = 0; i < sizeOfArray; i++) {
            if (array[i] > number) {
                sum += array[i];
            }
        }
        System.out.println(sum);

    }
}
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i <array.length ; i++) {
            array[i] = scanner.nextInt();
        }

        int n = scanner.nextInt();
        int counter = 0;

        for (int i = 0; i <array.length ; i++) {
            if(array[i] == n){
                counter++;
                continue;
            }
        }

        System.out.println(counter);
    }
}
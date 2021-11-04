import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int numberOfTriplets = 0;
        int arrayLength = scanner.nextInt();

        int[] array = new int[arrayLength];
        for (int i = 0; i <arrayLength ; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < arrayLength-2; i++) {
            if((array[i]<array[i+1])&& array[i+1]-array[i]==1){
                if((array[i+1]<array[i+2])&& array[i+2]-array[i+1]==1){
                    numberOfTriplets++;
                }
            }
        }

        System.out.println(numberOfTriplets);


    }
}
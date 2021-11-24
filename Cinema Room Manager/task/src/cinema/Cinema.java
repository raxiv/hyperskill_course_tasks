package cinema;

import java.util.Scanner;

public class Cinema {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Write your code here
        profitFromTickets();
    }


    public static void profitFromTickets() {
        System.out.println("Enter the number of rows:");
        int rowsNumber = scanner.nextInt();
        System.out.println("ENter the number of seats in each row:");
        int seatsNumber = scanner.nextInt();

        System.out.println("Total income:");
        int halfTicket = rowsNumber * seatsNumber / 2;
        if (rowsNumber * seatsNumber < 61) {
            System.out.println("$" + rowsNumber * seatsNumber * 10);
        } else {
            if (rowsNumber % 2 == 0) {

                System.out.println("$" + ((halfTicket * 10) + (halfTicket * 8)));
            } else {
                rowsNumber--;
                int halfTicket2 = rowsNumber * seatsNumber / 2;
                System.out.println("$" + ((halfTicket2 * 10) + ((rowsNumber / 2) + 1) * seatsNumber * 8));
            }

        }


    }


    public static void printCinemaRoom() {
        char[][] array = fillArray();
        int number = 1;
        System.out.println("Cinema:");
        String rows = "  1 2 3 4 5 6 7 8";
        System.out.println(rows);


        for (int i = 0; i < array.length; i++) {
            System.out.print(number + " ");
            number++;
            for (int j = 0; j < array[i].length; j++) {
                {
                    System.out.print(array[i][j] + " ");
                }

            }
            System.out.println("");
        }

    }

    public static char[][] fillArray() {


        char[][] array = new char[7][8];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = 'S';
            }
        }

        return array;
    }
}
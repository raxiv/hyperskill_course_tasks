package cinema;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Cinema {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Write your code here
        printMenu();
    }


    public static void statistic(char[][] array) {

        System.out.println("Number of purchased tickets: " + purchasedTickets(array));
        System.out.print("Percentage: "); purchasedTicketPercent(array);
        System.out.println("%");
        System.out.println("Current income: $" + totalProfit(array));
        System.out.println("Total income: $" + profitFromTickets(array));
    }


    public static int totalProfit(char[][] array) {
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 'B') {
                    total += ticketPrice(array, i+1, j+1);
                }
            }
        }
        return total;
    }


    public static void purchasedTicketPercent(char[][] array) {
        double totalTickets = array.length*array[0].length;
        double purchased = purchasedTickets(array);

        double percent = (purchased * 100) / totalTickets;

        System.out.printf("%.2f", percent);
    }


    public static int purchasedTickets(char[][] array) {
        int tickets = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 'B') {
                    tickets++;
                }
            }
        }
        return tickets;
    }

    public static void buyTicket(char[][] array) {

        boolean flag = true;

        while (flag) {
            System.out.println("Enter a row number:");
            int row = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int seat = scanner.nextInt();

            if (checkException(array, row, seat)) {

                if (array[row - 1][seat - 1] != 'B') {
                    System.out.println("Ticket price: $" + ticketPrice(array, row, seat));
                    System.out.println("");
                    changeArray(array, row, seat);
                    flag = false;
                } else {
                    System.out.println("That ticket has already been purchased! ");
                    flag = true;
                }

            } else {
                System.out.println("Wrong input!");
                flag = true;
            }


        }


    }


    public static boolean checkException(char[][] array, int row, int column) {
        if (array != null
                && row > -1
                && column > -1
                && row - 1 <= (array.length - 1)
                && column - 1 <= (array[row - 1].length - 1)) {
            return true;
        } else {
            return false;
        }
    }

    public static void printInfo() {
        System.out.println("1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "3. Statistics\n" +
                "0. Exit");
    }

    public static void printMenu() {
        System.out.println("Enter the number of rows:");
        int rowsNumber = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsNumber = scanner.nextInt();

        char[][] cinema = fillArray(rowsNumber, seatsNumber);
        printInfo();

        boolean exit = true;

        while (exit) {
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    //show seats
                    printArray(cinema);
                    printInfo();
                    break;
                case 2:
                    //buy ticket
                    buyTicket(cinema);
                    printInfo();
                    break;
                case 3:
                    //statis
                    statistic(cinema);
                    break;
                case 0:
                    //exit
                    exit = false;
                    break;
            }
        }

    }


    public static void changeArray(char[][] array, int row, int column) {
        array[row - 1][column - 1] = 'B';
    }

    public static int ticketPrice(char[][] array, int row, int column) {
        if (array.length * array[0].length < 61) {
            return 10;
        } else {
            if (array.length % 2 == 0) {
                if (row <= array.length / 2) {
                    return 10;
                } else {
                    return 8;
                }
            } else {
                int rows = array.length - 1;
                if (row <= rows / 2) {
                    return 10;
                } else {
                    return 8;
                }
            }

        }
    }

    public static int profitFromTickets(char[][] array) {

        int rowsNumber = array.length ;
        int seatsNumber = array[0].length ;

        int halfTicket = rowsNumber * seatsNumber / 2;
        if (rowsNumber * seatsNumber < 61) {
            return rowsNumber * seatsNumber * 10;
        } else {
            if (rowsNumber % 2 == 0) {
                return ((halfTicket * 10) + (halfTicket * 8));
            } else {
                rowsNumber--;
                int halfTicket2 = rowsNumber * seatsNumber / 2;
                return ((halfTicket2 * 10) + ((rowsNumber / 2) + 1) * seatsNumber * 8);
            }

        }


    }

    public static void printArray(char[][] array) {
        int number = 1;
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 0; i < array[0].length; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println("");


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

    public static char[][] printCinemaRoom(int x, int y) {
        char[][] array = fillArray(x, y);
        printArray(array);
        return array;
    }

    public static char[][] fillArray(int rows, int columns) {


        char[][] array = new char[rows][columns];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = 'S';
            }
        }

        return array;
    }
}
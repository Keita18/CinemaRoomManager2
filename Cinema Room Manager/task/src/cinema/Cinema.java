package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rowNum = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatNum = sc.nextInt();

        String[][] cinemaRoom = new String[rowNum][seatNum];
        for (String[] seat : cinemaRoom)
            Arrays.fill(seat, "S");

        printCinema(cinemaRoom, rowNum, seatNum);

        System.out.println("Enter a row number:");
        int xPlace = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int yPlace = sc.nextInt();

        int ticketPrice = ticketPrice(cinemaRoom, rowNum, seatNum, xPlace, yPlace );
        System.out.println();
        System.out.println("Ticket price: $" + ticketPrice);
        printCinema(cinemaRoom, rowNum, seatNum);
    }

    static void printCinema(String[][] cinemaRoom, int row, int seat) {
        System.out.println();
        System.out.println("Cinema:");
        StringBuilder s = new StringBuilder(" ");
        for (int i = 1; i <= seat; i++) {
            s.append(" ").append(i);
        }
        s.append("\n");
        for (int i = 1; i <= row; i++) {
            s.append(i);
            for (int j = 1; j <= seat; j++) {
                s.append(" ").append(cinemaRoom[i - 1][j - 1]);
            }
            s.append("\n");
        }
        System.out.println(s);
    }

    static int ticketPrice(String[][] cinemaRoom, int row, int seat, int xPlace, int yPlaye) {
        int totalSeat = row * seat;
        int price = 10;
        if (totalSeat > 60) {
            int frontRow = row / 2;
            if (xPlace > frontRow) {
                price = 8;
            }
        }
        cinemaRoom[xPlace -1][yPlaye -1] = "B";
        return price;
    }


    /* static void totalIncome() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int row = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seat = sc.nextInt();
        int totalSeat = row * seat;
        int totalIncome = 0;
        if (totalSeat > 60) {
            int frontRow = row / 2;
            int backRow = row - frontRow;
            totalIncome = (frontRow * 10 + backRow * 8) * seat;
        } else {
            totalIncome = totalSeat * 10;
        }

        System.out.println("Total income:\n$" + totalIncome);
    }*/
}
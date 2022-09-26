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

        boolean stop = false;
        int sellTicket = 0;
        double sellTicketPer = 0.0;
        int currentIncome = 0;
        int totalIncome = 0;
        do {
            System.out.println("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 0:
                    stop = true;
                    break;
                case 1:
                    printCinema(cinemaRoom, rowNum, seatNum);
                    break;
                case 2:
                    boolean goodPlace = false;
                    do {
                        System.out.println("\nEnter a row number:");
                        int xPlace = sc.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        int yPlace = sc.nextInt();
                        if (xPlace > rowNum || yPlace > seatNum) {
                            System.out.println("\nWrong input!");
                        } else {
                            int ticketPrice = ticketPrice(cinemaRoom, rowNum, seatNum, xPlace, yPlace);
                            System.out.println();
                            if (ticketPrice == 0) {
                                System.out.println("That ticket has already been purchased!");
                            } else {
                                System.out.println("Ticket price: $" + ticketPrice);
                                currentIncome += ticketPrice;
                                sellTicket++;
                                int totalSeat = rowNum * seatNum;
                                sellTicketPer = (double) sellTicket*100 / totalSeat;
                                goodPlace = true;
                            }
                        }
                    } while (!goodPlace);
                    break;
                case 3:
                    totalIncome = totalIncome(rowNum, seatNum);
//                    sellTicketPer = (double) currentIncome * 100 / totalIncome;

                    System.out.println("\nNumber of purchased tickets: " + sellTicket);
                    System.out.printf("Percentage: %.2f", sellTicketPer);
                    System.out.print("%");
                    System.out.println("\nCurrent income: $" + currentIncome);
                    System.out.println("Total income: $" + totalIncome);
                    break;
            }
        } while (!stop);
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

        if (cinemaRoom[xPlace - 1][yPlaye - 1].equals("B")) {
            price = 0;
        } else cinemaRoom[xPlace - 1][yPlaye - 1] = "B";
        return price;
    }

    static int totalIncome(int row, int seat) {
        int totalSeat = row * seat;
        int totalIncome = 0;
        if (totalSeat > 60) {
            int frontRow = row / 2;
            int backRow = row - frontRow;
            totalIncome = (frontRow * 10 + backRow * 8) * seat;
        } else {
            totalIncome = totalSeat * 10;
        }
       return totalIncome;
    }
}
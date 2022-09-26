package cinema;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
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
    }
}
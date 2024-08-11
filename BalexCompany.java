public class BalexCompany {
    // Constants for minimum wage, maximum hours, and overtime
    private static final double MINIMUM_WAGE = 8.00;
    private static final int MAX_HOURS = 60;
    private static final int OVERTIME_THRESHOLD = 40;
    private static final double OVERTIME_RATE = 1.5;

    // Method to calculate and print the total pay or an error message
    public void calculatePay(double basePay, int hoursWorked) {
        // Check if base pay is below the minimum wage
        if (basePay < MINIMUM_WAGE) {
            System.out.println("Error: Base pay is below the minimum wage.");
            return;
        }

        // Check if hours worked exceed the maximum allowed hours
        if (hoursWorked > MAX_HOURS) {
            System.out.println("Error: Hours worked exceeds the maximum allowed.");
            return;
        }

        // Calculate regular pay for up to 40 hours
        int regularHours = Math.min(hoursWorked, OVERTIME_THRESHOLD);
        double regularPay = regularHours * basePay;

        // Calculate overtime pay for hours over 40
        int overtimeHours = Math.max(0, hoursWorked - OVERTIME_THRESHOLD);
        double overtimePay = overtimeHours * basePay * OVERTIME_RATE;

        // Total pay is the sum of regular pay and overtime pay
        double totalPay = regularPay + overtimePay;

        System.out.printf("Total pay: $%.2f%n", totalPay);
    }

    public static void main(String[] args) {
        BalexCompany company = new BalexCompany();

        // Employee 1
        company.calculatePay(7.50, 35);

        // Employee 2
        company.calculatePay(8.20, 47);

        // Employee 3
        company.calculatePay(10.00, 73);
    }
}
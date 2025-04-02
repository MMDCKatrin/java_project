/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.payrollmotorph;
       

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Payrollmotorph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee emp1 = new Employee("10005", "Eduard Hernandez", "1990-05-15", 150, 500);
        
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        
        for (String day : days) {
            System.out.print(day + "-IN (HH:MM): ");
            String loginTime = scanner.next();
            System.out.print(day + "-OUT (HH:MM): ");
            String logoutTime = scanner.next();
            emp1.logWorkHours(day, loginTime, logoutTime);
        }
        
        emp1.displayEmployeeDetails();
        scanner.close();
    }
}

class Employee {
    private String employeeNumber;
    private String name;
    private String birthday;
    private double hourlyRate;
    private double totalHoursWorked;
    private double allowance;
    private static final LocalTime OFFICE_START = LocalTime.of(8, 30);
    private static final LocalTime GRACE_PERIOD = LocalTime.of(8, 10);

    public Employee(String employeeNumber, String name, String birthday, double hourlyRate, double allowance) {
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.birthday = birthday;
        this.hourlyRate = hourlyRate;
        this.allowance = allowance;
        this.totalHoursWorked = 0;
    }

    public void logWorkHours(String day, String loginTime, String logoutTime) {
        LocalTime login = LocalTime.parse(loginTime);
        LocalTime logout = LocalTime.parse(logoutTime);
        
        if (login.isAfter(GRACE_PERIOD)) {
            System.out.println("Late detected on " + day + ". Salary deductions may apply.");
        }
        
        double hoursWorked = ChronoUnit.MINUTES.between(login, logout) / 60.0;
        this.totalHoursWorked += hoursWorked;
    }

    public double calculateGrossSalary() {
        return hourlyRate * totalHoursWorked;
    }

    public double calculateDeductions(double grossSalary) {
        double sss = calculateSSS(grossSalary);
        double philHealth = calculatePhilHealth(grossSalary);
        double pagIbig = calculatePagIbig(grossSalary);
        double taxableIncome = grossSalary - (sss + philHealth + pagIbig);
        double withholdingTax = calculateWithholdingTax(taxableIncome);
        
        return sss + philHealth + pagIbig + withholdingTax;
    }

    public double calculateNetSalary() {
        double grossSalary = calculateGrossSalary();
        double totalDeductions = calculateDeductions(grossSalary);
        return grossSalary + allowance - totalDeductions;
    }

    private double calculateSSS(double salary) {
        if (salary < 3250) return 135;
        else if (salary < 3750) return 157.5;
        else if (salary < 4250) return 180;
        else if (salary < 4750) return 202.5;
        else if (salary < 5250) return 225;
        else if (salary < 5750) return 247.5;
        else return 1125;
    }

    private double calculatePhilHealth(double salary) {
        double contribution = salary * 0.03;
        return contribution / 2;
    }

    private double calculatePagIbig(double salary) {
        return Math.min(salary * 0.02, 100);
    }

    private double calculateWithholdingTax(double taxableIncome) {
        if (taxableIncome <= 20832) return 0;
        else if (taxableIncome < 33333) return (taxableIncome - 20833) * 0.2;
        else if (taxableIncome < 66667) return 2500 + (taxableIncome - 33333) * 0.25;
        else if (taxableIncome < 166667) return 10833 + (taxableIncome - 66667) * 0.3;
        else if (taxableIncome < 666667) return 40833.33 + (taxableIncome - 166667) * 0.32;
        else return 200833.33 + (taxableIncome - 666667) * 0.35;
    }

    public void displayEmployeeDetails() {
        System.out.println("\nEmployee Number: " + employeeNumber);
        System.out.println("Name: " + name);
        System.out.println("Birthday: " + birthday);
        System.out.println("Hourly Rate: " + hourlyRate);
        System.out.println("Total Hours Worked: " + totalHoursWorked);
        System.out.println("Gross Salary: " + calculateGrossSalary());
        System.out.println("Net Salary (Take-home Pay): " + calculateNetSalary());
    }
}




/**
 *
 * @author Chee
 */

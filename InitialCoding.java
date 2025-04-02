/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.initialcoding;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class InitialCoding {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int employeeNumber = 0;
        String employeeName = "Name";
        LocalDate birthday = LocalDate.of(1999, 1, 01);
        int hoursworked = 0;
        double grossSalary = 0;
        
        // Deductions
        double sss = 0;
        double philHealth = 0;
        double pagIbig = 0;
        double incomeTax = 0;
        
        // Calculate net pay
        double totalDeduction = sss + philHealth + pagIbig + incomeTax;
        double totalDeductions = 0;
        double netPay = grossSalary - totalDeductions;
        
        // Format decimal Output
        DecimalFormat df = new DecimalFormat("#,##0.00");
        
                 
        //Timein - Timeout
        //time Difference
        //Note: Military time (00:00-23:59)
        
        //Timein: 0;
        int timein_hours = 0;
        int timein_mins= 0;
        
        //Timeout: 0;
        int timeout_hours = 0;
        int timeout_mins = 0;
      
        
        
        LocalTime start = LocalTime.of(timein_hours,timein_mins,0); //Convert to time
        LocalTime end = LocalTime.of(timeout_hours,timeout_mins,0); //Convert to time
        
        Duration time_dur = Duration.between(start,end); //Compute Difference
        
        long Diff_hours = time_dur.toHours();//Save hours from Duration
        long Diff_minutes = time_dur.toMinutes() %60;//Save mins from Duration
        double Salary_hours = (Diff_hours  - 1) * 0;
        double Salary_mins = Diff_minutes * (0 / 60);
        
        System.out.println("Total Hours: " + Diff_hours);
        System.out.println("Total_minutes: " + Diff_minutes);
        System.out.println("Daily Salary: P" + (Salary_hours + Salary_mins));
        
        
              
        
                
        
        
        
        
       
            
            
            
        }
        
        
    }


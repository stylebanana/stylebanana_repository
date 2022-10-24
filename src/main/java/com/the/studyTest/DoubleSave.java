package com.example.demo;

import java.util.Scanner;
/*
 * zhang chong
 * 2022/10/24
 */

public class DoubleSave{
    public static void main(String[] args) {
        double savingAmount;
        double interestRate;

        System.out.println("Your saving balance?");
        Scanner saAm = new Scanner(System.in);
        savingAmount = saAm.nextDouble();
       
        System.out.println("Interest rate?");
        Scanner inSc = new Scanner(System.in);
        interestRate = inSc.nextDouble();


        int doubleYear =calculateYears(savingAmount, interestRate);
        
        System.out.println("It takes at least " + doubleYear + "years to double your savings.");
    }
    public static int calculateYears(double savingAmount,double interestRate){
        double doubleSavingAmount = savingAmount*2;
        int year = 0;
        while(savingAmount<doubleSavingAmount){
            year++;
            savingAmount *= 1+interestRate;
        }
        return year;
    }
}
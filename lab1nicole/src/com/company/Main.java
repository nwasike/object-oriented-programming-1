package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        System.out.println("Input the student's KCSE grade");
        int kcse_grade = input.nextInt();

        System.out.println("Input the student's interview questions scores");
        int interview_score = input.nextInt();

        System.out.println("Input the student's confidence level score");
        int confidence_lvl = input.nextInt();

        if (kcse_grade >= 65 && interview_score >= 6) {
            System.out.println("The student has been admitted");
        }
        else if (kcse_grade >= 65 && confidence_lvl >= 5) {
            System.out.println("The student has been admitted");
        }
        else {
            System.out.println("The student has been rejected");
        }
    }
}

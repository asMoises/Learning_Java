package entities;

import java.util.Locale;
import java.util.Scanner;

public class Student {
    public String studentName;
    public double grade01, grade02, grade03;

    public void EnterGrades() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        boolean aux = false;
        double gradeSc = 0;

        
        System.out.println("Enter the student name:");
        System.out.print("Name: ");
        studentName = sc.next();

        for (int i = 1; i < 4; i++) {
            System.out.print("Enter the grade 0" + i + ": ");
            do {
                if (i == 1) {
                    grade01 = sc.nextDouble();
                    gradeSc = grade01;
                } else if (i == 2) {
                    grade02 = sc.nextDouble();
                    gradeSc = grade02;
                } else if (i == 3) {
                    grade03 = sc.nextDouble();
                    gradeSc = grade03;
                }

                aux = CheckingGrades(gradeSc, i);
                if (!aux) {
                    System.out
                            .print(
                                    "Grade value is not in the allowed interval! Try another value to grade 0" + i
                                            + "\nEnter the grade 0" + i + ": ");
                }
            } while (aux == false);
        }
        System.out.println("\nStudent Name: " + studentName +
                "\nGrade 01: " + grade01 +
                "\nGrade 02: " + grade02 +
                "\nGrade 03: " + grade03);

        double totalGrade = grade01 + grade02 + grade03;
        System.out.println("Final grade: " + totalGrade);

        if ((grade01 < 18) || (grade02 < 21) || (grade03 < 21)) {
            System.out.println("Failed!");
        } else {
            System.out.println("Pass");
        }

        if (grade01 < 18) {
            System.out.println("Missing: " + (18 - grade01) + " points to grade 01!");
        }
        if (grade02 < 21) {
            System.out.println("Missing: " + (21 - grade02) + " points to grade 02!");
        }
        if (grade03 < 21) {
            System.out.println("Missing: " + (21 - grade03) + " points to grade 03!");
        }
        sc.close();

    }

    public boolean CheckingGrades(double gradeValue, int gradeOpt) {
        boolean aux = false;
        if (gradeOpt == 1) {
            if (gradeValue >= 0 && gradeValue <= 30) {
                aux = true;
            } else {
                aux = false;
            }
        } else if (gradeOpt == 2 || gradeOpt == 3) {
            if (gradeValue >= 0 && gradeValue <= 35) {
                aux = true;
            } else {
                aux = false;
            }
        } else {
            System.out.println("Grade do not exist. Try 1 - To Grade 01\n2 - To Grade 02\n3 - To Grade 03\nGrade: ");
            aux = false;
        }
        return aux;
    }
}

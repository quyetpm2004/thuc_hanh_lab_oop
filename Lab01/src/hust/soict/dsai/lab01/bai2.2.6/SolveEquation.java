import java.util.Scanner;

import javax.swing.JOptionPane;

public class SolveEquation {
    public static void main(String[] args) {
        String strOption = JOptionPane.showInputDialog(null, "Ban muon giai kieu phuong trinh nao\n 1.Phuong trinh bac nhat 1 an\n 2.He phuong trinh 2 an\n 3.Phuong trinh bac hai 1 an");
        int intOption = Integer.parseInt(strOption);
        switch (intOption) {
            case 1:
                firstDegreeEquationWithOneVal();
                break;
            case 2: 
                firstDegreeEquationWithTwoVal();
                break;
            case 3:
                twoDegreeEquationWithOneVal();
                break;
            default:
                break;
        }
    }
    public static void firstDegreeEquationWithOneVal() {
        System.out.println("Giai phuong trinh ax + b = 0");
        double a, b;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap a, b: ");
        a = sc.nextDouble();
        b = sc.nextDouble();
        if(a == 0) System.out.println("Phuong trinh vo nghiem!");
        else {
            System.out.println("Phuong trinh co nghiem: " + (- b / a));
        }
    }
    public static void firstDegreeEquationWithTwoVal() {
        System.out.println("Giai he phuong trinh a11*x1 + a12*x2 = b1\na21*x1 + a22*x2 = b2");
        double a11, a12, b1, a21, a22, b2;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap a11, a12, b1: ");
        a11 = sc.nextDouble();
        a12 = sc.nextDouble();
        b1 = sc.nextDouble();
        System.out.print("Nhap a21, a22, b2: ");
        a21 = sc.nextDouble();
        a22 = sc.nextDouble();
        b2 = sc.nextDouble();
        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;
        if (D == 0) {
            if(D1 != 0 || D2 != 0) System.out.println("He phuong trinh vo nghiem");
            else System.out.println("He phuong trinh vo so nghiem");
        } else {
            System.out.println("Phuong trinh co nghiem x = " + (D1/D) + " y = " + (D2/D));
        }
    }
    public static void twoDegreeEquationWithOneVal() {
        System.out.println("Giai phuong trinh a*x^2 + bx + c = 0");
        double a, b, c;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap a, b, c: ");
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();
        if (a == 0) {
            if (b == 0) {
                System.out.println("Phuong trinh vo nghiem!");
            } else {
                System.out.println("Phuong trinh co mot nghiem: " + "x = " + (-c / b));
            }
            return;
        }
        double delta = b*b - 4*a*c;
        double x1;
        double x2;
        if (delta > 0) {
            x1 = ((-b + Math.sqrt(delta)) / (2*a));
            x2 = ((-b - Math.sqrt(delta)) / (2*a));
            System.out.println("Phuong trinh co 2 nghiem: "
                    + "x1 = " + x1 + " va x2 = " + x2);
        } else if (delta == 0) {
            x1 = (-b / (2 * a));
            System.out.println("Phuong trinh co nghiem kep: "
                    + "x1 = x2 = " + x1);
        } else {
            System.out.println("Phuong trinh vo nghiem!");
        }
    }
}

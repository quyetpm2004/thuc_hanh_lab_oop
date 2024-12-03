package hust.soict.dsai.lab01.bai225;

import java.util.Scanner;

class Entry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so thu nhat: ");
        String strA = sc.next();
        System.out.print("Nhap so thu hai: ");
        String strB = sc.next();
        double a = Double.parseDouble(strA);
        double b = Double.parseDouble(strB);
        System.out.println("Tong: " + (a + b));
        System.out.println("Hieu: " + (a - b));
        System.out.println("Tich: " + (a * b));
        if(b != 0) {
            System.out.println("Thuong: " + (a / b));
        } else {
            System.out.println("Khong the chia");
        }
    }
}

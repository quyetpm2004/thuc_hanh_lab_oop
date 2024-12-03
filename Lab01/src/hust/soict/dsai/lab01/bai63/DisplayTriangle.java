package hust.soict.dsai.lab01.bai63;

import java.util.Scanner;

public class DisplayTriangle {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chieu cao (n): ");
        n = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            for(int j = i; j <= n - 1; j++) {
                System.out.print(" ");
            }
            for(int k = 1; k <= i * 2 - 1; k++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}


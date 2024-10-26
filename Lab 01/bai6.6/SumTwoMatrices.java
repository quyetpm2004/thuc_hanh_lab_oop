import java.util.Scanner;

public class SumTwoMatrices {
    public static void main(String[] args) {
        int n, m;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap hang, nhap cot: ");
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr1 = new int[1000][1000];
        int[][] arr2 = new int[1000][1000];
        int[][] arr3 = new int[1000][1000];
        System.out.println("Nhap mang 1: ");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }
        System.out.println("Nhap mang 2: ");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr2[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr3[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        System.out.println("Tong cua 2 mang la: ");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(arr3[i][j] + " ");
            }
            System.out.println();
        }
    }
}

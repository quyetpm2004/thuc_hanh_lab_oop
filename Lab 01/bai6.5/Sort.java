import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[100];
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so phan tu cua mang: ");
        n = sc.nextInt();
        System.out.print("Nhap mang: ");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        bubbleSort(arr, n);
        System.out.print("Mang sau khi sap xep: ");
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
        }
        double avg = (double) sum / n;
        System.out.print("\nTong cua mang: " + sum);
        System.out.print("\nGia tri trung binh cua mang: " + avg);
    }
    public static void bubbleSort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
        }
    }
}

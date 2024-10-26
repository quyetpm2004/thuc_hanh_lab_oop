import java.util.Scanner;

public class DisplayNumberOfMonth {
    public static void main(String[] args) {
        int year;
        String month;
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("Nhap nam: ");
            year = sc.nextInt();

            if(year <= 0) {
                System.out.print("Vui long nhap lai!");
                continue;
            }

            System.out.print("Nhap thang: ");
            month = sc.next();
            if(getIntMonth(month) == -1) {
                System.out.println("Vui long nhap lai!");
                continue;
            }
            System.out.println("Thang " + month + " cua nam " + year + " co " + dateOfMonth(getIntMonth(month), year) + " ngay");
            break;
        }
    }
    public static int getIntMonth(String month) {
        switch (month) {
            case "January": case "Jan.": case "Jan": case "1":
                return 1;
            case "February": case "Feb.": case "Feb": case "2":
                return 2;
            case "March": case "Mar.": case "Mar": case "3":
                return 3;
            case "April": case "Apr.": case "Apr": case "4":
                return 4;
            case "May": case "May.": case "5":
                return 5;
            case "June": case "June.": case "Jun": case "6":
                return 6;
            case "July": case "Jul.": case "Jul": case "7":
                return 7;
            case "August": case "Aug.": case "Aug": case "8":
                return 8;
            case "September": case "Sept.": case "Sept": case "9":
                return 9;
            case "October": case "Oct.": case "Oct": case "10":
                return 10;
            case "November": case "Nov.": case "Nov": case "11":
                return 11;
            case "December": case "Dec.": case "Dec": case "12":
                return 12;
            default:
                return -1;
        }
    }
    public static int dateOfMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2: 
                if(checkLeapYear(year) == 1) return 29;
                return 28;
            default:
                return 0;
        }
    }
    public static int checkLeapYear(int year) {
        if(year % 4 == 0) {
            if(year % 100 == 0 && year % 400 != 0) {
                return 0;
            } 
            return 1;
        } 
        return 0;
    }
    
}

package _01_introduction_java.practice;

import java.util.Scanner;

public class ung_dung_chuyen_doi_tien_te {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời nhập số tiền (usd)");
        float usd = Float.parseFloat(scanner.nextLine());
        float result = usd * 23000;
        System.out.println(result);
    }
}

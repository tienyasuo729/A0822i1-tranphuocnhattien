import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap chuoi: ");
        String strings = scanner.nextLine();
        Queue<Character> queue = new LinkedList<>();
        for (int i = strings.length() - 1; i >= 0; i--) {
            queue.add(strings.charAt(i));
        }
        String reverse = "";
        while (!queue.isEmpty()) {
            reverse = reverse + queue.remove();
        }
        if (strings.equals(reverse)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
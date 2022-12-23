import java.util.Scanner;

public class Main {
    public static void checkTriangle(int a, int b, int c) throws IllegalTriangleException{
        if(a > b + c && a > 0 && b > 0 && c > 0 || b > a + c && a > 0 && b > 0 && c > 0 || c > a + b && a > 0 && b > 0 && c > 0){
            throw  new IllegalTriangleException("Tam giác không hợp lệ");
        }else {
            throw new IllegalTriangleException("Tam giác hợp lệ");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        do {
            check = false;
            System.out.println("Nhập vào đây 3 cạnh của tam giác ");
            int a,b,c;
            try {
                System.out.println("Nhập cào đây cạnh a : ");
                a = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập cào đây cạnh b : ");
                b = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập cào đây cạnh c : ");
                c = Integer.parseInt(scanner.nextLine());
                checkTriangle(a,b,c);
            } catch (IllegalTriangleException illegalTriangleException){
                System.out.println(illegalTriangleException.getMessage());
                System.out.println("Nhập lại");
                check = true;
            } catch (NumberFormatException e){
                check = true;
                e.printStackTrace();
                System.out.println("Đang nhập chữ ");
            }

        }while (check);
    }
}

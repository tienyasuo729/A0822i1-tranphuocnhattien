package Java_Collecion_Frame_Work;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    static ArrayList<Product> products = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void prin() {
        products.add(new Product(56,"dd",200));
        products.add(new Product(23,"dffffd",20330));
        products.add(new Product(69,"ádasd",205550));
        System.out.println("1/ Thêm sản phâm mới");
        System.out.println("2/ Sủa sản phẩm trong danh sách");
        System.out.println("3/ Xoá sản phẩm trong danh sách");
        System.out.println("4/ Hiển thị sản phẩm trong danh sách");
        System.out.println("5/ Tìm kiếm sản phẩm trong danh sách");
        System.out.println("6/ Sắp xếp sản phẩm trong danh sách");
        System.out.println("7/ Thoát");
        int choose;
        do {
            System.out.print("Chọn chức năng muốn thực hiện : ");
            choose = Integer.parseInt(scanner.nextLine());
        } while (choose > 7 || choose <= 0);
        switch (choose) {
            case 1:
                addProduct();
                break;
            case 2:
                fixInformation();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                System.exit(0);
                break;
        }

    }
    public static void main(String[] args) {
        prin();
    }
    static void addProduct() {
            System.out.print("Nhập mã sản phẩm : ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập tên sản phẩm : ");
            String name = scanner.nextLine();
            System.out.print("Nhập giá sản phẩm : ");
            int price = Integer.parseInt(scanner.nextLine());
            System.out.print("Bạn có muốn thêm sản phẩm không ( Y OR N ) : ");
            String choose = scanner.nextLine();
            if (choose.equals("n") || choose.equals("N")) {
                prin();
            } else {
                Product product = new Product(id,name,price);
                products.add(product);
                prin();
            }
    }

    static void fixInformation(){
        System.out.print("Nhập id sản phẩm muốn sửa : ");
        int fixById = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == fixById) {
                System.out.println(products.get(i));
                int productNeedToFix = i;
                break;
            }
        }
        System.out.print("Nhập mã sản phẩm : ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên sản phẩm : ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm : ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.print("Bạn có muốn thêm sản phẩm không ( Y OR N ) : ");
        String choose = scanner.nextLine();
        if (choose.equals("n") || choose.equals("N")) {
            prin();
        } else {
            products.remove(productNeedToFix);
            Product product = new Product(id,name,price);
            products.add(fixById, product);
            System.out.println("Sản phẩm sau khi sửa là : " + products.get(fixById));
            prin();
        }
    }


}

import java.util.Scanner;

public class InsertSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập vào độ dài mảng");
        int number = scanner.nextInt();
        int [] arr = new  int[number];
        for (int i = 0; i < arr.length; i++){
            System.out.printf("a[%d] = ", i);
            arr[i] = scanner.nextInt();
        }

        for (int i = 0 ; i < number; i++){
            System.out.print(arr[i]+ " ");
        }

        System.out.println("mảng sau khi sắp xếp");
        insertionSort(arr);
        for (int i = 0 ; i < number; i++){
            System.out.print(arr[i]+ " ");
        }

    }

    public static int[] insertionSort(int [] array){
        int pos, x;
        for (int i = 1; i < array.length; i++){
            x = array[i];
            pos = i;
            while (pos > 0 && x < array[pos -1]){
                array[pos] = array[pos - 1];
                pos--;
            }
            array[pos] = x;
        }
        return array;
    }
}
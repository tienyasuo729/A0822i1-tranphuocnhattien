public class MinhHoaInsertSort {
    public static void main(String[] args) {
        int [] arr = {10, 8, 6, 11, 1, 4};
        insertSort(arr);
        show(arr);
    }
    public static void show(int [] arr){
        for (int e: arr) {
            System.out.print(e+ " ");
        }
        System.out.println();
    }
    public static void insertSort(int [] array){
        for (int i = 1; i < array.length;i++){
            show(array);
            int pos = i;
            int x = array[i];
            while (pos > 0 && x < array[pos - 1]){
                array[pos] = array[pos - 1];
                pos--;
            }
            array[pos] = x;
            show(array);
        }
    }
}
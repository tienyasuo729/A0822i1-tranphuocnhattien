package Bai_tap;

import java.util.Arrays;

public class Recursive {
    public static void main(String[] args) {
        int[] array = {1, 2 , 4 , 6 , 7 , 9};
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println(binarySearch(array, 0, 5, 5));
    }

    static int binarySearch(int[] array, int left, int right, int value) {
        int mid = (left + right) / 2;
        if (array[mid] == value) return mid;
        if (mid == right) return -1;
        if (array[mid] > value) {
            return binarySearch(array, left, mid - 1, value);
        } else {
            return binarySearch(array, mid + 1, right, value);
        }
    }
}

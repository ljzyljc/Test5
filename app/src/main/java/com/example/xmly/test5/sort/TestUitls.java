package com.example.xmly.test5.sort;

import java.util.Arrays;

public class TestUitls {

    public static void main(String[] args) {
        int[] arr = new int[]{93, 4, 55, 6, 1, 9, 38};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
//        System.out.println("----");
    }


    public static void quickSort(int[] array, int left, int right) {

        if (left < right) {
//            int base = partition(array, left, right);
            int base = partitionOrder(array, left, right);
            quickSort(array, left, base - 1);
            quickSort(array, base + 1, right);
        }


    }

    //中间的风格值，升序
    public static int partition(int[] array, int left, int right) {
        int base = array[left];
        while (left < right) {

            //从序列右端开始，往左遍历
            while (left < right && array[right] >= base) {
                right--;
            }
            array[left] = array[right];
            while ((left < right && array[left] <= base)) {
                left++;
            }
            array[right] = array[left];

        }
        array[left] = base;
        return left;

    }

    //降序
    public static int partitionOrder(int[] array, int left, int right) {

        int base = array[left];
//        while (left < right) {
//
//            while (left < right && array[left] >= base) {
//                left++;
//            }
//            array[right] = array[left];
//
//            while (left < right && array[right] <= base) {
//                right--;
//            }
//            array[left] = array[right];
//
//        }
        while (left < right) {

            while (left < right && array[right] <= base) {
                right--;
            }
            array[left] = array[right];
            while ((left < right && array[left] >= base)) {
                left++;
            }
            array[right] = array[left];

        }
        array[left] = base;
        return left;

    }

}

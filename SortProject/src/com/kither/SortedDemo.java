package com.kither;

import java.util.Arrays;

public class SortedDemo {

    public static void main(String[] args) {
        // 冒泡排序
        bubbleSortTest();
        // 插入排序
        insertSortTest();
        // 选择排序
        chooseSortTest();
        // 快速排序
        quickSortTest();
        // 归并排序
        mergeSortTest();
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSortTest() {
        bubbleSort(new int[]{2, 5, 1, 4, 3, 9, 7, 0, 8, 6, 33, 22, 41, 14, 11});
    }

    /**
     * 冒泡排序
     *
     * @param waitingSort 待排序数组
     */
    private static void bubbleSort(int[] waitingSort) {
        for (int i = 0, size = waitingSort.length - 1; i < size; i++) {
            for (int j = i + 1; j <= size; j++) {
                if (waitingSort[i] > waitingSort[j]) {
                    swap(waitingSort, i, j);
                }
            }
        }
        System.out.println(Arrays.toString(waitingSort));
    }


    /**
     * 插入排序
     */
    public static void insertSortTest() {
        insertSort(new int[]{2, 5, 1, 4, 3, 9, 7, 0, 8, 6, 33, 22, 41, 14, 11});
    }

    /**
     * 插入排序
     *
     * @param waitingSort 待排序数组
     */
    private static void insertSort(int[] waitingSort) {
        for (int i = 1, size = waitingSort.length; i < size; i++) {
            for (int j = i; j >= 1; j--) {
                if (waitingSort[j] < waitingSort[j - 1]) {
                    swap(waitingSort, j, j - 1);
                }
            }
        }
        System.out.println(Arrays.toString(waitingSort));
    }

    /**
     * 选择排序
     */
    public static void chooseSortTest() {
        chooseSort(new int[]{2, 5, 1, 4, 3, 9, 7, 0, 8, 6, 33, 22, 41, 14, 11});
    }

    /**
     * 选择排序
     *
     * @param waitingSort 待排序数组
     */
    private static void chooseSort(int[] waitingSort) {
        for (int i = 0, size = waitingSort.length - 1; i < size; i++) {
            int least = i;
            for (int j = i + 1; j <= size; j++) {
                if (waitingSort[least] > waitingSort[j]) {
                    // 记录最小下标
                    least = j;
                }
            }
            // 交换
            swap(waitingSort, least, i);
        }
        System.out.println(Arrays.toString(waitingSort));
    }

    /**
     * 快速排序
     */
    public static void quickSortTest() {
        int[] waitingSort = {2, 5, 1, 4, 3, 9, 7, 0, 8, 6, 33, 22, 41, 14, 11};
        quickSort(waitingSort, 0, waitingSort.length - 1);
        System.out.println(Arrays.toString(waitingSort));
    }

    /**
     * 快速排序
     *
     * @param waitingSort 待排序数组
     */
    private static void quickSort(int[] waitingSort, int head, int tail) {
        if (waitingSort == null || waitingSort.length < 2 || tail <= head) {
            return;
        }
        int i = head;
        int j = tail;
        int pivot = waitingSort[(head + tail) >>> 1];
        while (i <= j) {
            // 左边：找到第一个大于pivot的数
            while (waitingSort[i] < pivot) {
                i++;
            }
            // 右边：找到第一个小于pivot的数
            while (waitingSort[j] > pivot) {
                j--;
            }
            // 两数交换
            if (i < j) {
                swap(waitingSort, i, j);
                i++;
                j--;
            } else if (i == j) {
                i++;
            }
        }
        quickSort(waitingSort, head, j);
        quickSort(waitingSort, i, tail);
    }

    /**
     * 归并排序
     */
    public static void mergeSortTest() {
        int[] waitingSort = {2, 5, 1, 4, 3, 9, 7, 0, 8, 6, 33, 22, 41, 14, 11};
        mergeSort(waitingSort, 0, waitingSort.length - 1);
        System.out.println(Arrays.toString(waitingSort));
    }

    private static void mergeSort(int[] waitingSort, int head, int tail) {
        if (waitingSort == null || head >= tail) {
            return;
        }
        int mid = (head + tail) >>> 1;
        mergeSort(waitingSort, head, mid);
        mergeSort(waitingSort, mid + 1, tail);
        merge(waitingSort, head, mid, tail);

    }

    // 合并排序
    private static void merge(int[] waitingSort, int head, int mid, int tail) {
        if (waitingSort == null || head >= tail) {
            return;
        }
        int[] temp = new int[tail - head + 1];
        int i = head;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= tail) {
            if (waitingSort[i] < waitingSort[j]) {
                temp[k++] = waitingSort[i++];
            } else {
                temp[k++] = waitingSort[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = waitingSort[i++];
        }
        while (j <= tail) {
            temp[k++] = waitingSort[j++];
        }
        System.arraycopy(temp, 0, waitingSort, head, temp.length);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

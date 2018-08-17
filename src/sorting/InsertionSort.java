package sorting;

import java.util.Arrays;

public class InsertionSort {

  static void insertionSort(int[] a) {
    int count = 0;
    // after every loop we have a sorted array containing the first i elements.
    for (int i = 0; i < a.length - 1; i++) {
      int k = 0;
      while (k <= i) {
        // find a place to "insert" the (i+1)th element to the sorted array
        // (containing i elements)
        if (a[k] > a[i + 1]) {
          int temp1 = a[k];
          a[k] = a[i + 1];
          for (int j = k + 1; j <= i + 1; j++) {
            int temp2 = a[j];
            a[j] = temp1;
            temp1 = temp2;
            count++;
          }
          break;
        } else {
          k++;
        }

      }

    }
    System.out.println("Swap times " + count);
  }

  public static void main(String[] args) {

    int[] test1 = new int[] { 1, 8, 3, 7, 6, 5 };
    int[] test2 = new int[] { 10, 8, 23, 73, 46, 51, 40, 20, 33, 55, 100 };
    int[] test3 = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
    int[] test4 = new int[] { 1, 3, 5, 7, 9 };

    testInsertionSort(test1);
    testInsertionSort(test2);
    testInsertionSort(test3);
    testInsertionSort(test4);

  }

  static void testInsertionSort(int[] a) {
    System.out.println("before sort: " + Arrays.toString(a));
    insertionSort(a);
    System.out.println("after sort: " + Arrays.toString(a));

  }

}

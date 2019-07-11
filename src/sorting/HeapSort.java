package sorting;

import java.util.Arrays;

/**
 * flow of heapsort
 * - build a heap (parent always is bigger than it children , parentIndex = i, child1  index = 2i +1, child2 index = 2i +2
 * with i from 0
 * - take the top of heap (first element of the heap-array, heap-array is the array that is used to represent the heap)
 * and swap it with the last element of the current heap.
 * - rebuild the heap that leaves out the last element above (that element has been put in to the right position,
 * now we only need to sort with the remain.) (0, last element index - 1)
 * (means, in every step we take the  max element of the heap, swap it with the last element in the heap, then rebuild the heap with the max element has been left out)
 * So rebuild heap take logN, we run N times  to get the top element and swap. => Complexity NlogN
 *
 *
 * 1. build a heap
 * 2. take the top element -> swap it with the last element in the current heap-array
 * 3. rebuild the heap with the size of the heap array is  now shorter by 1 because 1 element has been put to the right position  thanks to step 2.
 * 4. repeat step 2->3 until the heap-array size is 1
 */
public class HeapSort {


  public static void makeHeap(int[] values) {
    for (int i = 0; i < values.length; i++) {
      int index = i;
      while (index != 0) {
        int parent = (index - 1) / 2;
        if (values[index] > values[parent]) {
          // swap current value with its parent
          int temp = values[parent];
          values[parent] = values[index];
          values[index] = temp;
          // continue to check with parent of parent.
          index = parent;
        } else {
          break;
        }
      }
    }
  }

  /**
   * remove the top item of a heap, then fix the heap by putting the last item into the root of the
   * heap, compare it with its children, if there is a child greater than it, swap it with the
   * child. Continue swapping the node down into the tree until you find a spot where the heap
   * property is already satisfied or you reach the bottom of the tree.
   *
   * @param values
   * @return
   */
  public static int removeTopItem(int[] values, int count) {
    int top = values[0];
    values[0] = values[count - 1];
    rebuildHeap(values, count);

    return top;
  }

  /**
   * rebuild the heap after the rightmost element has been swapped with the root.
   *
   * @param values
   * @param endIndex
   */
  public static void rebuildHeap(int[] values, int endIndex) {
    System.out.println("rebuild heap with endIndex =" +endIndex);
    int index = 0;
    while (true) {
      int child1 = index * 2 + 1;
      int child2 = index * 2 + 2;
      if (child1 >= endIndex) child1 = index;
      if (child2 >= endIndex) child2 = index;
      if (values[index] >= values[child1] && values[index] >= values[child2]) break;
      int swapChild = values[child1] > values[child2] ? child1 : child2;
      int temp = values[index];
      values[index] = values[swapChild];
      values[swapChild] = temp;
      System.out.println("Swap :" + values[swapChild] + " with " +values[index]);

      index = swapChild;
    }
  }

  public static void heapSort(int[] values) {
    makeHeap(values);
    System.out.println("heap built : " + Arrays.toString(values));
    for (int i = values.length - 1; i > 0; i--) {
      int temp = values[i];
      values[i] = values[0];
      values[0] = temp;
      rebuildHeap(values, i);
      // System.out.println("re-heap: " + Arrays.toString(values));

    }
    System.out.println("Sorted array " + Arrays.toString(values));
  }

  public static void main(String[] args) {
    int[] test = new int[] {3, 4, 1, 6, 9, 8, 5, 7};
    makeHeap(test);
    System.out.println(Arrays.toString(test));
    // System.out.println(test.getClass().getName());
    for (int i = 0; i < test.length; i++) {
      System.out.println(removeTopItem(test, test.length - i));
      // System.out.println(Arrays.toString(test));
    }
    int[] test2 = new int[] {3, 4, 1, 6, 9, 8, 5, 7};
    heapSort(test2);
  }
}

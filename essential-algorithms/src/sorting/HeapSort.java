package sorting;

import java.util.Arrays;

public class HeapSort {

  public static void makeHeap(int[] values) {
    for (int i = 0; i < values.length; i++) {
      int index = i;
      while (index != 0) {
        int parent = (index - 1) / 2;
        if (values[index] > values[parent]) {
          int temp = values[parent];
          values[parent] = values[index];
          values[index] = temp;
          index = parent;
        } else {
          break;
        }
      }

    }

  }

  /**
   * remove the top item of a heap, then fix the heap by putting the last item
   * into the root of the heap, compare it with its children, if there is a
   * child greater than it,
   * swap it with the child. Continue swapping the node down into the tree until
   * you find a spot where the heap property is already satisfied or you reach
   * the bottom of the tree.
   * 
   * @param values
   * @return
   */
  public static int removeTopItem(int[] values, int count) {
    int top = values[0];
    values[0] = values[count - 1];
    int index = 0;
    while (true) {
      int child1 = index * 2 + 1;
      int child2 = index * 2 + 2;
      if (child1 >= count)
        child1 = index;
      if (child2 >= count)
        child2 = index;
      if (values[index] >= values[child1] && values[index] >= values[child2])
        break;
      int swapChild = values[child1] > values[child2] ? child1 : child2;
      int temp = values[index];
      values[index] = values[swapChild];
      values[swapChild] = temp;
      index = swapChild;
    }

    return top;
  }

  /**
   * rebuild the heap after the rightmost element has been swapped with the
   * root.
   * 
   * @param values
   * @param count
   */
  public static void rebuildHeap(int[] values, int count) {
    int index = 0;
    while (true) {
      int child1 = index * 2 + 1;
      int child2 = index * 2 + 2;
      if (child1 >= count)
        child1 = index;
      if (child2 >= count)
        child2 = index;
      if (values[index] >= values[child1] && values[index] >= values[child2])
        break;
      int swapChild = values[child1] > values[child2] ? child1 : child2;
      int temp = values[index];
      values[index] = values[swapChild];
      values[swapChild] = temp;
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
    int[] test = new int[] { 3, 4, 1, 6, 9, 8, 5, 7 };
    makeHeap(test);
    System.out.println(Arrays.toString(test));
    // System.out.println(test.getClass().getName());
    for (int i = 0; i < test.length; i++) {
      System.out.println(removeTopItem(test, test.length - i));
      // System.out.println(Arrays.toString(test));
    }
    int[] test2 = new int[] { 3, 4, 1, 6, 9, 8, 5, 7 };
    heapSort(test2);

  }
}

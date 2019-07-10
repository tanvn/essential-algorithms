package sorting;

import java.util.Arrays;

public class MergeSort {
    private static int[] merge(int[] a,int startA, int endA, int[] b, int startB, int endB) {
        int size = endA-  startA  +1  +  endB - startB  +1;
//        System.out.println("startA=" + startA + " | endA="  + endA + " |startB =" + startB + "|endB=" + endB );
//        System.out.println("a=  "+Arrays.toString(a));
//        System.out.println("b=  "+Arrays.toString(b));

        int[] res = new int[size];
        int i = startA, j = startB, m = 0;
        while(i<= endA && j <= endB)  {
            if(a[i] < b[j]) {
                res[m] = a[i];
                i++;
            }else {
                res[m] = b[j];
                j++;
            }
            m++;
        }
        while(i  <= endA) {
            res[m++] = a[i++];
        }
        while(j <= endB) {
            res[m++] = b[j++];
        }
        System.out.println("res=  "+ Arrays.toString(res));


        return res;
    }

    public static int[] innerMergeSort(int[] arr, int start, int end) {
        int middle = start + (end - start)/2;
        System.out.println("start=" + start + " | end="  + end + " |middle =" + middle);
        if( middle -start  <= 1 &&  end - middle  <= 1) {
            return merge(arr, start, middle, arr, Math.min(middle+1, end), end);
        }else {
            int[] left = innerMergeSort(arr, start, middle);
//            System.out.println("left=  "+Arrays.toString(left));
            int[] right = innerMergeSort(arr, Math.min(middle+1, end), end);
//            System.out.println("right=  "+Arrays.toString(right));

            return merge(left,0, left.length-1, right,0, right.length-1);
        }
    }

    public static int[] mergeSort(int[] arr) {
        return innerMergeSort(arr, 0, arr.length -1);
    }

    public static void main(String[] args) {
        int[] data = {3 ,4 ,1 ,10, 5, 9, 30, 21, 40, 19,12,60,32};
        int[] sortedData  = mergeSort(data);
        System.out.println(Arrays.toString(sortedData));

    }
}

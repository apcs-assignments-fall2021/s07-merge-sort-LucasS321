import java.util.ArrayList;
import java.util.Arrays;

public class MyMain {
    // ********************
    // Code from homework
    // ********************

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length+ arr2.length];
        int arr1index = 0;
        int arr2index = 0;
        int arr3index = 0;
        int arr3value = Integer.MIN_VALUE + 50;
        while (arr1index <= arr1.length-1 || arr2index <= arr2.length-1) {
            int difference1 = Integer.MAX_VALUE;
            int difference2 = Integer.MAX_VALUE;
            if (arr1index <= arr1.length-1) {
                difference1 = arr1[arr1index] - arr3value;
            }
            if (arr2index <= arr2.length-1) {
                difference2 = arr2[arr2index] - arr3value;
            }
            if (difference1 < difference2) {
                arr3[arr3index] = arr1[arr1index];
                arr3value = arr1[arr1index];
                arr1index = arr1index + 1;
                arr3index = arr3index + 1;

            } else {
                arr3[arr3index] = arr2[arr2index];
                arr3value = arr2[arr2index];
                arr2index = arr2index + 1;
                arr3index = arr3index + 1;
            }
        }
        return arr3;
    }

    // **************************
    // In-class Practice Problems
    // **************************

    // Create a copy of part of an array
    // This should work similarly to substring in that we are
    // given two indexes, start and end, and we start with the
    // value at start and go up to but not including end

    // Examples:
    // subArray([5, 4, 3, 2, 1], 1, 3) => [4, 3]
    // subArray([1, 4, 3, 7], 0, 4) => [1, 4, 3, 7]
    // subArray([1, 4, 3, 7], 2, 4) => [3, 7]
    public static int[] subArray(int[] arr, int begin, int end) {
        int[] newarr = new int[end-begin];
        int curindex = 0;
        for (int x = begin; x < end; x++) {
            newarr[curindex] = arr[x];
            curindex += 1;
        }
        return newarr;
    }

    // Carries out merge sort!
    // The merge sort algorithm is divided into three main steps
    // Divide the array into two halves
    // Call merge sort (recursively) on the left half and the right half
    // Call merge to combine the two sorted halves into one sorted array
    //
    // We will keep recursing until the array is size 1, at which point we
    // just array the (sorted) array of size 1

    // You can assume that the array's length will be some power of 2

    // Examples:
    // mergeSort([6, 3, 4, 1, 5, 8, 7, 2]) => [1, 2, 3, 4, 5, 6, 7, 8]
    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        //System.out.println(Arrays.toString(mergeSort(subArray(arr, 0, (int) (arr.length / 2)))));
        //System.out.println(Arrays.toString(mergeSort(subArray(arr, (int) (arr.length / 2), arr.length))));
        return merge(mergeSort(subArray(arr,0, (int)(arr.length/2))),mergeSort(subArray(arr,(int)(arr.length/2),arr.length )));
    }



    // **************************
    // Homework Methods
    // **************************

    // For homework, we'll revisit a previous algorithm: insertion sort.
    // This will be the final recursive code that we'll write for a while.

    // First, write the insert method, which is given a sorted ArrayList
    // and a number x to insert into that ArrayList

    // Tail recursion will probably be helpful!

    // Hint: recall that we are going to insert x once we find the first
    // number in the ArrayList that is larger than x

    // Hint2: if we never find a number larger than x, x should be inserted
    // at the end of our ArrayList

    // Examples:
    // insert([1, 2, 4, 5], 3) => [1, 2, 3, 4, 5]
    // insert([1, 2, 4, 5], 0) => [0, 1, 2, 4, 5]
    // insert([1, 2, 4, 5, 7, 8], 10) => [1, 2, 4, 5, 7, 8, 10]

    // Wrapper method
    public static ArrayList<Integer> insert(ArrayList<Integer> list, int x) {
        for (int i = 0; i < list.size(); i ++) {
            if (list.get(i) > x) {
                list.add(i, x);
                return list;
            }
        }
        list.add(list.size(), x);
        return list;
    }

    // Tail recursive method
    public static ArrayList<Integer> insertTR(ArrayList<Integer> list, int x, int i) {
        // YOUR CODE HERE
        return null;
    }

    // Next, write the insertion sort method, which is sorts a given
    // ArrayList using insertion sort

    // We can use the following recursive pseudocode:
    // Base case: if the list is size 1, it's sorted so just return the original list
    // Otherwise:
    // * Save the last element in the ArrayList
    // * Remove the last element of the ArrayList (making the list 1 shorter)
    // * Recursively sort the (now shorter) list
    // * Insert the saved value into the sorted, shorter list

    // No tail recursion necessary!

    // Hint: use the insert value from above

    // Examples:
    /// insertionSort([6, 3, 4, 1, 5, 8, 7, 2]) => [1, 2, 3, 4, 5, 6, 7, 8]
    public static ArrayList<Integer> insertionSort(ArrayList<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }
        int lastitem = list.get(list.size()-1);
        list.remove(list.size()-1);

        return insert(insertionSort(list),lastitem);
    }
}

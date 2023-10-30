import java.util.Arrays;
import java.util.Random;

public class GenericSort<T extends Comparable<T>> {
    public void bubbleSort(T[] array) {
        int n = array.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1].compareTo(array[i]) > 0) {
                    T temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    public void mergeSort(T[] array) {
        if (array.length <= 1) {
            return;
        }

        int mid = array.length / 2;
        T[] left = Arrays.copyOfRange(array, 0, mid);
        T[] right = Arrays.copyOfRange(array, mid, array.length);

        mergeSort(left);
        mergeSort(right);

        merge(array, left, right);
    }

    private void merge(T[] result, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        GenericSort<Integer> sorter = new GenericSort<>();
        
        int arraySize = 10;
        Integer[] intArray = new Integer[arraySize];
        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            intArray[i] = random.nextInt(100);
        }
        
        System.out.println("Original Integer Array: " + Arrays.toString(intArray));
        
        Integer[] bubbleSortArray = Arrays.copyOf(intArray, intArray.length);
        sorter.bubbleSort(bubbleSortArray);
        System.out.println("Bubble Sorted Integer Array: " + Arrays.toString(bubbleSortArray));

        Integer[] mergeSortArray = Arrays.copyOf(intArray, intArray.length);
        sorter.mergeSort(mergeSortArray);
        System.out.println("Merge Sorted Integer Array: " + Arrays.toString(mergeSortArray));
    }
}

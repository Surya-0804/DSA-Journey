// Quick Sort 
// Implement Quick Sort, a Divide and Conquer algorithm, to sort an array, arr[] in ascending order.
// Link: https://www.geeksforgeeks.org/problems/quick-sort/1
// Time Complexity: O(n log n)

class QuickSortRecursiveSolution {

    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            // Find the partition index
            int partitionIndex = partition(arr, low, high);

            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (i <= high && arr[i] <= pivot) {
                i++;
            }

            while (j >= low && arr[j] > pivot) {
                j--;
            }

            if (i < j) {
                swap(arr, i, j);
            }
        }

        swap(arr, low, j);
        return j;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

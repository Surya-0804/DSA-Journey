//sort an array
//sort the array in ascending order in O(nlogn) compleity
//link: https://leetcode.com/problems/sort-an-array/

class MergeSortRecursiveSolution {

    private static void merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int[] temp = new int[high - left + 1];
        int index = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }
        while (left <= mid) {
            temp[index++] = arr[left++];
        }
        while (right <= high) {
            temp[index++] = arr[right++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[i + low] = temp[i];
        }
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
}
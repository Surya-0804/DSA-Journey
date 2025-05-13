//Upper Bound 
// Binary search algorithm to find the first position where a value can be inserted
// in a sorted array without changing the order of the array
// Time complexity: O(log n)
// Space complexity: O(1)
//link: https://www.geeksforgeeks.org/problems/implement-upper-bound/1

class UpperBoundSolution {
    int upperBound(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;
        int answer = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > target) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }
}
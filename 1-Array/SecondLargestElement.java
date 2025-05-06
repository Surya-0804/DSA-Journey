//Second largest element in an array
// Given an array of integers, find the second largest element in it. If there are no distinct elements, return -1.
// Time Complexity: O(n)
// Space Complexity: O(1)
// link: https://practice.geeksforgeeks.org/problems/second-largest3735/1
class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int largest = arr[0];
        int second = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                second = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > second) {
                second = arr[i];
            }
        }
        return second;
    }
}
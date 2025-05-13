// Maximum Points You Can Obtain from Cards
// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/

// You have a row of `n` cards. The `i-th` card has a value of `cardPoints[i]`.
// You want to pick some cards from the beginning and some cards from the end of the row to maximize the sum of the card values.
// After picking the cards, you cannot pick the cards from the same end any longer.

//Time Complexity: O(2*k)
//Space Complexity: O(1)
//Tow Pointers Approach
//We can use two pointers to keep track of the left and right ends of the row of cards.
//We can start by picking `k` cards from the left end and then gradually move the left pointer to the right and the right pointer to the left, while keeping track of the maximum sum of card values.
class MaximumPoints {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;
        int rightSum = 0;
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }
        maxSum = leftSum;
        int backIndex = cardPoints.length - 1;
        for (int i = k - 1; i >= 0; i--) {
            leftSum -= cardPoints[i];
            rightSum += cardPoints[backIndex--];
            int sum = rightSum + leftSum;
            maxSum = (maxSum < sum) ? sum : maxSum;
        }
        return maxSum;
    }
}
//Happy Number 
//Write an algorithm to determine if a number n is happy.
// A happy number is a number defined by the following process:
// Starting with any positive integer, replace the number by the sum of the squares of its digits.
// Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
// Those numbers for which this process ends in 1 are happy.
//link : https://leetcode.com/problems/happy-number/description/
//using hash set
//Time Complexity: O(log n)
// Space Complexity: O(log n)

import java.util.HashSet;
import java.util.Set;

class HappyNumberSolution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int num = n;

        while (num != 1 && !set.contains(num)) {
            set.add(num);
            num = sumOfSquares(num);
        }

        return num == 1;
    }

    private static int sumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int rem = num % 10;
            sum += rem * rem;
            num /= 10;
        }
        return sum;
    }
}
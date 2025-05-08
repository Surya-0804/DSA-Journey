// Problem: Count the number of palindrome words in a string
//link: https://www.naukri.com/code360/problems/count-palindrome-words-in-a-sentence_975378
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(1)

public class CountPalindromes {
    public static int countNumberOfPalindromeWords(String s) {
        // Write your code here!
        if (s.length() == 1 || s.length() == 0) {
            return s.length();
        }
        String[] words = s.split("\\s+");
        int count = 0;
        for (String word : words) {
            if (isPalindrome(word.toLowerCase())) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
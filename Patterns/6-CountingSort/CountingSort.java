// Counting sort
// Given a string arr consisting of lowercase English letters,
// arrange all its letters in lexicographical order using Counting Sort.
// Link: https://www.geeksforgeeks.org/problems/counting-sort/1

// Time Complexity: O(n + k) where n = length of string, k = 26 (constant for lowercase letters)
// Space Complexity: O(k) = O(26) = O(1), since count array has fixed size

import java.util.*;

class CountingSortSolution {

    public static String countSort(String arr) {
        // code here
        int[] count = new int[26];

        for (char ch : arr.toCharArray()) {
            count[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder(arr.length());

        for (int i = 0; i < 26; i++) {
            while (count[i]-- > 0) {
                sb.append((char) (i + 'a'));
            }
        }

        
        return sb.toString();
    }
}

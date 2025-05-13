//Longest Substring Without Repeating Characters
// Given a string s, find the length of the longest substring without repeating characters.
//Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/

// ------------------------------------------------------------------------------------
// 🧠 Brute Force Approach
//Time Complexity: O(n^2)
//Space Complexity: O(256) = O(1)
//Brute Force Approch

import java.util.Arrays;

class SolutionBruteForce {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean visited[] = new boolean[256];
            for (int j = i; j < s.length(); j++) {
                if (visited[s.charAt(j)]) {
                    break;
                }
                maxLength = Math.max(maxLength, j - i + 1);
                visited[s.charAt(j)] = true;
            }
        }
        return maxLength;
    }
}

// ------------------------------------------------------------------------------------
// ⚡ Optimized Approach: Two Pointers / Sliding Window
// Time Complexity: O(n)
// Space Complexity: O(256) = O(1)
class SolutionOptimized {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int maxLength = 0;
        int[] hash = new int[256];
        // for (int i = 0; i < 256; i++) {
        // hash[i] = -1;
        // }
        Arrays.fill(hash, -1); // Initialize the hash array with -1

        while (r < s.length()) {
            if (hash[s.charAt(r)] != -1) {
                if (hash[s.charAt(r)] >= l) {
                    l = hash[s.charAt(r)] + 1;
                }
            }
            maxLength = Math.max(maxLength, r - l + 1);
            hash[s.charAt(r)] = r;
            r++;
        }
        return maxLength;
    }
}
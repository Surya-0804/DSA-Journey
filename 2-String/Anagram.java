// 🧩 Problem: Valid Anagram
// ✅ Description:
// An anagram is a word or phrase formed by rearranging the letters of another.
// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
// 🔗 Link: https://leetcode.com/problems/valid-anagram/

// ✅ Approach 1: Sorting
// 📈 Time Complexity: O(n log n)
// 📦 Space Complexity: O(n)

import java.util.*;

class SolutionSorting {
    public boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(t1);

        return Arrays.equals(s1, t1);
    }
}

// ✅ Approach 2: HashMap
// 📈 Time Complexity: O(n)
// 📦 Space Complexity: O(n)
class SolutionHashMap {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            if (!map.containsKey(ch))
                return false;

            map.put(ch, map.get(ch) - 1);

            if (map.get(ch) < 0)
                return false;
        }

        return true;
    }
}

// ✅ Approach 3: Frequency Array
// 📈 Time Complexity: O(n)
// 📦 Space Complexity: O(1) – since array size is constant (26)
class SolutionArray {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] frequency = new int[26];

        for (char ch : s.toCharArray()) {
            frequency[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            if (frequency[ch - 'a'] == 0)
                return false;
            frequency[ch - 'a']--;

            if (frequency[ch - 'a'] < 0)
                return false;
        }

        return true;
    }
}

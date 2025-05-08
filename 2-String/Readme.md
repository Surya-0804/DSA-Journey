# 📦 String Problems

> StringNotes -> [Notes](./notes.md)

## 🔠 Longest Substring Without Repeating Characters

### 🔗 Problem Link:

[LeetCode - Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

### ✅ Approach 1: Brute Force

- Use nested loops to explore all substrings.

- Track visited characters using a boolean array.

- Stop when a character repeats.

- 📈 Time & Space Complexity:

  - Time: O(n²)

  - Space: O(256) ≈ O(1)

### ✅ Approach 2: Optimized - Sliding Window (Two Pointers)

- Use two pointers to track current window of unique characters.

- Hash array to store the last seen index of characters.

- If a character is repeated, move the left pointer just past the previous index of the character.

- 📈 Time & Space Complexity:

  - Time: O(n)

  - Space: O(256) ≈ O(1)

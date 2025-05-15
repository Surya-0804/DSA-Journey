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

---

## 🔁 Count Palindrome Words in a Sentence

### 🔗 Problem Link:

[Naukri Code360 - Count Palindrome Words in a Sentence](https://www.naukri.com/code360/problems/count-palindrome-words-in-a-sentence_975378)

### 🧠 Problem Statement:

- You are given a string S containing multiple words.
- Your task is to count the number of words that are palindromes.

- A word is a palindrome if it reads the same forwards and backwards (case-insensitive).

### ✅ Approach: Word Splitting + Palindrome Check

- Split the string using regex (\s+) to handle multiple spaces.

- Convert each word to lowercase to make the check case-insensitive.

- Use two-pointer technique to check each word for palindrome property.

- Increment a counter if the word is a palindrome.

- #### 📈 Time & Space Complexity:

  - Time Complexity: O(n)
    (where n is the total length of the string — each character is processed once)

  - Space Complexity: O(1)
    (ignoring the space for the split words which is unavoidable)

---

# 🧩 Valid Anagram

## 🔗 Problem Link:

[Leetcode - Valid Anagram](https://leetcode.com/problems/valid-anagram/description/)

## 📄 Problem Statement:

An anagram is a word or phrase formed by rearranging the letters of another, using all the original letters exactly once.

Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise.

---

## ✅ Approaches

### 🟠 Approach 1: Sorting

- Convert both strings to character arrays.
- Sort both arrays.
- Compare the sorted arrays.

#### 📈 Time Complexity:

- `O(n log n)`

#### 📦 Space Complexity:

- `O(n)` (due to char arrays)

---

### 🟢 Approach 2: HashMap

- Count frequency of each character in string `s`.
- Decrease frequency for each character in string `t`.
- If any character has mismatched frequency or doesn't exist, return false.

#### 📈 Time Complexity:

- `O(n)`

#### 📦 Space Complexity:

- `O(n)`

---

### 🔵 Approach 3: Frequency Array

- Use a fixed-size integer array (size 26 for lowercase a-z).
- Increment counts for characters in `s`, decrement for `t`.
- If any frequency goes below zero, return false.

#### 📈 Time Complexity:

- `O(n)`

#### 📦 Space Complexity:

- `O(1)` (since array size is constant)

---

## 📌 Notes:

- Frequency array is the most efficient in terms of space and speed for lowercase English letters.
- Use HashMap if input may include unicode or mixed-case characters.

---

# 🧩 Counting Sort – Lexicographical String Sorting

## 🔗 Problem Link:

[GeeksforGeeks - Counting Sort](https://www.geeksforgeeks.org/problems/counting-sort/1)

---

## 📄 Problem Statement:

Given a string `arr` consisting only of **lowercase English letters**, your task is to **sort its characters in lexicographical (alphabetical) order** using **Counting Sort**.

---

## ✅ Approach: Frequency Count (Counting Sort)

- Create an integer array of size `26` to store frequencies of each character (`'a'` to `'z'`).
- Traverse the input string and update the count of each character.
- Traverse the count array and rebuild the string by appending each character `count[i]` times.

---

### 🧠 Why Counting Sort?

- **Efficient** when working with small, bounded character sets like lowercase letters (`a-z`).
- Avoids `O(n log n)` complexity of comparison-based sorting algorithms.

---

<!-- ### 🛠️ Implementation:

```java
public static String countSort(String arr) {
    int[] count = new int[26];

    // Count frequency of each character
    for (char ch : arr.toCharArray()) {
        count[ch - 'a']++;
    }

    // Reconstruct the sorted string
    StringBuilder sb = new StringBuilder(arr.length());
    for (int i = 0; i < 26; i++) {
        while (count[i]-- > 0) {
            sb.append((char) (i + 'a'));
        }
    }

    return sb.toString();
}
```

--- -->

### 📈 Time Complexity:

- `O(n + k)`
  where:

  - `n` = length of the input string
  - `k` = 26 (constant size for lowercase English letters)

➡️ So effectively, **`O(n)`**

---

### 📦 Space Complexity:

- `O(k)` = `O(26)` = **`O(1)`**
  (Fixed-size frequency array; constant space)

---

## 📌 Notes:

- Very efficient for problems involving **only lowercase letters**.
- For general character sets (e.g. Unicode), consider using a **HashMap** instead of a fixed array.
- Unlike comparison-based sorts, **Counting Sort is not comparison-based** and is thus faster for constrained input domains.

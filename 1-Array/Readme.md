# 📦 Array Problems

> ArrayNotes -> [Notes](./notes.md)

## 🧩 Pattern: Find Second Largest

### 🔗 Problem Link:

[Second Largest Element in Array](https://practice.geeksforgeeks.org/problems/second-largest3735/1)

### ✅ Approach:

- Traverse array once
- Track largest and second largest
- Update accordingly while skipping duplicates

### 📈 Time & Space:

- Time: `O(n)`
- Space: `O(1)`

---

## 🧩 Pattern: Remove Duplicates from Sorted Array

### 🔗 Problem Link:

[Remove Duplicates from Sorted Array - LeetCode](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

### 📝 Problem Statement:

Given a sorted array nums, remove the duplicates in-place such that each element appears only once and return the new length.
Do not allocate extra space for another array — you must do this by modifying the input array in-place with O(1) extra memory.

### 🔍 Brute Force Approach

- Use a LinkedHashSet to eliminate duplicates while maintaining insertion order.

- Copy set back into array from index 0.

- ✅ Time & Space:
  - Time: O(n log n)
  - Space: O(n)

### ⚡ Optimized Approach (Two Pointers)

- Use two pointers:

  - i for placing unique elements
  - j for traversing the array

- If nums[i] != nums[j], increment i and update nums[i] = nums[j].

- ✅ Time & Space:

  - Time: O(n)

  - Space: O(1)

> 💡 Edge Case:
> If the array has 0 or 1 element, it’s already unique.

---

## 🃏 Maximum Points You Can Obtain from Cards

### 🔗 Problem Link:

[LeetCode - Maximum Points You Can Obtain from Cards](https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/)

### 🧠 Problem Summary:

You have a row of n cards, each with a value in cardPoints[i]. You can pick exactly k cards from either the beginning or the end (not from the middle) to maximize the total points. The goal is to choose the best combination of cards from the front and back.

### ✅ Approach: Two Pointers (Sliding Window)

- First, compute the total of the first k cards from the front.

- Then, slide a window by removing cards from the front and adding from the back.

- At each step, track the maximum sum.

- 📈 Time & Space Complexity:

  - Time: O(k) (Front k sum + sliding window of k)

  - Space: O(1)

### 📌 Intuition:

- Initially, consider taking all k from the start.

- For every iteration, take one less from the front and one more from the back.

- Compare each combination and keep track of the maximum total.

---

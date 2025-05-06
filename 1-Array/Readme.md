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

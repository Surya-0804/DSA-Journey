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

# 📈 Maximum Subarray Sum

## 🔗 Problem Link:

[Leetcode - Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)

---

## 🧩 Problem Statement:

Given an integer array `nums`, find the contiguous subarray (containing at least one number) which has the **largest sum** and return its **sum**.

---

## ✅ Approaches

### 🔴 Brute Force

- Use 3 nested loops.
- Check every possible subarray and track the maximum sum.

#### 📈 Time Complexity:

`O(n^3)`

#### 📦 Space Complexity:

`O(1)`

---

### 🟠 Better Approach

- Use 2 nested loops.
- Avoid recalculating subarray sums by maintaining a running sum.

#### 📈 Time Complexity:

`O(n^2)`

#### 📦 Space Complexity:

`O(1)`

---

### 🟢 Optimal Approach (Kadane’s Algorithm)

- Use a running sum.
- If sum drops below 0, reset it.
- Track maximum seen so far.

#### 📈 Time Complexity:

`O(n)`

#### 📦 Space Complexity:

`O(1)`

---

### 🔵 Kadane’s with Subarray Return

- In addition to max sum, return the actual subarray.
- Keep track of the start and end indices whenever a new maximum is found.

#### 📈 Time Complexity:

`O(n)`

#### 📦 Space Complexity:

`O(1)` (excluding output array)

---

## 💡 Notes:

- Kadane’s Algorithm is the best approach for this problem.
- Brute force and better methods are useful for understanding the problem or for interview discussion on optimization.

---

## ✍️ Example:

```java
int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
Output: 6 // Subarray: [4, -1, 2, 1]
```

---

## 🔍 Pattern: Binary Search

### 🔗 Problem Link:

[Binary Search - LeetCode](https://www.leetcode.com/problems/binary-search/)

### 📝 Problem Statement:

Given a **sorted array** of integers, find the **index** of a target value. If the target does not exist in the array, return -1.  
You must write an algorithm with **O(log n)** runtime complexity.

---

### ✅ Approaches

#### 🔁 Iterative Binary Search

- Initialize `low = 0` and `high = nums.length - 1`.
- While `low <= high`:
  - Compute `mid = low + (high - low) / 2` to avoid overflow.
  - If `nums[mid] == target`, return `mid`.
  - If `nums[mid] > target`, search left: `high = mid - 1`.
  - Else, search right: `low = mid + 1`.
- Return -1 if not found.

#### 🔁 Recursive Binary Search

- Use helper method: `binarySearch(nums, target, low, high)`.
- Base Case: if `low > high`, return -1.
- Compute `mid = low + (high - low) / 2`.
- Recursively search left or right based on comparison.

---

### 📈 Time & Space:

- Time: `O(log n)`
- Space:
  - Iterative: `O(1)`
  - Recursive: `O(log n)` (due to call stack)

---

### 🧠 Notes:

- Works only on **sorted arrays**.
- Use `mid = low + (high - low) / 2` instead of `(low + high) / 2` to avoid **integer overflow**.

---

# Binary Search Patterns: Lower Bound, Upper Bound, and Related Problems

This document covers three key binary search-based problems: **Lower Bound**, **Upper Bound**, and **Search Insert Position**, along with the **Floor and Ceil** problem. These problems are fundamental for solving sorted array queries efficiently.

---

## 🧩 Pattern: Lower Bound

### 🔗 Problem Link:

[Lower Bound](https://www.geeksforgeeks.org/problems/implement-lower-bound/1)

### ✅ Approach:

- Use binary search to find the **first index** where `arr[i] >= x`.
- If `x` exists, return its first occurrence; otherwise, return the insertion point.
- Maintain a variable `answer` (initially `n`) to track the smallest valid index.
- Update `answer` when `arr[mid] >= x` and search left for a smaller index.

### 📈 Time & Space:

- Time: `O(log₂ n)`
- Space: `O(1)`

---

## 🧩 Pattern: Upper Bound

### 🔗 Problem Link:

[Upper Bound](https://www.geeksforgeeks.org/problems/implement-upper-bound/1)

### ✅ Approach:

- Use binary search to find the **smallest index** where `arr[i] > x`.
- If no such element exists, return `n`.
- Maintain a variable `answer` (initially `n`) to track the smallest valid index.
- Update `answer` when `arr[mid] > x` and search left for a smaller index.

### 📈 Time & Space:

- Time: `O(log₂ n)`
- SPACE: `O(1)`

---

## 🧩 Pattern: Search Insert Position

### 🔗 Problem Link:

[Search Insert Position](https://leetcode.com/problems/search-insert-position/description/)

### ✅ Approach:

- Identical to **Lower Bound**: find the smallest index where `arr[i] >= x`.
- Returns the index of `x` if it exists, or the position where `x` should be inserted.
- Reuse the Lower Bound logic directly.

### 📈 Time & Space:

- Time: `O(log₂ n)`
- Space: `O(1)`

---

## 🧩 Pattern: Floor and Ceil in Sorted Array

### 🔗 Problem Link:

[Floor in sorted array](https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1)

[Ceil in sorted array](https://www.geeksforgeeks.org/problems/ceil-in-a-sorted-array/1)

### ✅ Approach:

- **Floor**: Use binary search to find the **largest number** `<= x`.
  - Update `ans` when `arr[mid] <= x` and search right for a larger valid number.
  - Return `-1` if no such number exists.
- **Ceil**: Use binary search to find the **smallest number** `>= x`.
  - Update `ans` when `arr[mid] >= x` and search left for a smaller valid number.
  - Return `-1` if no such number exists.

### 📈 Time & Space:

- Time: `O(log₂ n)` (for each operation)
- Space: `O(1)`

---

### 🎯 Key Notes:

- All these problems leverage **binary search** to achieve logarithmic time complexity.
- They are applicable to **sorted arrays** (with or without duplicates).
- Understanding **Lower Bound** and **Upper Bound** is crucial, as they form the basis for solving **Search Insert Position** and can be adapted for **Floor and Ceil**.
- Ensure overflow-safe midpoint calculation using `low + (high - low) / 2`.

---

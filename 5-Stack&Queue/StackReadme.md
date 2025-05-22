# Stack and Queue Implementations and Problems

> [Stack Notes](./stackNotes.md) | [Queue Notes](./queueNotes.md)

This directory contains implementations and problems for **Stack** and **Queue** data structures, implemented using arrays in Java.

---

# Stack Problems

## Stack Implementation using Array

### 🔗 Problem Link:

[GeeksForGeeks - Stack Implementation using Array](https://www.geeksforgeeks.org/problems/implement-stack-using-array/1)

**Description:**  
A stack is a linear data structure that follows the **Last In, First Out (LIFO)** principle. Elements are added (pushed) and removed (popped) from the same end, referred to as the "top" of the stack.

### 🔧 Implementation Details:

- **Data Structure Used:** Fixed-size array (`int[] arr`) with a maximum capacity of 1000.
- **Key Operations:**
  - `push(int x)`: Adds an element to the top of the stack.
  - `pop()`: Removes and returns the top element from the stack.
  - `top()`: Returns the top element without removing it.
  - `size()`: Returns the current number of elements in the stack.
- **Boundary Conditions:**
  - If the stack is full (`size() == 1000`), `push` operation is ignored.
  - If the stack is empty (`top == -1`), `pop` and `top` return `-1`.

### 🕒 Time & Space Complexity

| Operation | Time Complexity | Space Complexity |
| --------- | --------------- | ---------------- |
| Push      | O(1)            | O(1)             |
| Pop       | O(1)            | O(1)             |
| Top       | O(1)            | O(1)             |
| Size      | O(1)            | O(1)             |

---

## Balanced Parentheses

### 🔗 Problem Link:

[LeetCode - Balanced Parentheses](https://leetcode.com/problems/valid-parentheses/description/)

**Problem Statement:**  
Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is **valid**.

## ✅ Validity Conditions

A string is considered **valid** if:

1. **Open brackets are closed by the same type of brackets.**
2. **Brackets are closed in the correct order.**
3. **Every closing bracket has a corresponding previously opened bracket.**

## 🧠 Approach: Using Stack (LIFO)

### 🔧 Idea:

- Use a `Stack` to keep track of open brackets.
- Push opening brackets onto the stack.
- On encountering a closing bracket:
  - Check if the stack is empty (i.e., unmatched closing bracket).
  - If not empty, pop the top and validate if it matches the closing one.
- In the end, if the stack is empty → the string is valid.

### 🕒 Time & Space Complexity

| Complexity | Value        |
| ---------- | ------------ |
| Time       | O(n)         |
| Space      | O(n) (stack) |

---

# Next Greater Element I

### 🔗 Problem Link:

[LeetCode - Next Greater Element I](https://leetcode.com/problems/next-greater-element-i/)

---

### 🧩 Problem Description

You are given two **distinct** 0-indexed integer arrays `nums1` and `nums2`, where `nums1` is a **subset** of `nums2`.

The **next greater element** of some element `x` in `nums2` is the **first greater element** that is **to the right of `x`** in the same array.

For each element in `nums1`, find the next greater element of it in `nums2`. If it does not exist, return `-1`.

---

### 🚀 Solutions

### 1. Brute Force Approach

- **Idea:**  
  For every element in `nums1`, iterate over `nums2` to find the next greater element.
- **Process:**
  - Set a flag once the target element is found in `nums2`.
  - Continue iterating until an element greater than the target is found.
- **Time Complexity:** `O(n * m)`
- **Space Complexity:** `O(n)`

This approach searches linearly from the match in `nums2` to find the next greater element.

### 2. Optimized Approach using Stack and HashMap

- **Idea:**  
  Pre-compute the next greater element for every value in `nums2` using a stack while processing `nums2` in reverse. Store these mappings in a `HashMap`.
- **Process:**
  - Traverse `nums2` backwards.
  - Use a stack to maintain elements in decreasing order.
  - For each element, pop the smaller elements from the stack.
  - The top element of the stack (if exists) is the next greater element.
  - Save the result in a `HashMap`.
  - Finally, build the output for `nums1` using this map.
- **Time Complexity:** `O(n + m)`
- **Space Complexity:** `O(n + m)`

This uses a monotonic stack and a hashmap to preprocess the next greater elements for all elements in `nums2` and then fetches results for `nums1` efficiently.

---

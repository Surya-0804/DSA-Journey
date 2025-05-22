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

---

---

---

# Queue Problems

## Queue Implementation using Array (Circular Queue)

### 🔗 Problem Link:

[GeeksForGeeks - Queue Implementation using Array](https://www.geeksforgeeks.org/problems/implement-queue-using-array/1)

**Description:**  
A queue is a linear data structure that follows the **First In, First Out (FIFO)** principle. Elements are added (enqueued) at the rear and removed (dequeued) from the front. This implementation uses a circular array to optimize space usage.

### 🔧 Implementation Details:

- **Data Structure Used:** Fixed-size array (`int[] arr`) with a maximum capacity of 100005.
- **Key Operations:**
  - `push(int x)`: Adds an element to the rear of the queue.
  - `pop()`: Removes and returns the front element from the queue.
- **Boundary Conditions:**
  - If the queue is empty (`front == rear`), `pop` returns `-1`.
  - The circular nature is handled using modulo (`% 100005`) to wrap around the array indices.
- **Circular Queue Advantage:** Prevents wasted space by reusing the front of the array after elements are dequeued.
- **Note:** This implementation does not check for queue overflow (when `rear` catches up to `front` after wrapping). Add a check if needed: `if ((rear + 1) % 100005 == front)`.

### 🕒 Time & Space Complexity

| Operation | Time Complexity | Space Complexity |
| --------- | --------------- | ---------------- |
| Push      | O(1)            | O(1)             |
| Pop       | O(1)            | O(1)             |

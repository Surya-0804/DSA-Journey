# 🔗🔗 LinkedList Problems

> LikedList -> [Notes](./notes.md)

--

## 🔗 Design Linked List

### 🔗 Problem Link:

[LeetCode - Design Linked List](https://leetcode.com/problems/design-linked-list/description/)

### 🧠 Problem Summary:

Implement a singly linked list with the following features:

- `get(index)`: Get the value of the node at the `index`-th position (0-indexed).
- `addAtHead(val)`: Add a node of value `val` before the first node.
- `addAtTail(val)`: Append a node of value `val` to the last element.
- `addAtIndex(index, val)`: Add a node with value `val` before the `index`-th node.
- `deleteAtIndex(index)`: Delete the `index`-th node if it exists.

### ✅ Approach: Singly Linked List with Size Tracking

- Define a **Node** class containing `data` and `next`.
- Maintain references to both `head` and `tail`, and track the current `size`.
- For each operation:

  - Traverse from head up to the required index.
  - Adjust the links accordingly for insertions or deletions.

### 📌 Key Design Decisions:

- When list is **empty**, initialize both `head` and `tail`.
- Handle **edge cases** like:

  - Insertion at the beginning or end.
  - Deletion of only element (update tail).

- Check for **invalid indices** in `get`, `addAtIndex`, and `deleteAtIndex`.

### 📈 Time & Space Complexity:

| Operation         | Time Complexity | Space Complexity |
| ----------------- | --------------- | ---------------- |
| `get(index)`      | O(n)            | O(1)             |
| `addAtHead(val)`  | O(1)            | O(1)             |
| `addAtTail(val)`  | O(1)            | O(1)             |
| `addAtIndex()`    | O(n)            | O(1)             |
| `deleteAtIndex()` | O(n)            | O(1)             |

### 💡 Intuition:

A linked list allows dynamic memory allocation and efficient insertions/deletions without shifting elements like arrays. Tracking both head and tail with size makes operations predictable and efficient, especially for edge conditions.

---

# Linked List Cycle Detection

**Problem Link:** [Leetcode - Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/description/)

---

## 🧠 Problem Statement

Given the head of a linked list, determine if the linked list has a cycle in it.

A linked list has a cycle if there is a node in the list that can be reached again by continuously following the `next` pointer.

---

## 🔍 Approaches

### ✅ 1. Brute Force (Using HashMap)

- **Idea:** Store all visited nodes in a `HashMap`. If we encounter a node that's already in the map, it means there's a cycle.

- **Code Snippet:**

```java
Map<ListNode, Boolean> map = new HashMap<>();
while (node != null) {
    if (map.containsKey(node)) return true;
    map.put(node, true);
    node = node.next;
}
```

- **Time Complexity:** O(n)
- **Space Complexity:** O(n)

### 🚀 2. Optimized Approach (Floyd’s Cycle Detection - Tortoise & Hare)

- **Idea:** Use two pointers:

  - `slow` moves one step at a time.
  - `fast` moves two steps at a time.
  - If there's a cycle, `fast` will eventually meet `slow` inside the cycle.

- **Code Snippet:**

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;

    if (slow == fast)
        return true;
}
return false;
```

---

## ⚠️ Why `fast != null && fast.next != null`?

We must check both:

- `fast != null` → ensures the list is not yet ended (avoids `NullPointerException`).
- `fast.next != null` → ensures we can safely do `fast.next.next`.

This is crucial for **linear lists**:

- If the list has **even number of nodes** and is linear: `fast` will reach `null`.
- If the list has **odd number of nodes** and is linear: `fast.next` will be `null`.

In both cases, this condition avoids a crash and safely concludes the list has **no cycle**.

## 🧮 Summary

| Approach      | Time Complexity | Space Complexity | Notes                      |
| ------------- | --------------- | ---------------- | -------------------------- |
| Brute Force   | O(n)            | O(n)             | Uses extra space (HashMap) |
| Floyd’s Cycle | O(n)            | O(1)             | Most efficient and clean   |

---

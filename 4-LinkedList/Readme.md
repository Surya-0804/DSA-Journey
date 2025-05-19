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

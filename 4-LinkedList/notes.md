# 🔗 Linked List Notes

## 🧠 What is a Linked List?

- A linked list is a data structure used to store data in **non-contiguous memory locations**.
- The size of a linked list is **dynamic** and can be increased or decreased at any moment.
- The **starting point** of a linked list is called the **head**.
- Data is stored in **nodes**.
- Each node contains:

  - Data
  - Reference (or pointer) to the next node

## 💾 Memory Management

- Linked lists are stored in **heap memory**.
- Each node has a pointer to the next node using the `next` reference.
- The last node's `next` points to `null`.

## 🧩 Example Nodes

```
Node m1 -> data: 3, next: m2
Node m2 -> data: 22, next: m3
Node m3 -> data: 15, next: null
head = m1
```

## 📌 When to Use a Linked List

- Implementing other data structures like **Stacks** and **Queues**
- **Browser history** (back and forth navigation)

## ☕ Java Implementation

### 🧱 Node Class

```java
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node node) {
        this.data = data;
        this.next = node;
    }
}
```

### 🔄 Convert Array to Linked List

```java
public static Node convert(int[] arr) {
    Node head = new Node(arr[0]);
    Node mover = head;

    for (int i = 1; i < arr.length; i++) {
        Node temp = new Node(arr[i]);
        mover.next = temp;
        mover = temp;
    }
    return head;
}
```

### 👣 Traversal in Linked List

```java
public static void main(String[] args) {
    int[] arr = {12, 5, 6, 8};
    Node head = convert(arr);
    Node temp = head;

    while (temp != null) {
        System.out.print(temp.data + " ");
        temp = temp.next;
    }
}
```

### 📏 Length of Linked List

```java
private static int length(Node head) {
    Node temp = head;
    int count = 0;

    while (temp != null) {
        count++;
        temp = temp.next;
    }
    return count;
}
```

### 🔍 Search in Linked List

```java
private static boolean check(Node head, int target) {
    Node temp = head;

    while (temp != null) {
        if (temp.data == target)
            return true;
        temp = temp.next;
    }
    return false;
}
```

## ⚠️ Important Tip

> Never ever tamper with the **head** of the linked list unnecessarily!

---

# 🔗 Cycle Detection in Linked List

## 📋 Problem Statement

- We need to determine if a **linked list** contains a **loop** (or cycle).
- A loop exists if there is at least one node where we can start and reach back to the same node by following the `next` pointers.
- Given the `head` of the linked list, return `true` if there is a loop, and `false` otherwise.

## 🛠️ Brute Force Approach (Using Hashing)

### Concept

- Use a `HashMap` to store nodes as we traverse the linked list.
- If we encounter a node that is already in the `HashMap`, it means we have visited it before, indicating a loop.

### Java Code

```java
boolean detectLoop(Node head) {
    Map<Node, Integer> map = new HashMap<>();
    Node temp = head;

    while (temp != null) {
        if (map.containsKey(temp)) {
            return true; // Loop detected
        }
        map.put(temp, 1);
        temp = temp.next;
    }
    return false; // No loop
}
```

### Time Complexity

- **O(n)**, where `n` is the number of nodes in the linked list.
- We traverse each node once.

### Space Complexity

- **O(n)**, as we store each node in the `HashMap`.

## 🚀 Optimized Approach (Floyd’s Tortoise and Hare)

### Concept

- Also known as the **"Tortoise and Hare"** algorithm or **"Slow and Fast Pointer"** technique.
- Use two pointers:
  - `slow`: Moves one step at a time.
  - `fast`: Moves two steps at a time.
- If `slow` and `fast` meet at some point, there is a loop.
- If `fast` or `fast.next` becomes `null`, there is no loop (linear list).

### Java Code

```java
boolean optimizeDetectLoop(Node head) {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;         // Moves 1 step
        fast = fast.next.next;    // Moves 2 steps
        if (slow == fast) {
            return true; // Loop detected
        }
    }
    return false; // No loop
}
```

### Why Check `fast != null && fast.next != null`?

- This condition handles **linear linked lists** (no loop):
  - If the list has an **even number of nodes**, `fast` will reach `null`.
  - If the list has an **odd number of nodes**, `fast.next` will reach `null`.
- This ensures we don’t get a `NullPointerException` while traversing.

### Time Complexity

- **O(n)**, where `n` is the number of nodes in the linked list.
- The pointers traverse the list, and in the worst case, they meet after a few cycles.

### Space Complexity

- **O(1)**, as we only use two pointers regardless of the list size.

## 📊 Example (From Notes)

Consider a linked list where two pointers are moving:

- `fast` moves towards `slow` by 2 steps.
- `slow` moves away from `fast` by 1 step.
- Overall, `fast` approaches `slow` by 1 step per iteration.

### Distance Between `fast` and `slow`

- Initially, distance `d = 5`.
- After 1st iteration: `d = 4`.
- After 2nd iteration: `d = 3`.
- After 3rd iteration: `d = 2`.
- After 4th iteration: `d = 1`.
- After 5th iteration: `d = 0` (they meet).

### Conclusion

- They will collide at the same point after 5 iterations in this example.
- This confirms the presence of a loop using Floyd’s algorithm.

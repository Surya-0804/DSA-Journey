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

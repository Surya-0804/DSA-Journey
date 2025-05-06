# 📘 Arrays – Notes

---

## 🔹 What is an Array?

An **array** is a **contiguous block of memory** that stores elements of the **same data type**.

```java
int arr[] = new int[n]; // Declaration and initialization in Java

```

## Key Properties

- Fixed Size: Defined at compile time for static arrays.

- Contiguous Memory: Elements are stored in adjacent memory blocks.

- Homogeneous Elements: All elements must be of the same type.

- Indexed Access: Elements can be accessed using 0-based indexing.

---

## 🧠 Memory Details

| Scope         | Max Size (approx) | Default Values   | Notes                               |
| ------------- | ----------------- | ---------------- | ----------------------------------- |
| Local (main)  | 10⁶ elements      | Garbage values   | Uses Stack memory                   |
| Global/Static | 10⁷ elements      | Zero initialized | Uses Data Segment (Heap if dynamic) |

> ⚠️ Declaring very large arrays inside `main()` may cause stack overflow.

---

## 📎 Initialization Notes

- Local array → Uninitialized → Garbage values

- Global/static array → Automatically zero-initialized

---

## 🔍 Summary

- Arrays are best used when:

  - You know the size beforehand

  - You need fast indexed access

- Avoid defining huge arrays inside functions — prefer `global/static` or use `vector/ArrayList` for dynamic sizing.

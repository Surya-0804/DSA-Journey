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

## 🧠 Memory Details (Java-specific)

| Scope          | Max Size (approx)    | Default Values                      | Notes                                                     |
| -------------- | -------------------- | ----------------------------------- | --------------------------------------------------------- |
| Local Variable | Depends on heap size | Always initialized (e.g., 0, null)  | Array reference is on stack, but actual array is on heap  |
| Class Field    | No practical limit   | Always initialized (default values) | Arrays as fields follow object field initialization rules |
| Static Field   | No practical limit   | Always initialized (default values) | Stored in the method area (part of JVM memory model)      |

> ✅ Java arrays are **never uninitialized** – all elements have default values based on their type.

---

## 📎 Initialization Notes (Java)

- `new int[5]` creates an array with 5 elements initialized to `0`.
- Other types:

  - `boolean[]` → `false`
  - `char[]` → `'\u0000'`
  - `double[]` → `0.0`
  - `Object[]` → `null`

```java
int[] a = new int[3];   // [0, 0, 0]
boolean[] b = new boolean[2]; // [false, false]
String[] s = new String[2];   // [null, null]
```

---

## 🧠 Common Mistakes to Avoid in Java

- Assuming arrays have garbage values like in C/C++ (they don’t)
- Confusing array reference (`int[] arr`) with the actual array object
- Forgetting that arrays are fixed-size — use `ArrayList` for dynamic sizing

---

## 🔍 Summary

- Arrays are best used when:

  - You know the size beforehand

  - You need fast indexed access

- Avoid defining huge arrays inside functions — prefer `global/static` or use `vector/ArrayList` for dynamic sizing.

# ⏱️ Time Complexity

> **Time Complexity ≠ Time Taken**

Time Complexity does **not** measure the actual time taken by the algorithm. Instead, it expresses **how the time taken grows** relative to the **input size (n)**.

---

## 📌 Real-World Analogy

- **Old Windows Laptop**: Takes 2 seconds for input size `n`
- **New MacBook**: Takes 1 second for the same input

Even though the **actual time** differs, the **rate of increase** as the input grows is the same.  
This _rate of growth_ is what **Time Complexity** captures — it’s like the **slope (angle)** of a time-vs-input-size graph.

---

## 📖 Definition

Time Complexity is the rate at which the **execution time** of an algorithm **grows** as the **input size increases**.

Mathematically, it describes the upper bound or growth rate in **Big-O notation**.

---

## 💡 Common Complexities

| Complexity | Example                 | Description                |
| ---------- | ----------------------- | -------------------------- |
| O(1)       | Accessing array element | Constant time              |
| O(log n)   | Binary Search           | Halves input each step     |
| O(n)       | Linear search           | Proportional to input size |
| O(n log n) | Merge Sort              | Log-linear                 |
| O(n²)      | Bubble Sort             | Quadratic                  |

---

## 📊 Graph Analogy

Imagine plotting input size `n` on the X-axis and time on the Y-axis:

- A **steeper slope** means higher time complexity
- A **flatter slope** means better performance

So even if your Mac runs faster, the _shape of the line_ (complexity) remains the same.

---

## 📏 Rules to Calculate Time Complexity

- ✅ Always consider the **worst-case** scenario (unless specified)
- 🚫 Ignore **constants** (e.g., O(2n) → O(n))
- 🔻 Discard **lower-order terms** (e.g., O(n² + n) → O(n²))

These help us focus only on how an algorithm **scales**.

---

✅ Tip: Always aim for the flattest slope (lowest growth rate) possible!

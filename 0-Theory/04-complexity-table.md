# 📊 Complexity Table

This section provides a **quick reference** table for **Time** and **Space Complexities** of commonly used algorithms and operations. Use it during practice and revision to compare and evaluate algorithm efficiency.

---

## 🔢 Common Asymptotic Runtimes

| Complexity | Name        | Examples / Comments                                    |
| ---------- | ----------- | ------------------------------------------------------ |
| Θ(1)       | Constant    | Hash table lookup, variable assignment                 |
| Θ(log n)   | Logarithmic | Binary search. Log base is unimportant                 |
| Θ(n)       | Linear      | Iterating over a list                                  |
| Θ(n log n) | Loglinear   | Optimal comparison-based sorting (e.g., Merge Sort)    |
| Θ(n²)      | Quadratic   | Comparing all pairs (e.g., Bubble Sort)                |
| Θ(n³)      | Cubic       | Triple nested loops (e.g., Floyd-Warshall)             |
| O(n^k)     | Polynomial  | k nested loops (general polynomial time)               |
| Ω(kⁿ)      | Exponential | Generating subsets (k = 2), brute-force solutions      |
| Θ(n!)      | Factorial   | Generating all permutations (e.g., traveling salesman) |

---

## 🕒 Time Complexities

| Algorithm / Operation       | Best Case  | Average Case | Worst Case |
| --------------------------- | ---------- | ------------ | ---------- |
| Binary Search               | O(1)       | O(log n)     | O(log n)   |
| Linear Search               | O(1)       | O(n)         | O(n)       |
| Bubble Sort                 | O(n)       | O(n²)        | O(n²)      |
| Insertion Sort              | O(n)       | O(n²)        | O(n²)      |
| Merge Sort                  | O(n log n) | O(n log n)   | O(n log n) |
| Quick Sort                  | O(n log n) | O(n log n)   | O(n²)      |
| Heap Sort                   | O(n log n) | O(n log n)   | O(n log n) |
| Selection Sort              | O(n²)      | O(n²)        | O(n²)      |
| Binary Heap (insert/delete) | O(log n)   | O(log n)     | O(log n)   |
| Hash Table (search/insert)  | O(1)       | O(1)         | O(n)       |

---

## 🧠 Space Complexities

| Algorithm / Operation | Space Complexity |
| --------------------- | ---------------- |
| Bubble Sort           | O(1)             |
| Insertion Sort        | O(1)             |
| Merge Sort            | O(n)             |
| Quick Sort (in-place) | O(log n)         |
| Heap Sort             | O(1)             |
| Binary Search         | O(1)             |
| Hash Table            | O(n)             |

---

## 📌 Use This Table To:

- 🧠 Compare sorting/searching algorithms at a glance
- 📈 Understand algorithm trade-offs
- 🔁 Quickly revise during coding rounds or contests

---

> ✅ **Pro Tip:** Knowing complexities is great — but **explaining and optimizing them in your own code** is what makes you stand out!

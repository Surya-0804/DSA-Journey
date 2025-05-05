# Big O Notation

Big O Notation is a mathematical concept used in computer science to describe the performance or complexity of an algorithm. It provides an upper bound on the time or space required by an algorithm as the input size grows.

## Why Big O Notation?

Big O helps us understand:

- **Time Complexity**: How the runtime of an algorithm scales with input size.
- **Space Complexity**: How the memory usage of an algorithm scales with input size.

---

## Examples of O(n²) and O(n² / 2)

### Example 1: O(n²) - Nested Loops

```java
public void exampleOn2(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            System.out.println("Processing pair (" + i + ", " + j + ")");
        }
    }
}
```

- **Explanation**:
  - The outer loop runs `n` times.
  - The inner loop also runs `n` times for each iteration of the outer loop.
  - Total iterations = `n * n = n²`.

---

### Example 2: O(n² / 2) - Half the Nested Loops

```java
public void exampleOn2Div2(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            System.out.println("Processing pair (" + i + ", " + j + ")");
        }
    }
}
```

- **Explanation**:
  - The outer loop runs `n` times.
  - The inner loop runs fewer times as `j` starts from `i + 1`.
  - Total iterations ≈ `n² / 2`.
  - The constant factor `1/2` is ignored in Big O, so this is still O(n²).

---

## Key Takeaways

- Both examples demonstrate quadratic growth.
- Big O focuses on the dominant term and ignores constants or lower-order terms.
- Understanding Big O helps in optimizing algorithms for better performance.

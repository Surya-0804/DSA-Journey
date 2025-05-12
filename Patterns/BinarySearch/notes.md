# 🟦 Binary Search

Binary Search is a **searching algorithm** used on **sorted arrays**. It works by repeatedly dividing the search space in half until the target element is found or the search space is exhausted.

---

## 💡 Real-Life Example

Think of a **dictionary**:

- Suppose you are searching for the word **"Surya"**.
- A **Linear Search** would mean flipping every page one by one from the beginning.
- A **Binary Search** would mean opening the **middle page**:
  - If the middle page contains words starting with **P**, and since **S > P**, you discard the first half and search in the second half.
  - This process continues until you find the word or exhaust the search space.

🔁 This is how binary search works: **Divide & Conquer**.

---

## 🔁 Iterative Code (Java-style)

```java
int binarySearch(int[] arr, int target) {
    int low = 0, high = arr.length - 1;

    while (low <= high) {
        int mid = low + (high - low) / 2; // safe from overflow

        if (arr[mid] == target)
            return mid;
        else if (arr[mid] < target)
            low = mid + 1;
        else
            high = mid - 1;
    }

    return -1; // Not found
}
```

## 🔁 Recursive Code (Java-style)

```java
int binarySearchRecursive(int[] arr, int low, int high, int target) {
    if (low > high)
        return -1;

    int mid = low + (high - low) / 2;

    if (arr[mid] == target)
        return mid;
    else if (arr[mid] > target)
        return binarySearchRecursive(arr, low, mid - 1, target);
    else
        return binarySearchRecursive(arr, mid + 1, high, target);
}
```

## 🕒 Time and Space Complexity

| Type      | Time Complexity | Space Complexity  |
| --------- | --------------- | ----------------- |
| Iterative | O(log₂ n)       | O(1)              |
| Recursive | O(log₂ n)       | O(log₂ n) (stack) |

---

## ⚠️ Binary Search Overflow Prevention

### Problem

When performing Binary Search on large arrays or when `low` and `high` are close to `Integer.MAX_VALUE`, calculating the middle index as:

```java
int mid = (low + high) / 2;
```

can result in integer overflow, because the sum of `low + high` might exceed the range of a 32-bit signed integer.

### Why This Happens

Java's `int` has a maximum value of (2^{31} - 1) (\~2.1 billion). For example:

- If `low = 2_000_000_000` and `high = 2_000_000_000`, then:

  ```java
  int mid = (low + high) / 2; // Overflow!
  ```

### Solutions to Prevent Overflow

#### 1. Change the Formula (Most Recommended)

Use a safe formula that avoids directly adding `low + high`:

```java
int mid = low + (high - low) / 2;
```

**Explanation:**

- `high - low` is guaranteed not to overflow.
- Dividing by 2 and adding to `low` keeps the result within safe bounds.

#### 2. Use `long` Data Type (Less Common)

For extremely large search spaces (e.g., in problems involving `long[]`), use `long` instead of `int`:

```java
long mid = (low + high) / 2;
```

**Note:** This only works if `low`, `high`, and array indices are also `long`.

### Summary

| Method | Safe from Overflow? | Recommended For |
| --- | --- | --- |
| `(low + high) / 2` | ❌ No | Never use in large arrays |
| `low + (high - low) / 2` | ✅ Yes | ✅ Standard Binary Search |
| Using `long` | ✅ Yes | When working with `long`-based arrays |

### Best Practice

Always use `low + (high - low) / 2` for standard Binary Search to prevent overflow in large search spaces.
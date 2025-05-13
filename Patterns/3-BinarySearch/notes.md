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

| Method                   | Safe from Overflow? | Recommended For                       |
| ------------------------ | ------------------- | ------------------------------------- |
| `(low + high) / 2`       | ❌ No               | Never use in large arrays             |
| `low + (high - low) / 2` | ✅ Yes              | ✅ Standard Binary Search             |
| Using `long`             | ✅ Yes              | When working with `long`-based arrays |

### Best Practice

Always use `low + (high - low) / 2` for standard Binary Search to prevent overflow in large search spaces.

---

---

---

# Variants of Binary Search

Binary Search is a powerful algorithm for searching in **sorted arrays**, with a time complexity of O(log₂ n). While the basic version assumes unique elements, variants handle cases like **duplicate elements**, finding **insertion points**, or identifying **floor/ceil** values. Below are key variants, including Lower Bound, Upper Bound, Search Insert Position, and Floor/Ceil, with examples and implementations.

---

## 1. Lower Bound

### Definition

The **smallest index** `i` such that `arr[i] >= x`. If no such element exists, return `n` (array length).

### Purpose

Finds the **first occurrence** of `x` or the position where `x` would be inserted in a sorted array.

### Example

- Array: `[3, 5, 8, 15, 19]`, `n = 5`
- `x = 8` → Lower bound = `2` (since `arr[2] = 8`)
- `x = 9` → Lower bound = `3` (since `arr[3] = 15 >= 9`)

### Code (Java-style / Pseudocode)

```java
int lowerBound(int[] arr, int target, int n) {
    int low = 0, high = n - 1, answer = n;
    while (low <= high) {
        int mid = low + (high - low) / 2; // Overflow-safe
        if (arr[mid] >= target) {
            answer = mid; // Potential answer, check left
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return answer;
}
```

### Complexity

- Time Complexity: O(log₂ n)
- Space Complexity: O(1)

---

## 2. Upper Bound

### Definition

The **smallest index** `i` such that `arr[i] > x`. If no such element exists, return `n`.

### Purpose

Finds the index just after the **last occurrence** of `x` or where x would be inserted if larger than all elements.

### Example

- Array: `[2, 3, 6, 7, 8, 8, 11, 11, 11, 12]`, `n = 10`
- `x = 6` → Upper bound = `3` (since `arr[3] = 7 > 6`)
- `x = 11` → Upper bound = `9` (since `arr[9] = 12 > 11`)
- `x = 12` → Upper bound = `10` (no element `> 12`)

### Code (Java-style / Pseudocode)

```java
int upperBound(int[] arr, int target, int n) {
    int low = 0, high = n - 1, answer = n;
    while (low <= high) {
        int mid = low + (high - low) / 2; // Overflow-safe
        if (arr[mid] > target) {
            answer = mid; // Potential answer, check left
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return answer;
}
```

### Complexity

- Time Complexity: O(log₂ n)
- Space Complexity: O(1)

---

## 3. Search Insert Position

### Definition

Given a sorted array of **distinct values**, find the index of `x` if it exists, or the index where `x` should be inserted to maintain sorted order.

### Purpose

Equivalent to **Lower Bound**, returning the smallest index where `arr[i] >= x`.

### Example

- Array: `[3, 5, 8, 15, 19]`, `n = 5`
- `x = 8` → Return `2` (found at index `2`)
- `x = 9` → Return `3` (insert at index `3`)

### Code (Java)

```java
int searchInsert(int[] arr, int target, int n) {
    return lowerBound(arr, target, n); // Same as Lower Bound
}
```

### Complexity

- **Time Complexity**: O(log₂ n)
- **Space Complexity**: O(1)

---

## 4. Floor and Ceil in Sorted Array

### Definitions

- **Floor**: The **largest number** in the array `<= x`. If none exists, return `-1`.
- **Ceil**: The **smallest number** in the array `>= x`. If none exists, return `-1`.

### Purpose

Finds the closest numbers surrounding `x` in a sorted array.

### Example

- Array: `[10, 20, 30, 40, 50]`, `n = 5`
- `x = 25` → Floor = `20`, Ceil = `30`

### Code (Java)

```java
int floor(int[] arr, int x) {
    int low = 0, high = arr.length - 1;
    int ans = -1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (arr[mid] <= x) {
            ans = arr[mid];
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }

    return ans;
}

```

### Complexity

- **Time Complexity**: O(log₂ n)
- **Space Complexity**: O(1)

---

## Summary Table

| Variant           | Purpose                             | Time Complexity | Space Complexity | Return When Not Found   |
| ----------------- | ----------------------------------- | --------------- | ---------------- | ----------------------- |
| **Lower Bound**   | Smallest index where `arr[i] >= x`  | O(log₂ n)       | O(1)             | Insert position         |
| **Upper Bound**   | Smallest index where `arr[i] > x`   | O(log₂ n)       | O(1)             | Insert after target     |
| **Search Insert** | Index of `x` or where to insert `x` | O(log₂ n)       | O(1)             | Insertion index         |
| **Floor**         | Largest number `<= x`               | O(log₂ n)       | O(1)             | -1 (if no floor exists) |
| **Ceil**          | Smallest number `>= x`              | O(log₂ n)       | O(1)             | -1 (if no ceil exists)  |

---

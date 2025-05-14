# Merge Sort

Merge Sort is a highly efficient sorting algorithm based on the **Divide and Conquer** principle. It is stable, predictable, and well-suited for large datasets.

---

## 📌 Key Idea

- **Divide**: Recursively split the array into two halves until each subarray contains a single element.
- **Conquer**: Merge the sorted subarrays to produce a fully sorted array.

---

## 📉 Example Division & Merge

Given the input array: `[2, 1, 4, 5, 1, 6]`

### Division

1. Split into halves: `[2, 1, 4]` and `[5, 1, 6]`
2. Further divide: `[2], [1, 4]` and `[5], [1, 6]`
3. Final division: `[2], [1], [4]` and `[5], [1], [6]`

### Merge

1. Merge `[1], [2]` → `[1, 2]` and `[4]` → `[1, 2, 4]`
2. Merge `[1], [5]` → `[1, 5]` and `[6]` → `[1, 5, 6]`
3. Final merge: `[1, 2, 4]` and `[1, 5, 6]` → `[1, 1, 2, 4, 5, 6]`

> **Note**: The array can be split in various ways (e.g., 3/3 or 4/2), but the structure must remain consistent throughout the process.

---

## 🧠 Pseudocode

### MergeSort Function

```java
void mergeSort(int[] arr, int low, int high) {
    if (low >= high) {
        return;
    }

    int mid = (low + high) / 2;
    mergeSort(arr, low, mid);
    mergeSort(arr, mid + 1, high);
    merge(arr, low, mid, high);
}
```

### Merge Function

```java
void merge(int[] arr, int low, int mid, int high) {
    int[] temp = new int[high - low + 1];
    int left = low;
    int right = mid + 1;
    int tempIndex = 0;

    while (left <= mid && right <= high) {
        if (arr[left] <= arr[right]) {
            temp[tempIndex] = arr[left];
            left++;
        } else {
            temp[tempIndex] = arr[right];
            right++;
        }
        tempIndex++;
    }

    while (left <= mid) {
        temp[tempIndex] = arr[left];
        left++;
        tempIndex++;
    }

    while (right <= high) {
        temp[tempIndex] = arr[right];
        right++;
        tempIndex++;
    }

    for (int i = low; i <= high; i++) {
        arr[i] = temp[i - low];
    }
}
```

---

## 📊 Time and Space Complexity

| Operation | Complexity |
| --------- | ---------- |
| **Time**  | O(n log n) |
| **Space** | O(n)       |

- **Time Complexity**: O(n log n) due to:
  - `log n` divisions from recursive splitting.
  - `n` comparisons during the merge process.
- **Space Complexity**: O(n) for the temporary array used during merging.

---

## ✅ Summary

Merge Sort is:

- **Stable**: Maintains the relative order of equal elements.
- **Efficient**: Ideal for large datasets and linked lists.
- **Not In-Place**: Requires additional O(n) space for merging (unlike QuickSort).

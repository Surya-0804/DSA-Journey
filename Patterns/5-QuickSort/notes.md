# Quick Sort Algorithm

## 📖 Definition

**Quick Sort** is a highly efficient, comparison-based sorting algorithm that uses the **Divide and Conquer** strategy. It selects a pivot element and partitions the array into two sub-arrays:

- One with elements **less than or equal** to the pivot.

- One with elements **greater** than the pivot.

The pivot is then placed in its correct position, and the same process is recursively applied to the sub-arrays.

## ⚙️ Rules

1. **Pick a Pivot**: Choose an element as the pivot. The pivot can be:
   - First element in the array.
   - Last element in the array.
   - Random element in the array.
   - Median of the array.
2. **Partitioning**: Rearrange the array so that:
   - Elements smaller than the pivot are placed to its left.
   - Elements larger than the pivot are placed to its right.
   - The pivot is placed in its correct position in the sorted array.
3. **Recurse**: Apply the same process recursively to the sub-arrays on the left and right of the pivot.

## Example with Array

Consider the array: `[5, 10, 3, 12, 8, 6, 9]`

### Step-by-Step Process

1. **Choose Pivot**: Let’s select the first element, `5`, as the pivot.
2. **Partitioning**:
   - Initialize two pointers: `i = low` (start of array) and `j = high` (end of array).
   - Move `i` forward until an element greater than the pivot is found.
   - Move `j` backward until an element less than or equal to the pivot is found.
   - Swap elements at `i` and `j` if `i < j`.
   - Continue until `i` and `j` cross.
   - Finally, swap the pivot with the element at `j`.
   - Example:
     - Initial: `[5, 10, 3, 12, 8, 6, 9]`, pivot = `5`
     - After partitioning: `[3, 5, 10, 12, 8, 6, 9]` (pivot `5` in correct position, elements `< 5` on left, `> 5` on right)
3. **Recurse**:
   - Left sub-array: `[3]` (already sorted)
   - Right sub-array: `[10, 12, 8, 6, 9]`
     - Choose pivot (e.g., `10`).
     - Partition: `[6, 9, 8, 10, 12]` (pivot `10` in correct position)
     - Recurse on `[6, 9, 8]` and `[12]`.
     - Continue until all sub-arrays are sorted.
4. **Final Sorted Array**: `[3, 5, 6, 8, 9, 10, 12]`

## 💻 Java-Style Pseudocode

```java
// QuickSort Function
void quickSort(int[] arr, int low, int high) {
    if (low < high) {
        int partitionIndex = partition(arr, low, high);
        quickSort(arr, low, partitionIndex - 1);   // Sort left part
        quickSort(arr, partitionIndex + 1, high);  // Sort right part
    }
}

// Partition Function
int partition(int[] arr, int low, int high) {
    int pivot = arr[low]; // Choose the first element as pivot
    int i = low;
    int j = high;

    while (i < j) {
        // Move i to the right until an element greater than pivot is found
        while (i <= high && arr[i] <= pivot) {
            i++;
        }

        // Move j to the left until an element less than or equal to pivot is found
        while (j >= low && arr[j] > pivot) {
            j--;
        }

        // Swap if i and j have not crossed
        if (i < j) {
            swap(arr, i, j);
        }
    }

    // Place pivot in its correct position
    swap(arr, low, j);
    return j; // Return the final position of the pivot
}

// Swap Function
void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

```

## ⏱️ Time Complexity

| Case         | Time Complexity |
| ------------ | --------------- |
| Best Case    | O(n log n)      |
| Average Case | O(n log n)      |
| Worst Case   | O(n²)           |

> Worst case occurs when the pivot always divides the array into highly unbalanced parts (e.g., already sorted or reverse-sorted).

## 📦 Space Complexity

| Case       | Space Used                    |
| ---------- | ----------------------------- |
| Average    | O(log n)                      |
| Worst Case | O(n) (due to recursion stack) |

> Quick Sort is an in-place sorting algorithm (no extra arrays used), but uses stack space due to recursion.

# 📊 Counting Sort Algorithm

## 📖 Definition

**Counting Sort** is a non-comparison-based sorting algorithm suitable for sorting integers within a limited range. It works by **counting the occurrences** of each unique element and using this information to place them in the correct sorted position.

---

## ✅ When to Use

- When the range of input data (i.e., max value − min value) is **not significantly larger** than the number of elements.
- Input consists of **non-negative integers** (can be adapted for negatives).
- You need a **linear time sorting** for bounded data.

---

## ⚙️ Algorithm Steps

1. **Find the maximum** value in the array to determine the size of the count array.
2. **Create a count array** and initialize all elements to 0.
3. **Count the frequency** of each element in the input array.
4. **Modify the count array** so that each element at each index stores the sum of previous counts (cumulative frequency).
5. **Build the output array** by placing elements at their correct positions using the count array.
6. **Copy the output array** back into the original array (if in-place is needed).

---

## 🔢 Example

Input: `[4, 2, 2, 8, 3, 3, 1]`

1. Max element = 8 → Create `count[0...8]`
2. Count frequencies:

   `count[1] = 1`

   `count[2] = 2`

   `count[3] = 2`

   `count[4] = 1`

   `count[8] = 1`

3. Cumulative count:

   `count[1] = 1`

   `count[2] = 3`

   `count[3] = 5`

   `count[4] = 6`

   `count[8] = 7`

4. Place elements into `output[]` using the `count[]`.
5. Final sorted output: `[1, 2, 2, 3, 3, 4, 8]`

---

## 💻 Java-style Pseudocode

```java
void countingSort(int[] arr) {
 int n = arr.length;
 int max = findMax(arr); // Find maximum value

 int[] count = new int[max + 1]; // Count array

 // Step 1: Count frequencies
 for (int i = 0; i < n; i++) {
     count[arr[i]]++;
 }

 // Step 2: Cumulative count
 for (int i = 1; i <= max; i++) {
     count[i] += count[i - 1];
 }

 // Step 3: Build output array
 int[] output = new int[n];
 for (int i = n - 1; i >= 0; i--) {
     output[count[arr[i]] - 1] = arr[i];
     count[arr[i]]--;
 }

 // Step 4: Copy sorted output to original array
 for (int i = 0; i < n; i++) {
     arr[i] = output[i];
 }
}
```

## ⏱️ Time & Space Complexity

| Complexity | Value                |
| ---------- | -------------------- |
| Time       | O(n + k)             |
| Space      | O(k) auxiliary space |

> Where n is the number of elements, and k is the range of input (max value).

## ⚠️ Limitations

- Not suitable for sorting large integers with wide ranges.

- Not an in-place algorithm (requires additional arrays).

- Only works with discrete integer data (can be adapted for negatives with offset).

## 📌 Key Properties

- Stable: Yes (if implemented carefully).

- In-place: No.

- Comparison-based: No.

- Best Use Case: Counting small integers with limited range.

# 🟢 Kadane's Algorithm - Maximum Subarray Sum

Kadane's algorithm efficiently finds the **maximum sum of a contiguous subarray** in `O(n)` time.

---

## 💡 Intuition

- The idea behind Kadane's Algorithm is to **not consider a subarray if its sum is less than 0**.
- A subarray with a negative sum will always **reduce** the overall sum of any subarray that includes it.
- So, **discard any subarray with a sum less than 0** — it cannot be part of the optimal solution.
- Keep a running sum and reset it to `0` whenever it becomes negative.

---

## 🔁 Algorithm (Java-style Pseudocode)

```java
int maxSum = Integer.MIN_VALUE;
int sum = 0;

for (int i = 0; i < nums.length; i++) {
    sum += nums[i];

    if (sum > maxSum) {
        maxSum = sum;
    }

    if (sum < 0) {
        sum = 0;
    }
}

return maxSum;
```

---

## 🕒 Time and Space Complexity

- Time Complexity: `O(n)`

- Space Complexity: `O(1)`

### 📌 Example

- Input:
  `nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]`

- Output:
  `6`

- Explanation:
  The subarray `[4, -1, 2, 1]` has the largest `sum = 6`.

---

## ✅ Summary

- Kadane’s Algorithm is optimal for this problem.

- Even if the array contains negative numbers, it returns the correct answer.

- If all numbers are negative, it returns the maximum (least negative) number.

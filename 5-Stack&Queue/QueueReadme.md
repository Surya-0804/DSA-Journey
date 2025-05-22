# Queue Problems

## Queue Implementation using Array (Circular Queue)

### 🔗 Problem Link:

[GeeksForGeeks - Queue Implementation using Array](https://www.geeksforgeeks.org/problems/implement-queue-using-array/1)

**Description:**  
A queue is a linear data structure that follows the **First In, First Out (FIFO)** principle. Elements are added (enqueued) at the rear and removed (dequeued) from the front. This implementation uses a circular array to optimize space usage.

### 🔧 Implementation Details:

- **Data Structure Used:** Fixed-size array (`int[] arr`) with a maximum capacity of 100005.
- **Key Operations:**
  - `push(int x)`: Adds an element to the rear of the queue.
  - `pop()`: Removes and returns the front element from the queue.
- **Boundary Conditions:**
  - If the queue is empty (`front == rear`), `pop` returns `-1`.
  - The circular nature is handled using modulo (`% 100005`) to wrap around the array indices.
- **Circular Queue Advantage:** Prevents wasted space by reusing the front of the array after elements are dequeued.
- **Note:** This implementation does not check for queue overflow (when `rear` catches up to `front` after wrapping). Add a check if needed: `if ((rear + 1) % 100005 == front)`.

### 🕒 Time & Space Complexity

| Operation | Time Complexity | Space Complexity |
| --------- | --------------- | ---------------- |
| Push      | O(1)            | O(1)             |
| Pop       | O(1)            | O(1)             |

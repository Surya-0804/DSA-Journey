# 🔑 Hashing Notes

Hashing is a technique used to map data of arbitrary size to fixed-size values using a **hash function**. It is widely used in data structures like **HashMap**, **HashSet**, and in algorithmic problem-solving to achieve constant time operations.

---

## 📦 Commonly Used Hash-based Data Structures

### 🔸 `HashMap<K, V>`

- Stores key-value pairs.
- **Average Time Complexity:**
  - Insert: O(1)
  - Delete: O(1)
  - Search: O(1)
- Useful when you need to **store relationships** between elements or **count frequencies**.

### 🔸 `HashSet<E>`

- Stores **unique** elements.
- Backed by a `HashMap` internally.
- Used to:
  - Check for **existence** of an element.
  - **Avoid duplicates**.
  - Detect **cycles or repetitions** (like in Happy Number).

---

## ✅ Advantages of Hashing

- Fast lookups, insertions, deletions.

- Great for frequency analysis, uniqueness checks, and associative mapping.

## ⚠️ Limitations

- Hashing does **not maintain order** (unless using LinkedHashMap or TreeMap).

- Can lead to **collisions**; resolved using chaining or open addressing.

---

## 🧠 Tips

- Always check for collisions when designing custom hash functions.

- Use prime numbers as base in custom hashing.

- When dealing with strings or characters, consider mapping with `Map<Character, Integer>` or `int[26]` for lowercase letters.

# 🧵 String - Notes

## 📌 Basic Concepts

- String is not a primitive data type in Java.

- It is a class that represents a sequence of characters.

- Characters are represented using double quotes (") in strings and single quotes (') for single characters.

```java
String name = "Surya";
String name = new String("Surya");
```

## 🧠 Memory in Java (String)

- #### 📦 Heap vs Stack:
- Stack stores reference variables.

- Heap stores actual object instances.

### 🔁 Example:

```java
String s1 = "Surya";
String s2 = "Surya";
```

- s1 and s2 both refer to the same object in String Constant Pool.

### Example addresses:

- **Stack**: s1 → 101, s2 → 101

- **Heap**: name → 103 (new String)

---

## 🧪 String Constant Pool

- When using "Surya", the object is stored in the String Constant Pool (SCP).

- If the same value exists, Java reuses it (saves memory).

- When new String("Surya") is used:

- It forces creation of a new object in the heap.

```java
String name = "Surya";         // Stored in SCP
String name = name + " Abothula";  // New object created
```

- The old value becomes eligible for Garbage Collection.

---

## 🔀 Types of Strings

1. ✅ Immutable

   - String is immutable (once created, can't be changed).

   - Operations like concatenation create new objects.

2. 🔄 Mutable

   - StringBuffer

   - StringBuilder

---

## 📏 StringBuffer

- Mutable and Thread-safe (synchronized).

- Default capacity: 16 bytes

- If "Surya" is added: total capacity becomes 16 + 5 = 21

```java
StringBuffer sb = new StringBuffer();
System.out.println(sb.capacity()); // 16
```

- #### Methods:

  - `.append()`

  - `.capacity()`

---

## 🚀 StringBuilder

- Same as StringBuffer but not synchronized.

- Faster than StringBuffer in single-threaded environments.

- Not suitable for multi-threading.

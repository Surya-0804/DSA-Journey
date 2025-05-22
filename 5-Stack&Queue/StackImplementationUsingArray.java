// Stack Implementation using the array
//time complexity: O(1)
//space complexity: O(1)
//link: https://www.geeksforgeeks.org/problems/implement-stack-using-array/1

class MyStack {
    private int[] arr;
    private int top;

    public MyStack() {
        arr = new int[1000];
        top = -1;
    }

    public void push(int x) {
        // Your Code
        if (size() == 1000)
            return;
        arr[++top] = x;
    }

    public int pop() {
        // Your Code
        if (top == -1)
            return -1;
        int elem = arr[top--];
        return elem;
    }

    public int size() {
        return top + 1;
    }

    public int top() {
        if (size() == 0)
            return -1;
        return arr[top];
    }
}

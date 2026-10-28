

import java.util.Arrays;

/** Fixed-capacity integer stack used by StackVisualizer. */
public class Stack {

    private static final int CAPACITY = 8;

    private final int[] data = new int[CAPACITY];
    private int top = -1;

    public boolean isEmpty()  { return top == -1; }
    public boolean isFull()   { return top == CAPACITY - 1; }
    public int size()         { return top + 1; }
    public int capacity()     { return CAPACITY; }

    public void push(int value) {
        if (isFull()) {
            throw new IllegalStateException("Stack overflow");
        }
        data[++top] = value;
    }

    /** Returns the removed value, or null if the stack is empty. */
    public Integer pop() {
        return isEmpty() ? null : data[top--];
    }

    /** Returns the top value without removing it, or null if empty. */
    public Integer peek() {
        return isEmpty() ? null : data[top];
    }

    public void clear() {
        top = -1;
    }

    /** Bottom-to-top copy of the current elements. */
    public int[] getElements() {
        return Arrays.copyOf(data, size());
    }

    // Console fallback used when no display is available (headless)
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println("Elements: " + Arrays.toString(s.getElements()));
        System.out.println("Peek: " + s.peek());
        System.out.println("Pop: " + s.pop());
        System.out.println("Size: " + s.size());
    }
}

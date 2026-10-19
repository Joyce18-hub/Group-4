public class Stack {

    private static final int MAX_SIZE = 10;
    private int[] items;
    private int top;

    public Stack() {
        items = new int[MAX_SIZE];
        top = -1;
    }

    // PUSH - adds a value to the top
    public boolean push(int value) {
        if (isFull()) {
            return false;
        }

        items[++top] = value;
        return true;
    }

    // POP - removes and returns the top value
    public Integer pop() {
        if (isEmpty()) {
            return null;
        }

        return items[top--];
    }

    // PEEK - returns the top value without removing it
    public Integer peek() {
        if (isEmpty()) {
            return null;
        }

        return items[top];
    }

    // Checks if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Checks if stack is full
    public boolean isFull() {
        return top == MAX_SIZE - 1;
    }

    // Returns the number of elements
    public int size() {
        return top + 1;
    }

    // Removes all elements
    public void clear() {
        top = -1;
    }

    // Returns the maximum capacity
    public int capacity() {
        return MAX_SIZE;
    }

    // Returns a copy of the current stack
    public int[] getElements() {
        int[] result = new int[size()];

        for (int i = 0; i < size(); i++) {
            result[i] = items[i];
        }

        return result;
    }

    public static void main(String[] args) {
        if (java.awt.GraphicsEnvironment.isHeadless()) {
            Stack stack = new Stack();
            stack.push(10);
            stack.push(20);
            stack.push(30);

            System.out.println("Stack (bottom to top): "
                    + java.util.Arrays.toString(stack.getElements()));
            System.out.println("Top: " + stack.peek());
            return;
        }

        javax.swing.SwingUtilities.invokeLater(() -> {
            StackVisualizer window = new StackVisualizer();
            window.setVisible(true);
        });
    }
}

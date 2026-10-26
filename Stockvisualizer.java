import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class StackVisualizer extends JFrame {

    private Stack stack;
    private JTextField inputField;
    private JPanel stackPanel;
    private JLabel statusLabel;

    public StackVisualizer() {
        stack = new Stack();

        setTitle("2D Stack Visualizer");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createGUI();
        updateStackDisplay();
    }

    private void createGUI() {
        setLayout(new BorderLayout(10, 10));

        // Title
        JLabel title = new JLabel("2D STACK VISUALIZER", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        // Stack display
        stackPanel = new JPanel();
        stackPanel.setLayout(new BoxLayout(stackPanel, BoxLayout.Y_AXIS));
        stackPanel.setBorder(BorderFactory.createTitledBorder("STACK"));
        stackPanel.setBackground(Color.WHITE);
        add(stackPanel, BorderLayout.CENTER);

        // Bottom controls
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout(5, 5));

        // Input area
        JPanel inputPanel = new JPanel();
        inputField = new JTextField(10);

        JButton pushButton = new JButton("PUSH");
        JButton popButton = new JButton("POP");
        JButton peekButton = new JButton("PEEK");
        JButton clearButton = new JButton("CLEAR");
        JButton checkButton = new JButton("CHECK");
        JButton randomButton = new JButton("RANDOM");

        inputPanel.add(new JLabel("Value:"));
        inputPanel.add(inputField);
        inputPanel.add(pushButton);
        inputPanel.add(popButton);
        inputPanel.add(peekButton);
        inputPanel.add(clearButton);
        inputPanel.add(checkButton);
        inputPanel.add(randomButton);

        bottomPanel.add(inputPanel, BorderLayout.CENTER);

        // Status message
        statusLabel = new JLabel("Status: Stack is empty.", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 14));
        bottomPanel.add(statusLabel, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        // Button actions
        pushButton.addActionListener(e -> pushAction());
        popButton.addActionListener(e -> popAction());
        peekButton.addActionListener(e -> peekAction());
        clearButton.addActionListener(e -> clearAction());
        checkButton.addActionListener(e -> checkAction());
        randomButton.addActionListener(e -> randomAction());
        inputField.addActionListener(e -> pushAction()); // Enter key pushes
    }

    // PUSH
    private void pushAction() {
        String input = inputField.getText().trim();

        if (input.isEmpty()) {
            statusLabel.setText("Status: Please enter a value.");
            return;
        }

        try {
            int value = Integer.parseInt(input);

            if (stack.isFull()) {
                statusLabel.setText("STACK OVERFLOW: Cannot push, stack is full.");
                return;
            }

            stack.push(value);
            statusLabel.setText("Status: " + value + " pushed. TOP = " + stack.peek());
            inputField.setText("");
            updateStackDisplay();

        } catch (NumberFormatException e) {
            statusLabel.setText("Status: Please enter a valid integer.");
        }
    }

    // POP
    private void popAction() {
        Integer removed = stack.pop();

        if (removed == null) {
            statusLabel.setText("STACK UNDERFLOW: Cannot pop, stack is empty.");
        } else {
            statusLabel.setText("Status: " + removed + " popped.");
        }

        updateStackDisplay();
    }

    // PEEK
    private void peekAction() {
        Integer topValue = stack.peek();

        if (topValue == null) {
            statusLabel.setText("Status: Stack is empty. Nothing to peek.");
        } else {
            statusLabel.setText("Status: TOP element is " + topValue);
        }

        updateStackDisplay();
    }

    // CLEAR
    private void clearAction() {
        stack.clear();
        statusLabel.setText("Status: Stack cleared.");
        updateStackDisplay();
    }

    // CHECK
    private void checkAction() {
        if (stack.isEmpty()) {
            statusLabel.setText("Status: Stack is EMPTY (0/" + stack.capacity() + ").");
        } else if (stack.isFull()) {
            statusLabel.setText("Status: Stack is FULL (" + stack.size() + "/" + stack.capacity() + ").");
        } else {
            statusLabel.setText("Status: Stack has " + stack.size() + "/" + stack.capacity()
                    + " elements. Not empty, not full.");
        }
    }

    // RANDOM
    private void randomAction() {
        stack.clear();

        Random random = new Random();
        int numberOfElements = random.nextInt(stack.capacity()) + 1;

        for (int i = 0; i < numberOfElements; i++) {
            stack.push(random.nextInt(100) + 1);
        }

        statusLabel.setText("Status: Random stack generated. TOP = " + stack.peek());
        updateStackDisplay();
    }

    // Updates the visual stack
    private void updateStackDisplay() {
        stackPanel.removeAll();

        if (stack.isEmpty()) {
            JLabel emptyLabel = new JLabel("STACK EMPTY");
            emptyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            emptyLabel.setFont(new Font("Arial", Font.BOLD, 18));

            stackPanel.add(Box.createVerticalGlue());
            stackPanel.add(emptyLabel);
            stackPanel.add(Box.createVerticalGlue());

        } else {
            int[] elements = stack.getElements();

            // Display from top to bottom
            for (int i = elements.length - 1; i >= 0; i--) {

                JPanel block = new JPanel();
                block.setPreferredSize(new Dimension(180, 45));
                block.setMaximumSize(new Dimension(180, 45));
                block.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

                JLabel valueLabel = new JLabel(String.valueOf(elements[i]));
                valueLabel.setFont(new Font("Arial", Font.BOLD, 18));
                block.add(valueLabel);

                if (i == elements.length - 1) {
                    JLabel topLabel = new JLabel("  <- TOP");
                    topLabel.setFont(new Font("Arial", Font.BOLD, 14));
                    block.add(topLabel);
                }

                block.setAlignmentX(Component.CENTER_ALIGNMENT);

                stackPanel.add(block);
                stackPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            }
        }

        stackPanel.revalidate();
        stackPanel.repaint();
    }

    public static void main(String[] args) {
        if (GraphicsEnvironment.isHeadless()) {
            System.out.println("No display available; the GUI cannot be shown.");
            return;
        }

        SwingUtilities.invokeLater(() -> {
            StackVisualizer window = new StackVisualizer();
            window.setVisible(true);
        });
    }
}

// Simple fixed-capacity stack used by the visualizer
class Stack {

    private static final int CAPACITY = 8;
    private final int[] data = new int[CAPACITY];
    private int size = 0;

    public int capacity()    { return CAPACITY; }
    public int size()        { return size; }
    public boolean isEmpty() { return size == 0; }
    public boolean isFull()  { return size == CAPACITY; }

    public boolean push(int value) {
        if (isFull()) return false;
        data[size++] = value;
        return true;
    }

    public Integer pop() {
        if (isEmpty()) return null;
        return data[--size];
    }

    public Integer peek() {
        if (isEmpty()) return null;
        return data[size - 1];
    }

    public void clear() {
        size = 0;
    }

    // Bottom -> top
    public int[] getElements() {
        int[] copy = new int[size];
        System.arraycopy(data, 0, copy, 0, size);
        return copy;
    }
}

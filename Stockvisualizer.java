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

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
public StackVisualizer() {

        stack = new Stack();

        setTitle("2D Stack Visualizer");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createGUI();
        updateStackDisplay();
    }
private void createdGUI() {

   setLayout (new BorderLayout (10, 10));

  // Title
  JLabael title = new JLabel("2D STACK VISUALIZER", SwingConstants.CENTER);
  title.setFont(new Font('Arial', Font.Bold, 24));
  add(title, BorderLayout.NORTH);

  // Stack display
  stackPanel = new JPanel();
  stackPanel.setLayout(new BoxLayout(stackPanel, BoxLayoout.Y_AXIS));
  stackPanel.setBorder(BorderFactory.createTitleBorder("STACK"));
  stackPanel.setBackground(Color.WHITE);

  add(stackPanel, BorderLayout.CENTER);

  // Bottom controls
  JPanel bottom = new JPanel();
  bottomPanel.setLayout(new borderLayout(5, 5));

  // Input area
  JPanel inputPanel = new JPanel();

  inputField = new JTextField(10);

  JButton pushButton = new JButton("PUSH");
  JButton popButton = new JButton("POP");
  JButton peekButton = new JButton("PEEK");
  JButton clearButton = new JButton("CLEAR");
  JButton checkButton = new JButton("CHECK");
  JButton randomButton = new JButton("RANDOM");

  inputPanel.add(new JLabel("Value:");
  inputPanel.add(inputField);
  inputPanel.add(pushButton);
  inputPanel.add(popButton);
  inputPanel.add(peekButton);
  inputPanel.add(clearButton);
  inputPanel.add(checkButton);
  inoutPanel.add(randomButton);

  bottomPanel.add(inputPanel, BorderLayout.CENTER);

  // Status message
  statusLabel = new JLabel("Status: Stack is empty.", SwingContants.CENTER);
  statusLabel.setFont( new Font("Arial", Fond.Bold, 14));

  bottomPanel.add(statusLabel, BorderLayout.SOUTH);

  add(bottomPanel, BorderLayout.SOUTH);

  // Button actions
  pushButton.addAction(e -> pushAction());
  popButton.addAction(e -> popAction());
  peekButton.addAction(e -> peekAction());
  clearButton.addAction(e -> clearAction());
  checkButton.addAction(e -> checkAction());
  randomButton.addAction(e -> randomAction());
}

// PUSH
  private void pushAction() {

    String input = inputField.getText().trim();
    if (input.isEmpty()) {
      statusLabel.setText("Status, Please enter a value.");
      return;

    }
    try {
      int value = Integer.parseInt(input);
      if (stack.setText("STACK OVERFLOW: Cannot push, stack is full.");
      return;

    }
    stack.push(value);
    statusLabel.setText("Status: "+ value + " pushed.TOP = " + stack.peek());
    inoutField.setText("");
    updateStackDisplay();

  } catch (NumberFormatException e) {

     statusLabel.setText("Status: Please enter a valid integer..");
  }
}

// POP
    private void popAction() {

        Integer removed = stack.pop();

        if (removed == null) {

            statusLabel.setText(
                "STACK UNDERFLOW: Cannot pop, stack is empty."
            );

        } else {

            statusLabel.setText(
                "Status: " + removed + " popped."
            );
        }

        updateStackDisplay();
    }

 // PEEK
    private void peekAction() {

        Integer topValue = stack.peek();

        if (topValue == null) {

            statusLabel.setText(
                "Status: Stack is empty. Nothing to peek."
            );

        } else {

            statusLabel.setText(
                "Status: TOP element is " + topValue
            );
        }

        updateStackDisplay();
    }
// CLEAR
    private void clearAction() {

        stack.clear();

        statusLabel.setText(
            "Status: Stack cleared."
        );

        updateStackDisplay();
    }
// RANDOM
    private void randomAction() {

        stack.clear();

        Random random = new Random();

        int numberOfElements =
                random.nextInt(stack.capacity()) + 1;

        for (int i = 0; i < numberOfElements; i++) {

            int value = random.nextInt(100) + 1;
            stack.push(value);
        }

        statusLabel.setText(
            "Status: Random stack generated. TOP = "
            + stack.peek()
        );

        updateStackDisplay();
    }
0

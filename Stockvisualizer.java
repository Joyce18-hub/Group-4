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

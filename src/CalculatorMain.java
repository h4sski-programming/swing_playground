import javax.swing.*;

public class CalculatorMain extends JPanel {
    public CalculatorMain() {
        // Setup view of this JPanel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Create and add input class
        CalculatorInput calcInput = new CalculatorInput();
        this.add(calcInput);

        // Create and add 'Calculate' JPanel with JButton
        JPanel calculatePanel = new JPanel();
        calculatePanel.setLayout(new BoxLayout(calculatePanel, BoxLayout.X_AXIS));

        JButton calculateBtn = new JButton("Calculate");
        calculatePanel.add(calculateBtn);
        this.add(calculatePanel);

        // Create and add output class
        CalculatorOutput calcOutput = new CalculatorOutput();
        this.add(calcOutput);
    }
}

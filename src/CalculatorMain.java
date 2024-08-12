import javax.swing.*;

public class CalculatorMain extends JPanel {
    public CalculatorMain() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        CalculatorInput calcInput = new CalculatorInput();
        this.add(calcInput);
    }
}

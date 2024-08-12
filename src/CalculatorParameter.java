import javax.swing.*;
import java.awt.*;

public class CalculatorParameter extends JPanel {
    public CalculatorParameter(String name) {
        this.setLayout(new FlowLayout());
//        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        JLabel label = new JLabel(name);
        this.add(label);
        this.add(new JLabel("value"));
    }
}

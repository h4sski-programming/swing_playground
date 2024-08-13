import javax.swing.*;

public class LeftJLabel extends JLabel {
    public LeftJLabel(String text) {
        super(text);
        this.setOpaque(true);
        this.setHorizontalAlignment(SwingConstants.RIGHT);
    }
}
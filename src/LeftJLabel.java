import javax.swing.*;

public class LeftJLabel extends JLabel {
    public LeftJLabel(String text) {
        super(text, JLabel.RIGHT);
        setOpaque(true);
//        this.setHorizontalAlignment(SwingConstants.RIGHT);
    }
}
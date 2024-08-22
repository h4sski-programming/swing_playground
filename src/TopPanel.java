import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {

    public TopPanel() {
//        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.X_AXIS);
//        setLayout(boxLayout);
        GridLayout gridLayout = new GridLayout(1, 3);
        setLayout(gridLayout);

        Dimension maxDimension = new Dimension(5000, 8);
        setSize(maxDimension);
        setMaximumSize(maxDimension);
        int[] marginTLBR = {3, 0, 3, 0};
        setBorder(BorderFactory.createEmptyBorder(marginTLBR[0], marginTLBR[1], marginTLBR[2], marginTLBR[3]));

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Settings.greenColor);
        greenPanel.setMaximumSize(maxDimension);
        add(greenPanel);

        JPanel blueLabel = new JPanel();
        blueLabel.setBackground(Settings.blueColor);
        blueLabel.setMaximumSize(maxDimension);
        add(blueLabel);

        JPanel grayLabel = new JPanel();
        grayLabel.setBackground(Settings.grayColor);
        grayLabel.setMaximumSize(maxDimension);
        add(grayLabel);
    }

}

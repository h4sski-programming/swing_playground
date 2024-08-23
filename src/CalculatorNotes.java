import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CalculatorNotes extends JPanel {
    public CalculatorNotes() {
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxLayout);
        setMinimumSize(new Dimension(500, 20));
        setBackground(Settings.blueColor);
        setAlignmentX(CENTER_ALIGNMENT);
        int[] marginTLBR = {3, 7, 3, 7};
        setBorder(BorderFactory.createEmptyBorder(marginTLBR[0], marginTLBR[1], marginTLBR[2], marginTLBR[3]));

        add(new JLabel("Notes"));
    }


    public void updateNotes(List<String> notesList) {
        if (notesList == null) return;
        removeAll();
        add(new JLabel("Notes"));
        for (String note : notesList) {
            add(new JLabel(note));
        }
        revalidate();
        repaint();
    }
}

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class CalculatorNotes extends JPanel {
//    private Set<String> notes = new HashSet<String>();
    public CalculatorNotes() {
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setMinimumSize(new Dimension(0, 20));
        setBackground(Settings.blueColor);
        setAlignmentX(CENTER_ALIGNMENT);
        this.setLayout(boxLayout);

        add(new JLabel("Notes:"));
    }

//    public void reset() {
////        notes = new HashSet<String>();
//        this = new CalculatorNotes();
//    }

    public void addNote(String note) {
        JLabel noteLabel = new JLabel(note);
//        noteLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        noteLabel.setHorizontalTextPosition(SwingConstants.CENTER);
//        noteLabel.setMinimumSize(new Dimension(500, 0));
//        noteLabel.setSize(500, 0);
        add(noteLabel);
    }

//    public void update() {
//        for (String note : notes) {
//            add(new JLabel(note));
//        }
//    }
}

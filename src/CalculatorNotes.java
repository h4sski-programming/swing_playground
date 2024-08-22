import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class CalculatorNotes extends JPanel {
//    private Set<String> notes = new HashSet<String>();
//    List<JLabel> notesList = new ArrayList<>();
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

//    public void reset() {
////        notes = new HashSet<String>();
//        this = new CalculatorNotes();
//    }

//    public void addNote(String note) {
//        JLabel noteLabel = new JLabel(note);
//        if (notesList.size() >= 8) {
//            return;
//        }
//        notesList.add(noteLabel);
//        add(noteLabel);
//
////        noteLabel.setHorizontalAlignment(SwingConstants.CENTER);
////        noteLabel.setHorizontalTextPosition(SwingConstants.CENTER);
////        noteLabel.setMinimumSize(new Dimension(500, 0));
////        noteLabel.setSize(500, 0);
////        add(noteLabel);
//    }

    public void updateNotes(List<String> notesList) {
        if (notesList == null) return;
        removeAll();
        add(new JLabel("Notes"));
        for (String note : notesList) {
            add(new JLabel(note));
        }
    }
}

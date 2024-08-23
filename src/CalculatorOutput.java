import javax.swing.*;
import java.awt.*;
import java.util.HashMap;


public class CalculatorOutput extends JPanel {

    private final JLabel od = new JLabel("-");
    private final JLabel id = new JLabel("-");
    private final JLabel strengthCalcTemp = new JLabel("-");
    private final JLabel reducedStrengthCalcTemp = new JLabel("-");
    private final JLabel minRequiredThickness = new JLabel("-");
    private final JLabel creepStrengthTemp = new JLabel("-");
    private final JLabel reducedCreepStrengthTemp = new JLabel("-");
    private final JLabel allowanceC1 = new JLabel("-");
    private final JLabel calculatedWallThickness = new JLabel("-");
    private final LeftJLabel message = new LeftJLabel("-");
    private final JLabel messageValue = new JLabel("-");
    private final LeftJLabel noteL = new LeftJLabel("-");
    private final JLabel noteR = new JLabel("-");

    public CalculatorOutput() {
        GridLayout gridLayout = new GridLayout(0, 2, 10, 5);
        setLayout(gridLayout);

        add(new LeftJLabel("OD [mm]"));
        add(od);
        add(new LeftJLabel("ID [mm]"));
        add(id);
        add(new LeftJLabel("Proof strength at calc temp [MPa]"));
        add(strengthCalcTemp);
        add(new LeftJLabel("Reduced strength at calc temp [MPa]"));
        add(reducedStrengthCalcTemp);
        add(new LeftJLabel("Proof creep strength at calc temp [MPa]"));
        add(creepStrengthTemp);
        add(new LeftJLabel("Reduced creep strength at calc temp [MPa]"));
        add(reducedCreepStrengthTemp);
        add(new LeftJLabel("Minimum required wall thickness [mm]"));
        add(minRequiredThickness);
        add(new LeftJLabel("Allowance max(0.4, 12.5% en)[mm]"));
        add(allowanceC1);
        add(new LeftJLabel("Calculated minimal wall thickness [mm]"));
        add(calculatedWallThickness);

        add(message);
        messageValue.setOpaque(true);
        add(messageValue);

//        add(noteL);
//        add(noteR);
//        JPanel noteRpanel = new JPanel();
//        BoxLayout boxLayout = new BoxLayout(noteRpanel, BoxLayout.Y_AXIS);
//        noteRpanel.setLayout(boxLayout);
    }
    public void updateValues(HashMap<String, Object> outputValues) {
        od.setText(String.format("%.1f", (double)outputValues.get("od")));
        id.setText(String.format("%.2f", (double)outputValues.get("id")));
        strengthCalcTemp.setText(String.format("%.2f", (double)outputValues.get("strengthCalcTemp")));
        reducedStrengthCalcTemp.setText(String.format("%.2f", (double)outputValues.get("reducedStrengthCalcTemp")));
        creepStrengthTemp.setText(String.format("%.2f", (double)outputValues.get("creepStrengthTemp")));
        reducedCreepStrengthTemp.setText(String.format("%.2f", (double)outputValues.get("reducedCreepStrengthTemp")));
        minRequiredThickness.setText(String.format("%.4f", (double)outputValues.get("minRequiredThickness")));
        allowanceC1.setText(String.format("%.2f", (double)outputValues.get("allowanceC1")));
        calculatedWallThickness.setText(String.format("%.4f", (double)outputValues.get("calculatedWallThickness")));

        message.setText((String)outputValues.get("message"));
        messageValue.setText(((String)outputValues.get("messageValue")));
        if ((boolean)outputValues.get("isCorrectWall")) {
            message.setBackground(Settings.greenColor);
            messageValue.setBackground(Settings.greenColor);
        } else {
            message.setBackground(Settings.redColor);
            messageValue.setBackground(Settings.redColor);
        }

        noteL.setText((String) outputValues.get("noteL"));
        noteR.setText((String) outputValues.get("noteR"));
    }
}

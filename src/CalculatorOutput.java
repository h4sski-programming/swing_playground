import javax.swing.*;
import java.awt.*;
import java.util.HashMap;


public class CalculatorOutput extends JPanel {

    private JLabel calculatedWallThickness = new JLabel("-");
    private LeftJLabel message = new LeftJLabel("-");
    private JLabel messageValue = new JLabel("-");

    public CalculatorOutput() {
        GridLayout gridLayout = new GridLayout(0, 2);
        gridLayout.setHgap(10);
        setLayout(gridLayout);

        DataBase dataBase = new DataBase();

        // debug purpose values
        String selectedMaterial = dataBase.materials[3];
        int selectedDN = 50;
        double selectedWall = dataBase.walls[12];

        double odCalc = dataBase.od.get(selectedDN);
        double idCalc = odCalc - (2*selectedWall);

        CalculatorParameter od = new CalculatorParameter("OD [mm]", odCalc);
        CalculatorParameter id = new CalculatorParameter("ID [mm]", idCalc);
        CalculatorParameter strengthCalcTemp = new CalculatorParameter("Strength at calc temp [MPa]", dataBase.strengthAtTemp.get(selectedMaterial)[0]);
        CalculatorParameter reducedStrengthCalcTemp = new CalculatorParameter("Reduced strength at calc temp [MPa]", 126);
        CalculatorParameter minRequiredThickness = new CalculatorParameter("Minimum required wall thickness  [mm]");
        CalculatorParameter allowanceC1 = new CalculatorParameter("Allowance [mm]");
//        CalculatorParameter calculatedWallThickness = new CalculatorParameter("Calculated minimal wall thickness [mm]");
//        CalculatorParameter message = new CalculatorParameter("-");

        add(new LeftJLabel(od.getLabel()));
        add(new JLabel(od.getValueStr()));
        add(new LeftJLabel(id.getLabel()));
        add(new JLabel(String.format("%.1f", id.getValue())));
        add(new LeftJLabel(strengthCalcTemp.getLabel()));
        add(new JLabel(String.format("%d", strengthCalcTemp.getValueInt())));
        add(new LeftJLabel(reducedStrengthCalcTemp.getLabel()));
        add(new JLabel(reducedStrengthCalcTemp.getValueStr()));
        add(new LeftJLabel(minRequiredThickness.getLabel()));
        add(new JLabel(minRequiredThickness.getValueStr()));
        add(new LeftJLabel(allowanceC1.getLabel()));
        add(new JLabel(allowanceC1.getValueStr()));


        add(new LeftJLabel("Calculated minimal wall thickness [mm]"));
        add(calculatedWallThickness);

        add(message);
        messageValue.setOpaque(true);
        add(messageValue);
//        add(new JLabel(message.getValueStr()));

    }
    public void updateValues(HashMap<String, Object> outputValues) {

        String s;
        s = String.format("%.4f", (double)outputValues.get("calculatedWallThickness"));
        calculatedWallThickness.setText(s);

        message.setText((String)outputValues.get("message"));
        messageValue.setText(((String)outputValues.get("messageValue")));
        if ((boolean)outputValues.get("isCorrectWall")) {
            message.setBackground(Settings.greenColor);
            messageValue.setBackground(Settings.greenColor);
        } else {
            message.setBackground(Settings.redColor);
            messageValue.setBackground(Settings.redColor);
        }

    }
}

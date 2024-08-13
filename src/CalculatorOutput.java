import javax.swing.*;
import java.awt.*;

public class CalculatorOutput extends JPanel {
    public CalculatorOutput() {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel leftColumn = new JPanel();
        leftColumn.setLayout(new BoxLayout(leftColumn, BoxLayout.Y_AXIS));
        JPanel rightColumn = new JPanel();
        rightColumn.setLayout(new BoxLayout(rightColumn, BoxLayout.Y_AXIS));
        JPanel spacer = new JPanel();
        spacer.setMaximumSize(new Dimension(20, 10));

        DataBase dataBase = new DataBase();

        // debug purpose values
        int selected = 250;
        String selectedMaterial = dataBase.materials[3];

        CalculatorParameter od = new CalculatorParameter("OD [mm]", 50);
        CalculatorParameter id = new CalculatorParameter("ID [mm]", dataBase.dn.get(selected));
        CalculatorParameter strengthCalcTemp = new CalculatorParameter("Strength at calc temp = Rp [MPa]", dataBase.strengthAtTemp.get(selectedMaterial)[0]);
        CalculatorParameter reducedStrengthCalcTemp = new CalculatorParameter("Reduced strength at calc temp = Rp [MPa]", 126);
//        CalculatorParameter minRequiredThickness = new CalculatorParameter("Minimum required wall thickness  = e = (pc * Do) / (2* f * z + pc) [mm]");
//        CalculatorParameter allowanceC1 = new CalculatorParameter("Allowance = c1 = max(en * 12.5%, 0.4mm) [mm]");
//        CalculatorParameter calculatedWallThickness = new CalculatorParameter("Calculated minimal wall thickness = ecalc = e + c0 + c1 + c2 [mm]");
//        CalculatorParameter message = new CalculatorParameter("-");

        leftColumn.add(new JLabel(od.getLabel()));
        rightColumn.add(new JLabel(od.getValueStr()));
        leftColumn.add(new JLabel(id.getLabel()));
        rightColumn.add(new JLabel(String.format("%.1f", id.getValue())));
        leftColumn.add(new JLabel(strengthCalcTemp.getLabel()));
        rightColumn.add(new JLabel(String.format("%d", strengthCalcTemp.getValueInt())));
        leftColumn.add(new JLabel(reducedStrengthCalcTemp.getLabel()));
        rightColumn.add(new JLabel(reducedStrengthCalcTemp.getValueStr()));

        this.add(leftColumn);
        this.add(spacer);
        this.add(rightColumn);



//        this.add(od);
//        this.add(id);
//        this.add(strengthCalcTemp);
//        this.add(reducedStrengthCalcTemp);
//        this.add(minRequiredThickness);
//        this.add(allowanceC1);
//        this.add(calculatedWallThickness);
//        this.add(message);
    }
}

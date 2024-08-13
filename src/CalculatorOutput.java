import javax.swing.*;
import java.awt.*;



public class CalculatorOutput extends JPanel {
    public CalculatorOutput() {
        GridLayout gridLayout = new GridLayout(0, 2);
        gridLayout.setHgap(10);
        this.setLayout(gridLayout);
//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


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

        this.add(new LeftJLabel(od.getLabel()));
        this.add(new JLabel(od.getValueStr()));
        this.add(new LeftJLabel(id.getLabel()));
        this.add(new JLabel(String.format("%.1f", id.getValue())));
        this.add(new LeftJLabel(strengthCalcTemp.getLabel()));
        this.add(new JLabel(String.format("%d", strengthCalcTemp.getValueInt())));
        this.add(new LeftJLabel(reducedStrengthCalcTemp.getLabel()));
        this.add(new JLabel(reducedStrengthCalcTemp.getValueStr()));

//        this.add(minRequiredThickness);
//        this.add(allowanceC1);
//        this.add(calculatedWallThickness);
//        this.add(message);
    }
}

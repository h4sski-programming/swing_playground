import javax.swing.*;

public class CalculatorOutput extends JPanel {
    public CalculatorOutput() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        CalculatorParameter od = new CalculatorParameter("OD [mm]");
        CalculatorParameter id = new CalculatorParameter("ID [mm]");
        CalculatorParameter strengthCalcTemp = new CalculatorParameter("Strength at calc temp = Rp [MPa]");
        CalculatorParameter reducedStrengthCalcTemp = new CalculatorParameter("Reduced strength at calc temp = Rp [MPa]");
        CalculatorParameter minRequiredThickness = new CalculatorParameter("Minimum required wall thickness  = e = (pc * Do) / (2* f * z + pc) [mm]");
        CalculatorParameter allowanceC1 = new CalculatorParameter("Allowance = c1 = max(en * 12.5%, 0.4mm) [mm]");
        CalculatorParameter calculatedWallThickness = new CalculatorParameter("Calculated minimal wall thickness = ecalc = e + c0 + c1 + c2 [mm]");
        CalculatorParameter message = new CalculatorParameter("-");

        this.add(od);
        this.add(id);
        this.add(strengthCalcTemp);
        this.add(reducedStrengthCalcTemp);
        this.add(minRequiredThickness);
        this.add(allowanceC1);
        this.add(calculatedWallThickness);
        this.add(message);
    }
}

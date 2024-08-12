import javax.swing.*;
import java.awt.*;

public class CalculatorInput extends JPanel {

    public CalculatorInput() {
//        this.setLayout(new GridLayout(4,2));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        CalculatorParameter material = new CalculatorParameter("Material");
        CalculatorParameter dn = new CalculatorParameter("DN");
        CalculatorParameter wallThickness = new CalculatorParameter("Wall thickness");
        CalculatorParameter designTemperature = new CalculatorParameter("Design temperature");
        CalculatorParameter designPressure = new CalculatorParameter("Design pressure");
        CalculatorParameter corrosionAllowanceC0 = new CalculatorParameter("Corrosion allowance c0");
        CalculatorParameter thiningAllowanceC2 = new CalculatorParameter("Thining allowance c2");
        CalculatorParameter jointCoefficientZ = new CalculatorParameter("Joint coefficient z");

        this.add(material);
        this.add(dn);
        this.add(wallThickness);
        this.add(designTemperature);
        this.add(designPressure);
        this.add(corrosionAllowanceC0);
        this.add(thiningAllowanceC2);
        this.add(jointCoefficientZ);
    }
}

import javax.swing.*;
import java.awt.*;

public class CalculatorInput extends JPanel {

    public CalculatorInput() {
        GridLayout gridLayout = new GridLayout(0, 2);
        gridLayout.setHgap(10);
        this.setLayout(gridLayout);

        CalculatorParameter material = new CalculatorParameter("Material", "-");
        CalculatorParameter dn = new CalculatorParameter("DN", 50);
        CalculatorParameter wallThickness = new CalculatorParameter("Wall thickness", 3.2);
        CalculatorParameter designTemperature = new CalculatorParameter("Design temperature", 348);
        CalculatorParameter designPressure = new CalculatorParameter("Design pressure", 5.4);
        CalculatorParameter corrosionAllowanceC0 = new CalculatorParameter("Corrosion allowance c0", 2);
        CalculatorParameter thiningAllowanceC2 = new CalculatorParameter("Thining allowance c2", 0);
        CalculatorParameter jointCoefficientZ = new CalculatorParameter("Joint coefficient z", 1);

        this.add(new LeftJLabel(material.getLabel()));
        this.add(new JLabel(material.getValueStr()));
        this.add(new LeftJLabel(dn.getLabel()));
        this.add(new JLabel(dn.getValueStr()));
        this.add(new LeftJLabel(wallThickness.getLabel()));
        this.add(new JLabel(wallThickness.getValueStr()));
        this.add(new LeftJLabel(designTemperature.getLabel()));
        this.add(new JLabel(designTemperature.getValueStr()));
        this.add(new LeftJLabel(designPressure.getLabel()));
        this.add(new JLabel(designPressure.getValueStr()));
        this.add(new LeftJLabel(corrosionAllowanceC0.getLabel()));
        this.add(new JLabel(corrosionAllowanceC0.getValueStr()));
        this.add(new LeftJLabel(thiningAllowanceC2.getLabel()));
        this.add(new JLabel(thiningAllowanceC2.getValueStr()));
        this.add(new LeftJLabel(jointCoefficientZ.getLabel()));
        this.add(new JLabel(jointCoefficientZ.getValueStr()));
    }
}

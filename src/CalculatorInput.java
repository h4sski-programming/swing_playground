import javax.swing.*;
import java.awt.*;

public class CalculatorInput extends JPanel {

    public CalculatorInput() {
//        this.setLayout(new GridLayout(4,2));
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.X_AXIS);
        this.setLayout(boxLayout);
//        this.setAlignmentX(RIGHT_ALIGNMENT);

        JPanel leftColumn = new JPanel();
        leftColumn.setLayout(new BoxLayout(leftColumn, BoxLayout.Y_AXIS));
        leftColumn.setAlignmentX(RIGHT_ALIGNMENT);
        JPanel rightColumn = new JPanel();
        rightColumn.setLayout(new BoxLayout(rightColumn, BoxLayout.Y_AXIS));
        JPanel spacer = new JPanel();
        spacer.setMaximumSize(new Dimension(20, 10));

        CalculatorParameter material = new CalculatorParameter("Material", "-");
        CalculatorParameter dn = new CalculatorParameter("DN", 50);
        CalculatorParameter wallThickness = new CalculatorParameter("Wall thickness", 3.2);
        CalculatorParameter designTemperature = new CalculatorParameter("Design temperature", 348);
        CalculatorParameter designPressure = new CalculatorParameter("Design pressure", 5.4);
        CalculatorParameter corrosionAllowanceC0 = new CalculatorParameter("Corrosion allowance c0", 2);
        CalculatorParameter thiningAllowanceC2 = new CalculatorParameter("Thining allowance c2", 0);
        CalculatorParameter jointCoefficientZ = new CalculatorParameter("Joint coefficient z", 1);

        leftColumn.add(new JLabel(material.getLabel(), SwingConstants.TRAILING));
        rightColumn.add(new JLabel(material.getValueStr()));
        leftColumn.add(new JLabel(dn.getLabel()));
        rightColumn.add(new JLabel(dn.getValueStr()));
        leftColumn.add(new JLabel(wallThickness.getLabel()));
        rightColumn.add(new JLabel(wallThickness.getValueStr()));
        leftColumn.add(new JLabel(designTemperature.getLabel()));
        rightColumn.add(new JLabel(designTemperature.getValueStr()));
        leftColumn.add(new JLabel(designPressure.getLabel()));
        rightColumn.add(new JLabel(designPressure.getValueStr()));
        leftColumn.add(new JLabel(corrosionAllowanceC0.getLabel()));
        rightColumn.add(new JLabel(corrosionAllowanceC0.getValueStr()));
        leftColumn.add(new JLabel(thiningAllowanceC2.getLabel()));
        rightColumn.add(new JLabel(thiningAllowanceC2.getValueStr()));
        leftColumn.add(new JLabel(jointCoefficientZ.getLabel()));
        rightColumn.add(new JLabel(jointCoefficientZ.getValueStr()));

        this.add(leftColumn);
        this.add(spacer);
        this.add(rightColumn);
    }
}

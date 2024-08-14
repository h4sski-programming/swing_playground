import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class CalculatorInput extends JPanel {

    protected DataBase dataBase = new DataBase();
    protected JComboBox<String> material = new JComboBox<String>(dataBase.materials);
    protected JComboBox<Integer> dn = new JComboBox<Integer>(dataBase.dn);
    protected JComboBox<Double> wall = new JComboBox<Double>(dataBase.walls);
    protected SpinnerModel spinnerModelDesignTemperatureSpinner = new SpinnerNumberModel(100, 100, 1500, 1);
    protected JSpinner designTemperatureSpinner = new JSpinner(spinnerModelDesignTemperatureSpinner);
    protected SpinnerModel spinnerModelDesignPressureSpinner = new SpinnerNumberModel(1.2, 0., 100., 0.01);
    protected JSpinner designPressureSpinner = new JSpinner(spinnerModelDesignPressureSpinner);
    protected SpinnerModel spinnerModelCorrosionAllowanceC0Spinner = new SpinnerNumberModel(2., 0., 100., 0.1);
    protected JSpinner corrosionAllowanceC0Spinner = new JSpinner(spinnerModelCorrosionAllowanceC0Spinner);
    protected SpinnerModel spinnerModelThiningAllowanceC2Spinner = new SpinnerNumberModel(0., 0., 100., 0.1);
    protected JSpinner thiningAllowanceC2Spinner = new JSpinner(spinnerModelThiningAllowanceC2Spinner);
    protected JComboBox<String> jointCoefficientZ = new JComboBox<String>(dataBase.jointCoefficient);


    public CalculatorInput() {
        GridLayout gridLayout = new GridLayout(0, 2, 10, 5);
        setLayout(gridLayout);

        add(new LeftJLabel("Material"));
        add(material);
        add(new LeftJLabel("DN"));
        add(dn);
        add(new LeftJLabel("Wall thickness [mm]"));
        add(wall);
        add(new LeftJLabel("Design temperature [°C]"));
        add(designTemperatureSpinner);
        add(new LeftJLabel("Design pressure [MPa]"));
        add(designPressureSpinner);
        add(new LeftJLabel("Corrosion allowance c0 [mm]"));
        add(corrosionAllowanceC0Spinner);
        add(new LeftJLabel("Thining allowance c2 [mm]"));
        add(thiningAllowanceC2Spinner);
        add(new LeftJLabel("Joint coefficient z [-]"));
        add(jointCoefficientZ);
    }

    public HashMap<String, Object> getValues() {
        HashMap<String, Object> values = new HashMap<String, Object>();

        values.put("material", material.getSelectedItem());
        values.put("dn", dn.getSelectedItem());
        values.put("wall", wall.getSelectedItem());
        values.put("designTemperature", designTemperatureSpinner.getValue());
        values.put("designPressure", designPressureSpinner.getValue());
        values.put("corrosionAllowanceC0", corrosionAllowanceC0Spinner.getValue());
        values.put("thiningAllowanceC2", thiningAllowanceC2Spinner.getValue());
        values.put("jointCoefficientZ", jointCoefficientZ.getSelectedItem());

        return values;
    }
}

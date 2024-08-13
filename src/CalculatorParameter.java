import javax.swing.*;
import java.awt.*;

public class CalculatorParameter extends JPanel {
    private String label;
    private double value;
    private int valueInt;
    private String valueStr;

    public CalculatorParameter(String name) {
        this.label = name;
    }

    public CalculatorParameter(String label, double value) {
        this.label = label;
        this.value = value;
        this.valueStr = String.format("%.2f", this.value);
    }

    public CalculatorParameter(String label, int value) {
        this.label = label;
        this.valueInt = value;
        this.valueStr = String.format("%d", this.valueInt);
    }

    public CalculatorParameter(String label, String valueStr) {
        this.label = label;
        this.valueStr = valueStr;
    }

    public String getLabel() {
        return this.label;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }

    public int getValueInt() {
        return this.valueInt;
    }

    public String getValueStr() {
        return this.valueStr;
    }
}

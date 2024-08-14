import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class CalculatorMain extends JPanel {

    protected DataBase dataBase = new DataBase();
    private CalculatorInput calcInput = new CalculatorInput();
    private CalculatorOutput calcOutput = new CalculatorOutput();
    private HashMap<String, Object> inputValues = new HashMap<String, Object>();
    private HashMap<String, Object> outputValues = new HashMap<String, Object>();

    public CalculatorMain() {
        // Setup view of this JPanel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Create and add input class
        add(calcInput);

        // Create and add 'Calculate' JPanel with JButton
        JPanel calculatePanel = new JPanel();
        calculatePanel.setLayout(new BoxLayout(calculatePanel, BoxLayout.X_AXIS));

        JButton calculateBtn = new JButton("Calculate");
        calculateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });

        calculatePanel.add(calculateBtn);
        add(calculatePanel);

        // Create and add output class
        add(calcOutput);
    }

    private void calculate() {
        inputValues = calcInput.getValues();

        calculateValues();

        calcOutput.updateValues(outputValues);

        // Debug purpose Sys.out
//        System.out.println(inputValues.get("material"));
//        System.out.println(inputValues.get("dn"));
//        System.out.println(inputValues.get("wall"));
//        System.out.println(inputValues.get("designTemperature"));
//        System.out.println(inputValues.get("designPressure"));
//        System.out.println(inputValues.get("corrosionAllowanceC0"));
//        System.out.println(inputValues.get("thiningAllowanceC2"));
//        System.out.println(inputValues.get("jointCoefficientZ"));
    }

    private void calculateValues() {
        double od = dataBase.od.get(inputValues.get("dn"));
        outputValues.put("od", od);

        double wall = (double) inputValues.get("wall");
        double id = od - (2 * wall);
        outputValues.put("id", id);

        double approximateStrength = approximateStrength((String) inputValues.get("material"), (int) inputValues.get("designTemperature"));
        outputValues.put("strengthCalcTemp", approximateStrength);

        double reducedStrengthCalcTemp = approximateStrength/1.5;
        outputValues.put("reducedStrengthCalcTemp", reducedStrengthCalcTemp);

        // e = (pc * Do) / (2* f * z + pc) minimum required wall thickness [mm]
        double designPressure = (double)inputValues.get("designPressure");
        double jointCoefficientZ;
        jointCoefficientZ = dataBase.jointCoefficienthm.get((String)inputValues.get("jointCoefficientZ"));
        double minRequiredThickness;
        minRequiredThickness = designPressure * od /
                (2* reducedStrengthCalcTemp * jointCoefficientZ + designPressure);
        outputValues.put("minRequiredThickness", minRequiredThickness);

        double allowanceC1;
        allowanceC1 = Math.max(0.4, wall*0.125);
        outputValues.put("allowanceC1", allowanceC1);

        double calculatedWallThickness;
        calculatedWallThickness = minRequiredThickness + (double)inputValues.get("corrosionAllowanceC0") +
                (double)inputValues.get("thiningAllowanceC2");
        outputValues.put("calculatedWallThickness", calculatedWallThickness);

        String message;
        String messageValue;
        String wallString = String.format("%.4f", wall);
        String calcWallString = String.format("%.4f", calculatedWallThickness);
        String wallRatioString = String.format("%.2f", wall/calculatedWallThickness * 100);
        messageValue = wallString + " / " + calcWallString + " = " + wallRatioString + "%";
        boolean isCorrectWall = false;
        if (wall > calculatedWallThickness) {
            message = "Selected wall thickness meets the conditions";
            isCorrectWall = true;
        } else {
            message = "Selected wall thickness do NOT meets the conditions";
            isCorrectWall = false;
        }
        outputValues.put("message", message);
        outputValues.put("messageValue", messageValue);
        outputValues.put("isCorrectWall", isCorrectWall);

        // Debug purpose Sys.out
//        System.out.println(wall);
//        System.out.println(calculatedWallThickness);
//        System.out.format("\n%.4f", outputValues.get("strengthCalcTemp"));
//        System.out.println("\n" + dataBase.strengthAtTempHM);
    }

    private double approximateStrength(String material, int calcTemp) {
        HashMap<Integer, Integer> materialStrengthAtTemp = dataBase.strengthAtTempHM.get(material);
        int lowerTemp = 0;
        int higherTemp = 1;
        for (int i=0; i<dataBase.temps.length; i++) {
            if (dataBase.temps[i] > calcTemp) {
                higherTemp = dataBase.temps[i];
                break;
            }
            lowerTemp = dataBase.temps[i];
        }
        int lowerTempStrength = materialStrengthAtTemp.get(lowerTemp);
        int higherTempStrength = materialStrengthAtTemp.get(higherTemp);

        // Check if calcTemp is out of table with values for this material
        if (higherTempStrength==0 && calcTemp!=lowerTemp) {
            return 0.;
        }

        double tempRatio = (double) (calcTemp - lowerTemp) / (higherTemp - lowerTemp);
        // debug purpose
//        double answer = lowerTempStrength - tempRatio * (lowerTempStrength-higherTempStrength);
//        System.out.println(answer);
        return lowerTempStrength - tempRatio * (lowerTempStrength-higherTempStrength);
    }
}

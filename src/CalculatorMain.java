import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class CalculatorMain extends JPanel {

    protected DataBase dataBase = new DataBase();
    private CalculatorInput calcInput = new CalculatorInput();
    private CalculatorOutput calcOutput = new CalculatorOutput();
    private CalculatorNotes calcNotes = new CalculatorNotes();
    private HashMap<String, Object> inputValues = new HashMap<String, Object>();
    private HashMap<String, Object> outputValues = new HashMap<String, Object>();

    protected List<String> notesList;

    public CalculatorMain() {
        // Setup view of this JPanel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // creating top panel, only for style
        add(new TopPanel());

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

        add(calcNotes);
        add(calcOutput);
    }

    private void calculate() {
        notesList = new ArrayList<>();

        inputValues = calcInput.getValues();
        calculateValues();
        calcNotes.updateNotes(notesList);
        calcOutput.updateValues(outputValues);

        // Debug purpose Sys.out
//        System.out.println(dataBase.strengthAtTempHM.get((String)inputValues.get("material")));
//        System.out.println(inputValues.get("jointCoefficientZ"));
    }

    private void calculateValues() {
        String material = (String) inputValues.get("material");
        Integer designTemperature = (Integer) inputValues.get("designTemperature");

        double od = dataBase.od.get(inputValues.get("dn"));
        outputValues.put("od", od);

        double wall = (double) inputValues.get("wall");
        double id = od - (2 * wall);
        outputValues.put("id", id);
        if (id<=0) {
            notesList.add("ID is less then 0, check input values!");
        }

        // Tensile calculations
        HashMap<Integer, Integer> strengthAtTempHM = dataBase.strengthAtTempHM.get(material);
        double approxStrength = approximateStrength(strengthAtTempHM, (int) inputValues.get("designTemperature"));
        outputValues.put("strengthCalcTemp", approxStrength);
        double tensileStrengthRm = dataBase.tensileStrengthRm.get(material);
        double reducedStrengthCalcTemp = Math.min(approxStrength/1.5, tensileStrengthRm/2.4);
        outputValues.put("reducedStrengthCalcTemp", reducedStrengthCalcTemp);

        // Creep calculations
        double creepStrengthTemp = getCreepStrength(material, designTemperature);
        outputValues.put("creepStrengthTemp", creepStrengthTemp);
        double reducedCreepStrengthTemp = creepStrengthTemp/1.5;
        outputValues.put("reducedCreepStrengthTemp", reducedCreepStrengthTemp);

        // Get minimum, positive value of 'f'.
        // min(reducedStrengthCalcTemp, reducedCreepStrengthTemp), but they have to be '>0' values.
        double reducedStrength= 0;
        if (reducedStrengthCalcTemp <= 0 && reducedCreepStrengthTemp <= 0) {
            notesList.add("Both tensile and creep values are not calculated. Check input values.");
        } else if (reducedStrengthCalcTemp <= 0) {
            reducedStrength = reducedCreepStrengthTemp;
        } else if (reducedCreepStrengthTemp <= 0) {
            reducedStrength = reducedStrengthCalcTemp;
        } else {
            reducedStrength = Math.min(reducedStrengthCalcTemp, reducedCreepStrengthTemp);
        }
        outputValues.put("reducedStrength", reducedStrength);

        double designPressure = (double)inputValues.get("designPressure");
        double jointCoefficientZ;
        jointCoefficientZ = dataBase.jointCoefficienthm.get((String)inputValues.get("jointCoefficientZ"));

        double minRequiredThickness;
        if (od/id <= 1.7){
            // e = (pc * Do) / (2* f * z + pc) minimum required wall thickness [mm]
//            outputValues.put("noteL", "-"); // default value
            minRequiredThickness = designPressure * od /
                    (2* reducedStrength * jointCoefficientZ + designPressure);
        } else {
            // e = Do/2 (1- sqrt((f z - pc) / (f z + pc)) minimum required wall thickness [mm]
//            outputValues.put("noteL", "Do / Di > 1.7");
            notesList.add("Thick wall, calculating with condition: Do / Di > 1.7");
            minRequiredThickness = od/2* (1 -
                    Math.sqrt( (reducedStrength * jointCoefficientZ - designPressure) /
                            (reducedStrength * jointCoefficientZ + designPressure) ));
        }
        outputValues.put("minRequiredThickness", minRequiredThickness);

        double allowanceC1;
        allowanceC1 = Math.max(0.4, wall*0.125);
        outputValues.put("allowanceC1", allowanceC1);

        double calculatedWallThickness;
        calculatedWallThickness = minRequiredThickness + (double)inputValues.get("corrosionAllowanceC0") +
                allowanceC1 + (double)inputValues.get("thiningAllowanceC2");
        outputValues.put("calculatedWallThickness", calculatedWallThickness);

        String message;
        String messageValue;
        String wallString = String.format("%.1f", wall);
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
//        System.out.println(calculatedWallThickness);
//        System.out.format("\n%.4f", outputValues.get("strengthCalcTemp"));
//        System.out.println("\n" + dataBase.strengthAtTempHM);
    }


    private double approximateStrength(HashMap<Integer, Integer> materialStrengthAtTemp, Integer calcTemp) {
        int lowerTemp = Collections.min(materialStrengthAtTemp.keySet());
        int higherTemp = Collections.max(materialStrengthAtTemp.keySet());

        for (Integer temp : materialStrengthAtTemp.keySet()) {
            if (temp >= calcTemp && temp < higherTemp) higherTemp = temp;
            if (temp < calcTemp && temp > lowerTemp) lowerTemp = temp;
        }

        if (lowerTemp == higherTemp) return materialStrengthAtTemp.get(lowerTemp);

        int lowerTempStrength = materialStrengthAtTemp.get(lowerTemp);
        int higherTempStrength = materialStrengthAtTemp.get(higherTemp);

        // Check if higherTemp have NOT positive value then return 0.
        if ( !(higherTempStrength > 0)) {
            return 0.;
        }

        double tempRatio = (double) (calcTemp - lowerTemp) / (higherTemp - lowerTemp);

        // debug purpose
//        double answer = lowerTempStrength - tempRatio * (lowerTempStrength-higherTempStrength);
//        System.out.println(lowerTemp);

        return lowerTempStrength - tempRatio * (lowerTempStrength-higherTempStrength);
    }

    private double getCreepStrength(String material, Integer designTemperature) {

        if (!dataBase.creepStrength.containsKey(material)) {
            notesList.add("Material " + material + " does not have creep values");
            return 0.;
        }

        String creepDuration = (String) inputValues.get("creepDuration");
        HashMap<Integer, Integer> creepHashMap = dataBase.creepStrength.get(material).get(creepDuration);
        Set<Integer> creepTemps = creepHashMap.keySet();
        Integer minCreepTemp = Collections.min(creepTemps);
        Integer maxCreepTemp = getMaxKeyWithPositiveValue(creepHashMap);
        if (minCreepTemp > designTemperature || designTemperature > maxCreepTemp) {
            notesList.add("Material " + material + " have creep temp range between " + minCreepTemp + " ~ " + maxCreepTemp);
            return 0.;
        }

        return approximateStrength(creepHashMap, designTemperature);
    }

    private Integer getMaxKeyWithPositiveValue (HashMap<Integer, Integer> creepHashMap) {
        Integer answer = 0;
        for (Integer temp : creepHashMap.keySet()) {
            if (temp >= answer && creepHashMap.get(temp) > 0) answer = temp;
        }
        return answer;
    }
}

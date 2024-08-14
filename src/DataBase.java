import java.util.HashMap;

public class DataBase {

    HashMap<Integer, Double> od = new HashMap<Integer, Double>();
    Integer[] dn = new Integer[]{10, 15, 20, 25, 32, 40, 50, 65, 80, 100, 125, 150, 200, 250, 300, 350, 400, 450, 500};

    Double[] walls = new Double[]{1.6, 1.8, 2.0, 2.3, 2.6, 2.9, 3.2, 3.6, 4.0, 4.5, 5.0, 5.6, 6.3, 7.1, 8.0, 8.8, 10., 11., 12.5, 14.2, 16., 17.5, 20., 22.2, 25., 28., 30., 32., 36., 40., 45., 50., 55., 60., 65., 70., 80., 90., 100.};
    String[] jointCoefficient = new String[]{
            "1.0 Seamless / destructive and non-destructive testing",
            "0.85 Random non-destructive testing",
            "0.7 NOT non-destructive testing"
    };
    HashMap<String, Double> jointCoefficienthm = new HashMap<String, Double>();
//    HashMap<String, Double> jointCoefficient = new HashMap<String, Double>();
    String[] materials = new String[] {"P195GH 1.0348", "P235GH 1.0345", "P265GH 1.0425", "20MnNb6 1.0471", "16Mo3 1.5415", "8MoB5-4 1.5450", "14MoV6-3 1.7715", "10CrMo5-5 1.7338", "13CrMo4-5 1.7335", "10CrMo5-5 1.7338",
            "10CrMo9-10 1.7380", "11CrMo9-10 1.7383", "25CrMo4 1.7218", "20CrMoV13-5-5 1.7779", "15NiCuMoNb5-6-4 1.6368", "7CrWVMoNb9-6 1.8201", "7CrMoVTiB10-10 1.7378", "X11CrMo5+I 1.7362+I",
            "X11CrMo5+NT1 1.7362+NT1", "X11CrMo5+NT2 1.7362+NT2", "X11CrMo9-1+I 1.7386+I", "X11CrMo9-1+NT 1.7386+NT", "X10CrMoVNb9-1 1.4903", "X10CrWMoVNb9-2 1.4901", "X11CrWMoVNb9-1-1 1.4905", "X20CrMoV11-1 1.4922"};

    HashMap<String, Integer[]> strengthAtTemp = new HashMap<>();
    HashMap<String, HashMap<Integer, Integer>> strengthAtTempHM = new HashMap<>();
    Integer[] temps = new Integer[]{100, 150, 200, 250, 300, 350, 400, 450, 500, 550, 600};
    HashMap<Integer, Integer> hmAtTemp = new HashMap<Integer, Integer>();


    public DataBase() {
        od.put(10, 17.1);
        od.put(15, 21.3);
        od.put(20, 26.7);
        od.put(25, 33.4);
        od.put(32, 42.2);
        od.put(40, 48.3);
        od.put(50, 60.3);
        od.put(65, 73.0);
        od.put(80, 88.9);
        od.put(100, 116.3);
        od.put(125, 141.3);
        od.put(150, 168.3);
        od.put(200, 219.1);
        od.put(250, 273.1);
        od.put(300, 323.9);
        od.put(350, 355.6);
        od.put(400, 406.4);
        od.put(450, 457.2);
        od.put(500, 508.0);

//        jointCoefficient.put("0.7 NOT non-destructive testing", 0.7);
//        jointCoefficient.put("0.85 Random non-destructive testing", 0.85);
//        jointCoefficient.put("1.0 Seamless / destructive and non-destructive testing", 1.0);

        String material;
        Integer[] listAtTemp;

        material = "P195GH 1.0348";
        listAtTemp = new Integer[]{175, 165, 150, 130, 113, 102, 94, 0, 0, 0, 0};
        combineMaterialAndStrengthAtTemp(material, listAtTemp);

        material = "P235GH 1.0345";
        listAtTemp = new Integer[]{198, 187, 170, 150, 132, 120, 112, 108, 0, 0, 0};
        combineMaterialAndStrengthAtTemp(material, listAtTemp);

        material = "P265GH 1.0425";
        listAtTemp = new Integer[]{226, 213, 192, 171, 154, 141, 134, 128, 0, 0, 0};
        combineMaterialAndStrengthAtTemp(material, listAtTemp);

        material = "20MnNb6 1.0471";
        listAtTemp = new Integer[]{312, 292, 265, 241, 219, 200, 186, 174, 0, 0, 0};
        combineMaterialAndStrengthAtTemp(material, listAtTemp);

        jointCoefficienthm.put("1.0 Seamless / destructive and non-destructive testing", 1.0);
        jointCoefficienthm.put("0.85 Random non-destructive testing", 0.85);
        jointCoefficienthm.put("0.7 NOT non-destructive testing", 0.7);
    }

    private void combineMaterialAndStrengthAtTemp(String material, Integer[] listAtTemp) {
        strengthAtTemp.put(material, listAtTemp);
        hmAtTemp = new HashMap<Integer, Integer>();
        for (int i=0; i<temps.length; i++) {
            hmAtTemp.put(temps[i], listAtTemp[i]);
        }
        strengthAtTempHM.put(material, hmAtTemp);
    }
}

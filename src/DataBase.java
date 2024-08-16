import java.util.Arrays;
import java.util.HashMap;

public class DataBase {

    HashMap<Integer, Double> od = new HashMap<Integer, Double>();
    Integer[] dn = new Integer[]{10, 15, 20, 25, 32, 40, 50, 65, 80, 100, 125, 150, 200, 250, 300, 350, 400, 450, 500};

    // Based on EN 10216-2 Table 6
    Double[] walls = new Double[]{1.6, 1.8, 2.0, 2.3, 2.6, 2.9, 3.2, 3.6, 4.0, 4.5, 5.0, 5.6, 6.3, 7.1, 8.0, 8.8, 10., 11., 12.5, 14.2, 16., 17.5, 20., 22.2, 25., 28., 30., 32., 36., 40., 45., 50., 55., 60., 65., 70., 80., 90., 100.};
    String[] jointCoefficient = new String[]{
            "1.0 Seamless / destructive and non-destructive testing",
            "0.85 Random non-destructive testing",
            "0.7 NOT non-destructive testing"
    };
    HashMap<String, Double> jointCoefficienthm = new HashMap<String, Double>();
//    HashMap<String, Double> jointCoefficient = new HashMap<String, Double>();
    String[] materials = new String[] {"P195GH 1.0348", "P235GH 1.0345", "P265GH 1.0425", "20MnNb6 1.0471", "16Mo3 1.5415", "8MoB5-4 1.5450", "14MoV6-3 1.7715", "10CrMo5-5 1.7338", "13CrMo4-5 1.7335",
            "10CrMo9-10 1.7380", "11CrMo9-10 1.7383", "25CrMo4 1.7218", "20CrMoV13-5-5 1.7779", "15NiCuMoNb5-6-4 1.6368", "7CrWVMoNb9-6 1.8201", "7CrMoVTiB10-10 1.7378", "X11CrMo5+I 1.7362+I",
            "X11CrMo5+NT1 1.7362+NT1", "X11CrMo5+NT2 1.7362+NT2", "X11CrMo9-1+I 1.7386+I", "X11CrMo9-1+NT 1.7386+NT", "X10CrMoVNb9-1 1.4903", "X10CrWMoVNb9-2 1.4901", "X11CrWMoVNb9-1-1 1.4905", "X20CrMoV11-1 1.4922"};

    // Based on EN 10216-2 Table 4
    HashMap<String, Integer> tensileStrengthRm = new HashMap<>();

    // Based on EN 10216-2 Table A.1
    // <Material, <Duration, <Temp, strength>>>
    // <String, <String, <Integer, Integer>>>
    HashMap<String, HashMap<String, HashMap<Integer, Integer>>> creepStrength = new HashMap<>();
    String[] creepDuration = new String[]{"10 000 h", "100 000 h", "200 000 h"};

//    HashMap<String, Integer[]> strengthAtTemp = new HashMap<>();
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

        jointCoefficienthm.put("1.0 Seamless / destructive and non-destructive testing", 1.0);
        jointCoefficienthm.put("0.85 Random non-destructive testing", 0.85);
        jointCoefficienthm.put("0.7 NOT non-destructive testing", 0.7);

        // Based on EN 10216-2 Table 4
        Integer[] tensileStrengthRmList = new Integer[]{320, 360, 410, 500, 450, 540, 460, 410, 440, 480,
                540, 540, 740, 610, 510, 565, 430, 480, 570, 460, 590, 630, 620, 620, 690};
        tensileStrengthRm = generateHMStrInt(materials, tensileStrengthRmList);


        // Based on EN 10216-2 Table A.1
        // <Material <Duration <Temp, strength>>>
        // <String, <String, <Integer, Integer>>>
        String material;
        Integer[] creepTemps;
        Integer[] creepStrengthList10k;
        Integer[] creepStrengthList100k;
        Integer[] creepStrengthList200k;
//        HashMap<Integer, Integer> tempStrengthHM;
//        HashMap<String, HashMap<Integer, Integer>> durationTempStrengthHM;


        // Values based on EN 10216-2 Table 5
        Integer[] listAtTemp;

        material = "P195GH 1.0348";
        listAtTemp = new Integer[]{175, 165, 150, 130, 113, 102, 94, 0, 0, 0, 0};
        strengthAtTempHM.put(material, generateHMIntInt(temps, listAtTemp));

        material = "P235GH 1.0345";
        listAtTemp = new Integer[]{198, 187, 170, 150, 132, 120, 112, 108, 0, 0, 0};
        strengthAtTempHM.put(material, generateHMIntInt(temps, listAtTemp));
        creepTemps = new Integer[]{400, 410, 420, 430, 440, 450, 460, 470, 480, 490, 500};
        creepStrengthList10k = new Integer[]{182, 166, 151, 138, 125, 112, 100, 88, 77, 67, 58};
        creepStrengthList100k = new Integer[]{141, 128, 114, 100, 88, 77, 66, 56, 47, 39, 32};
        creepStrengthList200k = new Integer[]{128, 115, 102, 89, 77, 66, 56, 46, 33, 26, 24};
        creepStrength.put(material, generateHMForCreepStrength(creepTemps, creepStrengthList10k, creepStrengthList100k, creepStrengthList200k));

        material = "P265GH 1.0425";
        listAtTemp = new Integer[]{226, 213, 192, 171, 154, 141, 134, 128, 0, 0, 0};
        strengthAtTempHM.put(material, generateHMIntInt(temps, listAtTemp));
        creepTemps = new Integer[]{400, 410, 420, 430, 440, 450, 460, 470, 480, 490, 500};
        creepStrengthList10k = new Integer[]{182, 166, 151, 138, 125, 112, 100, 88, 77, 67, 58};
        creepStrengthList100k = new Integer[]{141, 128, 114, 100, 88, 77, 66, 56, 47, 39, 32};
        creepStrengthList200k = new Integer[]{128, 115, 102, 89, 77, 66, 56, 46, 33, 26, 24};
        creepStrength.put(material, generateHMForCreepStrength(creepTemps, creepStrengthList10k, creepStrengthList100k, creepStrengthList200k));

        material = "20MnNb6 1.0471";
        listAtTemp = new Integer[]{312, 292, 265, 241, 219, 200, 186, 174, 0, 0, 0};
        strengthAtTempHM.put(material, generateHMIntInt(temps, listAtTemp));
        creepTemps = new Integer[]{400, 410, 420, 430, 440, 450, 460, 470, 480, 490, 500};
        creepStrengthList10k = new Integer[]{243, 221, 200, 180, 161, 143, 126, 110, 96, 84, 74};
        creepStrengthList100k = new Integer[]{179, 157, 136, 117, 100, 85, 73, 63, 55, 47, 41};
        creepStrengthList200k = new Integer[]{157, 135, 115, 97, 82, 70, 60, 52, 44, 37, 0};
        creepStrength.put(material, generateHMForCreepStrength(creepTemps, creepStrengthList10k, creepStrengthList100k, creepStrengthList200k));

        material = "16Mo3 1.5415";
        listAtTemp = new Integer[]{243, 237, 224, 205, 173, 159, 156, 150, 146, 0, 0};
        strengthAtTempHM.put(material, generateHMIntInt(temps, listAtTemp));
        creepTemps = new Integer[]{450, 460, 470, 480, 490, 500, 510, 520, 530, 540, 550};
        creepStrengthList10k = new Integer[]{298, 273, 247, 221, 196, 171, 148, 125, 104, 84, 64};
        creepStrengthList100k = new Integer[]{236, 205, 176, 149, 124, 102, 83, 65, 51, 40, 32};
        creepStrengthList200k = new Integer[]{218, 188, 158, 129, 105, 84, 67, 53, 42, 34, 25};
        creepStrength.put(material, generateHMForCreepStrength(creepTemps, creepStrengthList10k, creepStrengthList100k, creepStrengthList200k));

        material = "8MoB5-4 1.5450";
        listAtTemp = new Integer[]{368, 368, 368, 368, 368, 368, 368, 0, 0, 0, 0};
        strengthAtTempHM.put(material, generateHMIntInt(temps, listAtTemp));

        material = "14MoV6-3 1.7715";
        listAtTemp = new Integer[]{282, 276, 268, 241, 225, 216, 209, 203, 200, 197, 0};
        strengthAtTempHM.put(material, generateHMIntInt(temps, listAtTemp));
        creepTemps = new Integer[]{450, 460, 470, 480, 490, 500, 510, 520, 530, 540, 550, 560, 570, 580, 590, 600};
        creepStrengthList10k = new Integer[]{337, 349, 324, 298, 274, 249, 225, 203, 181, 162, 143, 126, 112, 97, 85, 74};
        creepStrengthList100k = new Integer[]{305, 276, 249, 224, 200, 177, 155, 135, 117, 102, 87, 75, 65, 58, 48, 41};
        creepStrengthList200k = new Integer[]{282, 255, 226, 202, 179, 158, 136, 117, 101, 86, 74, 63, 54, 47, 40, 34};
        creepStrength.put(material, generateHMForCreepStrength(creepTemps, creepStrengthList10k, creepStrengthList100k, creepStrengthList200k));

        material = "10CrMo5-5 1.7338";
        listAtTemp = new Integer[]{240, 228, 219, 208, 165, 156, 148, 144, 143, 0, 0};
        strengthAtTempHM.put(material, generateHMIntInt(temps, listAtTemp));
        creepTemps = new Integer[]{450, 460, 470, 480, 490, 500, 510, 520, 530, 540, 550, 560, 570, 580, 590, 600};
        creepStrengthList10k = new Integer[]{377, 347, 319, 292, 264, 238, 209, 181, 155, 131, 109, 90, 74, 60, 50, 41};
        creepStrengthList100k = new Integer[]{290, 58, 227, 198, 170, 145, 121, 100, 80, 65, 53, 44, 38, 31, 26, 20};
        creepStrengthList200k = new Integer[]{264, 233, 203, 175, 148, 123, 103, 82, 66, 51, 41, 35, 30, 25, 0, 0};
        creepStrength.put(material, generateHMForCreepStrength(creepTemps, creepStrengthList10k, creepStrengthList100k, creepStrengthList200k));

        material = "13CrMo4-5 1.7335";
        listAtTemp = new Integer[]{264, 253, 245, 236, 192, 182, 174, 168, 166, 0, 0};
        strengthAtTempHM.put(material, generateHMIntInt(temps, listAtTemp));
        creepTemps = new Integer[]{450, 460, 470, 480, 490, 500, 510, 520, 530, 540, 550, 560, 570, 580, 590, 600};
        creepStrengthList10k = new Integer[]{377, 347, 319, 292, 264, 238, 209, 181, 155, 131, 109, 90, 74, 60, 50, 41};
        creepStrengthList100k = new Integer[]{290, 58, 227, 198, 170, 145, 121, 100, 80, 65, 53, 44, 38, 31, 26, 20};
        creepStrengthList200k = new Integer[]{264, 233, 203, 175, 148, 123, 103, 82, 66, 51, 41, 35, 30, 25, 0, 0};
        creepStrength.put(material, generateHMForCreepStrength(creepTemps, creepStrengthList10k, creepStrengthList100k, creepStrengthList200k));

        material = "10CrMo9-10 1.7380";
        listAtTemp = new Integer[]{249, 241, 234, 224, 219, 212, 207, 193, 180, 0, 0};
        strengthAtTempHM.put(material, generateHMIntInt(temps, listAtTemp));
        creepTemps = new Integer[]{450, 460, 470, 480, 490, 500, 510, 520, 530, 540, 550, 560, 570, 580, 590, 600};
        creepStrengthList10k = new Integer[]{308, 284, 261, 238, 216, 195, 176, 158, 142, 126, 111, 99, 88, 78, 69, 60};
        creepStrengthList100k = new Integer[]{229, 212, 194, 177, 160, 141, 124, 105, 95, 81, 70, 61, 53, 46, 40, 35};
        creepStrengthList200k = new Integer[]{204, 188, 172, 156, 140, 124, 108, 94, 80, 68, 57, 49, 43, 38, 33, 28};
        creepStrength.put(material, generateHMForCreepStrength(creepTemps, creepStrengthList10k, creepStrengthList100k, creepStrengthList200k));

        material = "11CrMo9-10 1.7383";
        listAtTemp = new Integer[]{323, 312, 304, 396, 389, 380, 275, 257, 239, 0, 0};
        strengthAtTempHM.put(material, generateHMIntInt(temps, listAtTemp));
        creepTemps = new Integer[]{400, 410, 420, 430, 440, 450, 460, 470, 480, 490, 500, 510, 520};
        creepStrengthList10k = new Integer[]{382, 355, 333, 312, 294, 276, 259, 242, 225, 208, 191, 174, 157};
        creepStrengthList100k = new Integer[]{313, 289, 272, 255, 238, 221, 204, 187, 170, 153, 137, 122, 107};
        creepStrengthList200k = new Integer[]{};
        creepStrength.put(material, generateHMForCreepStrength(creepTemps, creepStrengthList10k, creepStrengthList100k, creepStrengthList200k));

        material = "25CrMo4 1.7218";
        listAtTemp = new Integer[]{315, 315, 305, 295, 285, 265, 225, 185, 0, 0, 0};
        strengthAtTempHM.put(material, generateHMIntInt(temps, listAtTemp));

        material = "20CrMoV13-5-5 1.7779";
        listAtTemp = new Integer[]{575, 575, 570, 560, 550, 510, 470, 420, 370, 0, 0};
        strengthAtTempHM.put(material, generateHMIntInt(temps, listAtTemp));
        creepTemps = new Integer[]{420, 430, 440, 450, 460, 470, 480, 490, 500, 510, 520, 530, 540, 550};
        creepStrengthList10k = new Integer[]{470, 440, 410, 360, 310, 270, 240, 210, 186, 169, 152, 134, 117, 98};
        creepStrengthList100k = new Integer[]{420, 370, 310, 260, 220, 190, 165, 145, 127, 114, 101, 87, 74, 59};
        creepStrengthList200k = new Integer[]{};
        creepStrength.put(material, generateHMForCreepStrength(creepTemps, creepStrengthList10k, creepStrengthList100k, creepStrengthList200k));

        material = "15NiCuMoNb5-6-4 1.6368";
        listAtTemp = new Integer[]{42, 412, 402, 392, 382, 373, 343, 304, 0, 0, 0};
        strengthAtTempHM.put(material, generateHMIntInt(temps, listAtTemp));
        creepTemps = new Integer[]{400, 410, 420, 430, 440, 450, 460, 470, 480, 490, 500};
        creepStrengthList10k = new Integer[]{402, 385, 368, 348, 328, 304, 274, 242, 212, 179, 147};
        creepStrengthList100k = new Integer[]{373, 349, 325, 300, 273, 245, 210, 175, 139, 104, 69};
        creepStrengthList200k = new Integer[]{};
        creepStrength.put(material, generateHMForCreepStrength(creepTemps, creepStrengthList10k, creepStrengthList100k, creepStrengthList200k));

        material = "7CrWVMoNb9-6 1.8201";
        listAtTemp = new Integer[]{379, 370, 363, 361, 359, 351, 345, 338, 330, 299, 266};
        strengthAtTempHM.put(material, generateHMIntInt(temps, listAtTemp));
        creepTemps = new Integer[]{450, 460, 470, 480, 490, 500, 510, 520, 530, 540, 550, 560, 570};
        creepStrengthList10k = new Integer[]{275, 260, 246, 232, 219, 206, 194, 182, 170, 159, 148, 137, 125};
        creepStrengthList100k = new Integer[]{233, 219, 206, 193, 181, 169, 157, 145, 134, 122, 110, 97, 79};
        creepStrengthList200k = new Integer[]{};
        creepStrength.put(material, generateHMForCreepStrength(creepTemps, creepStrengthList10k, creepStrengthList100k, creepStrengthList200k));

        material = "7CrMoVTiB10-10 1.7378";
        listAtTemp = new Integer[]{397, 383, 373, 366, 359, 352, 345, 336, 324, 301, 248};
        strengthAtTempHM.put(material, generateHMIntInt(temps, listAtTemp));
        creepTemps = new Integer[]{450, 460, 470, 480, 490, 500, 510, 520, 530, 540, 550, 560, 570, 580, 590, 600};
        creepStrengthList10k = new Integer[]{278, 262, 247, 231, 214, 198, 171, 165, 148, 130, 113, 0, 0, 0, 0, 0};
        creepStrengthList100k = new Integer[]{378, 342, 311, 281, 257, 240, 222, 205, 187, 170, 152, 134, 117, 99, 82, 64};
        creepStrengthList200k = new Integer[]{};
        creepStrength.put(material, generateHMForCreepStrength(creepTemps, creepStrengthList10k, creepStrengthList100k, creepStrengthList200k));

        material = "X11CrMo5+I 1.7362+I";
        listAtTemp = new Integer[]{156, 150, 148, 147, 145, 142, 137, 129, 116, 0, 0};
        strengthAtTempHM.put(material, generateHMIntInt(temps, listAtTemp));
        creepTemps = new Integer[]{450, 460, 470, 480, 490, 500, 510, 520, 530, 540, 550, 560, 570, 580, 590, 600, 610, 620, 630};
        creepStrengthList10k = new Integer[]{196, 180, 166, 152, 140, 128, 116, 105, 95, 85, 77, 69, 63, 58, 50, 45, 41, 37, 33};
        creepStrengthList100k = new Integer[]{147, 133, 119, 108, 98, 89, 79, 69, 62, 55, 49, 44, 38, 34, 30, 26, 24, 0, 0};
        creepStrengthList200k = new Integer[]{130, 118, 107, 96, 86, 76, 67, 58, 52, 46, 41, 36, 31, 27, 24, 22, 0, 0, 0};
        creepStrength.put(material, generateHMForCreepStrength(creepTemps, creepStrengthList10k, creepStrengthList100k, creepStrengthList200k));

        material = "X11CrMo5+NT1 1.7362+NT1";
        listAtTemp = new Integer[]{245, 237, 230, 223, 216, 206, 196, 181, 167, 0, 0};
        strengthAtTempHM.put(material, generateHMIntInt(temps, listAtTemp));
        creepTemps = new Integer[]{450, 460, 470, 480, 490, 500, 510, 520, 530, 540, 550, 560, 570, 580, 590, 600};
        creepStrengthList10k = new Integer[]{242, 242, 242, 215, 188, 164, 145, 128, 113, 100, 88, 78, 69, 60, 53, 46};
        creepStrengthList100k = new Integer[]{270, 255, 188, 157, 131, 113, 96, 82, 70, 60, 50, 0, 0, 0, 0, 0};
        creepStrengthList200k = new Integer[]{237, 202, 170, 141, 116, 96, 80, 68, 58, 48, 40, 0, 0, 0, 0, 0};
        creepStrength.put(material, generateHMForCreepStrength(creepTemps, creepStrengthList10k, creepStrengthList100k, creepStrengthList200k));

        material = "X11CrMo5+NT2 1.7362+NT2";
        listAtTemp = new Integer[]{366, 350, 334, 332, 309, 299, 289, 280, 265, 0, 0};
        strengthAtTempHM.put(material, generateHMIntInt(temps, listAtTemp));
        creepTemps = new Integer[]{450, 460, 470, 480, 490, 500, 510, 520, 530, 540, 550, 560, 570, 580, 590, 600};
        creepStrengthList10k = new Integer[]{242, 242, 242, 215, 188, 164, 145, 128, 113, 100, 88, 78, 69, 60, 53, 46};
        creepStrengthList100k = new Integer[]{270, 255, 188, 157, 131, 113, 96, 82, 70, 60, 50, 0, 0, 0, 0, 0};
        creepStrengthList200k = new Integer[]{237, 202, 170, 141, 116, 96, 80, 68, 58, 48, 40, 0, 0, 0, 0, 0};
        creepStrength.put(material, generateHMForCreepStrength(creepTemps, creepStrengthList10k, creepStrengthList100k, creepStrengthList200k));

        material = "X11CrMo9-1+I 1.7386+I";
        listAtTemp = new Integer[]{187, 186, 178, 177, 175, 171, 164, 153, 142, 120, 0};
        strengthAtTempHM.put(material, generateHMIntInt(temps, listAtTemp));
        creepTemps = new Integer[]{460, 470, 480, 490, 500, 510, 520, 530, 540, 550, 560, 570, 580, 590, 600};
        creepStrengthList10k = new Integer[]{275, 240, 210, 190, 170, 152, 134, 118, 104, 90, 78, 68, 60, 53, 48};
        creepStrengthList100k = new Integer[]{190, 170, 150, 130, 115, 102, 89, 78, 67, 58, 49, 42, 37, 33, 30};
        creepStrengthList200k = new Integer[]{};
        creepStrength.put(material, generateHMForCreepStrength(creepTemps, creepStrengthList10k, creepStrengthList100k, creepStrengthList200k));

        material = "X11CrMo9-1+NT 1.7386+NT";
        listAtTemp = new Integer[]{363, 348, 334, 330, 326, 322, 316, 311, 290, 235, 0};
        strengthAtTempHM.put(material, generateHMIntInt(temps, listAtTemp));
        creepTemps = new Integer[]{450, 460, 470, 480, 490, 500, 510, 520, 530, 540, 550, 560, 570, 580, 590, 600, 610, 620, 630, 640, 650};
        creepStrengthList10k = new Integer[]{335, 308, 284, 261, 239, 219, 200, 182, 164, 148, 132, 117, 102, 89, 77, 65, 55, 47, 40, 34, 30};
        creepStrengthList100k = new Integer[]{27, 253, 231, 211, 192, 174, 156, 139, 123, 107, 92, 78, 66, 55, 45, 37, 31, 27, 24, 21, 0};
        creepStrengthList200k = new Integer[]{259, 236, 215, 196, 177, 160, 142, 126, 111, 95, 80, 67, 55, 45, 37, 32, 27, 24, 0, 0, 0};
        creepStrength.put(material, generateHMForCreepStrength(creepTemps, creepStrengthList10k, creepStrengthList100k, creepStrengthList200k));

        material = "X10CrMoVNb9-1 1.4903";
        listAtTemp = new Integer[]{410, 395, 380, 370, 360, 350, 340, 320, 300, 270, 215};
        strengthAtTempHM.put(material, generateHMIntInt(temps, listAtTemp));
        creepTemps = new Integer[]{500, 510, 520, 530, 540, 550, 560, 570, 580, 590, 600, 610, 620, 630, 640, 650, 660, 670};
        creepStrengthList10k = new Integer[]{289, 270, 251, 234, 216, 200, 183, 167, 152, 137, 122, 109, 97, 86, 76, 68, 61, 54};
        creepStrengthList100k = new Integer[]{255, 236, 217, 199, 182, 164, 148, 132, 117, 103, 90, 79, 70, 62, 55, 48, 42, 36};
        creepStrengthList200k = new Integer[]{245, 225, 206, 188, 170, 153, 136, 121, 106, 93, 81, 71, 63, 56, 49, 43, 36, 0};
        creepStrength.put(material, generateHMForCreepStrength(creepTemps, creepStrengthList10k, creepStrengthList100k, creepStrengthList200k));

        material = "X10CrWMoVNb9-2 1.4901";
        listAtTemp = new Integer[]{420, 412, 405, 400, 392, 382, 372, 360, 340, 300, 248};
        strengthAtTempHM.put(material, generateHMIntInt(temps, listAtTemp));
        creepTemps = new Integer[]{520, 530, 540, 550, 560, 570, 580, 590, 600, 610, 620, 630, 640, 650};
        creepStrengthList10k = new Integer[]{272, 256, 240, 225, 210, 195, 181, 167, 153, 139, 126, 113, 100, 88};
        creepStrengthList100k = new Integer[]{235, 218, 202, 187, 172, 157, 142, 127, 113, 100, 87, 75, 65, 56};
        creepStrengthList200k = new Integer[]{129, 115, 101, 88, 76, 65, 56, 48, 0, 0, 0, 0, 0, 0};
        creepStrength.put(material, generateHMForCreepStrength(creepTemps, creepStrengthList10k, creepStrengthList100k, creepStrengthList200k));

        material = "X11CrWMoVNb9-1-1 1.4905";
        listAtTemp = new Integer[]{412, 401, 390, 383, 376, 367, 356, 342, 319, 287, 231};
        strengthAtTempHM.put(material, generateHMIntInt(temps, listAtTemp));
        creepTemps = new Integer[]{520, 530, 540, 550, 560, 570, 580, 590, 600, 610, 620, 630, 640, 650};
        creepStrengthList10k = new Integer[]{252, 237, 222, 208, 194, 180, 166, 152, 139, 125, 111, 99, 88, 78};
        creepStrengthList100k = new Integer[]{220, 204, 188, 173, 157, 142, 126, 111, 98, 85, 75, 65, 56, 0};
        creepStrengthList200k = new Integer[]{113, 98, 86, 75, 65, 56, 0, 0, 0, 0, 0, 0, 0, 0};
        creepStrength.put(material, generateHMForCreepStrength(creepTemps, creepStrengthList10k, creepStrengthList100k, creepStrengthList200k));

        material = "X20CrMoV11-1 1.4922";
        listAtTemp = new Integer[]{430, 430, 430, 415, 390, 380 ,360, 330, 290, 250, 0};
        strengthAtTempHM.put(material, generateHMIntInt(temps, listAtTemp));
        creepTemps = new Integer[]{480, 490, 500, 510, 520, 530, 540, 550, 560, 570, 580, 590, 600, 610, 620, 630, 640, 650};
        creepStrengthList10k = new Integer[]{348, 319, 292, 269, 27, 225, 205, 184, 165, 147, 130, 113, 97, 84, 72, 61, 52, 44};
        creepStrengthList100k = new Integer[]{289, 263, 236, 212, 188, 167, 147, 128, 111, 95, 81, 69, 59, 51, 43, 36, 31, 26};
        creepStrengthList200k = new Integer[]{270, 242, 218, 194, 170, 149, 129, 112, 96, 81, 68, 58, 49, 42, 36, 30, 0, 0};
        creepStrength.put(material, generateHMForCreepStrength(creepTemps, creepStrengthList10k, creepStrengthList100k, creepStrengthList200k));

    }


    private HashMap<Integer, Integer> generateHMIntInt(Integer[] keys, Integer[] values) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        if (keys.length != values.length) {
            System.out.println("Passed lists are not same length");
            return hm;
        }
        for (int i=0; i<keys.length; i++) {
            hm.put(keys[i], values[i]);
        }
        return hm;
    }

    private HashMap<String, Integer> generateHMStrInt(String[] keys, Integer[] values) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        if (keys.length != values.length) {
            System.out.println("Passed lists are not same length");
            return hm;
        }
        for (int i=0; i<keys.length; i++) {
            hm.put(keys[i], values[i]);
        }
        return hm;
    }

    private HashMap<String, HashMap<Integer, Integer>> generateHMForCreepStrength(Integer[] creepTemps,
                                                                                  Integer[] creepStrengthList10k,
                                                                                  Integer[] creepStrengthList100k,
                                                                                  Integer[] creepStrengthList200k) {
        HashMap<String, HashMap<Integer, Integer>> durationTempStrengthHM = new HashMap<>();
        if (creepTemps.length != creepStrengthList10k.length) {
            System.out.println("creepTemps and 10k have NOT same length");
            System.out.println(Arrays.toString(creepStrengthList10k));
        }
        durationTempStrengthHM.put(creepDuration[0], generateHMIntInt(creepTemps, creepStrengthList10k));
        if (creepTemps.length != creepStrengthList100k.length) {
            System.out.println("creepTemps and 100k have NOT same length");
            System.out.println(Arrays.toString(creepStrengthList100k));
        }
        durationTempStrengthHM.put(creepDuration[1], generateHMIntInt(creepTemps, creepStrengthList100k));
        if (creepStrengthList200k.length > 0){
            if (creepTemps.length != creepStrengthList200k.length) {
                System.out.println("creepTemps and 200k have NOT same length");
                System.out.println(Arrays.toString(creepStrengthList200k));
            }
            durationTempStrengthHM.put(creepDuration[2], generateHMIntInt(creepTemps, creepStrengthList200k));
        }
        return durationTempStrengthHM;
    }
}

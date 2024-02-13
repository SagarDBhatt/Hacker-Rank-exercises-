/**
 * Task is to find the min initial energy for the bot to start jumping the building.
 *
 * Each jump updates the new energy.
 *
 * case 1: If the height of the building is less than starting energy
 * New Energy = Starting energy + delta of enegy
 *
 * case 2: If the height of building is higher than starting energy
 * New Energy = Starting energy - delta of energy
 */

//SI:
//5
//3 4 3 2 4

//SO:
//4

//99
//1401 2019 1748 3785 3236 3177 3443 3772 2138 1049 353 908 310 2388 1322 88 2160 2783 435 2248 1471 706 2468 2319 3156 3506 2794 1999 1983 2519 2597 3735 537 344 3519 3772 3872 2961 3895 2010 10 247 3269 671 2986 942 758 1146 77 1545 3745 1547 2250 2565 217 1406 2070 3010 3404 404 1528 2352 138 2065 3047 3656 2188 2919 2616 2083 1280 2977 2681 548 4000 1667 1489 1109 3164 1565 2653 3260 3463 903 1824 3679 2308 245 2689 2063 648 568 766 785 2984 3812 440 1172 2730

//1010

package ThreeMonthPreparationKit.October_2022.Week9;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChiefHopper {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int n = Integer.parseInt(br.readLine());
            List<Integer> list = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            System.out.println(ChiefHopperResult.chiefHopper(list));
        }catch (IOException e){
            e.printStackTrace();
        }
    }//main
}//end of class

class ChiefHopperResult {

    public static int chiefHopper(List<Integer> arr){
        ////////////////////
        // Rather than iterating with the different inital energy to find the positive end energy, I should start with +ve end energy
        // and iterate in the last to first to find the minimum positive energy.

        // To calculate this, consider the end energy is 1.
        // The energy before jumping the last building should be :
        // newEnergy = currentEne + delta (currnetEne - height);
        // newEnergy = 2 * currentEne - height;  => We need to have newEnergy >= 0 & need to find the currentEnergy.

        // currentEne = newEnergy + height / 2;

        double newEne = 0;
        double currentEne = 0;

        for(int i = arr.size() - 1; i >= 0; i--){
            currentEne = Math.ceil( (newEne + arr.get(i)) / 2 );
            newEne = currentEne;
        }

        return (int)currentEne;
    }

    public static int chiefHopperv2(List<Integer> arr) {
//        //1. Put the inital energy as the first building energy.
//        int startEng = arr.get(0) - 1;
//
//        while(calcEndEnergy(startEng, arr) < 0){
//            startEng += 1;
//            System.out.println("start - " + startEng);
//        };
//
//        //2. Hop all the building and find Last Energy. If the LE is -ve then increase the StartEne and repeate the process
//        // until the positive EndEne.
//        return startEng;

        ////////////////////
        // Rather than iterating with the different inital energy to find the positive end energy, I should start with +ve end energy
        // and iterate in the last to first to find the minimum positive energy.

        // To calculate this, consider the end energy is 1.
        // The energy before jumping the last building should be :
        // currentEne = currentEne + delta (currnetEne - height);
        // 1 = currentEne + currentEne - height
        // currentEne = (height + 1 ) / 2;

        // Above formula gives me the currentEnergy before jumping the last building.
        double initialEne = 0;

        for(int i = arr.size()-1; i >0; i--){
//            initialEne = Math.ceil( (arr.get(i) + 1) / 2.0);
            initialEne = (initialEne + arr.get(i) + 1) / 2;
        }

        return (int)initialEne;
    }

    public static int calcEndEnergy(int startEne, List<Integer> arr){
        int newEng = startEne;

        System.out.println("End ener v1 = " + newEng);
        for(int i = 0; i < arr.size(); i++){
            if(newEng >= arr.get(i)){
                 int deltaEne = newEng - arr.get(i);
                 newEng += deltaEne;
            }else{
                int deltaEne = arr.get(i) - newEng;
                newEng -= deltaEne;
                System.out.println("End ener v2 = " + newEng);
                if(newEng < 0)return newEng;
            }
        }
        return newEng;
    }//end of calcEndEnergy

}


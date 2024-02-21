/**
 * Problem: THere are N petrol pumps and each pump can provide the fixed amount of petrol and the distance to the next pump. Need to find out the mimimum index of pump for which we can finish the loop and/or
 * journey of all the pumps. 1 Liter of petrol can drive 1 km and need to check if we can arrive to the next pump.
 *
 * Need to check Gas_At_Beginning & Gas_At_Arriving_Next pump.
 */

/**
 * SI:
 * 3
 * 1 5
 * 10 3
 * 3 4
 *
 * SO:
 * 1
 *
 * In above ex, We start at index 1, get 10 Ltr of petrol. Next pump is 3 km so we can arrive next pump. Then fill the new gas and now we have 10 -3 + 3 = 10 liters and next gas station is 4 kms away which can be achieved.
 *
 * Validate if the currentGas >= next petrol pump.
 */


package ThreeMonthPreparationKit.October_2022.Week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MockTestWeek9 {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<List<Integer>> iL= new ArrayList<>();

        try{
            int n = Integer.parseInt(br.readLine());

            IntStream.range(0,n).forEach(i -> {

                try{
                    iL.add(Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
                }
                catch (IOException e){
                    e.printStackTrace();
                };
            });

            System.out.println(ResultMockTestWeek9.truckTour(iL));

        }catch(IOException e){
            e.printStackTrace();
        }


    }//end of main

}//end of class

class ResultMockTestWeek9 {

    /*
     * Complete the 'truckTour' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
     */

    public static int truckTour(List<List<Integer>> petrolpumps) {
        // 1. How to iterate all the pumps - Start with index 2 and end at index 0 of the list.
        // Check if the amount of petrol given is greater than or equals to the distance of the next petrol pump. If yes then move to the next.
        List<Integer> result = new ArrayList<>();

//        for(int i = 0; i < petrolpumps.size(); i++){
//            int startGas = petrolpumps.get(i).get(0);
//            int distanceToNextPump = petrolpumps.get(i).get(1);
//            int destGas = 0;
//
//            if(startGas < distanceToNextPump){
//                continue;
//            }
//            else{
//                for(int j = 0; j < petrolpumps.size(); j++){
//                    int index =
//
//                }//enf of J
//
//            }//End of else
//
//
//
//        }//end of I
        for(int i = 0; i < petrolpumps.size(); i++){
            int startGas = 0;
            int distanceToNextPump = 0;
            int counter = 0;

            for(int j = 0; j < petrolpumps.size(); j++){
                int index = (i + j) % petrolpumps.size();
                startGas += petrolpumps.get(index).get(0);
                distanceToNextPump = petrolpumps.get(index).get(1);

                if(startGas < distanceToNextPump)break;
                else{
                    counter++;
                    startGas -= distanceToNextPump;
                }

                if(counter == petrolpumps.size()-1)result.add(i);
            }//J
        }//I

        Collections.sort(result);
        return result.get(0);
    }

}

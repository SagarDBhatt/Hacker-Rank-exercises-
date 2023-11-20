//Given the array, count the num of +ve, -ve and zeros and then find the ratio of each. Answer should be in 6 precision

//Sample input:
//6
//-4 3 -9 0 4 1
//
//Output:
//0.500000
//0.333333
//0.166667

package ThreeMonthPreparationKit.October_2022.Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class EX06_PlusMinus {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            List<Integer> inpList = new ArrayList<Integer>();

            inpList = Arrays.asList(br.readLine().split(" "))
                    .stream().map(i -> Integer.parseInt(i))
                    .collect(Collectors.toList());
            ResultPlusMinus.plusMinus(inpList);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

class ResultPlusMinus {

    public static void plusMinus(List<Integer> arr) {
        // Write your code here

        //Create a LinkedHashmap (maintain the insertion order) to map the count of +ve, -ve and zeros with their frequency.
        Map<Integer,Integer> counterMap = new LinkedHashMap<>(){{
            put(1, 0);
            put(-1,0);
            put(0,0);
        }};

        //Iterate each int from arr and map their freq in the Map.
        for(Integer a : arr){
            if(a > 0)counterMap.put(1, counterMap.get(1) + 1);
            else if(a < 0)counterMap.put(-1, counterMap.get(-1) + 1);
            else counterMap.put(0, counterMap.get(0) + 1);
        }

        //Create a DecimalFormat class obj and assign 6 digits precision.
        DecimalFormat dfm = new DecimalFormat("0.000000");

        //Iterate each key of the map and print the ratio.
        for(int b : counterMap.keySet()){
            System.out.println(dfm.format((double)counterMap.get(b) / arr.size()));
        }
    }

}
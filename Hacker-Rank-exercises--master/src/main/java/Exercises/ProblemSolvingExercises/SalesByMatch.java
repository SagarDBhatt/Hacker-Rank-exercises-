/**
 * Given the list of integers find the number of matching pairs.
 */

//SI
//9
//10 20 20 10 10 30 50 10 20

//SO
//3

package Exercises.ProblemSolvingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SalesByMatch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> numbers = Arrays.asList(br.readLine().split(" ")).stream()
                .map(Integer::parseInt).collect(Collectors.toList());

        System.out.println(ResultSalesByMatch.getPairsCount(numbers));

    }//main
}//class

class ResultSalesByMatch{
    public static int getPairsCount(List<Integer> num){
        int pairs = 0;
        Map<Integer, Integer> freq = new HashMap<Integer,Integer>();

        num.stream().forEach(i -> {
            freq.put(i, freq.getOrDefault(i,0)+1);
        });

        for(int key : freq.keySet()){
            if(freq.get(key) >= 2){
                pairs += freq.get(key) / 2;
            }
        }
        System.out.println(freq);
        System.out.println(pairs);
        return pairs;
    }
}

package ThreeMonthPreparationKit.October_2022.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class EX05_MigratoryBirds {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> birdSightingList = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxSightedBirdId = ResultBirdSighting.migratoryBirds(birdSightingList);

        System.out.println(maxSightedBirdId);
    }//EOF MAIN
}//EOF CLASS

class ResultBirdSighting {

    /*
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here
        //1. Find the occurrence of each bird
        Map<Integer,Integer> birdMap = new HashMap<>();

        arr.stream().forEach(obj -> {
            if(birdMap.containsKey(obj)) birdMap.put(obj,birdMap.get(obj)+1);
            else birdMap.put(obj,1);
        });

        int sightings = 0;
        int id  = 0;

        for(Map.Entry<Integer, Integer> m : birdMap.entrySet()){
            if(m.getValue() > sightings){
                sightings = m.getValue();
                id = m.getKey();
            }
        }

        return id;
    }

}
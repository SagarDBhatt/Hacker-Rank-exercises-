/**
 * We are given the list of bird ids. find the occurrence of each id and return the bird with the highest occurrence.
 *
 * If there are more than 1 ids with highest occurrence then return the lowest id number.
 */

//SI
//11
//1 2 3 4 5 4 3 2 1 3 4

//SO
//3

package Miscallaneous.JavaRandomHackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class MigratoryBirds {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            int n = Integer.parseInt(br.readLine());
            List<Integer> birdIds = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toList());

            System.out.println(ResultMigratoryBird.getTheHighestOccurredBirdId(birdIds));
        }catch (IOException e){
            e.printStackTrace();
        }

    }//main
}//class

class ResultMigratoryBird{
    public static Integer getTheHighestOccurredBirdId(List<Integer> birdIds){

        //Create the map to find the occurrence of the each id
        Map<Integer, Integer> countMapper = new HashMap<>();

        for(Integer i : birdIds){
            countMapper.put(i, countMapper.getOrDefault(i,0)+1);
        }

        //Sort the map by key:
//        List<Integer> listOfKeys = new ArrayList(countMapper.keySet());
//        Comparator comparator = new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return Integer.parseInt((String) o1) - Integer.parseInt((String) o2);
//            }
//        };
//        Collections.sort(listOfKeys, comparator);
//
//        int minKey = listOfKeys.get(0);
//        for(Integer key : listOfKeys){
//            if(minKey > key)minKey = key;
//        }
//        System.out.println("Min Key = " + minKey);

        //Sort the map based on the value.
//        List<Integer> values = (List<Integer>) countMapper.values();
        List<Integer> values = new ArrayList<>(countMapper.values());
        Collections.sort(values, Collections.reverseOrder());

        Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for(Integer value : values){
            for(Map.Entry<Integer,Integer> map : countMapper.entrySet()){
                if(value == map.getValue())sortedMap.put(map.getKey(), map.getValue());
            }
        }
        System.out.println("Sorted map -- " + sortedMap);

        List<Integer> keys = new ArrayList<>();
        int max = 0;
        for(Map.Entry<Integer, Integer> map : sortedMap.entrySet()){
            if(map.getValue() > max){
                keys.add(map.getKey());
                max = map.getValue();
            }
        }

        return Collections.min(keys);
    }
}
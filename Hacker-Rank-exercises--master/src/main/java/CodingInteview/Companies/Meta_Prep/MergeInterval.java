/**
 * Given the intervals merge them if overlapping.
 */

//SI
// [ [1,3], [2,4], [5,8] ]

//SO
// [ [1,4], [5,8] ]

package CodingInteview.Companies.Meta_Prep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();

        list.add(List.of(1,3));
        list.add(List.of(5,8));
        list.add(List.of(2,4));
        list.add(List.of(10,13));

        System.out.println(list);

        SolutionMergeInterval.getTheResult(list);
    }
}

class SolutionMergeInterval{
    public static void getTheResult(List<List<Integer>> list){

        //sort the list -
        // Implement the comparator interface object and then pass it to collections.sort method.
        Comparator<List<Integer>> comparator = new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        };
        Collections.sort(list, comparator);
        System.out.println(list);

        //Create the newArrayList and assign the first val
        List<Integer> newList = new ArrayList<>(list.get(0));

        //Create the result array and add the newList
        List<List<Integer>> result = new ArrayList<>();
        result.add(newList);

        //Iterate each element and add the merged list to result
        for(List<Integer> integerList : list){

            if(integerList.get(0) <= newList.get(1)){
                Integer max = Math.max(integerList.get(1), newList.get(1));
                newList.set(1, max);
            }
            else{
                newList = integerList;
                result.add(newList);
            }
        }//for

        System.out.println(result);
    }
}
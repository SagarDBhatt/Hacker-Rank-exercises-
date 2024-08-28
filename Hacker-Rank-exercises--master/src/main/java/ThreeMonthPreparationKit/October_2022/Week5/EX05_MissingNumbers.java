//Given two arrays of integers, find which elements in the second array are missing from the first array.
//
//        Example
//
//
//        The  array is the orginal list. The numbers missing are .
//
//        Notes
//
//        If a number occurs multiple times in the lists, you must ensure that the frequency of that number in both lists is the same. If that is not the case, then it is also a missing number.
//        Return the missing numbers sorted ascending.
//        Only include a missing number once, even if it is missing multiple times.
//        The difference between the maximum and minimum numbers in the original list is less than or equal to .
//        Function Description
//
//        Complete the missingNumbers function in the editor below. It should return a sorted array of missing numbers.
//
//        missingNumbers has the following parameter(s):
//
//        int arr[n]: the array with missing numbers
//        int brr[m]: the original array of numbers
//        Returns
//
//        int[]: an array of integers
//        Input Format
//
//        There will be four lines of input:
//
//        - the size of the first list,
//        The next line contains  space-separated integers
//        - the size of the second list,
//        The next line contains  space-separated integers
//
//        Constraints
//
//        Sample Input
//10
//203 204 205 206 207 208 203 204 205 206
//13
//203 204 204 205 206 207 205 208 203 206 205 206 204
//
//        Sample Output
//
//        204 205 206

//        Explanation
//        is present in both arrays. Its frequency in  is , while its frequency in  is . Similarly,  and  occur twice in , but three times in . The rest of the numbers have the same frequencies in both lists.
//

/**
 * Pseudocode:
 *         1. Read len of missingArr. Read the missing arr
 *         2. Read the len of original arr. Read all elements of original arry.
 *         3. Create a map (TreeMap) to find the frequency of each array element. Do the same for missing array.
 *         4. Iterate missing arr treemap to validate if element is present:
 *             i.  If Not then add to missing element ArrayList.
 *             ii. If yes then check the freq. If freq is less than original map freq then add into missing element ArrayList.
 *         5. Return the (arrayList, sort asc and convert to ToArray) and display.
 */


package ThreeMonthPreparationKit.October_2022.Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EX05_MissingNumbers {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int missArrayCounter = Integer.parseInt(br.readLine());
        List<Integer> missingArray= Stream.of(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int origArrayCounter = Integer.parseInt(br.readLine());
        List<Integer> origArray = Stream.of(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        Map<Integer, Integer> origArrayMap = new TreeMap<Integer, Integer>();
        origArrayMap = FindMissingElements.getTheFreqOfElements(origArray);

        Map<Integer, Integer> missingArrayMap = new TreeMap<Integer, Integer>();
        missingArrayMap = FindMissingElements.getTheFreqOfElements(missingArray);

        List<Integer> resultList = FindMissingElements.getTheMissingElementsList(origArrayMap, missingArrayMap);
        resultList.stream().forEach(i -> System.out.print(i + " "));

    }//eof main
}//eof class

class FindMissingElements{

    /**
     * Method to return the TreeMap with the frequency of each elements.
     * @param arr
     */
    public static Map<Integer, Integer> getTheFreqOfElements(List<Integer> arr){
        Map<Integer, Integer> resultMap = new TreeMap<Integer, Integer>();

        arr.stream().forEach(i -> {
            if(!resultMap.containsKey(i)){
                resultMap.put(i, 1);
            }
            else{
                resultMap.put(i, resultMap.get(i) + 1);
            }
        });

        return resultMap;
    }

    public static List<Integer> getTheMissingElementsList(Map<Integer, Integer> _origMap, Map<Integer, Integer> _missingMap){

        List<Integer> resultList = new ArrayList<Integer>();

        for(Integer i : _origMap.keySet()){
            if(_missingMap.containsKey(i)){
                if(_missingMap.get(i) < _origMap.get(i)){
                    resultList.add(i);
                }
            }
            else{
                resultList.add(i);
            }
        }
        return resultList;
    }

}//eof class
